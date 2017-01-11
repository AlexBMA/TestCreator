package services;

import java.util.List;

import org.hibernate.SessionFactory;

import database.DBOperation;
import database.DBTableQuestion;

import model.Answer;
import model.Question;



public class QuestionService implements BasicService<Question>{

	@Override
	public Question getItem(SessionFactory factory, int id) {
		
		DBOperation<Question> questionOpearions = new DBTableQuestion();
		
		BasicService<Answer> answerService = new AnswerService();
		
		Question q = questionOpearions.getARow(factory, id);
		List<Answer> listAnswer = q.getListAnswersi();
		
		
		
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

	@Override
	public List<Question> getSimilarItems(SessionFactory factory, int idSimilar) {
		
		DBOperation<Question> questionOpearions = new DBTableQuestion();
		List<Question> questionList;
		
		return null;
	}
	
	
	
}
