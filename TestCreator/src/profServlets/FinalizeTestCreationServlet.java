package profServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;
import services.QuestionDao;
import services.TestDao;


/**
 * Servlet implementation class FinalizeazaTest
 */
@WebServlet("/FinalizeazaTest")
public class FinalizeTestCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizeTestCreationServlet() {
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
		
		String testName = request.getParameter("numeTest").trim();
		
		TestDao.addQuestonsToTest(QuestionDao.getListaIntrebari(), testName);
		
		String fileName="D:\\git\\TestCreator\\TestCreator\\fisiereXml";
		
		
		//TestDao.saveInXMLFile(fileName);
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		final String  NEXT_PAGE_NAME ="ProfPage";
		
		String page=pathCreator.createPath(NEXT_PAGE_NAME);
		
		response.sendRedirect(page);
		
	}

}
