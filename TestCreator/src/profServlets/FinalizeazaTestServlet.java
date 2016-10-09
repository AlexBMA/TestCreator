package profServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.IntreabreService;
import services.TestServices;

/**
 * Servlet implementation class FinalizeazaTest
 */
@WebServlet("/FinalizeazaTest")
public class FinalizeazaTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizeazaTestServlet() {
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
		
		String numeTest = request.getParameter("numeTest").trim();
		
		TestServices.addIntrebariLaTest(IntreabreService.getListaIntrebari(), numeTest);
		
		String fileName="C:\\Users\\Alexandru\\git\\TestCreator";
		
		
		TestServices.salvezaTesteInXml(fileName);
		
		String page="ProfPage.jsp";
		response.sendRedirect(page);
		
	}

}
