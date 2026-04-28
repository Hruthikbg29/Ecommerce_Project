package com.Project.Service;

import java.util.List;

import com.Project.Entity.Review;

public interface ReviewService {

	 Review add(Review review);

	    List<Review> getByProduct(Long productId);

	    void delete(Long id);

	    Double average(Long productId);
}
