package servicesimpl;

import java.util.List;

import org.hibernate.SessionFactory;

import database.DAOOperations;
import database.QuestionDAOImpl;

import model.Answer;
import model.Question;
import services.BasicService;



public class QuestionServiceImpl implements BasicService<Question>{

	@Override
	public Question getItem(SessionFactory factory, int id) {
		
		DAOOperations<Question> questionOpearions = new QuestionDAOImpl();
		
		//BasicService<Answer> answerService = new AnswerService();
		
		Question q = questionOpearions.getARow(factory, id);
		//List<Answer> listAnswer = q.getListAnswersi();
		
		
		
		return q;
	}

	@Override
	public List<Question> getAllItems(SessionFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editItem(SessionFactory factory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(SessionFactory factory, int id) {
		
		DAOOperations<Question> questionOpearions = new QuestionDAOImpl();
		
		Question item = questionOpearions.getARow(factory, id);
		
		List<Answer> listAnswer = item.getListAnswersi();
		BasicService<Answer>answerService = new AnswerServiceImpl();
		
		for(Answer a:listAnswer)
		{
			answerService.deleteItem(factory, a.getId());
		}
		
		questionOpearions.deleteRow(factory, id);
	}

	@Override
	public void createItem(SessionFactory factory, Question item) {
		
		DAOOperations<Question> questionOpearions = new QuestionDAOImpl();
		
		List<Answer> listAnswer = item.getListAnswersi();
		BasicService<Answer>answerService = new AnswerServiceImpl();
		
		for(Answer a: listAnswer)
		{
			answerService.createItem(factory, a);
		}
		
		questionOpearions.insert(factory, item);
		
	}

	@Override
	public List<Question> getSimilarItems(SessionFactory factory, int idSimilar) {
		
		DAOOperations<Question> questionOpearions = new QuestionDAOImpl();
		List<Question> questionList = questionOpearions.getAllSimilarRows(factory, idSimilar);
		
		return questionList;
	}
	
	
	
}
