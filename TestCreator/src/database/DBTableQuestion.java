package database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Question;

public class DBTableQuestion implements DBOperation<Question> {


	@Override
	public void insert(SessionFactory theSessionFactory, Question ob) {
		
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
	public Question getARow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getAllRow(SessionFactory theSessionFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Question> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
