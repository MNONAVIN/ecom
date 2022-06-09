package com.ecom.service;

import java.util.List;
import com.ecom.entity.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	
	public Product getProductById(int productId);
	
	public List<Product> getAllProduct();
	
	public Product updateProduct(Product product);
	
	public void deleteProduct(int productId);
	
	public List<Product> getByCategory(String category);
	
	public Product getByProductName(String productName);
	
	public List<Product> getProductsWithinRange(double lower,double upper);
}
