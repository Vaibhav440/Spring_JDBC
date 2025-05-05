package com.nt.service;

import com.nt.model.Student;

public interface StudentService {
	
	boolean save(Student student);
    Student getById(int id);
    boolean update(Student student,int id);
    boolean delete(int id);

}
