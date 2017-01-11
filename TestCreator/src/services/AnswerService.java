package services;


import java.util.List;
import org.hibernate.SessionFactory;
import database.DBOperation;
import database.DBTableAnswer;
import model.Answer;


public class AnswerService implements BasicService<Answer> {

	@Override
	public Answer getItem(SessionFactory factory, int id) {

		DBOperation<Answer>answerOpearions = new DBTableAnswer();
		
		return answerOpearions.getARow(factory, id);
		
		
	}

	@Override
	public List<Answer> getAllItems(SessionFactory factory) {
		
		return null;
	}


	@Override
	public void deleteItem(SessionFactory factory, int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void editItem(SessionFactory factory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createItem(SessionFactory factory, Answer item) {
		
			DBOperation<Answer>answerOpearions = new DBTableAnswer();
			answerOpearions.insert(factory, item);
		
	}

	@Override
	public List<Answer> getSimilarItems(SessionFactory factory, int idSimilar) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
