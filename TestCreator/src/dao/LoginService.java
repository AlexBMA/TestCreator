package dao;

import database.DB;
import model.User;

public class LoginService {

	private static User user;
	
	
	public static boolean testUser(String username,String pass)
	{
		user = DB.verifyUserAndPass(username, pass);
		
		if(user !=null) return true;
		
		return false;
	}
	
	public static String getUserRole()
	{
		return user.getRole();
	}
	
	public static String getUserName()
	{
		return user.getUserName();
	}
	
	public static String getUserPass()
	{
		return user.getPass();
	}
}
