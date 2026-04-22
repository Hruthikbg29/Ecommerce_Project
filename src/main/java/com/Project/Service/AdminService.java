package com.Project.Service;

import com.Project.Entity.Admin;

public interface AdminService {

	Admin register(Admin admin);
	
	String login(String email, String password);
}
