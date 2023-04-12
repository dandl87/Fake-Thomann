package com.protom.fakethomann.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 

public class MySqlConnection {
	
	private static final String param= "jdbc:mysql://localhost:3306/fake_thomann?user=root&password=1234&serverTimezone=Europe/Rome";
    private Connection connection;
    
    private MySqlConnection() {
    	
    }
    
	public Connection getConnection() {
		return connection;
	}

	public  Connection avviaConnessione() {
		
		try { 
			
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  this.connection = DriverManager.getConnection(param);
		 
		  if (connection == null) {
			  System.out.println("Connessione al db failed");
			  return null;
		  }
		  
		  return connection;

			} catch (Exception e) {
				System.out.println("Eccezione --> Connessione al db failed");
				e.printStackTrace();
				return null;
			}

	}
	
	public void chiudiConnessione() { 
			 try {
				 this.connection.close();
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
 
    }
	
	public static MySqlConnection getInstance() {
		return BuilderInstance.instance;
		 
	}
	
	private static class BuilderInstance{
		private static MySqlConnection instance = new MySqlConnection();
	}


}
