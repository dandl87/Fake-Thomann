package com.protom.fakethomann.model.daoimpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.protom.fakethomann.dbconnection.MySqlConnection; 
import com.protom.fakethomann.model.dao.OrderDAO;
import com.protom.fakethomann.model.dao.ProductDAO;
import com.protom.fakethomann.model.entity.Order;
import com.protom.fakethomann.model.entity.Product;
 

public class OrderDAOimpl implements OrderDAO{
	
	private MySqlConnection mySqlConnection;

	public OrderDAOimpl(MySqlConnection mySqlConnection) {
		super();
		this.mySqlConnection = mySqlConnection;
	}

	@Override
	public boolean createOrder(Order order) {
		String query = " INSERT INTO ordine (indirizzo_spedizione,data,totale,cliente_username) VALUES ('"+order.getShippingAddress()+"','"+order.getDateOfSale()+"','"+order.getTotalAmount()
		+"','"+order.getUser()+"');";
		
		try {
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
			int result = ps.executeUpdate(query);
			if(result==1) {
				System.out.println("ordine inserito a db");
				return true;
			}else {
				System.out.println("ordine non inserito a db");
				return false;
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
	}

	@Override
	public Order readOrder(int id) {
		
		ResultSet rs;
		
		String query = "SELECT * FROM ordine WHERE id="+id+";";
		
		try {
			
			
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			 
			int idFromDb = rs.getInt(id);
			String shippingAddress = rs.getString("indirizzo_spedizione");
			Date data  = rs.getDate("data");
			double total = rs.getDouble("totale");
			String clienteUsername = rs.getString("cliente_username");
			 
			
			ProductDAO productDAO = new ProductDAOimpl(mySqlConnection);
			
			ArrayList<Product> listOfInstruments = productDAO.readAllProductsByOrder(idFromDb); 
			
			Order order = new Order(idFromDb, shippingAddress, data, total, clienteUsername, listOfInstruments);
			return order;		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Attenzione non è stato possibile prelevare il dato dal db!!");
			return null;
		}
		
		
		
		
		
	}

	@Override
	public boolean updateOrder(Order order) {
		  return false;
	}

	@Override
	public boolean deleteOrdine(int id) {
		return false;
	}

	@Override
	public ArrayList<Order> readAllOrdersOfAClient(String username) {
		ArrayList<Order> listOfOrders = new ArrayList<>();

		ResultSet rs;
		String query = "SELECT * FROM ordine WHERE cliente_username='"+username+"';";
		
		try {
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) { 
				int idFromDb = rs.getInt("id");
				String shippingAddress = rs.getString("indirizzo_spedizione");
				Date data  = rs.getDate("data");
				double total = rs.getDouble("totale");
				String clienteUsername = rs.getString("cliente_username");
				 
				
				ProductDAO productDAO = new ProductDAOimpl(mySqlConnection);
				
				ArrayList<Product> listOfProducts = productDAO.readAllProductsByOrder(idFromDb); 
				
				Order order = new Order(idFromDb, shippingAddress, data, total, clienteUsername, listOfProducts);
				listOfOrders.add(order);	
				
			}
			
			return listOfOrders; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
