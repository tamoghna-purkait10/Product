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

import com.cognizant.bootup.productcatalogservice.entity.Review;
import com.cognizant.bootup.productcatalogservice.service.ReviewService;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	
	@PostMapping("/{id}/reviews")
	public Review newReview(@RequestBody Review review, @PathVariable int id) {
		return reviewService.newReview(review, id);
	}
	
	@GetMapping("/{id}/reviews")
	public List<Review> getReview(@PathVariable int id) {
		return reviewService.getReview(id);
	}
}
