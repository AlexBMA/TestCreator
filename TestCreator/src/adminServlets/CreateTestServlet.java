package adminServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.IntreabreService;
import services.TestServices;

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
		
		String numeTest= request.getParameter("numetest").trim();
		String autorTest = request.getParameter("numneautor").trim();
		int nrIntrebari =  Integer.parseInt(request.getParameter("numarintrebari").trim());
		
	//	System.out.println(numeTest);
	//	System.out.println(autorTest);
	//	System.out.println(nrIntrebari);
		
		TestServices.createTest(numeTest, autorTest, nrIntrebari);
		
		IntreabreService.createListaIntrebari();
		
		
		String  path="TestCreated.jsp";	
		RequestDispatcher reqDispacher = request.getRequestDispatcher(path);
		
		request.setAttribute("numeTest" , numeTest);
		request.setAttribute("autorTest", autorTest);
		request.setAttribute("numarIntrebari", nrIntrebari);
		
		reqDispacher.forward(request, response);
		
		
		//doGet(request, response);
		
		
	}

}
