package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.Answer;

public class DBTableRaspuns {
	
	public void insertRaspuns(Connection conn,Answer rasp)
	{
		
		try {
			Statement stmt= conn.createStatement();
			
			
			String sql="";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateRaspuns(Connection conn,Answer rasp)
	{
		
	}
	
	public void getRaspuns(Connection conn)
	{
		
	}

}
