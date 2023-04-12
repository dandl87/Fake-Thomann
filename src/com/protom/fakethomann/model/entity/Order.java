package com.protom.fakethomann.model.entity;

import java.sql.Date;
import java.util.ArrayList;

public class Order {
	
	private int id;
	private String shippingAddress;
	private Date dateOfSale;
	private double totalAmount;
	private String user;
	private ArrayList<Product> listOfProducts;
	
	public Order(int id, String shippingAddress, Date dateOfSale, double totalAmount, String user, ArrayList<Product> listOfProducts) {
		super();
		this.id = id;
		this.shippingAddress = shippingAddress;
		this.dateOfSale = dateOfSale;
		this.totalAmount = totalAmount;
		this.user = user;
		this.listOfProducts=listOfProducts;
	}

	public Order(String shippingAddress, Date dateOfSale, double totalAmount,String user, ArrayList<Product> listOfProducts) {
		super();
		this.shippingAddress = shippingAddress;
		this.dateOfSale = dateOfSale;
		this.totalAmount = totalAmount;
		this.user = user;
		this.listOfProducts=listOfProducts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Date getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	} 
	 
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
	public ArrayList<Product> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(ArrayList<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	@Override
	public String toString() {
		return "Ordine [id=" + id + ",user="+user+", shippingAddress=" + shippingAddress + ", dateOfSale=" + dateOfSale
				+ ",list Of Instruments="+listOfProducts+", totalAmount=" + totalAmount + "]";
	}
	
	

}
