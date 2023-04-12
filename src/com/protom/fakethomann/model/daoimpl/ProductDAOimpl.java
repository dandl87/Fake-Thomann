package com.protom.fakethomann.model.daoimpl;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.protom.fakethomann.dbconnection.MySqlConnection;
import com.protom.fakethomann.model.dao.OrderDAO;
import com.protom.fakethomann.model.dao.ProductDAO;
import com.protom.fakethomann.model.entity.Order;
import com.protom.fakethomann.model.entity.Product; 
 

public class ProductDAOimpl implements ProductDAO{
	
	
	private MySqlConnection mySqlConnection;

	public ProductDAOimpl(MySqlConnection mySqlConnection) {
		super();
		this.mySqlConnection = mySqlConnection;
	}

	@Override
	public boolean createProduct(Product strumentoSpecifico) {
		String query = " INSERT INTO prodotto (codice,strumento_codice,ordine_id) VALUES ('"+strumentoSpecifico.getProductCode()+"','"+strumentoSpecifico.getProductCode()
				+"',"+strumentoSpecifico.getOrdine().getId()+");";
		
		try {
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
			int result = ps.executeUpdate(query);
			if(result==1) {
				System.out.println("strumento specifico inserito a db");
				return true;
			}else {
				System.out.println("strumento specifico non inserito a db");
				return false;
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
	}

	@Override
	public Product readProduct(int id) {
		
		ResultSet rs;
		
		String query = "SELECT * FROM prodotto WHERE id='"+id+"';";
		
		try {
			
			
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			 
			String codeProduct = rs.getString("codice");
			String instrumentCode = rs.getString("strumento_codice");
			boolean isInShop = rs.getBoolean("presente");
			int idOrder  = rs.getInt("ordine_id"); 
			 
			 
			
			OrderDAO orderDAO = new OrderDAOimpl(mySqlConnection);
			
			Order order = orderDAO.readOrder(idOrder);
			
			 
			Product strumentoSpecifico = new Product(codeProduct,instrumentCode,isInShop, order);
			
			return strumentoSpecifico;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Attenzione non è stato possibile prelevare il dato dal db!!");
			return null;
		}
		
		
		
		
		
	}

	@Override
	public boolean updateProduct(Product product) {
		  return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		return false;
	}

	@Override
	public ArrayList<Product> readAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> readAllProductsByInstrument(String instrumentCode) {
		ArrayList<Product> listOfProducts = new ArrayList<>();

		ResultSet rs;
		String query = "SELECT * FROM prodotto WHERE strumento_codice='"+instrumentCode+"';";
		
		try {
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {  
				String productCode = rs.getString("codice");
				String instrumentCodeFromDb = rs.getString("strumento_codice");
				boolean isInShop = rs.getBoolean("presente");
				int orderId = rs.getInt("ordine_id");
				Order orderFromDb;
				
				if(orderId!=0) {
					OrderDAO orderDAO = new OrderDAOimpl(mySqlConnection);
					orderFromDb = orderDAO.readOrder(orderId);
				}else
					orderFromDb = null;
				
				Product  product= new Product(productCode, instrumentCode,isInShop,orderFromDb);
				listOfProducts.add(product);	
				
			}
			
			return listOfProducts; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Product> readAllProductsByOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

 

}
