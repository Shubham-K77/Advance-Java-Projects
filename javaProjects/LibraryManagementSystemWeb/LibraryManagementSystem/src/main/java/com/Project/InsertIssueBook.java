package com.Project;
import java.sql.*;
public class InsertIssueBook {
	static boolean flag = false;
	public static boolean injectBook (int studentId, int bookId, String issueDate, String dueDate) {
		try {
			Connection con = ConnectionProvider.getConnection();
			String query = "INSERT INTO issuebook(studentId, bookId, issueDate, dueDate) VALUES(?, ?, ?, ?);";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.setInt(2, bookId);
			stmt.setString(3, issueDate);
			stmt.setString(4, dueDate);
			stmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
