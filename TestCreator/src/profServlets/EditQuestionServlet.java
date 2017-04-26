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
import services.BasicService;
import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;
import servicesimpl.QuestionServiceImpl;

/**
 * Servlet implementation class EditQuestionServlet
 */
@WebServlet("/EditQuestionServlet")
public class EditQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int questionId =Integer.parseInt(request.getParameter("questionid").trim());
		int testId = Integer.parseInt(request.getParameter("testid").trim());
		
		BasicService<Question> questionService = new QuestionServiceImpl();
		
		Question question = questionService.getItem(DB.getSessionFactory(), questionId);
		
		PathCreatorPrefixAndSufix pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		
		request.setAttribute("question", question);
		request.setAttribute("testId", testId);
		
		String NEXT_PAGE ="EditQuestion";
		String path=pathCreator.createPath(NEXT_PAGE);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
