import DB.DatabaseHandler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String id = request.getParameter("id"); // Taken from form 
		String password = request.getParameter("password"); // Taken from form 
		
		DatabaseHandler hand = new DatabaseHandler();
		if(hand.checkLogin(id, password)) {
			System.out.println("Here");
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			response.sendRedirect(request.getContextPath() + "/student.jsp");
		}else {
			response.sendRedirect(request.getContextPath() + "/login.html");
		}
	}
	
}
