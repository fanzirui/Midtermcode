package com.cisc181.core;
import java.util.UUID;


public class Course {
	
	private UUID CourseID;
	private String CourseName;
	private int Gradepoint;

	public Course(){
	}
	
	public Course(UUID CourseID, String CourseName, int Gradepoint){
		this.CourseID=CourseID;
		this.CourseName=CourseName;
		this.Gradepoint=Gradepoint;
		
	}


	public UUID getCourseID() {
		return CourseID;
	}


	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}


	public String getCourseName() {
		return CourseName;
	}


	public void setCourseName(String courseName) {
		CourseName = courseName;
	}


	public int getGradepoint() {
		return Gradepoint;
	}


	public void setGradepoint(int gradepoint) {
		Gradepoint = gradepoint;
	}
		
	

}
