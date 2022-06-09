package com.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_tbl")
public class Customer {

	@Id
	@Column(name="Cust_Id")
	private int customerId;
	
	@Column(name="Cust_Name")
	private String customerName;
	@Column(name="Cust_mobile")
	private String mobile;
	
	@Column(name="cust_email")
	private String email;
	@Column(name="cust_user")
	private String userName;
	@Column(name="cust_pass")
	private String password;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
		
}
