package com.bgy.admin.controller;

import com.bgy.admin.entity.Student;
import com.bgy.admin.service.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
	
	private static final Log log = LogFactory.getLog(StudentController.class);
	
	@Autowired
	StudentService studentService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="stuonefind",method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> findOne(HttpServletRequest req) {
		String name = req.getParameter("name");
		List<Student> list = (List<Student>) studentService.findById(name);
		log.info("list={}====="+ list.size());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		return map;
		
	}
	
	//ok
	@RequestMapping(value = "stuallfind", method = RequestMethod.GET)
	public ModelAndView findAll(HttpServletRequest req) {
		List<Student> list = studentService.find();
		ModelAndView mav = new ModelAndView("index.jsp");
		mav.addObject("students", list);
		return mav;
	}
	
	
	//ok
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest req) {
		Student student = new Student();
		try {
			String name = req.getParameter("name");
			String age = req.getParameter("age");
			
			student.setAge(age);
			student.setName(name);
			
			studentService.add(student);
		} catch (Exception e) {
			log.error("add", e);
		}
		return new ModelAndView("redirect:stuallfind.action");
	}
	
	@RequestMapping(value = "del")
	public ModelAndView del(String id) {
		 Student obj= studentService.findById(id);
		studentService.delete(obj);
		
		return new ModelAndView("redirect:stuallfind.action");
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(String id, String name, String age){
		Object obj = studentService.findById(id);
		Student student = (Student) obj;
		student.setName(name);
		student.setAge(age);
		studentService.update(student);
		
		return new ModelAndView("redirect:stuallfind.action");
	}
	

}
