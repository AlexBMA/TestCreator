package profServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AnswerDao;
import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;
import services.QuestionDao;

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
	
		String testName= request.getParameter("numeTest").trim();
		String testCreator = request.getParameter("numeAutor").trim();
		int numberOfQuestions =  Integer.parseInt(request.getParameter("numarIntrebari").trim());
		
		
		int numberOfCorrectAnswers = Integer.parseInt(request.getParameter("numarVarianteCorecte").trim());
		int numberOfIncorrectAnswers = Integer.parseInt(request.getParameter("numarVarianteIncorecte").trim());
		String textQuestion = request.getParameter("textIntreabare").trim();
		
		//System.out.println("Text intreabre:"+textIntrebare);
		
		AnswerDao.createListaRaspunsuri();
		
		for(int i=0;i<numberOfCorrectAnswers;i++)
		{
			String correctAnswer = request.getParameter("textRaspunsC"+i).trim();
		//	System.out.println(variantaCorecta);
			
			AnswerDao.createRaspuns(correctAnswer, 1);
			
		}
		
		for(int i=0;i<numberOfIncorrectAnswers;i++)
		{
			String incorrectAnswer = request.getParameter("textRaspunsI"+i).trim();
		//	System.out.println(variantaGresita);
			
			AnswerDao.createRaspuns(incorrectAnswer, 0);
		}
		
	
		QuestionDao.createIntrebare(textQuestion, numberOfCorrectAnswers, numberOfCorrectAnswers+numberOfIncorrectAnswers, AnswerDao.getListaRaspunsuri());
		
		
		String msg= "Intrebare creata cu succes";
		System.out.println(msg);
		
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		final String  NEXT_PAGE_NAME = "AddQuestion";
		
		String  path=pathCreator.createPath(NEXT_PAGE_NAME);	
		
		
		request.setAttribute("numeTest" , testName);
		request.setAttribute("numeAutor", testCreator);
		request.setAttribute("numarIntrebari", numberOfQuestions);
		
		RequestDispatcher  requestDispacher = request.getRequestDispatcher(path);
		requestDispacher.forward(request, response);
		
	}

}
