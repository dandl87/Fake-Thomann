package com.protom.fakethomann.service;

import com.protom.fakethomann.dbconnection.MySqlConnection;
import com.protom.fakethomann.model.dao.InstrumentDAO;
import com.protom.fakethomann.model.dao.OrderDAO;
import com.protom.fakethomann.model.dao.ProductDAO;
import com.protom.fakethomann.model.dao.UserDAO;
import com.protom.fakethomann.model.daoimpl.InstrumentDAOimpl;
import com.protom.fakethomann.model.daoimpl.OrderDAOimpl;
import com.protom.fakethomann.model.daoimpl.ProductDAOimpl;
import com.protom.fakethomann.model.daoimpl.UserDAOimpl;
import com.protom.fakethomann.model.entity.User;

public class ReadService {
	private UserDAO userDAO;
	private OrderDAO orderDAO;
	private ProductDAO productDAO;
	private InstrumentDAO instrumentDAO;
	
	
	public ReadService(MySqlConnection mySqlConnection) {
		super();
		this.userDAO = new UserDAOimpl(mySqlConnection);
		this.orderDAO = new OrderDAOimpl(mySqlConnection);
		this.productDAO = new ProductDAOimpl(mySqlConnection);
		this.instrumentDAO = new InstrumentDAOimpl(mySqlConnection);
	}
	
	public User findAUser(String username) {
		User user = userDAO.readUser(username);
		if(user==null)
			return null;
		else
			return user;
		} 
 
	 
}
