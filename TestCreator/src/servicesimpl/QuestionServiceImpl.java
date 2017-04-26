package servicesimpl;

import java.util.List;

import org.hibernate.SessionFactory;

import database.DAOOperations;
import database.QuestionDAOImpl;
import factorypack.DAOFactory;
import factorypack.ServiceFactory;
import model.Answer;
import model.Question;
import services.BasicService;



public class QuestionServiceImpl implements BasicService<Question>{
	
	private static final String CLASS_NAME = "Question";

	@Override
	public Question getItem(SessionFactory factory, int id) {
		return (Question) DAOFactory.getDAO(CLASS_NAME).getARow(factory, id);
	}

	@Override
	public List<Question> getAllItems(SessionFactory factory) {
		return DAOFactory.getDAO(CLASS_NAME).getAllRow(factory);
	}

	@Override
	public void editItem(SessionFactory factory) {
				
	}

	@Override
	public void deleteItem(SessionFactory factory, int id) {
		
		DAOOperations<Question> questionOpearions = DAOFactory.getDAO(CLASS_NAME);
		
		Question item = questionOpearions.getARow(factory, id);
		
		List<Answer> listAnswer = item.getListAnswersi();
		BasicService<Answer>answerService = ServiceFactory.getService("Answer");
		
		for(Answer a:listAnswer)
		{
			answerService.deleteItem(factory, a.getId());
		}
		
		questionOpearions.deleteRow(factory, id);
	}

	@Override
	public void createItem(SessionFactory factory, Question item) {
		
		List<Answer> listAnswer = item.getListAnswersi();
		
		BasicService<Answer>answerService = ServiceFactory.getService("Answer");
		
		for(Answer a: listAnswer)
		{
			answerService.createItem(factory, a);
		}
		
		DAOFactory.getDAO(CLASS_NAME).insert(factory, item);
		
	}

	@Override
	public List<Question> getSimilarItems(SessionFactory factory, int idSimilar) {
		
		return DAOFactory.getDAO(CLASS_NAME).getAllSimilarRows(factory, idSimilar);
	}
	
	
	
}
