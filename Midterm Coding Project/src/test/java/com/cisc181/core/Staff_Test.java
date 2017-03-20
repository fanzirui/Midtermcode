package com.cisc181.core;

import static org.junit.Assert.*;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;


import com.cisc181.eNums.eTitle;



import com.cisc181.core.Person;
import com.cisc181.core.PersonException;
public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void test_AverageSalary() {
		
			ArrayList<Staff> stafflist = new ArrayList<Staff>();
			double Salary1=10;
			double Salary2=20;
			double Salary3=40;
			double Salary4=50;
			double Salary5=90;
			stafflist.add(new Staff(Salary1));
			stafflist.add(new Staff(Salary2));
			stafflist.add(new Staff(Salary3));
			stafflist.add(new Staff(Salary4));
			stafflist.add(new Staff(Salary5));
			double sum=0;
			double expectAverage=(Salary1+Salary2+Salary3+Salary4+Salary5)/5;
			for (Staff staff: stafflist){
				
				sum+=staff.getSalary();
			}
			double actualAverage=sum/stafflist.size();
			assertEquals(expectAverage,actualAverage,0.00001);


	}	

	public void Phonenumber(String phone_num) throws PersonException{
		Employee newemployee=new Employee(phone_num);
		
		String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(newemployee.getPhone());
		String test_phone=matcher.replaceFirst("($1)-$2-$3");
		
		if (matcher.matches()==false){
			throw new PersonException(newemployee);
		}
		else if (matcher.matches()==true && !(newemployee.getPhone().equals(test_phone))){
			throw new PersonException(newemployee);
		}
		else {
			System.out.println(newemployee.getPhone()+" is valid");
		}
	}
	
	
	//Method 1 Having exception
	@Test(expected=PersonException.class)
	public void test_Phonenumber1() throws PersonException {
		Phonenumber("(302)5326981");
	}	
	
	//Method 1 Having exception
	@Test(expected=PersonException.class)
	public void test_Phonenumber2() throws PersonException {
		Phonenumber("(302) 532-6981");	
	}
	
	//Method 2 Having exception
	@Test
	public void test_Phonenumber3() {
		boolean result1=false;
		boolean result2=true;
		try{
			
			Phonenumber("30253269");
			result2=false;
		}
		catch(PersonException ex){
			result1=true;
		}
		// If it is true, the exception is thrown. If it is false, there is no exception.
		assertTrue("The format for phone number is correct and there is no exception ",result1);
	}
	
	//Method 2 no exception 
	@Test
	public void test_Phonenumber4() {
		boolean result1=false;
		boolean result2=true;
		try{
			
			Phonenumber("(302)-532-6981");
			result2=false;
		}
		catch(PersonException ex){
			result1=true;
		}
		// If it is true, the exception is thrown. If it is false, there is no exception.
		assertFalse("The format for phone number is wrong and there is an exception ",result2);
	}
	
	public static Date date(int year, int month, int day) {
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		return date.getTime();
		} 
	
	public void DOB(Date DOB) throws PersonException{
		Employee newemployee=new Employee(DOB);
		Date current_date=new Date();
		
	
		int diff = current_date.getYear() - DOB.getYear();
		if (DOB.getMonth() > current_date.getMonth() || 
				(DOB.getMonth() == current_date.getMonth() && DOB.getDay() > current_date.getDay())) {
		
			diff--;
		}
		
		
		if (diff>100){
			throw new PersonException(newemployee);
		}
		else {
			System.out.println(newemployee.getDOB()+" is valid");
		}
		
	}
	

	//Method 1 Having exception
	@Test(expected=PersonException.class)
	public void test_DOB1() throws PersonException {
		Date date=date(1881,2,6); 
		DOB(date);
	}	
	
	//Method 1 Having exception
	@Test(expected=PersonException.class)
	public void test_DOB2() throws PersonException {
		Date date=date(1001,12,16); 
		DOB(date);
	}	
	
	//Method 2 Having exception
	@Test
	public void test_DOB3() {
	;
		boolean result=false;
		Date date=date(1912,10,10); 
		try{
			
			DOB(date);
		}
		catch(PersonException ex){
			result=true;
		}
		// If it is true, the exception is thrown. If it is false, there is no exception.
		assertTrue("DOB given is less than or equal 100 years older than the current date and there is no exception ",result);
	}
	
	//Method 2 no exception
	@Test
	public void test_DOB4() {
	;
		boolean result=false;
		Date date=date(1996,8,2); 
		try{
			
			DOB(date);
		}
		catch(PersonException ex){
			result=true;
		}
		// If it is true, the exception is thrown. If it is false, there is no exception.
		assertFalse("DOB given is larger than or equal 100 years older than the current date and there is an exception ",result);
	}
	
	
	
	
	
	
	
	
	
}