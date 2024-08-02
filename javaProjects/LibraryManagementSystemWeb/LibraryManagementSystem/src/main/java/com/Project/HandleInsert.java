package com.Project;
import javax.servlet.http.*;
import java.io.*;
public class HandleInsert extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter print = res.getWriter();
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String gender = req.getParameter("gender");
			String program = req.getParameter("program");
			String section = req.getParameter("section");
			if(firstName != null && lastName != null && gender != null && program != null && section != null) {
				boolean flag = InsertStudent.injectStudent(firstName, lastName, gender, program, section);
				if(flag == true) {
					print.println("Student Successfully Inserted! New Value Updated In The Dashboard!");
					res.sendRedirect("Dashboard.jsp");
				}else {
					print.println("Sorry! Injection Failed!");
				}
			}else {
				print.println("Student Credentials Shouldn't Be Empty!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
