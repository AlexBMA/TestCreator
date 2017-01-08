package profServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;

/**
 * Servlet implementation class AdaugaTextIntrebareSiNrRaspunsi
 */
@WebServlet("/AdaugaTextIntrebareSiNrRaspunsi")
public class AddQuestionTextAndNumberOfAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionTextAndNumberOfAnswerServlet() {
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
		//doGet(request, response);
		

		String testName= request.getParameter("numeTest").trim();
		String testCreator = request.getParameter("numeAutor").trim();
		int numberOfQuestions =  Integer.parseInt(request.getParameter("numarIntrebari").trim());
		
			
		String questionText = request.getParameter("textIntrebare").trim();
		
		int numberOfAnswers = Integer.parseInt(request.getParameter("numarVariante").trim());
		int numberOfCorrectAnswers = Integer.parseInt(request.getParameter("numarVarianteCorecte").trim());
		
		
		System.out.println(questionText);
		System.out.println(numberOfAnswers);
		System.out.println(numberOfCorrectAnswers);
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		final String  NEXT_PAGE_NAME = "AddAnswer";
		
		String  path=pathCreator.createPath(NEXT_PAGE_NAME);	
		
		
		RequestDispatcher requestDispacher = request.getRequestDispatcher(path);
		request.setAttribute("textIntrebare", questionText);
		request.setAttribute("numarVariante", numberOfAnswers);
		request.setAttribute("numarVarianteCorecte", numberOfCorrectAnswers);
		
		request.setAttribute("numeTest" , testName);
		request.setAttribute("autorTest", testCreator);
		request.setAttribute("numarIntrebari", numberOfQuestions);
		
		requestDispacher.forward(request, response);
		
		
		
		
		
	}

}
