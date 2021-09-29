package com.app.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RoleRepository;
import com.app.dao.UserRepository;
import com.app.helper.UserFoundException;
import com.app.pojos.User;
import com.app.pojos.UserRole;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository rolepository;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRole) throws Exception {
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null)
		{
			System.out.println("User is already there !!");
			throw new UserFoundException();
		}
		else {
			//create user
			for(UserRole ur:userRole)
			{
				rolepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRole);
			local =this.userRepository.save(user);
		}
		
		return local;
	}

	//grtting user by username
	@Override
	public User getUser(String username) {
		
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}

}
