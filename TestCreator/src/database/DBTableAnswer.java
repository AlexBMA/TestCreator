package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Answer;

public class DBTableAnswer implements DBOperation<Answer>{

	@Override
	public void insert(SessionFactory theSessionFactory, Answer ob) {
		
		// get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
		// save the object in the database
		theSession.saveOrUpdate(ob);
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		//close the session
		theSession.close();
		
	}

	@Override
	public Answer getARow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> getAllRow(SessionFactory theSessionFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Answer> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
