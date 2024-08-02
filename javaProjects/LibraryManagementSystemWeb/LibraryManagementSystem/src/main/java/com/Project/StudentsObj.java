package com.Project;

public class StudentsObj {
	int id;
	String firstName;
	String lastName;
	String gender;
	String program;
	String section;
	
	StudentsObj(int id, String firstName, String lastName, String gender, String program, String section){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.program = program;
		this.section = section;
	}
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getGender() {
		return gender;
	}
	public String getProgram() {
		return program;
	}
	public String getSection() {
		return section;
	}

}
