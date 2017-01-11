package profServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;
import model.Answer;
import model.Question;
import model.Test;
import services.BasicService;
import services.PathCreatorPrefixAndSufix;
import services.PathCreatorPrefixAndSufixImpl;
import services.QuestionService;
import services.TestService;

/**
 * Servlet implementation class ViewTestServlet
 */
@WebServlet("/ViewTestServlet")
public class ViewTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int testId = Integer.parseInt(request.getParameter("testid").trim());
		
		BasicService<Test> testService = new TestService();
		
		Test test = testService.getItem(DB.getSessionFactory(), testId);
		
		
		System.out.println(test.getListQuestions().size());
		/*List<Question> listQuestion = test.getListQuestions();
		int size= listQuestion.size();
		System.out.println(size);
		
		List<List<Answer>> answerList = new ArrayList<>();
		List<Answer> tempAnswerList;
		
		for(Question q:listQuestion)
		{
			size=q.getListAnswersi().size();
			System.out.println(q.getListAnswersi().get(0).getAnswerText());
			tempAnswerList = q.getListAnswersi();
			answerList.add(tempAnswerList);
		}
		
		*/
		
		
		PathCreatorPrefixAndSufix  pathCreator = new PathCreatorPrefixAndSufixImpl();
		
		final String NEXT_PAGE_NAME="ShowTest";
		String  path=pathCreator.createPath(NEXT_PAGE_NAME);	
		
		request.setAttribute("test", test);
		
	//	request.setAttribute("questionlist", listQuestion);
	//	request.setAttribute("answerlist",answerList);
		
		RequestDispatcher reqDispacher = request.getRequestDispatcher(path);	
		reqDispacher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
