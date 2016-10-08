package adminServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.IntreabreService;
import services.RaspunsService;

/**
 * Servlet implementation class AdaugaVarianteDeRaspuns
 */
@WebServlet("/AdaugaVarianteDeRaspuns")
public class AdaugaVarianteDeRaspunsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdaugaVarianteDeRaspunsServlet() {
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
	
		String numeTest= request.getParameter("numeTest").trim();
		String autorTest = request.getParameter("numeAutor").trim();
		int nrIntrebari =  Integer.parseInt(request.getParameter("numarIntrebari").trim());
		
		
		int nrVarianteCorecte = Integer.parseInt(request.getParameter("numarVarianteCorecte").trim());
		int nrVarianteGresite = Integer.parseInt(request.getParameter("numarVarianteIncorecte").trim());
		String textIntrebare = request.getParameter("textIntreabare").trim();
		
		//System.out.println("Text intreabre:"+textIntrebare);
		
		RaspunsService.createListaRaspunsuri();
		
		for(int i=0;i<nrVarianteCorecte;i++)
		{
			String variantaCorecta = request.getParameter("textRaspunsC"+i).trim();
		//	System.out.println(variantaCorecta);
			
			RaspunsService.createRaspuns(variantaCorecta, 1);
			
		}
		
		for(int i=0;i<nrVarianteGresite;i++)
		{
			String variantaGresita = request.getParameter("textRaspunsI"+i).trim();
		//	System.out.println(variantaGresita);
			
			RaspunsService.createRaspuns(variantaGresita, 0);
		}
		
	
		IntreabreService.createIntrebare(textIntrebare, nrVarianteCorecte, nrVarianteCorecte+nrVarianteGresite, RaspunsService.getListaRaspunsuri());
		
		
		String msg= "Intrebare creata cu succes";
		System.out.println(msg);
		
		
		String path="AdaugaIntrebare.jsp";
		
		request.setAttribute("numeTest" , numeTest);
		request.setAttribute("numeAutor", autorTest);
		request.setAttribute("numarIntrebari", nrIntrebari);
		
		RequestDispatcher  requestDispacher = request.getRequestDispatcher(path);
		requestDispacher.forward(request, response);
		
	}

}
