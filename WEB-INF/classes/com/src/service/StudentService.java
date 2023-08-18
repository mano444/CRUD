package com.src.service;


import com.src.dao.StudentDAOImpl;

import java.util.List;

import com.src.dao.StudentDAO;
import com.src.model.Student;
import com.src.model.User;

public class StudentService implements StudentServiceInterface {

	StudentDAO sdao = new StudentDAOImpl();
	@Override
	public int addStudent(Student s) {		
		
		return sdao.addStudent(s);
	}

	@Override
	public int deleteStudent(Student s) {

		
		return sdao.deleteStudent(s);
	}

	@Override
	public int editStudent(Student s) {
	
		return sdao.editStudent(s);
		
	}

	@Override
	public Student displayStudent(int id) {
		
		
		
		
		
		return sdao.displayStudent(id);
		
		
	}


	public List<Student> dispalyAllStudents() {
		
		return sdao.dispalyAllStudents();
	}


	public int totalNumberOfStudents() {
		
		return sdao.totalNumberOfStudents();
	}

	@Override
	public boolean getUser(User u) {
		
		return sdao.getUser(u);
	}

}
