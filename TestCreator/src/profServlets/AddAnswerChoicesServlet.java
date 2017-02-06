package profServlets;

import java.io.IOException;
import java.util.ArrayList;
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

import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;


/**
 * Servlet implementation class AdaugaVarianteDeRaspuns
 */
@WebServlet("/AdaugaVarianteDeRaspuns")
public class AddAnswerChoicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnswerChoicesServlet() {
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
		// TODO Auto-generated method stub
	
		
		int numberOfCorrectAnswers = Integer.parseInt(request.getParameter("numarVarianteCorecte").trim());
		int numberOfIncorrectAnswers = Integer.parseInt(request.getParameter("numarVarianteIncorecte").trim());
		String textQuestion = request.getParameter("textIntreabare").trim();
			
		
		List<Answer> listAnswers = createAnswerList(request,numberOfCorrectAnswers,numberOfIncorrectAnswers);
		
		Question question = new Question(textQuestion , numberOfCorrectAnswers, listAnswers.size(), listAnswers);
		
		HttpSession theSession = request.getSession(false);
		Test test = (Test) theSession.getAttribute("test");
		test.getListQuestions().add(question);
		theSession.setAttribute("test",test);
				
		
		String msg= "Intrebare creata cu succes";
		System.out.println(msg);
		
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		final String  NEXT_PAGE_NAME = "AddQuestion";
		
		String  path=pathCreator.createPath(NEXT_PAGE_NAME);	
		
				
		RequestDispatcher  requestDispacher = request.getRequestDispatcher(path);
		requestDispacher.forward(request, response);
		
	}
	
	protected List<Answer> createAnswerList(HttpServletRequest request, int numberOfCorrectAnswers,int numberOfIncorrectAnswers)
	{	
		List<Answer> listAnswers = new ArrayList<>();
		
		Answer answer;
		String answerText;
		
		for(int i=0;i<numberOfCorrectAnswers;i++)
		{
			answerText = request.getParameter("textRaspunsC"+i).trim();	
			answer = new Answer(answerText , 1);
			listAnswers.add(answer);		
		}
		
		for(int i=0;i<numberOfIncorrectAnswers;i++)
		{
			answerText = request.getParameter("textRaspunsI"+i).trim();
			answer = new Answer(answerText, 0);
			listAnswers.add(answer);
		}
		
		return listAnswers;
	}

}
