<%@page import="Springmvcproject1.dto.EmployeeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%EmployeeDto obj=(EmployeeDto)request.getAttribute("object");%>
   <table border="">
   <tr>
     <th>id</th>
     <th>name</th>
   </tr>
   <tr>
   <td><%=obj.getId()%></td>
   <td><%=obj.getName()%></td>
   </tr>
      </table>

</body>
</html>