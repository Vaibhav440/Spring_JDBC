package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.StudentDao;
import com.nt.model.Student;

@Service("stud")
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao dao;
	
	public boolean save(Student student) {
		return dao.save(student);
	}

	public Student getById(int id) {
		return dao.getById(id);
	}

	public boolean update(Student student,int id) {
		return dao.update(student,id);
	}

	public boolean delete(int id) {
		return dao.delete(id);
	}

}
