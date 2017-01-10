package services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import database.DBOperation;
import database.DBTableTest;
import model.Question;
import model.Test;
import xmlpack.XMLXervices;

public class TestService implements BasicService<Test>  {

	@Override
	public Test getItem(SessionFactory factory, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> getAllItems(SessionFactory factory) {
		DBOperation<Test> testOpearions = new DBTableTest();
		
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
	public void createItem(SessionFactory factory, Test item) {
		
		DBOperation<Test> testOpearions = new DBTableTest();

		List<Question> listQuestion = item.getListQuestions();
		BasicService<Question> questionService = new QuestionService();
		
		for(Question q:listQuestion){
			questionService.createItem(factory, q);
		}
		
		
		testOpearions.insert(factory, item);
		
	}

	

}
