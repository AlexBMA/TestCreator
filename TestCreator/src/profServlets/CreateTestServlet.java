package profServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDao;
import dao.TestDao;
import dao.PathCreatorPrefixAndSufix;
import dao.PathCreatorPrefixAndSufixImpl;

/**
 * Servlet implementation class CreateTestServlet
 */
@WebServlet("/CreateTestServlet")
public class CreateTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTestServlet() {
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
		
		String testName= request.getParameter("numetest").trim();
		String testCreator = request.getParameter("numneautor").trim();
		int numberOfQuestions =  Integer.parseInt(request.getParameter("numarintrebari").trim());
		
	//	System.out.println(numeTest);
	//	System.out.println(autorTest);
	//	System.out.println(nrIntrebari);
		
		TestDao.createTest(testName, testCreator, numberOfQuestions);
		
		QuestionDao.createListaIntrebari();
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		final String  NEXT_PAGE_NAME ="TestCreated";
		
		String  path=pathCreator.createPath(NEXT_PAGE_NAME);	
		
		RequestDispatcher reqDispacher = request.getRequestDispatcher(path);
		
		request.setAttribute("numeTest" , testName);
		request.setAttribute("autorTest", testCreator);
		request.setAttribute("numarIntrebari", numberOfQuestions);
		
		reqDispacher.forward(request, response);
		
		
		//doGet(request, response);
		
		
	}

}
