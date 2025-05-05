package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	JdbcTemplate template;

    private static final String SAVE_STUDENT = "INSERT INTO student(name, marks) VALUES (?, ?)";
    private static final String GET_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ?";
    private static final String UPDATE_STUDENT = "UPDATE student SET name = ?, marks = ? WHERE id = ?";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE id = ?";

    public boolean save(Student student) {
        int value = template.update(SAVE_STUDENT, student.getName(), student.getMarks());
        return value > 0;
    }

	public Student getById(int id) {
		return template.queryForObject(GET_STUDENT_BY_ID, new Object[] {id}, new RowMapper<Student>() {
	        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Student student = new Student();
	            student.setId(rs.getInt("id"));
	            student.setName(rs.getString("name"));
	            student.setMarks(rs.getInt("marks"));
	            return student;
	        }
	    });
	}

	public boolean update(final Student student,final int id) {
		
		PreparedStatementSetter setter=new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, student.getName());
				ps.setInt(2, student.getMarks());
				 ps.setInt(3,id);

			}
		};
		int value=template.update(UPDATE_STUDENT,setter);
		return value>0;
	}

	public boolean delete(int id) {
        int value = template.update(DELETE_STUDENT, id);
        return value > 0;
    }

    
	

}
