package com.ecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Address;
import com.ecom.service.AddressService;

@RestController
public class AddressController {
	@Autowired
		AddressService addService;
	
		
		@PostMapping("/Address/save")
		public Address saveAddress(@RequestBody Address address) {
			Address savedAddress = addService.addAddress(address);
			return savedAddress;
		}
		
		@GetMapping("/Address/find/{add_id}")
		public Optional<Address> findId(@PathVariable("add_id") int address_Id) {
			Optional<Address> byId = addService.findById(address_Id);
			return  byId;
		}
		
		@GetMapping("/Address/gets")
		public List<Address> get() {
			List<Address> allDetails = addService.getAll();
			return allDetails;
		}
}
