package profServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DB;
import factorypack.ServiceFactory;
import model.Test;
import model.User;
import services.BasicService;
import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;
import servicesimpl.TestServiceImpl;


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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//	String fileName="D:\\git\\TestCreator\\TestCreator\\fisiereXml";
		
		BasicService<Test> testService = ServiceFactory.getService("Test");
		
		HttpSession theSession = request.getSession(false);
		
		User user = (User)theSession.getAttribute("user");
		Test test = (Test)theSession.getAttribute("test");
		test.setNumberOfQuestions(test.getListQuestions().size());
		test.setUserId(user.getId());
		
		DB.closeFactory();
		DB.DBConnect();
		
		testService.createItem(DB.getSessionFactory(), test);
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		String  NEXT_PAGE_NAME ="ProfPage";
		
		NEXT_PAGE_NAME =pathCreator.createPath(NEXT_PAGE_NAME);
		
		String state = (String) request.getSession(false).getAttribute("state");

		if( state.equals("edit"))
		{
			  NEXT_PAGE_NAME = "EditTestServlet";	
			  System.out.println(test.getId()+" $$$$$$$$$$$$$$$$");
			 request.setAttribute("testId",test.getId()) ;
		}
		
		
		System.out.println(NEXT_PAGE_NAME);
				
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(NEXT_PAGE_NAME);
		requestDispatcher.forward(request, response);
		
	}

}
