package com.Project;
import java.sql.*;
public class InsertBook {
	static boolean flag = false;
	public static boolean injectBook (String authorName, String title, String publicationName, String subject) {
		try {
			Connection con = ConnectionProvider.getConnection();
			String query = "INSERT INTO books(authorName, title, publicationName, subject) VALUES(?, ?, ?, ?);";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, authorName);
			stmt.setString(2, title);
			stmt.setString(3, publicationName);
			stmt.setString(4, subject);
			stmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
