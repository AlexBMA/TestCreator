package studentServlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Answer;
import model.Question;
import model.Test;
import model.TestReport;
import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;

/**
 * Servlet implementation class SwitchQuestionBackSerlvet
 */
@WebServlet("/SwitchQuestionBackSerlvet")
public class SwitchQuestionBackSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SwitchQuestionBackSerlvet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int currentIndex = Integer.parseInt(request.getParameter("index"));
		int indexOfCurrentQuestion = currentIndex + 1;

		HttpSession theSession = request.getSession(false);
		Test localTest = (Test) theSession.getAttribute("test");

		//TestReport testReport = 

		getAndCheckAnswer(request, currentIndex, localTest);

		PathCreatorPrefixAndSufix pathCreator = new PathCreatorPrefixAndSufixImpl();

		String NEXT_PAGE_NAME = "TakeTest";
		String path = pathCreator.createPath(NEXT_PAGE_NAME);

		if (indexOfCurrentQuestion == localTest.getNumberOfQuestions()) {

			NEXT_PAGE_NAME = "TestScore";
			path = pathCreator.createPath(NEXT_PAGE_NAME);
		}
		
		request.setAttribute("currentquestion", indexOfCurrentQuestion);

		RequestDispatcher reqDispacher = request.getRequestDispatcher(path);
		reqDispacher.forward(request, response);
	}

	public void getAndCheckAnswer(HttpServletRequest request, int currentIndex, Test localTest) {

		

		Question theQuestion = localTest.getListQuestions().get(currentIndex);

		Enumeration<String> attributeNames = request.getParameterNames();

		String radioQuestionAnswer = "radioanswer";
		String checkQuestionAnswer = "checkanswer";

		List<Answer> answerList = theQuestion.getListAnswersi();
		
		

		while (attributeNames.hasMoreElements()) {
			String name = attributeNames.nextElement();

			if (name.contains(radioQuestionAnswer)) {

				if (checkAnswer(request, theQuestion, answerList, 1)) {
					System.out.println("Q radio was answerd correct");
					
				}

			}
			if (name.contains(checkQuestionAnswer)) {
				if (checkAnswer(request, theQuestion, answerList, 2)) {
					System.out.println("Q check  was answerd correct");
					
				}
			}

		}
		
	}

	public boolean checkAnswer(HttpServletRequest request, Question theQuestion, List<Answer> answerList, int mode) {

		int numberOfAnswers = theQuestion.getNumberOfAnswers();
		int numberOfCorrectAnswers = theQuestion.getNumberOfCorrectAnswers();

		int answers = 0;

		for (int i = 0; i < numberOfAnswers; i++) {
			Answer answer = answerList.get(i);

			if (answer.getTrueFalse() == 1 && mode == 1) {

				if (answer.getAnswerText().equals(request.getParameter("radioanswer" + i))) {
					answers++;
				}
			}

			if (answer.getTrueFalse() == 1 && mode == 2) {
				if (answer.getAnswerText().equals(request.getParameter("checkanswer" + i))) {
					answers++;
				}
			}
		}

		if (answers == numberOfCorrectAnswers)
			return true;

		return false;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
