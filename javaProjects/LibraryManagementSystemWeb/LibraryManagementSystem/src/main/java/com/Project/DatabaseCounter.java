package com.Project;

import java.sql.*;

public class DatabaseCounter {
    public static int[] dbCount() {
        int[] counts = new int[3]; // Array to hold the counts: [studentCount, bookCount, issueCount]
        try {
            Connection con = ConnectionProvider.getConnection();
            
            // Counting students
            String studentQuery = "SELECT COUNT(id) AS 'studCount' FROM students;";
            Statement stmt1 = con.createStatement();
            ResultSet result1 = stmt1.executeQuery(studentQuery);
            if (result1.next()) {
                counts[0] = result1.getInt("studCount");
            }
            result1.close();
            stmt1.close();

            // Counting books
            String booksCounter = "SELECT COUNT(id) AS 'bookCount' FROM books;";
            Statement stmt2 = con.createStatement();
            ResultSet result2 = stmt2.executeQuery(booksCounter);
            if (result2.next()) {
                counts[1] = result2.getInt("bookCount");
            }
            result2.close();
            stmt2.close();

            // Counting issued books
            String issuedBookCounter = "SELECT COUNT(issueId) AS 'issueCount' FROM issuebook;";
            Statement stmt3 = con.createStatement();
            ResultSet result3 = stmt3.executeQuery(issuedBookCounter);
            if (result3.next()) {
                counts[2] = result3.getInt("issueCount");
            }
            result3.close();
            stmt3.close();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return counts;
    }
}
