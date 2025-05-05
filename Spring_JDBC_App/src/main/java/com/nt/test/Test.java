package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.Config.Config;
import com.nt.model.Student;
import com.nt.service.StudentServiceImpl;

public class Test {

    public static void main(String arg[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        StudentServiceImpl studentServiceImpl = context.getBean("stud", StudentServiceImpl.class);

        // Test Save
        Student student = new Student();
        student.setName("Vaibhav");
        student.setMarks(90);
        boolean result = studentServiceImpl.save(student);
        System.out.println("Save result: " + result);

        // Test Get by ID
        Student retrievedStudent = studentServiceImpl.getById(1); // assuming id is 1
        System.out.println("Retrieved Student: " + retrievedStudent.getName() + " - " + retrievedStudent.getMarks());

        // Test Update
        student.setMarks(95);
        boolean updateResult = studentServiceImpl.update(student,1);
        System.out.println("Update result: " + updateResult);

        // Test Delete
        boolean deleteResult = studentServiceImpl.delete(1); // assuming id is 1
        System.out.println("Delete result: " + deleteResult);
    }
}
