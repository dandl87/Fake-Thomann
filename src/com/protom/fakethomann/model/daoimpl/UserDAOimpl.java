package com.protom.fakethomann.model.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.protom.fakethomann.dbconnection.MySqlConnection;
import com.protom.fakethomann.model.dao.OrderDAO;
import com.protom.fakethomann.model.dao.UserDAO;
import com.protom.fakethomann.model.entity.Order;
import com.protom.fakethomann.model.entity.User; 
 

public class UserDAOimpl implements UserDAO {
	
	private MySqlConnection mySqlConnection;

	public UserDAOimpl(MySqlConnection mySqlConnection) {
		super();
		this.mySqlConnection = mySqlConnection;
	}

	@Override
	public boolean createUser(User user) {
		String query = " INSERT INTO cliente (username, password, name, surname) VALUES ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getName()+"','"+user.getSurname()+"');";
		
		try {
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
			int result = ps.executeUpdate(query);
			if(result==1) {
				System.out.println("cliente inserito a db");
				return true;
			}else {
				System.out.println("cliente non inserito a db");
				return false;
			}
			
		
		} catch (SQLException e) { 
			e.printStackTrace();
			return false;
		}
		
	
	}

	@Override
	public User readUser(String username) {
		
		ResultSet rs;
		
		String query = "SELECT * FROM cliente WHERE username='"+username+"';";
		
		try {
			
			
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			 
			String usernameFromDb = rs.getString("username");
			String password = rs.getString("password");
			String name = rs.getString("nome");
			String surname = rs.getString("cognome");
			
			OrderDAO orderDAO = new OrderDAOimpl(mySqlConnection);
			
			ArrayList<Order> listOfOrders = orderDAO.readAllOrdersOfAClient(usernameFromDb);
			User user = new User(usernameFromDb,password,name,surname,listOfOrders);
			
			return user;
			
			
		} catch (SQLException e) {
			return null;
		}
		
		
		
		
		
	}

	@Override
	public boolean updateUser(User user) {
		  return false;
	}

	@Override
	public boolean deleteUser(String username) {
		return false;
	}

//	@Override
//	public ArrayList<User> readAllUsers() {
//		ArrayList<User> listOfUsers = new ArrayList<>();
//
//		ResultSet rs;
//		String query = "SELECT * FROM cliente;";
//		
//		try {
//			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
//			rs = ps.executeQuery();
//			
//			while(rs.next()) { 
//				String username = rs.getString("username");
//				String password = rs.getString("password");
//				String name = rs.getString("nome");
//				String surname =rs.getString("cognome");
//				
//				OrderDAO orderDAO = new OrderDAOimpl(mySqlConnection);
//				
//				ArrayList<Order> listOfOrders = orderDAO.readAllOrdersOfAUser(username);
//				
//				User user = new User(username,password,name,surname,listOfOrders);
//				listOfUsers.add(user); 
//				
//			}
//			
//			return listOfUsers; 
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		
//		
//		
//	}
// 

}
