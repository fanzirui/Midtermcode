package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	private static ArrayList<Course>Courselist = new ArrayList<Course>(3);
	private static ArrayList<Semester>Semesterlist = new ArrayList<Semester>(2);
	private static ArrayList<Section>Sectionlist = new ArrayList<Section>(2);
	private static ArrayList<Student>Studentlist = new ArrayList<Student>(10);

	
	public static Date date(int year, int month, int day) {
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		return date.getTime();
		}
	@BeforeClass
	public static void setup() {
		


		Courselist.add(new Course(UUID.randomUUID(), "CHEM", 4));
		Courselist.add(new Course(UUID.randomUUID(), "NURSING", 4));
		Courselist.add(new Course(UUID.randomUUID(), "BUSINESS", 4));
		Semester Spring=new Semester(UUID.randomUUID(),date(2016,2,8),date(2016,5,22));
		Semester fall =new Semester(UUID.randomUUID(),date(2016,9,1),date(2016,12,14));
		Semesterlist.add(Spring);
		Semesterlist.add(fall);
		for (Semester a: Semesterlist){
			for(Course b:Courselist){
				Sectionlist.add(new Section(b.getCourseID(),a.getSemesterID(),(int) (Math.random()*100),UUID.randomUUID()));
			}
		}
		

		Studentlist.add(new Student("AA","","aa", date(1995,5,14),eMajor.BUSINESS, "1 Montague Rd","(202) 568-8911","1fjlafjaui@udel.edu" ));
		Studentlist.add(new Student("BB","","bb", date(1995,6,12),eMajor.BUSINESS, "2 Montague Rd","(202) 568-8912","2fjlafjaui@udel.edu" ));
		Studentlist.add(new Student("CC","","cc", date(1995,6,24),eMajor.BUSINESS, "3 Montague Rd","(202) 568-8913","3fjlafjaui@udel.edu" ));
		Studentlist.add(new Student("DD","","dd", date(1995,2,12),eMajor.BUSINESS, "4 Montague Rd","(202) 568-8914","4fjlhtaui@udel.edu" ));
		Studentlist.add(new Student("EE","","ee", date(1995,11,15),eMajor.CHEM, "5 Montague Rd","(202) 568-8915","5fjlafjaui@udel.edu" ));
		Studentlist.add(new Student("FF","","ff", date(1995,12,14),eMajor.CHEM, "6 Montague Rd","(202) 568-8916","6fjlafjaui@udel.edu" ));
		Studentlist.add(new Student("GG","","gg", date(1995,5,19),eMajor.BUSINESS, "7 Montague Rd","(202) 568-8917","7fjlafjaui@udel.edu" ));
		Studentlist.add(new Student("HH","","hh", date(1995,6,9),eMajor.BUSINESS, "8 Montague Rd","(202) 568-8918","8fjlafjaui@udel.edu" ));
		Studentlist.add(new Student("II","","ii", date(1995,12,16),eMajor.BUSINESS, "9 Montague Rd","(202) 568-8919","9fjlafjaui@udel.edu" ));
		Studentlist.add(new Student("JJ","","jj", date(1995,11,15),eMajor.BUSINESS, "10 Montague Rd","(202) 568-1910","10fjlafjaui@udel.edu" ));

}

	
	@Test
	public void test_GPA() {
		ArrayList<Enrollment> Enrollmentlist= new ArrayList<Enrollment>();
		
		int i=0;
		int j=0;
		
		for (Student students: Studentlist){
			i+=1;
			for(Section sections: Sectionlist  ){
				j+=1;
				Enrollmentlist.add(new Enrollment(students.getStudentID(), sections.getSectionID())); 
				
			}
		}
		
		Enrollmentlist.get(0).setGrade(100);
		Enrollmentlist.get(1).setGrade(90);
		Enrollmentlist.get(2).setGrade(60);
		Enrollmentlist.get(3).setGrade(80);
		Enrollmentlist.get(4).setGrade(84);
		Enrollmentlist.get(5).setGrade(95);
		
		
		double averageGPA=Studentlist.get(0).GPA_Calculator(Enrollmentlist.get(0).getGrade(), Enrollmentlist.get(1).getGrade(),
					Enrollmentlist.get(2).getGrade(), Enrollmentlist.get(3).getGrade(), 
					Enrollmentlist.get(4).getGrade(), Enrollmentlist.get(5).getGrade());
		assertEquals(averageGPA,3.23,0.0001);
	}
	
	@Test 
	public void test_averageGrade(){
		ArrayList<Enrollment> Enrollmentlist= new ArrayList<Enrollment>();
		
		int i=0;
		int j=0;
		
		for (Student students: Studentlist){
			i+=1;
			for(Section sections: Sectionlist  ){
				j+=1;
				Enrollmentlist.add(new Enrollment(students.getStudentID(), sections.getSectionID())); 
				
			}
		}
		
		Enrollmentlist.get(0).setGrade(100);Enrollmentlist.get(30).setGrade(90);
		Enrollmentlist.get(6).setGrade(90);Enrollmentlist.get(36).setGrade(86);
		Enrollmentlist.get(12).setGrade(60);Enrollmentlist.get(42).setGrade(40);
		Enrollmentlist.get(18).setGrade(80);Enrollmentlist.get(48).setGrade(80);
		Enrollmentlist.get(24).setGrade(84);Enrollmentlist.get(54).setGrade(90);
		ArrayList<Enrollment> list=new ArrayList<Enrollment>(10);
		list.addAll(Arrays.asList(Enrollmentlist.get(0),Enrollmentlist.get(6),
				Enrollmentlist.get(12),Enrollmentlist.get(18),
				Enrollmentlist.get(24),Enrollmentlist.get(30),
				Enrollmentlist.get(36),Enrollmentlist.get(42),
				Enrollmentlist.get(48),Enrollmentlist.get(54)));
		assertEquals(Sectionlist.get(0).AverageGrade(list),80,0.000001);
		
	}
	
	@Test
	public void change_major(){
		assertEquals(Studentlist.get(1).getMajor(), eMajor.BUSINESS);
		
		Studentlist.get(1).setMajor ( eMajor.PHUSICS);
		assertEquals(Studentlist.get(1).getMajor(), eMajor.PHUSICS);
		
		
	}
	
}