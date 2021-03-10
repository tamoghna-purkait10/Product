package com.cognizant.bootup.productcatalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bootup.productcatalogservice.dao.ProductDao;
import com.cognizant.bootup.productcatalogservice.entity.Product;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductDao productDao;
	
	@PostMapping
	public Product newProduct(@RequestBody Product product){
		return productDao.save(product);
	}
	
	@PostMapping("/all")
	public List<Product> newProducts(@RequestBody List<Product> products){
		return productDao.saveAll(products);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id){
		return productDao.findProductById(id);
	}
	
	@GetMapping("/byName/{letter}")
	public List<Product> getProductByNameContainingInput(@PathVariable String letter){
		return productDao.findProductByNameContainingIgnoreCase(letter);
		}
}
