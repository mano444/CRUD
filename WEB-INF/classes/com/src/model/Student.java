package com.src.model;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Student implements Serializable{

	private int stdid; // non-static -> it can be accessed only using object
	private String stdname;
	private long stdmobile;
	private String stdaddress;
	private int stdm1marks;
	private int stdm2marks;
	private int stdm3marks;
	private int totalmarkssecured;
	private double stdpercentage;
	private char stdgrade;
	final static int totalnumberofsubjects=3;
	public static int totalnoofstudents; // static -> it is accessed by class name.
	final static int totalmarks = 300;
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(stdid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return stdid == other.stdid;
	}

	public Student() {
		
	}

	public Student(int stdid) {
		
		this.stdid = stdid;
	}
	
	

	public Student(int stdid, String stdname, long stdmobile, String stdaddress, int stdm1marks, int stdm2marks,
			int stdm3marks) {
		
		this.stdid = stdid;
		this.stdname = stdname;
		this.stdmobile = stdmobile;
		this.stdaddress = stdaddress;
		this.stdm1marks = stdm1marks;
		this.stdm2marks = stdm2marks;
		this.stdm3marks = stdm3marks;
		this.totalmarkssecured = assignTotalMarksSecured();
		this.stdpercentage = assignStdPercentage(this.totalmarkssecured);
		assignStdGrade(this.stdpercentage);
	}

	public Student(int stdid, String stdname, long stdmobile, String stdaddress, int stdm1marks, int stdm2marks,
			int stdm3marks, int totalmarkssecured, double stdpercentage, char stdgrade) {
		
		this.stdid = stdid;
		this.stdname = stdname;
		this.stdmobile = stdmobile;
		this.stdaddress = stdaddress;
		this.stdm1marks = stdm1marks;
		this.stdm2marks = stdm2marks;
		this.stdm3marks = stdm3marks;
		this.totalmarkssecured = totalmarkssecured;
		this.stdpercentage = stdpercentage;
		this.stdgrade = stdgrade;
	}

	public int getStdid() {
		return stdid;
	}

	public String getStdname() {
		return stdname;
	}

	public long getStdmobile() {
		return stdmobile;
	}

	public String getStdaddress() {
		return stdaddress;
	}

	public int getStdm1marks() {
		return stdm1marks;
	}

	public int getStdm2marks() {
		return stdm2marks;
	}

	public int getStdm3marks() {
		return stdm3marks;
	}

	public int getTotalmarkssecured() {
		return totalmarkssecured;
	}

	public double getStdpercentage() {
		return stdpercentage;
	}

	public char getStdgrade() {
		return stdgrade;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	public void setStdmobile(long stdmobile) {
		this.stdmobile = stdmobile;
	}

	public void setStdaddress(String stdaddress) {
		this.stdaddress = stdaddress;
	}

	public void setStdm1marks(int stdm1marks) {
		this.stdm1marks = stdm1marks;
	}

	public void setStdm2marks(int stdm2marks) {
		this.stdm2marks = stdm2marks;
	}

	public void setStdm3marks(int stdm3marks) {
		this.stdm3marks = stdm3marks;
	}

	public void setTotalmarkssecured(int totalmarkssecured) {
		this.totalmarkssecured = totalmarkssecured;
	}

	public void setStdpercentage(double stdpercentage) {
		this.stdpercentage = stdpercentage;
	}

	public void setStdgrade(char stdgrade) {
		this.stdgrade = stdgrade;
	}

	public int assignTotalMarksSecured() // type 3
	{
		return stdm1marks + stdm2marks + stdm3marks;
	}
	
	public double assignStdPercentage(int total) // type 4
	{
		return ((double)total/(double)totalnumberofsubjects);
	}
	
	public void assignStdGrade(double percentage) // type 2
	{
		if(percentage >75.0)
		{
			stdgrade='A';
		}
		else if(percentage >65.0 && percentage <=75)
		{
			stdgrade='B';
		}
		else if(percentage >55.0 && percentage <=65)
		{
			stdgrade='C';
		}
		else if(percentage >45.0 && percentage <=55)
		{
			stdgrade='D';
		}
		else if(percentage >35.0 && percentage <=45)
		{
			stdgrade='E';
		}
		else
		{
			stdgrade='F';
		}
		
		
	}
	
	
	public static void incTotalNoOfStudents()
	{
		totalnoofstudents++;
	}
	
	public static void decTotalNoOfStudents()
	{
		totalnoofstudents--;
	}
	
	
	public void display()// type 1
	{
		System.out.println("Student [stdid=" + stdid + ", stdname=" + stdname + ", stdmobile=" + stdmobile + ", stdaddress="
				+ stdaddress + ", stdm1marks=" + stdm1marks + ", stdm2marks=" + stdm2marks + ", stdm3marks="
				+ stdm3marks + ", totalmarkssecured=" + totalmarkssecured + ", stdpercentage=" + stdpercentage
				+ ", stdgrade=" + stdgrade + "]");	
	}

	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", stdname=" + stdname + ", stdmobile=" + stdmobile + ", stdaddress="
				+ stdaddress + ", stdm1marks=" + stdm1marks + ", stdm2marks=" + stdm2marks + ", stdm3marks="
				+ stdm3marks + ", totalmarkssecured=" + totalmarkssecured + ", stdpercentage=" + stdpercentage
				+ ", stdgrade=" + stdgrade + "]";
	}
	
	
	
}
