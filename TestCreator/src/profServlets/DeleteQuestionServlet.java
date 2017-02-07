package profServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;
import model.Question;
import model.Test;
import services.BasicService;
import services.QuestionService;
import services.TestService;

/**
 * Servlet implementation class DeleteQuestionServlet
 */
@WebServlet("/DeleteQuestionServlet")
public class DeleteQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int questionId =Integer.parseInt(request.getParameter("questionid").trim());
		int testId = Integer.parseInt(request.getParameter("testid").trim());
		
		BasicService<Question> questionService = new QuestionService();
		questionService.deleteItem(DB.getSessionFactory(), questionId);
		
		
		
		request.setAttribute("testid",  testId);
		
		String NEXT_PAGE="EditTestServlet";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(NEXT_PAGE);
		requestDispatcher.forward(request, response);
	}

}
