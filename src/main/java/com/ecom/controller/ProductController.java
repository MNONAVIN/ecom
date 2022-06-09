package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Product;
import com.ecom.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	@GetMapping("/product/all")
	public List<Product> fetchAll() {
		List<Product> products = productService.getAllProduct();
		return products;
		}
	
	@PostMapping("/product/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		Product newProduct = productService.saveProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/product/find/{pId}")
	public ResponseEntity<Object> fetchId(@PathVariable("pId") int productId){
		ResponseEntity<Object> responseEntity = null;
		Product product = productService.getProductById(productId);
		responseEntity = new ResponseEntity<>(product,HttpStatus.FOUND);		
		return responseEntity;
	}
	
	@DeleteMapping("/product/delete/{pid}")
	public ResponseEntity<String> delete(@PathVariable("pid")int productId) {
		productService.deleteProduct(productId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("The record deleted Successfully",HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/product/update")
	public ResponseEntity<Product> update(@RequestBody Product product) {
		Product products = productService.updateProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(products,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/product/findCategory/{Category}")
	public List<Product> getProductsByCategory(@PathVariable("Category")String category) {
		List<Product> byCategory = productService.getByCategory(category);
		return byCategory;
	}
	
	@GetMapping("product/{productName}")
	public Product getProductByName(@PathVariable("productName") String productName) {
		Product product = productService.getByProductName(productName);
		return product;
	}
	
	
	@GetMapping("product/byPrice/{lPrice}/{uPrice}")
	public List<Product> fetchProductByPriceWithinRange(@PathVariable("lPrice")double lRange,@PathVariable("uPrice")double uRange) {
		List<Product> product = productService.getProductsWithinRange(lRange, uRange);
		return product;
	}
	 
}
