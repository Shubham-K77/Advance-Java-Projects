package com.Project;
import java.sql.*;
import java.util.*;
public class BooksFetcher {
	static ArrayList<BooksObj> Books = new ArrayList<>();
	public static ArrayList getBooks() {
		Books.clear();  // Clear the list before populating
		try {
			Connection con = ConnectionProvider.getConnection();
			String query = "SELECT * FROM books;";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String authorName = result.getString("authorName");
				String title = result.getString("title");
				String publicationName = result.getString("publicationName");
				String subject = result.getString("subject");
				BooksObj book = new BooksObj(id, authorName, title, publicationName, subject);
				Books.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Books;
	}
}
