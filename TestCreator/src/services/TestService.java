package services;


import java.util.List;


import org.hibernate.SessionFactory;


import database.DBOperation;
import database.DBTableTest;
import model.Question;
import model.Test;


public class TestService implements BasicService<Test>  {

	@Override
	public Test getItem(SessionFactory factory, int id) {
		
		DBOperation<Test> testOpearions = new DBTableTest();
		
		BasicService<Question> questionService = new QuestionService();
		
	//	List<Question> questionList = questionService.getItem(factory, id);
		
		Test test = testOpearions.getARow(factory, id);
		
		return test;
	}

	@Override
	public List<Test> getAllItems(SessionFactory factory) {
		
		DBOperation<Test> testOpearions = new DBTableTest();
		
		List<Test> testList = testOpearions.getAllRow(factory);
		
		return testList;
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
	public void createItem(SessionFactory factory, Test item) {
		
		DBOperation<Test> testOpearions = new DBTableTest();

		List<Question> listQuestion = item.getListQuestions();
		BasicService<Question> questionService = new QuestionService();
		
		for(Question q:listQuestion){
			questionService.createItem(factory, q);
		}
		
		
		testOpearions.insert(factory, item);
		
	}

	@Override
	public List<Test> getSimilarItems(SessionFactory factory, int idSimilar) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
