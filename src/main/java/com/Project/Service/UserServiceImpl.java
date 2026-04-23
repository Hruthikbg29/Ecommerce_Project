package com.Project.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Project.Entity.User;
import com.Project.Repository.AdminRepository;
import com.Project.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private final AdminRepository adminRepository;
	private final UserRepository repository;
	
	

	public UserServiceImpl(UserRepository repository , AdminRepository adminRepository) {	
		this.repository = repository;
		this.adminRepository = adminRepository;
	}

	@Override
	public User register(User user) {
		if(repository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("Email already exists");
		}
		return repository.save(user);
	}

	@Override
	public String login(String email, String password) {
		
		if(adminRepository.existsByEmail(email)) {
			return "This email belongs to admin";
		}
		
		
		Optional<User>optionalUser= repository.findByEmail(email);
		
		if(optionalUser.isEmpty()) {
			return "User not found";
		}
		
		User dbUser = optionalUser.get();
		
		if(!dbUser.getPassword().equals(password)) {
			return "invalid password";
		}
		return "User login successfully";
	}

}
