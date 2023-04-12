package com.protom.fakethomann.model.entity;

public class Product {

	private String productCode;
	private String instrumentCode;
	private Order order;
	private boolean isInShop;
	
	
	

	public Product(String productCode, String instrumentCode, boolean isInShop, Order order) {
		super();
		this.productCode = productCode;
		this.instrumentCode = instrumentCode;
		this.order=order;
		this.isInShop=isInShop;
	}



	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	

	public String getInstrumentCode() {
		return instrumentCode;
	}



	public void setInstrumentCode(String instrumentCode) {
		this.instrumentCode = instrumentCode;
	}



	public Order getOrdine() {
		return order;
	}

	public void setOrdine(Order order) {
		this.order = order;
	}
	
	

	public boolean isInShop() {
		return isInShop;
	}



	public void setInShop(boolean isInShop) {
		this.isInShop = isInShop;
	}



	@Override
	public String toString() {
		return "StrumentoSpecifico [ productCode=" + productCode + ", instrumentCode=" + instrumentCode + ",in shop: "+isInShop+", ordine="+order+"]";
	} 
	
	
	
}
