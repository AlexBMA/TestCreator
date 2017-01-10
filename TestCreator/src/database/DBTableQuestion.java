package database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Question;
import model.Test;

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
		   // get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
		Question question = theSession.get(Question.class, id);
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		//close the session
		theSession.close();
		
		return question;
	}

	@Override
	public List<Question> getAllRow(SessionFactory theSessionFactory) {
				
			   // get the session
				Session theSession = theSessionFactory.getCurrentSession();
				
				//begins the transaction
				theSession.getTransaction().begin();
				
				String hql="from Question";
				
				List<Question> questionList= theSession.createQuery(hql).getResultList();
					
				// commits the transaction
				theSession.getTransaction().commit();
				
				//close the session
				theSession.close();
				
				return questionList;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
		Question question = theSession.get(Question.class, id);
		theSession.delete(question);
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		//close the session
		theSession.close();
		
	}

	@Override
	public List<Question> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		
		// get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
		String hql="from Question";
		
		List<Question> questionList= theSession.createQuery(hql).getResultList();
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		//close the session
		theSession.close();
		
		return questionList;
	}
	
	
}
