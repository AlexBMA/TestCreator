package student.servlets.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.DB;
import factory.pack.ServiceFactory;
import model.Answer;
import model.Question;
import model.Test;




/**
 * Servlet implementation class ViewAllTestServlet
 */
@WebServlet("/ViewAllTestServlet")
public class ViewAllTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("application/json");
		DB.DBConnect();
		if(DB.getSessionFactory()==null) DB.DBConnect();
		
			
		Answer a = new Answer();
				a.setAnswerText("Text 1");
				a.setId(1);
				a.setTrueFalse(1);
		
		Gson gson = new Gson();

		String json = gson.toJson(a);
	
		System.out.println(json);
		
		response.getWriter().append(json);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
