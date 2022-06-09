package com.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Product;
import com.ecom.exception.ProductNotFoundException;
import com.ecom.respository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		Product products = productRepository.save(product);
		return products;
	}

	@Override
	public  Product getProductById(int productId) throws ProductNotFoundException {
		Optional<Product> detailsById = productRepository.findById(productId);
		
		if(detailsById.isEmpty()) {
			throw new ProductNotFoundException("The record is not present with id "+productId);
		}
		Product product = detailsById.get();
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
	List<Product> products =	productRepository.findAll();
		return products;
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> updated = productRepository.findById(product.getProductId());
		if(updated.isEmpty()) {
			throw new ProductNotFoundException("The Record is not found with the id: "+product.getProductId());
		}
		Product updatedRecord = productRepository.save(product);
		return updatedRecord;
	}

	@Override
	public void deleteProduct(int productId) {
		Optional<Product> delete = productRepository.findById(productId);
		if(delete.isEmpty()) {
			throw new ProductNotFoundException("The product is not found with the id: "+productId);
		}
		productRepository.deleteById(productId);
		
	}

	@Override
	public List<Product> getByCategory(String category) {
		List<Product> byCategory = productRepository.findByCategory(category);
		return byCategory;
	}

	@Override
	public Product getByProductName(String productName) {
		Product product  = productRepository.findByProductName(productName);
		return product;
	}

	
	@Override
	public List<Product> getProductsWithinRange(double lower, double upper) {
		List<Product> product = productRepository.findAllProductsWithinPriceRange(lower, upper);
		return product;
	}
	 
	

}
