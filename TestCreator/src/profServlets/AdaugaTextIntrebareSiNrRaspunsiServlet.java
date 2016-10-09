package profServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdaugaTextIntrebareSiNrRaspunsi
 */
@WebServlet("/AdaugaTextIntrebareSiNrRaspunsi")
public class AdaugaTextIntrebareSiNrRaspunsiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdaugaTextIntrebareSiNrRaspunsiServlet() {
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
		//doGet(request, response);
		

		String numeTest= request.getParameter("numeTest").trim();
		String autorTest = request.getParameter("numeAutor").trim();
		int nrIntrebari =  Integer.parseInt(request.getParameter("numarIntrebari").trim());
		
			
		String textIntrebare = request.getParameter("textIntrebare").trim();
		
		int numarVariante = Integer.parseInt(request.getParameter("numarVariante").trim());
		int numarVarianteCorecte = Integer.parseInt(request.getParameter("numarVarianteCorecte").trim());
		
		
		System.out.println(textIntrebare);
		System.out.println(numarVariante);
		System.out.println(numarVarianteCorecte);
		
		String path="AdaugaRaspuns.jsp";
		
		RequestDispatcher requestDispacher = request.getRequestDispatcher(path);
		request.setAttribute("textIntrebare", textIntrebare);
		request.setAttribute("numarVariante", numarVariante);
		request.setAttribute("numarVarianteCorecte", numarVarianteCorecte);
		
		request.setAttribute("numeTest" , numeTest);
		request.setAttribute("autorTest", autorTest);
		request.setAttribute("numarIntrebari", nrIntrebari);
		
		requestDispacher.forward(request, response);
		
		
		
		
		
	}

}
