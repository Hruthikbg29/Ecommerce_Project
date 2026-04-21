package com.Project.Service;

import com.Project.Entity.User;

public interface UserService {

	User register(User user);
	
	String login(String email, String password);
}
