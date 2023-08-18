package com.src.dao;

import java.util.List;

import com.src.model.Student;
import com.src.model.User;

public interface StudentDAO {
	
	public int addStudent(Student s);
	public int deleteStudent(Student s);
	public int editStudent(Student s);
	public Student displayStudent(int id);
	public List<Student> dispalyAllStudents();
	public int totalNumberOfStudents();
	
	public boolean getUser(User u);

}
