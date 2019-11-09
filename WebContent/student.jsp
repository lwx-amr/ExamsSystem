<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Page</title>
</head>
<body>

	<%
		if(session.getAttribute("username")==null)
			response.sendRedirect("login.html");
	%>
	<h1>Hello, Student Page !</h1>

	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>