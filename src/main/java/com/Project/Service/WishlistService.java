package com.Project.Service;

import java.util.List;

import com.Project.Entity.Wishlist;

public interface WishlistService {

	Wishlist add(Wishlist wishlist);
	
	List<Wishlist> getByUser(Long userId);
	
	void remove(Long id);
}
