package com.protom.fakethomann.model.entity;

import java.util.ArrayList;

public class User {
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private ArrayList<Order> orders;
	
	
	public User(String username, String password, String name, String surname, ArrayList<Order> orders) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.orders=orders;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	


	public ArrayList<Order> getOrders() {
		return orders;
	}


	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Cliente [username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ " number od orders="+orders.size()+" ]";
	}
	
	
	

}
