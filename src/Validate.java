

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// SQL Part
import java.sql.*;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String username = request.getParameter("username"); // Taken from form 
		String password = request.getParameter("password"); // Taken from form 
		
		DatabaseHandler hand = new DatabaseHandler();
		if(hand.checkLogin(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			response.sendRedirect(request.getContextPath() + "/student.jsp");
		}else {
			response.sendRedirect(request.getContextPath() + "/login.html");
		}
	}
	
}
