package factory.pack;

import database.AnswerDAOImpl;
import database.DAOOperations;
import database.QuestionDAOImpl;
import database.TestDAOImpl;
import database.UserDAOImpl;

public class DAOFactory {
	
	
	public static DAOOperations getDAO(String nameOfDAO)
	{
		if(nameOfDAO.equalsIgnoreCase("Answer"))
		{
			return new AnswerDAOImpl();
		}
		
		if(nameOfDAO.equalsIgnoreCase("Question"))
		{
			return new QuestionDAOImpl();
		}
		
		if(nameOfDAO.equalsIgnoreCase("Test"))
		{
			return new TestDAOImpl();
		}
		
		if(nameOfDAO.equalsIgnoreCase("User"))
		{
			return new UserDAOImpl();
		}
		
		
		return null;
	}

}
