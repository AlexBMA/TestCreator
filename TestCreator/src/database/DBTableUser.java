package database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class DBTableUser implements DBOperation<User> {

	@Override
	public void insert(SessionFactory theSessionFactory, User ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getARow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		return null;
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
		
		String hql="from User where username= ? and   pass= ? ";
		
		theSession.beginTransaction();
		
		List<User> listUser =  theSession.createQuery(hql).
												setParameter(0, userName).
												setParameter(1, userPass).
												getResultList();
		
		System.out.println();
		
		
		theSession.getTransaction().commit();
		
		theSession.close();
		
		if(listUser.size()==1)
		{
			
			User user = listUser.get(0);
			return user;
			
		}
		
		else 	return null;
	}
	
}
