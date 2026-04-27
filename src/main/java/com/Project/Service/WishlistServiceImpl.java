package com.Project.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Project.Entity.Wishlist;
import com.Project.Repository.ProductRepository;
import com.Project.Repository.UserRepository;
import com.Project.Repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService{

	private final WishlistRepository repository;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	
	
	
	
	public WishlistServiceImpl(WishlistRepository repository, UserRepository userRepository,
			ProductRepository productRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
	}

	@Override
	public Wishlist add(Wishlist wishlist) {
		Long userId = wishlist.getUser().getId();
		Long productId = wishlist.getProduct().getId();
		
		if(!userRepository.existsById(userId)) {
			throw new RuntimeException("User Not found");
		}
		
		if(!productRepository.existsById(productId)) {
			throw new RuntimeException("Product Not found");
		}
		
		
		return repository.save(wishlist);
	}

	@Override
	public List<Wishlist> getByUser(Long userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);
		
	}
	

}
