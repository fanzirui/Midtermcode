package com.cisc181.core;

import java.util.Calendar;
import java.util.Date;

import com.cisc181.eNums.eTitle;

public class Staff extends Employee {

	 private eTitle Title;

	   public Staff(eTitle title){
	        this.Title = title;
	    }

	    public void setTitle(eTitle title){
	        this.Title = title;
	    }
	    public eTitle getTitle(){
	        return this.Title;
	    }
	    
	    
	public static Date date(int year, int month, int day) {
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		return date.getTime();
		} 
    
	public Staff(double salary){
    	
    	this("","","",date(1992,6,8),"","","","",0,salary,date(2016,8,2),null);
    	super.setSalary(salary);
    }

    
	public Staff(String FirstName, String MiddleName, String LastName,
			Date DOB, String Address, String Phone_number, String Email,
			String officeHours, int rank, double salary, Date hireDate,
			eTitle Title) 
	
	{
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number,
				Email, officeHours, salary, hireDate);
		
		this.Title = Title;
	}

}