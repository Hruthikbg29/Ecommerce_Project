package com.Project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entity.Review;
import com.Project.Service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin("*")
public class ReviewController {

	private final ReviewService service;

	public ReviewController(ReviewService service) {
		this.service = service;
	}
	
	@PostMapping
	public Review add(@RequestBody Review review) {
		return service.add(review);
	}
	
	@GetMapping("/{productId}")
	public List<Review> get(@PathVariable Long productId){
		return service.getByProduct(productId);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "Review deleteed Successfully";		
	}
	
	@GetMapping("/average/{productId}")
	public Double average(@PathVariable Long productId) {
		return service.average(productId);
	}
	
	
	
	
}
