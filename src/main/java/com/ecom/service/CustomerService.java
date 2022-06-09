package com.ecom.service;

import java.util.List;

import com.ecom.entity.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer) ;
	public Customer findById(int customerId);
	public void deleteCustomer(int customerId);
	public Customer updateCustomer(Customer customer);
	public List<Customer> getAll();
	public Customer login(String userName,String password);
}
