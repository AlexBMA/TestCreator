package prof.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Test;
import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;


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
		String testCreator = request.getParameter("numeautor").trim();
			
		
		Test theTest = new Test(testName,testCreator);
		
		HttpSession theSession = request.getSession(false);
		
		theSession.setAttribute("test", theTest);
		theSession.setAttribute("state","new");
		
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		final String  NEXT_PAGE_NAME ="TestCreated";
		
		String  path=pathCreator.createPath(NEXT_PAGE_NAME);	
		
		RequestDispatcher reqDispacher = request.getRequestDispatcher(path);
		
		reqDispacher.forward(request, response);
		
		
		//doGet(request, response);
		
		
	}

}
