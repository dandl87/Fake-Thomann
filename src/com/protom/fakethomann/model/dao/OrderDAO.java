package com.protom.fakethomann.model.dao;

import java.util.ArrayList;
 
import com.protom.fakethomann.model.entity.Order; 
 

public interface OrderDAO {
	
	boolean createOrder(Order order);
	Order readOrder(int id);
	boolean updateOrder(Order order);
	boolean deleteOrdine(int id);
	
	ArrayList<Order> readAllOrdersOfAClient(String username);
	//ArrayList<Ordine> readAllOrdersOfAnInstrument(Strumento strumento);

}
