package database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class UserDAO implements DAOOperations<User> {

	@Override
	public void insert(SessionFactory theSessionFactory, User ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getARow(SessionFactory theSessionFactory, int id) {
		
		
		Session theSession = theSessionFactory.getCurrentSession();
		
		
		theSession.beginTransaction();
		
		User user = theSession.get(User.class, id);
		
		theSession.getTransaction().commit();
		
		
		
		return user;
	}

	@Override
	public List<User> getAllRow(SessionFactory theSessionFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		// TODO Auto-generated method stub
		return null;
	}

	public User checkUserAndPass(SessionFactory theSessionFactory,String userName,String userPass)
	{
		Session theSession = theSessionFactory.getCurrentSession();
		
		String hql="from User where userName= ? and   pass= ? ";
		
		theSession.beginTransaction();
		
		List<User> listUser =  theSession.createQuery(hql).
												setParameter(0, userName).
												setParameter(1, userPass).
												getResultList();
		
		System.out.println();
		
		
		theSession.getTransaction().commit();
		
		
		
		if(listUser.size()==1)
		{
			
			User user = listUser.get(0);
			return user;
			
		}
		
		else 	return null;
	}
	
}
