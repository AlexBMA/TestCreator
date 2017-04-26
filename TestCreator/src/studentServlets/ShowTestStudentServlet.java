package studentServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;
import factorypack.ServiceFactory;
import model.Test;
import services.BasicService;
import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;
import servicesimpl.TestServiceImpl;

/**
 * Servlet implementation class ShowTestStudentServlet
 */
@WebServlet("/ShowTestStudentServlet")
public class ShowTestStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTestStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		
		List<Test> testList = ServiceFactory.getService("Test").getAllItems(DB.getSessionFactory());
				
		
		final String  NEXT_PAGE_NAME ="StudentPage";
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
