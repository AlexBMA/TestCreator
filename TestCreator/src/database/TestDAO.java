package database;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Test;

public class TestDAO implements DAOOperations<Test>{

	@Override
	public void insert(SessionFactory theSessionFactory, Test ob) {
		
		// get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
		// save the object in the database
		theSession.saveOrUpdate(ob);
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		
		
	}

	@Override
	public Test getARow(SessionFactory theSessionFactory, int id) {
			   // get the session
				Session theSession = theSessionFactory.getCurrentSession();
				
				//begins the transaction
				theSession.getTransaction().begin();
				
				Test test = theSession.get(Test.class, id);
					
				// commits the transaction
				theSession.getTransaction().commit();
				
				
				
				return test;
	}

	@Override
	public List<Test> getAllRow(SessionFactory theSessionFactory) {
		
		// get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
	
		String hql="from Test";
		
		List<Test> testList= theSession.createQuery(hql).getResultList();
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		
		
		return testList;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		
		   // get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
		Test test = theSession.get(Test.class, id);
		theSession.delete(test);
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		
	}

	@Override
	public List<Test> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
