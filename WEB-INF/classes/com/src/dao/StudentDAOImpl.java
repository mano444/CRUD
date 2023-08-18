package com.src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.src.model.Student;
import com.src.model.User;

public class StudentDAOImpl implements StudentDAO {

	Connection con=null;
	Statement st = null;
	
	public Statement getstdStatement()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/batch12";
			String username = "root";
			String password = "root";		
			con = DriverManager.getConnection(url, username, password); //step 2		
			st = con.createStatement();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		
		return st;
		
	}
	
	
	public void closeStatement()
	{
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int addStudent(Student s) {
		
		st = getstdStatement();
		int result=0;
		
		String sql ="insert into Student values("+s.getStdid()+",'"+s.getStdname()+"',"+s.getStdmobile()+",'"+s.getStdaddress()+"',"+s.getStdm1marks()+","+s.getStdm2marks()+","+s.getStdm3marks()+","+s.getTotalmarkssecured()+","+s.getStdpercentage()+",'"+s.getStdgrade()+"')";
		try {
			result = st.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeStatement();
		return result;
	}

	
	public int deleteStudent(Student s) {
		st = getstdStatement();		
		int result=0;
		String sql ="delete from student where stdid="+s.getStdid();		
		try {
			result = st.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeStatement();
		return result;
	}

	
	public int editStudent(Student s) {
		
		st = getstdStatement();		
		int result=0;
		String sql ="update student set stdname='"+s.getStdname()+"',stdmobile ="+s.getStdmobile()+",stdaddress='"+s.getStdaddress()+"',stdm1marks="+s.getStdm1marks()+",stdm2marks="+s.getStdm2marks()+",stdm3marks="+s.getStdm3marks()+", stdtotalmarks="+s.getTotalmarkssecured()+",stdpercentage="+s.getStdpercentage()+", stdgrade='"+s.getStdgrade()+"' where stdid="+s.getStdid();		
		try {
			result = st.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeStatement();
		return result;
	}

	
	public Student displayStudent(int id) {
		
		st = getstdStatement();		
		Student s=null;
		String sql ="select * from student where stdid="+id;		
		try {
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				s = new Student(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getDouble(9),rs.getString(10).charAt(0));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeStatement();
		
		return s;
	}

	
	public List<Student> dispalyAllStudents() {
		ArrayList<Student> students = new ArrayList<>();
		st = getstdStatement();		
		String sql ="select * from student";		
		try {
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				
				Student s = new Student(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getDouble(9),rs.getString(10).charAt(0));
				students.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeStatement();
		return students;

	}

	
	public int totalNumberOfStudents() {
		
		st = getstdStatement();
		int result=0;
		
		String sql ="select count(*) from student";
		
		try {
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeStatement();
		
		return result;
	}


	@Override
	public boolean getUser(User u) {
		
		st = getstdStatement();		
		String sql ="select * from User where username='"+u.getUsername()+"' and password='"+u.getPassword()+"'";		
		try {
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				return true;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeStatement();
		return false;
	}

}
