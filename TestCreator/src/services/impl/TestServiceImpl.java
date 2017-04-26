package services.impl;


import java.util.List;


import org.hibernate.SessionFactory;


import database.DAOOperations;
import database.QuestionDAOImpl;
import database.TestDAOImpl;
import factory.pack.DAOFactory;
import factory.pack.ServiceFactory;
import model.Question;
import model.Test;
import services.BasicService;


public class TestServiceImpl implements BasicService<Test>  {
	
	private static final String CLASS_NAME = "Test";

	@Override
	public Test getItem(SessionFactory factory, int id) {
		
		DAOOperations<Test> testOpearions = DAOFactory.getDAO(CLASS_NAME);
		BasicService<Question> questionService = ServiceFactory.getService("Question");
		
	
		Test test = testOpearions.getARow(factory, id);
		List<Question> questionList = questionService.getSimilarItems(factory, test.getId());
		
		test.setListQuestions(questionList);
		
		
		return test;
	}

	@Override
	public List<Test> getAllItems(SessionFactory factory) {
	
		return DAOFactory.getDAO(CLASS_NAME).getAllRow(factory);
	}

	

	@Override
	public void deleteItem(SessionFactory factory, int id) {
		DAOOperations<Test> testOpearions = DAOFactory.getDAO(CLASS_NAME);
		
		BasicService<Question> questionService = ServiceFactory.getService("Question");
		
		Test test = testOpearions.getARow(factory, id);
		List<Question> questionList = questionService.getSimilarItems(factory, test.getId());
		
		for(Question q:questionList)
		{
			questionService.deleteItem(factory, q.getId());
		}
		
		
		testOpearions.deleteRow(factory, id);
	}


	@Override
	public void editItem(SessionFactory factory) {
	
		
	}

	@Override
	public void createItem(SessionFactory factory, Test item) {
		
		DAOOperations<Test> testOpearions =DAOFactory.getDAO(CLASS_NAME);

		List<Question> listQuestion = item.getListQuestions();
		BasicService<Question> questionService = ServiceFactory.getService("Question");
		
		for(Question q:listQuestion){
			questionService.createItem(factory, q);
		}
		
		testOpearions.insert(factory, item);
		
	}

	@Override
	public List<Test> getSimilarItems(SessionFactory factory, int idSimilar) {
		return DAOFactory.getDAO(CLASS_NAME).getAllSimilarRows(factory, idSimilar);
	}

	

}
