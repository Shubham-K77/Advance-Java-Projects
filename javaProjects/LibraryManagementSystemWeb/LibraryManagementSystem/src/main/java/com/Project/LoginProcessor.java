package com.Project;

import java.io.*;
import javax.servlet.http.*;

public class LoginProcessor extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            PrintWriter printer = res.getWriter();

            if (username == null || password == null) {
                printer.println("Credentials Can't Be Empty!");
            } else {
                boolean flag = Authenticator.authenticate(username, password);
                if (flag) {
                    // Invalidate the current session and create a new one
                    HttpSession oldSession = req.getSession(false);
                    if (oldSession != null) {
                        oldSession.invalidate();
                    }
                    HttpSession newSession = req.getSession(true);
                    newSession.setAttribute("user", username);
                    newSession.setAttribute("login", true);
                    res.sendRedirect("Dashboard.jsp");
                } else {
                    printer.println("Credentials Invalid!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
