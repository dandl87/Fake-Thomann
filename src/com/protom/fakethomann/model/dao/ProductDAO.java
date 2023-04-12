package com.protom.fakethomann.model.dao;

import java.util.ArrayList;
 
import com.protom.fakethomann.model.entity.Product;
 

public interface ProductDAO {
	
	boolean createProduct(Product product);
	Product readProduct(int id);
	boolean updateProduct(Product product);
	boolean deleteProduct(int id);
	
	ArrayList<Product> readAllProducts();
	ArrayList<Product> readAllProductsByInstrument(String instrumentCode);
	ArrayList<Product> readAllProductsByOrder(int orderId);

}
