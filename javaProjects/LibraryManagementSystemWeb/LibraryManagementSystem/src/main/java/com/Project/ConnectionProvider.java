package com.Project;
import java.sql.*;
public class ConnectionProvider {
	static Connection con;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem", "root", "Shubham@707");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
