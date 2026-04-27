package com.Project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

	List<Wishlist> findByUserId(Long userId);
}
