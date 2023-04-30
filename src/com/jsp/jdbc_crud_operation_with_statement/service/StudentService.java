package com.jsp.jdbc_crud_operation_with_statement.service;

import java.util.List;
import com.jsp.jdbc_crud_operation_with_statement.dao.StudentDao;
import com.jsp.jdbc_crud_operation_with_statement.dto.Student;

public class StudentService {
	
	StudentDao dao = new StudentDao();
	
	//insert method for student
	public void insertStudent(Student student) {
		
		dao.insertStudent(student);
	}
	
	//delete method for student
	public void deleteStudent(int id) {
		dao.deleteStudent(id);
	}

	//update method for student
	public void updateStudent(Student student) {
		dao.updateStudent(student);
	}
	
	//display method for student
	public List<Student> displayStudent() {
		List<Student> students = dao.displayStudent();
		return students;
	}
}
