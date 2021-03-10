package com.cognizant.bootup.productcatalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bootup.productcatalogservice.dao.ProductDao;
import com.cognizant.bootup.productcatalogservice.dao.ReviewDao;
import com.cognizant.bootup.productcatalogservice.entity.Product;
import com.cognizant.bootup.productcatalogservice.entity.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ProductDao productDao;
	@Autowired
	ReviewDao reviewDao;

	@Override
	public Review newReview(Review review, int id) {
		Product product = productDao.findProductById(id);
		review.setProduct(product);
		return reviewDao.save(review);
	}

	@Override
	public List<Review> getReview(int id) {
		Product product = productDao.findProductById(id);
		return reviewDao.findReviewByProductId(product.getId());
	}
	
	

}
