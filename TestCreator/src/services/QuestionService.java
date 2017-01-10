package services;

import java.util.List;

import org.hibernate.SessionFactory;

import database.DBOperation;
import database.DBTableQuestion;
import database.DBTableTest;
import model.Answer;
import model.Question;
import model.Test;

public class QuestionService implements BasicService<Question>{

	@Override
	public Question getItem(SessionFactory factory, int id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createItem(SessionFactory factory, Question item) {
		
		DBOperation<Question> questionOpearions = new DBTableQuestion();
		
		List<Answer> listAnswer = item.getListAnswersi();
		BasicService<Answer>answerService = new AnswerService();
		
		for(Answer a: listAnswer)
		{
			answerService.createItem(factory, a);
		}
		
		
		questionOpearions.insert(factory, item);
		
		
	}
	
	
	
}
