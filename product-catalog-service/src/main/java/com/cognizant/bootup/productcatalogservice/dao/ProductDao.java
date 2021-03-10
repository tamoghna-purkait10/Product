package com.cognizant.bootup.productcatalogservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.bootup.productcatalogservice.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	public Product findProductById(int id);
	
	public List<Product> findProductByNameContainingIgnoreCase(String letter);
}
