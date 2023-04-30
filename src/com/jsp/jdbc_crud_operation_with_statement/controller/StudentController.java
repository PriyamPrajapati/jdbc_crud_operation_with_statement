package com.jsp.jdbc_crud_operation_with_statement.controller;

import java.util.List;
import java.util.Scanner;
import com.jsp.jdbc_crud_operation_with_statement.dto.Student;
import com.jsp.jdbc_crud_operation_with_statement.service.StudentService;

public class StudentController {
	
	public static void main(String[] args) {
		
		System.out.println("Start the main method");
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		StudentService studentService = new StudentService();
		while(true) {
			
			System.out.println("1.InsertStudent\n2.DeleteStudent\n3.UpdateStudent\n4.DisplayStudent");
			System.out.println("Choose Your Choice");
			
			int ch = sc.nextInt();
			
			switch (ch) {
			//insert case
			case 1: {
				
				System.out.println("Enter the Student Id");
				student.setId(sc.nextInt());
				System.out.println("Enter the Student Name");
				student.setName(sc.next());
				System.out.println("Enter the Student RollNo");
				student.setRollno(sc.nextInt());
				System.out.println("Enter the Student Address");
				student.setAddress(sc.next());
				
				studentService.insertStudent(student);
				
			}
			break;
			//delete case
			case 2:{
				
				System.out.println("Enter the Student Id");
				int id = sc.nextInt();
				
				studentService.deleteStudent(id);
			}
			
			break;
			
			//update case
			case 3:{
				System.out.println("Enter the student Id");
				student.setId(sc.nextInt());
				System.out.println("Enter the Student Name");
				student.setName(sc.next());
				
				studentService.updateStudent(student);
			}
			break;
			
			//display case
			case 4:{
				
				List<Student> students = studentService.displayStudent();
				
				for(Student student2 : students) {
					System.out.println("Id :"+student2.getId());
					System.out.println("Name :"+student2.getName());
					System.out.println("RollNo :"+student2.getRollno());
					System.out.println("Address :"+student2.getAddress());
					System.out.println("======================");
				}
			}
			break;
		}
	}

	}
}
