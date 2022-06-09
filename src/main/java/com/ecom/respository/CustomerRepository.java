package com.ecom.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecom.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	@Query("select c from Customer c where c.userName=:uName and c.password=:pswrd")
	public Customer doLogin(@Param("uName") String userName,@Param("pswrd")String password);
}
