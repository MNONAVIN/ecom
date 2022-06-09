package com.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_tbl")
public class Product {
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="product_id")
private int productId;

@Column(name="product_name")
private String productName;

@Column(name="product_price")
private double productPrice;

private String category;

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}



}
