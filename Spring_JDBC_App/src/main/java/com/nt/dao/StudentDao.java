package com.nt.dao;

import com.nt.model.Student;

public interface StudentDao {

	boolean save(Student student);

	Student getById(int id);

	boolean update(Student student,int id);

	boolean delete(int id);

}
