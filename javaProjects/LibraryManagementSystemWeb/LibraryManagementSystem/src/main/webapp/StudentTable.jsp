<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.Project.StudentFetcher" %>
<%@ page import="com.Project.StudentsObj" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Students List</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            display: flex;
            min-height: 100vh;
            width: 100%;
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
        .list-item:hover {
            border-radius: 0.25rem;
            padding: 0.5rem;
        }
        .form-container {
            background-color: #fff;
            padding: 2rem;
            border-radius: 1rem;
            box-shadow: 0px 10px 20px rgba(0,0,0,0.1);
            max-width: 500px;
            width: 100%;
            margin: auto;
        }
        .form-container h2 {
            margin-bottom: 1rem;
            font-size: 2rem;
            color: #333;
            text-align: center;
        }
        .form-group {
            margin-bottom: 1rem;
        }
        .form-group label {
            display: block;
            font-size: 1rem;
            margin-bottom: 0.5rem;
        }
        .form-group select {
            width: 100%;
            padding: 0.5rem;
            font-size: 1rem;
            border: 1px solid #ccc;
            border-radius: 0.25rem;
            background-color: #fff;
        }
        .form-group button {
            width: 100%;
            padding: 0.75rem;
            font-size: 1rem;
            color: #fff;
            background-color: #333;
            border: none;
            border-radius: 0.25rem;
            cursor: pointer;
            margin-top: 1rem;
        }
        .form-group button:hover {
            background-color: green;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 15px;
            text-align: left;
        }
        th {
            background-color: #333;
            color: #fff;
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
                <li class="list-item"><a href="Dashboard.jsp"><i class = "fa fa-school" style = "font-size:1rem; margin-right: 0.5rem;"> Home</i></a></li>
                <li class="list-item"><a href="logout"><i class = "fa fa-window-close" style = "font-size:1rem; margin-right: 0.5rem;"> Logout</i></a></li>
            </ul>
        </div>
        <div class="content">
            <h2>Students List</h2>
        	<table>
            	<thead>
                	<tr>
                    	<th>ID</th>
                    	<th>First Name</th>
                    	<th>Last Name</th>
                    	<th>Gender</th>
                    	<th>Program</th>
                    	<th>Section</th>
                	</tr>
            	</thead>
            	<tbody>
                	<% 
                		int id = 1;
                    	StudentFetcher studentFetcher = new StudentFetcher();
                		List<StudentsObj> students = studentFetcher.getStudents();
                    	for (StudentsObj student : students) {
                	%>
                		<tr>
                    		<td><%= id++ %></td>
                    		<td><%= student.getFirstName() %></td>
                    		<td><%= student.getLastName() %></td>
                    		<td><%= student.getGender() %></td>
                    		<td><%= student.getProgram() %></td>
                    		<td><%= student.getSection() %></td>
                		</tr>
                	<% } %>
            	</tbody>
        	</table>
        </div>
</div>
</body>
</html>
