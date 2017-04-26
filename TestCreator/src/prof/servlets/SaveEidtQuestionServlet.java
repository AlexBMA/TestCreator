package prof.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;
import factory.pack.ServiceFactory;
import model.Answer;
import model.Question;
import oracle.net.aso.q;
import services.BasicService;
import services.impl.QuestionServiceImpl;

/**
 * Servlet implementation class SaveEidtQuestionServlet
 */
@WebServlet("/SaveEidtQuestionServlet")
public class SaveEidtQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEidtQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String textQuestion = request.getParameter("textIntrebare").trim();
		int nrOfTotalAnswers = Integer.parseInt(request.getParameter("nrofanswers").trim());
		int questionId = Integer.parseInt(request.getParameter("questionid").trim());
		int testId = Integer.parseInt(request.getParameter("testid").trim());
		
		List<Answer> listAnswers = new ArrayList<>();
		
		Answer temp;
		String textAnswer;
		int trueFalse;
		int nrOfCorrectAnswers = 0;
		int answerId;
		
		
		for(int i=1;i<=nrOfTotalAnswers;i++)
		{
			textAnswer = request.getParameter("answertext"+i).trim();
			trueFalse = Integer.parseInt(request.getParameter("answer"+i));
			answerId = Integer.parseInt(request.getParameter("answerid"+i).trim());
			temp = new Answer(textAnswer,trueFalse);
			temp.setId(answerId);
			
			if(trueFalse == 1) nrOfCorrectAnswers++;
				
			listAnswers.add(temp);
		}
		
		Question question = new Question();
		question.setId(questionId);
		question.setQuestionText(textQuestion);
		question.setListAnswersi(listAnswers);
		question.setNumberOfCorrectAnswers(nrOfCorrectAnswers);
		question.setNumberOfAnswers(nrOfTotalAnswers);
		
		
		ServiceFactory.getService("Question").createItem(DB.getSessionFactory(), question);
		
		String NEXT_PAGE ="EditTestServlet";
		
		
		
		request.setAttribute("testid", testId);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(NEXT_PAGE);
		requestDispatcher.forward(request, response);
		
	}

}
