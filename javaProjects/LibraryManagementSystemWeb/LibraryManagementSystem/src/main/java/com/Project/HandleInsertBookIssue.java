package com.Project;
import java.io.PrintWriter;

import javax.servlet.http.*;
public class HandleInsertBookIssue extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter print = res.getWriter();
			int studentId = Integer.parseInt(req.getParameter("studentId"));
			int bookId = Integer.parseInt(req.getParameter("bookId"));
			String issueDate = req.getParameter("issueDate");
			String dueDate = req.getParameter("dueDate");
			if(studentId != 0 && bookId != 0 && issueDate != null && dueDate != null) {
				boolean flag = InsertIssueBook.injectBook(studentId, bookId, issueDate, dueDate);
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
