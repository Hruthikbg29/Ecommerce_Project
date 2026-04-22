package com.Project.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Project.Entity.Admin;
import com.Project.Repository.AdminRepository;
import com.Project.Repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{

	private final AdminRepository adminRepository;
	private final UserRepository userRepository;
	
	public AdminServiceImpl(AdminRepository adminRepository, UserRepository userRepository) {
		super();
		this.adminRepository = adminRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Admin register(Admin admin) {
		if(adminRepository.existsByEmail(admin.getEmail())) {
			throw new RuntimeException("This email belongs to user");
		}
		
		return adminRepository.save(admin);
	}

	@Override
	public String login(String email, String password) {
		Optional<Admin> optionalAdmin = adminRepository.findByEmail(email);
		
		if(optionalAdmin.isEmpty()) {
			return "Admin not found";
		}
		Admin dbadmin = optionalAdmin.get();
		
		if(!dbadmin.getPassword().equals(password)) {
			return "Invalid password";
		}
		
		
		return "Admin login successful";
	}

}
