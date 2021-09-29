package com.app.service;

import java.util.Set;

import com.app.pojos.User;
import com.app.pojos.UserRole;

public interface IUserService {
	
		//creating user
		public User createUser(User user,Set<UserRole>userRole)throws Exception;
		
		//get user by user Name
		public User getUser(String username);
		
		//delete user by id
		public void deleteUser(Long userId);
			
}
