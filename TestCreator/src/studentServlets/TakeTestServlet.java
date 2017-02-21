package studentServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DB;
import model.Test;
import services.BasicService;
import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;
import services.TestService;

/**
 * Servlet implementation class TakeTestServlet
 */
@WebServlet("/TakeTestServlet")
public class TakeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakeTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int testId = Integer.parseInt(request.getParameter("testid").trim());
		BasicService<Test> testService = new TestService();
		
		Test test = testService.getItem(DB.getSessionFactory(), testId);
		
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		final String NEXT_PAGE_NAME="TakeTest";
		String  path=pathCreator.createPath(NEXT_PAGE_NAME);	
		
		request.setAttribute("test", test);
		request.setAttribute("currentquestion", 0);
		HttpSession theSession = request.getSession(false);
		theSession.setAttribute("test", test);
		
			
		RequestDispatcher reqDispacher = request.getRequestDispatcher(path);	
		reqDispacher.forward(request, response);
	}

	

}
