package studentServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Question;
import model.Test;
import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;

/**
 * Servlet implementation class SwitchQuestionServlet
 */
@WebServlet("/SwitchQuestionServlet")
public class SwitchQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SwitchQuestionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int questionId = Integer.parseInt(request.getParameter("questionid"));
	

		HttpSession theSession = request.getSession(false);

		Test currentTest = (Test) theSession.getAttribute("test");

		
		int indexOfCurrentQuestion = getSelectedQuestion(questionId, currentTest);
		
		
		

		PathCreatorPrefixAndSufix pathCreator = new PathCreatorPrefixAndSufixImpl();

		final String NEXT_PAGE_NAME = "TakeTest";
		String path = pathCreator.createPath(NEXT_PAGE_NAME);

		request.setAttribute("currentquestion", indexOfCurrentQuestion);

		RequestDispatcher reqDispacher = request.getRequestDispatcher(path);
		reqDispacher.forward(request, response);

	}

	public int getSelectedQuestion(int questionId, Test currentTest) {
		int size = currentTest.getNumberOfQuestions();
		List<Question> questionList = currentTest.getListQuestions();
		int indexOfCurrentQuestion=0;

		for (int i = 0; i < size; i++) {
			if (questionList.get(i).getId() == questionId) {
				indexOfCurrentQuestion = i;
				break;
			}
		}
		return indexOfCurrentQuestion;
	}
	
	
	
}
