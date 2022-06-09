package com.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.entity.Address;
import com.ecom.respository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	
	public Address addAddress(Address address) {
		Address savedAddress = addressRepository.save(address);
		return savedAddress;
	}
	
	
	public Optional<Address> findById(int address_Id) {
		Optional<Address> byId = addressRepository.findById(address_Id);
		return  byId;
	}
	
	
	public List<Address> getAll() {
		List<Address> allDetails = addressRepository.findAll();
		return allDetails;
	}
	
}
