package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
