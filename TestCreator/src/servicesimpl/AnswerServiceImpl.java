package servicesimpl;


import java.util.List;
import org.hibernate.SessionFactory;
import database.DAOOperations;
import database.AnswerDAOImpl;
import model.Answer;
import services.BasicService;


public class AnswerServiceImpl implements BasicService<Answer> {

	@Override
	public Answer getItem(SessionFactory factory, int id) {

		DAOOperations<Answer>answerOpearions = new AnswerDAOImpl();
		
		return answerOpearions.getARow(factory, id);
		
		
	}

	@Override
	public List<Answer> getAllItems(SessionFactory factory) {
		
		return null;
	}


	@Override
	public void deleteItem(SessionFactory factory, int id) {
		
		DAOOperations<Answer>answerOpearions = new AnswerDAOImpl();
		answerOpearions.deleteRow(factory, id);
	}


	@Override
	public void editItem(SessionFactory factory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createItem(SessionFactory factory, Answer item) {
		
			DAOOperations<Answer>answerOpearions = new AnswerDAOImpl();
			answerOpearions.insert(factory, item);
		
	}

	@Override
	public List<Answer> getSimilarItems(SessionFactory factory, int idSimilar) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
