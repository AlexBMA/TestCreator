package services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import database.DBOperation;
import database.DBTableAnswer;
import database.DBTableQuestion;
import model.Answer;
import model.Question;

public class AnswerService implements BasicService<Answer> {

	@Override
	public Answer getItem(SessionFactory factory, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> getAllItems(SessionFactory factory) {
		// TODO Auto-generated method stub
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

	
}
