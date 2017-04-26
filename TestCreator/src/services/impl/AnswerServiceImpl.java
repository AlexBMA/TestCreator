package services.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import database.DAOOperations;
import factory.pack.DAOFactory;
import database.AnswerDAOImpl;
import model.Answer;
import services.BasicService;

public class AnswerServiceImpl implements BasicService<Answer> {

	private static final String CLASS_NAME = "Answer";

	@Override
	public Answer getItem(SessionFactory factory, int id) {
		return (Answer) DAOFactory.getDAO(CLASS_NAME).getARow(factory, id);
	}

	@Override
	public List<Answer> getAllItems(SessionFactory factory) {
		return DAOFactory.getDAO(CLASS_NAME).getAllRow(factory);
	}

	@Override
	public void deleteItem(SessionFactory factory, int id) {
		DAOFactory.getDAO(CLASS_NAME).deleteRow(factory, id);
	}

	@Override
	public void editItem(SessionFactory factory) {
	}

	@Override
	public void createItem(SessionFactory factory, Answer item) {
		DAOFactory.getDAO(CLASS_NAME).insert(factory, item);
	}

	@Override
	public List<Answer> getSimilarItems(SessionFactory factory, int idSimilar) {
		return DAOFactory.getDAO(CLASS_NAME).getAllSimilarRows(factory, idSimilar);
	}

}
