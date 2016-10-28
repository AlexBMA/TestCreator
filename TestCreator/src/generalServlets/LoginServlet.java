package generalServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import database.DB;
import dao.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Serlvet folosit pentru login", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		DB.makeCon();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String user = request.getParameter("user").trim();
		String pass = request.getParameter("pass").trim();
		
		
		boolean rez =LoginService.testUser(user, pass);
		
		if(rez == true)
		{
			String userRole = LoginService.getUserRole();
			RequestDispatcher requestDispacher;
			
			if(userRole.equalsIgnoreCase("p"))
			{
				HttpSession session =  request.getSession();
				session.setMaxInactiveInterval(600);
				
				//WEB-INF/view/ProfPage.jsp
				PathCreatorPrefixAndSufix pathCreator = new PathCreatorPrefixAndSufixImpl();
				String nextPage= pathCreator.createPath("ProfPage");
				
				session.setAttribute("user", LoginService.getUserName());
				request.setAttribute("user", LoginService.getUserPass());
				
				requestDispacher = request.getRequestDispatcher(nextPage);
				requestDispacher.forward(request, response);
				System.out.println("##");
			}
		
		}
	}

}
