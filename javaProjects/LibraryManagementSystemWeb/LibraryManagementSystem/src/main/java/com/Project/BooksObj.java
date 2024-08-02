package com.Project;

public class BooksObj {
	int id;
	String authorName;
	String title;
	String publicationName;
	String subject;

	BooksObj(int id, String authorName, String title, String publicationName, String subject){
		this.id = id;
		this.authorName = authorName;
		this.title = title;
		this.publicationName = publicationName;
		this.subject = subject;
	}
	
	
	public int getId() {
		return id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public String getTitle() {
		return title;
	}
	public String getPublicationName() {
		return publicationName;
	}
	public String getSubject() {
		return subject;
	}
}
