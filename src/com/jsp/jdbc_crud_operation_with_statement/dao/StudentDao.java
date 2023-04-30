package com.jsp.jdbc_crud_operation_with_statement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.jsp.jdbc_crud_operation_with_statement.dto.Student;

public class StudentDao {
	
	Connection connection = null;
	Statement statement = null;
	
	//insert method for student
	public void insertStudent(Student student) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student";
			String user = "root";
			String pass = "Priyam";
			
			 connection = DriverManager.getConnection(url,user,pass);
			
			 statement = connection.createStatement();
			
			String insertStudentQuery = "insert into student values("+ student.getId() +", '"+ student.getName()+"',"+ student.getRollno() +",'"+ student.getAddress() +"')";

			statement.execute(insertStudentQuery);
			System.out.println("Data Inserted Sucessfully...");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	//delete method for student
	public void deleteStudent(int id) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student";
			String user = "root";
			String pass = "Priyam";
			
			 connection = DriverManager.getConnection(url,user,pass);
			
			 statement = connection.createStatement();
			
			String deleteStudentQuery = "delete from student where id = "+id+"";
			
			int id1 = statement.executeUpdate(deleteStudentQuery);
			
			if(id1!=0) {
				System.out.println("Data Deleted");
			}else {
				System.out.println("Given id not Present");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	//update method for student
	public void updateStudent(Student student) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student";
			String user = "root";
			String pass = "Priyam";
			
			 connection = DriverManager.getConnection(url,user,pass);
			
			 statement = connection.createStatement();
			
			String updateStudentQuery = "update student set name='"+student.getName()+"' where id ="+student.getId()+"";
			
			int id = statement.executeUpdate(updateStudentQuery);
			
			if(id!=0) {
				System.out.println("Data Updated");
			}else {
				System.out.println("Given id is not present");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	//display method for student
	public List<Student> displayStudent(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student";
			String user = "root";
			String pass = "Priyam";
			
			 connection = DriverManager.getConnection(url,user,pass);
			
			 statement = connection.createStatement();
			
			String displayStudentQuery = "Select * from student";
			
			ResultSet resultSet = statement.executeQuery(displayStudentQuery);
			
			List<Student> students = new ArrayList<>();
			
			while(resultSet.next()) {
				
				Student student = new Student();
				
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setRollno(resultSet.getInt("rollno"));
				student.setAddress(resultSet.getString("address"));
				
				students.add(student);
			}
			
			return students;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}

}
