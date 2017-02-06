package profServlets;

import java.io.IOException;

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
import services.TestService;

/**
 * Servlet implementation class DeleteTestServlet
 */
@WebServlet("/DeleteTestServlet")
public class DeleteTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTestServlet() {
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
		int testId = Integer.parseInt(request.getParameter("testid").trim());
		
		BasicService<Test> testService = new TestService();
		
		 testService.deleteItem(DB.getSessionFactory(), testId);

		final String NEXT_PAGE_NAME="VizualizeazaTeste";
		
		RequestDispatcher reqDispacher = request.getRequestDispatcher(NEXT_PAGE_NAME);	
		reqDispacher.forward(request, response);
		
	}

}
