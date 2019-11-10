

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DatabaseHandler;

/**
 * Servlet implementation class ExamSubmit
 */
@WebServlet("/ExamSubmit")
public class ExamSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("id"); 
		String qustion = request.getParameter("question");
		String answer = request.getParameter("answer");
		DatabaseHandler hand = new DatabaseHandler();
		hand.submitExam(Integer.parseInt(sid), qustion, answer);
		response.sendRedirect(request.getContextPath() + "/student.jsp");
	}
	
}
