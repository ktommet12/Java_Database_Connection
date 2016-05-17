package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private static Statement statement = null;
	private static ResultSet result = null;
	
	private static Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://us-cdbr-azure-southcentral-e.cloudapp.net/JavaIM";
			String username = "b5f5472103c700";
			String password = "bcefb3c7";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	public static boolean retrieveItems() throws SQLException{
		try{
			Connection conn = getConnection();
			statement = conn.createStatement();
			result = statement.executeQuery("select * from hello_world");
			while(result.next()){
				String productName = result.getString("name");
				System.out.println(productName);
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return false;
	}
}
