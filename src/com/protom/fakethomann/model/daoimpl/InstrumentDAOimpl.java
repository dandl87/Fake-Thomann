package com.protom.fakethomann.model.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.protom.fakethomann.dbconnection.MySqlConnection;
import com.protom.fakethomann.model.dao.InstrumentDAO;
import com.protom.fakethomann.model.dao.ProductDAO;
import com.protom.fakethomann.model.entity.Instrument;
import com.protom.fakethomann.model.entity.Product; 

 

public class InstrumentDAOimpl implements InstrumentDAO {
	
	private MySqlConnection mySqlConnection;

	public InstrumentDAOimpl(MySqlConnection mySqlConnection) {
		super();
		this.mySqlConnection = mySqlConnection;
	}

	@Override
	public boolean createInstrument(Instrument instrument) {
		String query = " INSERT INTO strumento (code,tipo,marca,modello,prezzo) VALUES ('"+instrument.getCode()+"','"+instrument.getType()+"','"+instrument.getBrand()+"','"
				+instrument.getModel()+"',"+instrument.getPrice()+");";
		
		try {
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
			int result = ps.executeUpdate(query);
			if(result==1) {
				System.out.println("strumento inserito a db");
				return true;
			}else {
				System.out.println("strumento non inserito a db");
				return false;
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
	}

	@Override
	public Instrument readInstrument(String code) {
		
		ResultSet rs;
		
		String query = "SELECT * FROM strumento WHERE codice='"+code+"';";
		
		try {
			
			
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			 
			String codeFromDb = rs.getString("codice");
			String type = rs.getString("tipo");
			String marca = rs.getString("marca");
			String modello = rs.getString("modello");
			double price = rs.getDouble("prezzo");
			
			ProductDAO productDAO = new ProductDAOimpl(mySqlConnection);
			
			ArrayList<Product> listOfProducts = productDAO.readAllProductsByInstrument(codeFromDb);
			Instrument instrument = new Instrument(codeFromDb,type,marca,modello,price,listOfProducts);
			
			return instrument;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Attenzione non è stato possibile prelevare il dato dal db!!");
			return null;
		}
		
		
		
		
		
	}

	@Override
	public boolean updateInstrument(Instrument instrument) {
		  return false;
	}

	@Override
	public boolean deleteInstrument(String code) {
		return false;
	}

	 
 

 

}
