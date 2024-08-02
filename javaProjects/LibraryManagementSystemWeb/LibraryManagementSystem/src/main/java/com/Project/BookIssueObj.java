package com.Project;

public class BookIssueObj {
	
	String firstName;
	String title;
	String issueDate;
	String dueDate;
	
	BookIssueObj(String firstName, String title, String issueDate, String dueDate){
		this.firstName = firstName;
		this.title = title;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getTitle() {
		return title;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	
}
