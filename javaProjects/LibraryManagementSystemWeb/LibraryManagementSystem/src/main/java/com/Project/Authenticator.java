package com.Project;
import java.sql.*;
public class Authenticator {
	static boolean flag = false;
	public static boolean authenticate (String username, String password) {
		try {
			Connection con = ConnectionProvider.getConnection();
			String query = "SELECT username, password FROM users WHERE username = ? AND password = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String dbUsername = result.getString("username");
				String dbPassword = result.getString("password");
				if(username.equals(dbUsername) && password.equals(dbPassword)) {
					flag = true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
