package com.Project;
import java.io.*;
import javax.servlet.http.*;

public class LogoutManager extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) {
        try {
            HttpSession session = req.getSession(false); // Get the session, but don't create one if it doesn't exist
            if (session != null) {
                session.invalidate(); // Invalidate the session to remove all attributes and mark it as invalid
            }
            res.sendRedirect("index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
