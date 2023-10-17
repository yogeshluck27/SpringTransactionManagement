package com.springtxn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springtxn.dto.Product;

@Repository
public class ProductRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//@Transactional
	//@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Transactional(propagation=Propagation.REQUIRED)
	//@Transactional(propagation=Propagation.NEVER)
	//@Transactional(propagation=Propagation.NOT_SUPPORTED)
	//@Transactional(propagation=Propagation.MANDATORY)
	//@Transactional(propagation=Propagation.SUPPORTS)

	public void saveProduct(Product product){
		String sql = "INSERT INTO Product VALUES (?,?)";
		Object args[] = {product.getId(),product.getpName()};
		jdbcTemplate.update(sql,args);
		
		System.out.println("Product saved...");
	}
}
