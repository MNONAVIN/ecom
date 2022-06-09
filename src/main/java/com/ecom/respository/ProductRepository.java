package com.ecom.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecom.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	public List<Product> findByCategory(String Category);
	
	public Product findByProductName(String productName);
	
	@Query("select p from Product p where p.productPrice between :lRange and :uPrice")
	public List<Product> findAllProductsWithinPriceRange(@Param("lRange") double lower,@Param("uPrice") double upper);
}
