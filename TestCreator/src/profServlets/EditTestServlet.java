package profServlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;
import model.Test;
import services.BasicService;
import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;
import servicesimpl.TestServiceImpl;

/**
 * Servlet implementation class EditTestServlet
 */
@WebServlet("/EditTestServlet")
public class EditTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int testId;
		
		
		
		try{
			testId = Integer.parseInt(request.getParameter("testid").trim());
		}
		catch(NullPointerException e)
		{
			testId =(int) request.getAttribute("testId");
		}
		
		
		BasicService<Test> testService = new TestServiceImpl();
		
		Test test = testService.getItem(DB.getSessionFactory(), testId);
		test.setNumberOfQuestions(test.getListQuestions().size());
		
		DB.getSessionFactory().close();
		DB.DBConnect();
		
		testService.createItem(DB.getSessionFactory(), test);
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		final String NEXT_PAGE_NAME="EditTest";
		String  path=pathCreator.createPath(NEXT_PAGE_NAME);	
		
		String state="edit";
		
		
		
		request.setAttribute("test", test);
		request.getSession(false).setAttribute("test", test);
		request.getSession(false).setAttribute("state",state);
		
		RequestDispatcher reqDispacher = request.getRequestDispatcher(path);	
		reqDispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
