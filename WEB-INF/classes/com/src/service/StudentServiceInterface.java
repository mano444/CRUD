package com.src.service;
import java.util.ArrayList;
import java.util.List;

import com.src.model.Student;
import com.src.model.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
public interface StudentServiceInterface {
	
	
	
	ArrayList<Student> students = new ArrayList<>();
	
	public int addStudent(Student s);
	public int deleteStudent(Student s);
	public int editStudent(Student s);
	public Student displayStudent(int id);
	public List<Student> dispalyAllStudents();
	public int totalNumberOfStudents();
	
	public boolean getUser(User u);

}
