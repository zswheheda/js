package com.bgy.admin.service.impl;

import com.bgy.admin.entity.Student;
import com.bgy.admin.service.StudentService;
import com.bgy.admin.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudenServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Transactional
	public void add(Student student) {
		studentDao.add(student);
	}
	
	@Transactional
	public void delete(Student student) {
		studentDao.delete(student);
	}
	
	@Transactional
	public void update(Student student) {
		studentDao.update(student);
	}
	
	@Transactional(readOnly = true)
	public Student findById(String id) {
		return studentDao.findbyId(id);
	}
	

	@Transactional(readOnly = true)
	public List<Student> find() {
		return (List<Student>) studentDao.findAll();
	}


}
