<%@page import="Springmvcproject1.dto.EmployeeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
    <h2>Employee List</h2>
    <%
        List<EmployeeDto> employees = (List<EmployeeDto>) request.getAttribute("object");
        if (employees != null && !employees.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            <% for (EmployeeDto employee : employees) { %>
            <tr>
                <td><%= employee.getId() %></td>
                <td><%= employee.getName() %></td>
                <td>
                    <a href="delete?id=<%= employee.getId() %>">Delete</a>
                    <a href="update?id=<%= employee.getId() %>&name=<%= employee.getName() %>">Edit</a>
                </td>
            </tr>
            <% } %>
        </table>
    <% } else { %>
        <p>No employees found.</p>
    <% } %>
</body>
</html>
