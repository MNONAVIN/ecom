package com.ecom.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
