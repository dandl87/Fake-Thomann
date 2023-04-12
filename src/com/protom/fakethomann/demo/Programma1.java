package com.protom.fakethomann.demo;

import java.sql.Date;
import java.util.ArrayList;

import com.protom.fakethomann.dbconnection.MySqlConnection;
import com.protom.fakethomann.model.dao.InstrumentDAO;
import com.protom.fakethomann.model.dao.OrderDAO;
import com.protom.fakethomann.model.dao.ProductDAO;
import com.protom.fakethomann.model.dao.UserDAO;
import com.protom.fakethomann.model.daoimpl.InstrumentDAOimpl;
import com.protom.fakethomann.model.daoimpl.OrderDAOimpl;
import com.protom.fakethomann.model.daoimpl.ProductDAOimpl;
import com.protom.fakethomann.model.daoimpl.UserDAOimpl;
import com.protom.fakethomann.model.entity.Instrument;
import com.protom.fakethomann.model.entity.Order;
import com.protom.fakethomann.model.entity.Product;
import com.protom.fakethomann.model.entity.User;

public class Programma1 {
	
	public static void main(String[] args) {
		
		// avvia connessione a db
		
		// leggi user
		
		// fai operazione su utente
		
		// stampa lista di ordini
		
		
		
		
		
		
		System.out.println("Primo programma - Compriamo qualcosa");
		MySqlConnection mySqlConnection = MySqlConnection.getInstance();
		
		mySqlConnection.avviaConnessione();
		
		UserDAO userDAO = new UserDAOimpl(mySqlConnection);
		
		User user1 = userDAO.readUser("Dan87");
		
		InstrumentDAO instrumentDAO = new InstrumentDAOimpl(mySqlConnection);
		
		Instrument instrument1 = instrumentDAO.readInstrument("GTRFSC01");
		
		System.out.println("Vediamo un po i dati :");
		System.out.println("cliente:" +user1);
		ArrayList<Order> listOfOrders = user1.getOrders();
		Order order =listOfOrders.get(0);
		ArrayList<Product> listOfProduct = order.getListOfProducts();
		System.out.println("strumento scelto:" +instrument1);
		
		ProductDAO productDAO = new ProductDAOimpl(mySqlConnection);
		ArrayList<Product> listOfAvailableProducts = productDAO.readAllProductsByInstrument(instrument1.getCode());
		
		System.out.println(listOfAvailableProducts);
		
//		ArrayList<Product> listOfProductsSelling = new ArrayList<Product>();
//		
//		Product product1 = listOfAvailableProducts.get(0);
//		listOfProductsSelling.add(product1);
//		
//		Product product2 = listOfAvailableProducts.get(1);
//		listOfProductsSelling.add(product2);
// 
// 		OrderDAO orderDAO = new OrderDAOimpl(mySqlConnection);
// 		
// 		double totale =0.0;
// 		for(Product p :listOfProductsSelling) {
// 			Instrument s = instrumentDAO.readInstrument(p.getInstrumentCode());
// 			totale = totale + s.getPrice();
// 		}
// 			 
// 		
// 		String dateAsString = "2023-04-10";
// 		Date d1 = Date.valueOf(dateAsString);
// 		Order ordine1 = new Order("via Toledo 19",d1,totale,user1.getUsername(),listOfProductsSelling);
// 		boolean result = orderDAO.createOrder(ordine1);
// 		
//		if(result) {
//		System.out.println("Acquisto effettuato");
//		System.out.println("ordine generato:");
//		System.out.println("cliente:"+ordine1.getUser());
//		System.out.println("indirizzo di spedizione:"+ordine1.getShippingAddress());
//		System.out.println("totale:"+ordine1.getTotalAmount());
//		System.out.println("data:"+ordine1.getDateOfSale());
//		System.out.println("strumenti comprati:");
//		for(Product p : ordine1.getListOfProducts()) {
//			Instrument instrument = instrumentDAO.readInstrument(p.getInstrumentCode());
//			System.out.println(instrument);
//			System.out.println( p.getProductCode() );
//		}
//		} else System.out.println("Ordine non riuscito");
		}

}
