package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.User;

public class DB {

	private static InitialContext ctx;
	private static DataSource pool = null;
	private static Connection conn = null;
	private static Statement stmt = null;

	public static void makeCon() {
		try {

			ctx = new InitialContext();
			Context context = (Context) ctx.lookup("java:comp/env");
			pool = (DataSource) context.lookup("jdbc/TestDB");

			if (pool == null)
				System.out.println(" Poll is null ");
			else {
				conn = pool.getConnection();
			}

		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	public static User verifyUserAndPass(String user,String pass)
	{
		
		try {
			String comandaSQL = "SELECT * From user where userName=" + "'" + user + "'" + " and "
					+ " pass=" + "'" + pass + "'";
			stmt = conn.createStatement();
		
			
			ResultSet resultSet = 	stmt.executeQuery(comandaSQL);;
			
			if (resultSet.next()) {
				
				
				
				User u  = new User(user,  pass,resultSet.getString("role"));
				
				System.out.println("Utilizatorul:  " + resultSet.getString("userName") + "\n");
				System.out.println("Parola:  " + resultSet.getString("pass") + " \n");
				System.out.println("Rolul: "+resultSet.getString("role")+ " \n");

				return u;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static Connection getConnection() {
		return conn;
	}
	
	
	public static void closeConn() {
		try {

			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close(); // return to pool

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
