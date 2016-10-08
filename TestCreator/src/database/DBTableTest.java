package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.Test;

public class DBTableTest {
	
	
	public void createTest(Connection conn,Test t)
	{
		try {
			Statement stmt = conn.createStatement();
			
			
			String sql="";
			stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
