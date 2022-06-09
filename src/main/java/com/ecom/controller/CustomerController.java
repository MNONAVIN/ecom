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

import com.ecom.entity.Customer;
import com.ecom.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	
	@GetMapping("/customer/find/{cust_id}")
	public ResponseEntity<Customer> getById(@PathVariable("cust_id") int customerId) {
		Customer  custById = customerService.findById(customerId);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(custById,HttpStatus.FOUND);
		return responseEntity;
	}
	
	@PostMapping("/customer/save")
	public Customer saveCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.saveCustomer(customer);
		return savedCustomer;
	}
	
	@GetMapping("/customer/get")
	public List<Customer> allDetails() {
		List<Customer> all = customerService.getAll();
		return all;
	}
	
	@DeleteMapping("/customer/delete/{cid}")
	public ResponseEntity<String> delete(@PathVariable("cid")int customerId) {
		customerService.deleteCustomer(customerId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Succcessfully deleted",HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/customer/update")
	public ResponseEntity<Customer> update(@RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/customer/login")
	public ResponseEntity<Customer> doLogin(@RequestBody Customer customer) {
		Customer customer1 = customerService.login(customer.getUserName(), customer.getPassword());
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer1,HttpStatus.OK);
		return responseEntity;
	}
}
