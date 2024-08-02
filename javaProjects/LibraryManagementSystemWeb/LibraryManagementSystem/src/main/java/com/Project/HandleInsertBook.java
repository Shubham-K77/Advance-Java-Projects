package com.Project;
import javax.servlet.http.*;
import java.io.*;
public class HandleInsertBook extends HttpServlet{
	public void service (HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter print = res.getWriter();
			String authorName = req.getParameter("authorName");
			String title = req.getParameter("title");
			String publicationName = req.getParameter("publicationName");
			String subject = req.getParameter("subject");
			if(authorName != null && title != null && publicationName != null && subject != null) {
				boolean flag = InsertBook.injectBook(authorName, title, publicationName, subject);
				if(flag == true) {
					res.sendRedirect("Dashboard.jsp");
				}
				else {
					print.println("Failed To Inject Into Database!");
				}
			}else {
				print.println("Informations Can't Be Empty!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
