package com.bgy.admin.service;

import com.bgy.admin.entity.Student;

import java.util.List;

public interface StudentService {
	
	void add(Student student);
	void delete(Student student);
	void update(Student student);
	Student findById(String id);
	List<Student> find();
	

}
