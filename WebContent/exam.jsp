<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exam Page</title>
</head>
<body>

	<%
		if(session.getAttribute("id")==null)
			response.sendRedirect("login.html");
	%>
	<h1>Hello, Exams Page !</h1>
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>