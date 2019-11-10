<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("id")==null)
		response.sendRedirect("login.html");
%>

<%@ page import="DB.DatabaseHandler"%>
<%@ page import="java.util.ArrayList" %>

<% 
	DatabaseHandler hand = new DatabaseHandler();
	ArrayList<String> finalOutput = hand.getQuestion();
	String question = finalOutput.get(0); 
	String ans1 = finalOutput.get(1);
	String ans2 = finalOutput.get(2);
	String ans3 = finalOutput.get(3);
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
				<form action="ExamSubmit" class="logout">
					<label><%= question  %></label>
					<input type="text" hidden name="question" value="<%=question%>">
					<br><br>
					<input type="radio" name="answer" value="<%= ans1 %>"> <%= ans1 %>
					<br>
					<input type="radio" name="answer" value="<%= ans2 %>"> <%= ans2 %>
					<br>
					<input type="radio" name="answer" value="<%= ans3 %>"> <%= ans3 %>
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