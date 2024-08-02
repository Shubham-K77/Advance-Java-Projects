package com.Project;
import java.sql.*;
import java.util.*;
public class BookIssueFetcher {
	static ArrayList<BookIssueObj> BookIssue = new ArrayList<>();
	public static ArrayList getBooksIssued() {
		BookIssue.clear();  // Clear the list before populating
		try {
			Connection con = ConnectionProvider.getConnection();
			String query = "SELECT s.firstName, b.title, i.issueDate, i.dueDate FROM issuebook i JOIN students s ON i.studentId = s.id JOIN books b ON i.bookId = b.id; ";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String firstName = result.getString("s.firstName");
				String title = result.getString("b.title");
				String issueDate = result.getString("i.issueDate");
				String dueDate = result.getString("i.dueDate");;
				BookIssueObj book = new BookIssueObj(firstName, title, issueDate, dueDate);
				BookIssue.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return BookIssue;
	}
}
