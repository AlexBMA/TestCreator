package database;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Answer;
import model.Question;
import model.Test;
import model.User;


public class DB {
	
private static SessionFactory factory;
	
	public static void  DBConnect()
	{
		// create session factory
				factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(User.class)
											.addAnnotatedClass(Test.class)
											.addAnnotatedClass(Question.class)
											.addAnnotatedClass(Answer.class)
											.buildSessionFactory();
	}
	
	public static  SessionFactory getSessionFactory()
	{
		return factory;
	}
	
	public static void closeFactory()
	{
		factory.close();
	}

}
