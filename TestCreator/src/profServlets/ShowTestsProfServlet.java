package profServlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class VizualizeazaTeste
 */
@WebServlet("/VizualizeazaTeste")
public class ShowTestsProfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTestsProfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String filePath="D:\\git\\TestCreator\\TestCreator\\fisiereXml\\Test.xml";
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		
		BasicService<Test> testService = new TestServiceImpl();
		
		List<Test> testList = testService.getAllItems(DB.getSessionFactory());
		
		
		final String  NEXT_PAGE_NAME ="ShowTests";
		String page= pathCreator.createPath(NEXT_PAGE_NAME);
		
		request.setAttribute("testlist", testList);
		
		RequestDispatcher requestDispacher = request.getRequestDispatcher(page);
		requestDispacher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
