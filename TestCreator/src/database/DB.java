package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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

	public static Connection getConnection() {
		return conn;
	}
	
	
	public void closeConn() {
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
