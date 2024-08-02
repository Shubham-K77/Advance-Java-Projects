package com.Project;
import java.sql.*;
import java.util.*;
public class StudentFetcher {
	static ArrayList<StudentsObj>Students = new ArrayList<>();
	public static ArrayList getStudents() {
		Students.clear();  // Clear the list before populating
		try {
			Connection con = ConnectionProvider.getConnection();
			String query = "SELECT * FROM students;";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String gender = result.getString("gender");
				String program = result.getString("program");
				String section = result.getString("section");
				StudentsObj stud = new StudentsObj(id, firstName, lastName, gender, program, section);
				Students.add(stud);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Students;
	}
}
