package com.pd.app;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

	int id;
	String name;
	private Timestamp dob1;
	Date dob;

	public Person(int id, String name, Timestamp dob1, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob1 = dob1;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDob1() {
		return dob1;
	}

	public void setDob1(String dob1) {
		if(dob1!=null){
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		Date parsedDate;
		try {
			parsedDate = dateFormat.parse(dob1);
			this.dob1= new Timestamp(parsedDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
		
	}
	
	public void setDob1(Timestamp dob1) {
		this.dob1 = dob1;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Person() {
		System.out.println("Defult person constructor");
	}

}
