package com.Project;
import java.sql.*;
public class InsertStudent {
	static boolean flag = false;
	public static boolean injectStudent(String firstName, String lastName, String gender, String program, String section) {
		try {
			Connection con = ConnectionProvider.getConnection();
			String query = "INSERT INTO students(firstName, lastName, gender, program, section) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, gender);
			stmt.setString(4, program);
			stmt.setString(5, section);
			stmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
