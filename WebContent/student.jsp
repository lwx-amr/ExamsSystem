<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("id")==null)
		response.sendRedirect("login.html");
%>

<%@ page import="DB.DatabaseHandler"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student Page</title>
		<style>
			.page{
				text-align: center;
				padding-top: 100px;
			}
			.btn{
				width: 200px;
				padding: 8px 0px;
				color: #fff;
				background-color: skyblue;
				display: inline-block;
				text-decoration: none;
			}
			.btn.gray{
				background-color: darkgray;
				border: 0;
			}
			.logout{
				margin-top: 300px;	
			}
		</style>
	</head>
	<body>
	
		<%
			String id = (String)session.getAttribute("id");
			DatabaseHandler hand = new DatabaseHandler();
			boolean before = hand.checkExam(id);
		%>
		
		<div class="page">
			<% if(!before) {%>
				<a href="exam.jsp" class="btn">Start exam</a>
			<% } else { %>
				<button type="button" class="btn gray">Start exam</button>
			<%} %>
			<form action="Logout" class="logout">
				<input type="submit" value="Logout">
			</form>
		</div>
		
	</body>
</html>