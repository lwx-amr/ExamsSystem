<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("id")==null)
		response.sendRedirect("login.html");
%>

<% 
	String question = "What is you name?"; 
	String ans1 = "Amr";
	String ans2 = "Ahmed";
	String ans3 = "Sara";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Exam Page</title>
		<style>
			.page{
				text-align:center;
				padding-top: 60px;
			}
			h1{
				margin-bottom: 100px;
			}
			.logout{
				margin-top: 100px;
			}
			.question{
				width: 600px;
				margin: auto;
				text-align: left;
			}
			.btn{
				padding: 5px 15px;
				border: 0;
				background-color: tomato;
				color: #fff;
			}
		</style>
	</head>
	<body>
		<div class="page">
			<h1>Hello, Exams Page !</h1>
			<div class="question">
				<form action="#" class="logout">
					<label><%= question  %></label>
					<br><br>
					<input type="radio" name="asnwer" value="<%= ans1 %>"> <%= ans1 %>
					<br>
					<input type="radio" name="asnwer" value="<%= ans2 %>"> <%= ans2 %>
					<br>
					<input type="radio" name="asnwer" value="<%= ans3 %>"> <%= ans3 %>
					<br><br>
					<input type="submit" value="Submit" class="btn">
				</form>
			</div>
			<form action="Logout" class="logout">
				<input type="submit" value="Logout">
			</form>
		</div>
	</body>
</html>