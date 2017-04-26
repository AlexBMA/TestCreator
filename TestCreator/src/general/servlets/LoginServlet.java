package general.servlets;

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
import general.services.LoginService;
import model.User;
import services.*;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DB.DBConnect();
		
		String username = request.getParameter("user").trim();
		String pass = request.getParameter("pass").trim();
		
		LoginService loginService = new LoginService();
		
		boolean rez =loginService.checkUsernameAndPass(DB.getSessionFactory(), username, pass);
		
		if(rez  == true)
		{
			
			User user = loginService.getUser();
			
			HttpSession theSession  = request.getSession(true);
			theSession.setAttribute("user", user);
			String role = user.getRole();
			
			PathCreatorPrefixAndSufix pathCreator = new PathCreatorPrefixAndSufixImpl();
			
			String nextPage="";
			System.out.println(role);
			
			
			if(role.equals("p"))
			{
				nextPage=pathCreator.createPath("ProfPage");
			}
			if(role.equals("s"))
			{
				nextPage= "ShowTestStudentServlet";
			}
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
			requestDispatcher.forward(request, response);
		}
		
	}

}
