<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*, javax.servlet.*, com.Project.DatabaseCounter" %>
<%
    HttpSession sess = request.getSession(false); // Get the session, but don't create one if it doesn't exist
    if (sess == null || sess.getAttribute("login") == null || !(Boolean)sess.getAttribute("login") || sess.getAttribute("user") == null) {
        response.sendRedirect("index.html");
        return;
    }
    String username = (String) sess.getAttribute("user");
    int[]counts = DatabaseCounter.dbCount();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            min-height: 100vh;
        }
        .sidebar {
            width: 250px;
            background-color: #333;
            color: #fff;
            padding: 20px;
            box-sizing: border-box;
        }
        .sidebar ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }
        .sidebar ul li {
            padding: 10px 0;
        }
        .sidebar ul li a {
            color: #fff;
            text-decoration: none;
            display: block;
        }
        .sidebar ul li:hover {
            background-color: green;
        }
        .content {
            flex: 1;
            padding: 20px;
        }
        .bottom-bar {
            background-color: #5c5550;
            color: #fff;
            padding: 10px;
            position: fixed;
            font-size: 1.1rem;
            font-weight: bold;
            bottom: 0;
            width: 100%;
            text-align: center;
        }
        .list-item:hover {
            border-radius: 0.25rem;
            padding: 0.5rem;
        }
        .boxes:hover{
        	box-shadow: 0px 10px 10px 0px rgba(0,0,0,0.75);
        	background-color: green;
        	color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <h2>Dashboard</h2>
            <ul>
                <li class="list-item"><a href="createStudent.html"><i class = "fa fa-user-graduate" style = "font-size:1rem; margin-right: 0.5rem;"> Students</i></a></li>
                <li class="list-item"><a href="createBook.html"><i class = "fa fa-book-open" style = "font-size:1rem; margin-right: 0.5rem;"> Books</i></a></li>
                <li class="list-item"><a href="BookIssuer.jsp"><i class = "fa fa-book-reader" style = "font-size:1rem; margin-right: 0.5rem;"> Issue a Book</i></a></li>
                <li class="list-item"><a href="StudentTable.jsp"><i class = "fa fa-tasks" style = "font-size:1rem; margin-right: 0.5rem;"> Students List</i></a></li>
                <li class="list-item"><a href="BookTable.jsp"><i class = "fa fa-tasks" style = "font-size:1rem; margin-right: 0.5rem;"> Books List</i></a></li>
                <li class="list-item"><a href="BookIssueTable.jsp"><i class = "fa fa-tasks" style = "font-size:1rem; margin-right: 0.5rem;"> Issued Book List</i></a></li>
                <li class="list-item"><a href="logout"><i class = "fa fa-window-close" style = "font-size:1rem; margin-right: 0.5rem;"> Logout</i></a></li>
            </ul>
        </div>
        <div class="content">
            <!-- Main content area where data will be displayed -->
            <h1>Welcome to the Dashboard!</h1>
            <div style = "margin: 2rem; display: flex; justify-content: space-evenly; align-items: center; flex-wrap: wrap;">
            	<div style = "margin:2rem; width: 20%; height: 30vh; border-radius: 2rem; border: 2px solid black; padding: 1rem; display: flex; justify-content: center; align-items: center; flex-direction: column;" class = "boxes">
            		<div style = "font-size: 2rem; font-weight: bold; margin-bottom: 1rem;">
            			Students
            		</div>
            		<div style = "font-size: 2rem; font-weight: bold; margin-bottom: 1rem;">
            			<i class = "fa fa-user-graduate" style = "font-size:2rem; margin-right: 0.5rem;"> </i>
            		</div>
            		<div style = "font-size: 2rem; font-weight: bold; margin-bottom: 1rem;">
            			<%= counts[0] %>
            		</div>
            	</div>
            	<div style = "margin:2rem; width: 20%; height: 30vh; border-radius: 2rem; border: 2px solid black; padding: 1rem; display: flex; justify-content: center; align-items: center; flex-direction: column;" class = "boxes">
					<div style = "font-size: 2rem; font-weight: bold; margin-bottom: 1rem;">
            			Books
            		</div>
            		<div style = "font-size: 2rem; font-weight: bold; margin-bottom: 1rem;">
            			<i class = "fa fa-book-open" style = "font-size:2rem; margin-right: 0.5rem;"> </i>
            		</div>
            		<div style = "font-size: 2rem; font-weight: bold; margin-bottom: 1rem;">
            			<%= counts[1] %>
            		</div>
            	</div>
            	<div style = "margin:2rem; width: 20%; height: 30vh; border-radius: 2rem; border: 2px solid black; padding: 1rem; display: flex; justify-content: center; align-items: center; flex-direction: column;" class = "boxes">
					<div style = "font-size: 2rem; font-weight: bold; margin-bottom: 1rem;">
            			Issued Books
            		</div>
            		<div style = "font-size: 2rem; font-weight: bold; margin-bottom: 1rem;">
            			<i class = "fa fa-book-reader" style = "font-size:2rem; margin-right: 0.5rem;"> </i>
            		</div>
            		<div style = "font-size: 2rem; font-weight: bold; margin-bottom: 1rem;">
            			<%= counts[2] %>
            		</div>
            	</div>
            </div>
        </div>
    </div>
    <div class="bottom-bar">
        <p>Logged in as: <span id="username"><%= username %></span></p>
    </div>
</body>
</html>
