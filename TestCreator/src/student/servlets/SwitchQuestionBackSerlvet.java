package student.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import model.Item;
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

		// TestReport testReport =

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

		checkUserAnswers(request, theQuestion, attributeNames);

	}

	public void checkUserAnswers(HttpServletRequest request, Question theQuestion, Enumeration<String> paramNames) {
		
		List<Answer> answerList = theQuestion.getListAnswersi();
		List<String> paramName = new ArrayList<>();

		getParmeters(paramNames, paramName);

		List<String> userAnswerText = new ArrayList<>();
		
		getUserAnswersText(request, paramName, userAnswerText);
		

		int numberOfCorrectAnswers = theQuestion.getNumberOfCorrectAnswers();
		int numberOfCorrectAnswersFromUser = 0;
		
		int size = answerList.size();
		int size2 = userAnswerText.size();
		List<String> correctAnswers = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			Answer tempAnswer = answerList.get(i);
			if (tempAnswer.getTrueFalse() == 1) {
				correctAnswers.add(tempAnswer.getAnswerText());
				for (int j = 0; j < size2; j++) {
					if (tempAnswer.getAnswerText().equalsIgnoreCase(userAnswerText.get(j))) {
						numberOfCorrectAnswersFromUser++;
					}
				}
			}
		}

		HttpSession theSession = request.getSession(false);
		TestReport testReport = (TestReport)theSession.getAttribute("testreport");
		
		List<Item> testItem = testReport.getTestItems();
		Item tempItem = new Item();
		tempItem.setQuestionText(theQuestion.getQuestionText());
		tempItem.setMyAnswers(userAnswerText);
		tempItem.setCorrectAnswers(correctAnswers);
		testItem.add(tempItem);
		testReport.setTestItems(testItem);
		
		if (numberOfCorrectAnswersFromUser == numberOfCorrectAnswers) {
			testReport.setScore((testReport.getScore()+1));
		} 
		
		theSession.setAttribute("testreport", testReport);
		
		
	}

	public void getUserAnswersText(HttpServletRequest request, List<String> paramName, List<String> userAnswerText) {
		int size = paramName.size();
		for (int i = 0; i < size; i++) {

			if (!paramName.get(i).equalsIgnoreCase("index")) {
				userAnswerText.add(request.getParameter(paramName.get(i)));
			}
		}
	}

	public void getParmeters(Enumeration<String> attributeNames, List<String> paramName) {
		while (attributeNames.hasMoreElements()) {
			paramName.add(attributeNames.nextElement());
		}
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
