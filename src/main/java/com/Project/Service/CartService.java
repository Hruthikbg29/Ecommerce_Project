package com.Project.Service;

import java.util.List;

import com.Project.Entity.Cart;

public interface CartService {

	Cart addToCart(Cart cart);

	List<Cart> getUserCart(Long userId);

	void removeItem(Long cartId);

	void clearCart(Long userId);

}
