package com.cognizant.bootup.productcatalogservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.bootup.productcatalogservice.entity.Review;

public interface ReviewDao extends JpaRepository<Review, Integer>{
	
	public List<Review> findReviewByProductId(int id);

}
