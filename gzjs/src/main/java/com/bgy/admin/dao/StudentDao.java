package com.bgy.admin.dao;

import com.bgy.admin.entity.Student;

import java.util.List;

public interface StudentDao {

	void add(Student studnet);

	void delete(Student studnet);

	void update(Student studnet);

	Student findbyId(String id);

	List<Student> findAll();

}
