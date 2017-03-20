package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Student extends Person {

	private eMajor eMajor;
	private UUID StudentID;
	
	public eMajor getMajor ( )
    {
        return this.eMajor;
    }
    public void setMajor (eMajor eMajor)
    {
        this.eMajor = eMajor;    
    }
    
    public UUID getStudentID(){
    	return this.StudentID;
    }
    
	public Student(String FirstName, String MiddleName, String LastName,Date DOB, eMajor eMajor,
			String Address, String Phone_number, String Email)
	{
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number, Email);
		this.StudentID = UUID.randomUUID();
		this.eMajor = eMajor;
		
	}
	
	@Override
	public void PrintName() {
		System.out.println(getLastName() + ","  + getFirstName() + ' ' + getMiddleName());
	}

	public void PrintName(boolean bnormal)
	{
		super.PrintName();
	}
	
	public double GPA_Calculator(double G1,double G2,double G3,double G4,double G5,double G6){
		double [] Gades=new double[6];
		double [] GPA=new double[6];
		
		Gades[0]=G1;
		Gades[1]=G2;
		Gades[2]=G3;
		Gades[3]=G4;
		Gades[4]=G5;
		Gades[5]=G6;
		double TotalGPA=0;
		for (int i=0;i<Gades.length;i++){
			if(Gades[i]>=95.0){
				GPA[i]= 4.00;
			}
			else if (Gades[i]>=90.0){
				GPA[i]= 3.70;
			}
			else if (Gades[i]>=85.0){
				GPA[i]= 3.30;
			}
			else if (Gades[i]>=80.0){
				GPA[i]= 3.00;
			}
			else if (Gades[i]>=75.0){
				GPA[i]= 2.70;
			}
			else if (Gades[i]>=70.0){
				GPA[i]= 2.30;
			}
			else if (Gades[i]>=65.0){
				GPA[i]= 2.00;
			}
			else if (Gades[i]>=60.0){
				GPA[i]= 1.70;
			}
			else if (Gades[i]>=55.0){
				GPA[i]= 1.30;
			}
			else if (Gades[i]>=50.0){
				GPA[i]= 1.00;
			}
			else if (Gades[i]>=45.0){
				GPA[i]= 0.70;
			}
			else {
				GPA[i]= 0.00;
			}
			TotalGPA+=GPA[i];
			
		}
		double AverageGPA=((int)(TotalGPA*100/6.00))/100.00;
		
	
		return AverageGPA;
	}
}