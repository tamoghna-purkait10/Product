package com.cognizant.bootup.productcatalogservice.service;

import java.util.List;

import com.cognizant.bootup.productcatalogservice.entity.Review;

public interface ReviewService {
	
	public Review newReview(Review review, int id);
	
	public List<Review> getReview(int id);

}
