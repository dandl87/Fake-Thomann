package com.protom.fakethomann.model.entity;

import java.util.ArrayList;

public class Instrument{
	
	private String code;
	private String type;
	private String brand;
	private String model;
	private double price;
	private ArrayList<Product> listOfInstruments;
	
	public Instrument(String code, String type, String brand, String model, double price, ArrayList<Product> listOfInstruments) {
		super();
		this.code = code;
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.listOfInstruments=listOfInstruments;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public ArrayList<Product> getListOfInstruments() {
		return listOfInstruments;
	}

	public void setListOfInstruments(ArrayList<Product> listOfInstruments) {
		this.listOfInstruments = listOfInstruments;
	}

	@Override
	public String toString() {
		return "Strumento [code=" + code + ", type=" + type + ", brand=" + brand + ", model=" + model + ", price="
				+ price + ",available="+listOfInstruments.size()+"]";
	}
	
	

}
