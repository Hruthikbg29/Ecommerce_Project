package com.Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entity.Admin;
import java.util.List;


public interface AdminRepository  extends JpaRepository<Admin, Long>{

	boolean existsByEmail(String email);
	
	Optional<Admin>  findByEmail(String email);
	
}
