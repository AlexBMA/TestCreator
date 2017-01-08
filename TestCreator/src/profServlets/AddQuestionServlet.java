package profServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.test.cases.TestSerialization;

import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;
import services.TestDao;

/**
 * Servlet implementation class AdaugaIntrebareServlet
 */
@WebServlet("/AdaugaIntrebareServlet")
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionServlet() {
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
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		final String  NEXT_PAGE_NAME ="AddQuestion";
		
		String  path=pathCreator.createPath(NEXT_PAGE_NAME);	
		
		String testName = request.getParameter("numeTest").trim();
		
		String CreatorName = TestDao.getCreatorName(testName);
		int numberOfQuestions = TestDao.getNumarIntrebari(testName);
		
		
		RequestDispatcher reqDispacher = request.getRequestDispatcher(path);
		
		request.setAttribute("numeAutor", CreatorName);
		request.setAttribute("numarIntrebari", numberOfQuestions);
		request.setAttribute("numeTest", testName);
		
		reqDispacher.forward(request, response);
		
		
	}

}
