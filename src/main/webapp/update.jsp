<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="upadte" method="post">
	<input type="hidden" name="id1" value="<%=request.getParameter("id")%>"></br>
	<input type="text" name="uname" value="<%=request.getParameter("name")%>"></br>
	<button>update</button>
</form>
</body>
</html>