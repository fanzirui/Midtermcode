package com.cisc181.core;
import java.util.ArrayList;
import java.util.UUID;

public class Section {
	
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;

	public Section(UUID CourseID,UUID SemesterID,int RoomID, UUID SectionID) {
		
		this.CourseID=CourseID;
		this.SemesterID=SemesterID;
		this.RoomID=RoomID;
		this.SectionID=SectionID;
	}


	public UUID getCourseID() {
		return CourseID;
	}


	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}


	public UUID getSemesterID() {
		return SemesterID;
	}


	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}


	public UUID getSectionID() {
		return SectionID;
	}


	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}


	public int getRoomID() {
		return RoomID;
	}


	public void setRoomID(int roomID) {
		RoomID = roomID;
	}

	public double AverageGrade(ArrayList list){
		ArrayList<Enrollment> List=list;
		double sum=0;
		for (Enrollment En: List){
			sum+=En.getGrade();
		}
		double AverageGrade=sum/List.size();
		return AverageGrade;
		
	}
	
	
}
