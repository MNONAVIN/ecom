package com.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Customer;
import com.ecom.exception.CustomerNotFoundException;
import com.ecom.exception.UserNotFoundException;
import com.ecom.respository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	

	

	@Override
	public Customer saveCustomer(Customer customer) {
	Customer customers =	customerRepository.save(customer);
		return customers;
	}





	@Override
	public Customer findById(int customerId)  {
		Optional<Customer> byId = customerRepository.findById(customerId);
		if(byId.isEmpty()) {
			throw new CustomerNotFoundException("The Customer is not found with id: "+customerId);
		}
		Customer customer =byId.get();
		return customer;
	}





	@Override
	public void deleteCustomer(int customerId)  {
		Optional<Customer> cust = customerRepository.findById(customerId);
		if(cust.isEmpty()) {
			throw new CustomerNotFoundException("The Customer is not found with id: "+customerId);
		}
		customerRepository.deleteById(customerId);
	}





	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> cust =customerRepository.findById(customer.getCustomerId());
		if(cust.isEmpty()) {
			throw new CustomerNotFoundException("The Customer is not found with id: "+customer.getCustomerId());
		}
		Customer customers = customerRepository.save(customer);
		return customers;
	}





	@Override
	public List<Customer> getAll() {
		List<Customer> allDetails = customerRepository.findAll();
		return allDetails;
	}





	@Override
	public Customer login(String userName, String password) {
		Customer customer = customerRepository.doLogin(userName, password);
		if(customer==null) {
			throw new UserNotFoundException("User or password invalid!");
		}
		return customer;
	}
	
}
