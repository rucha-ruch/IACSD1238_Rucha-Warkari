package com.app;







import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.helper.UserFoundException;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.service.IUserService;
import com.app.service.UserServiceImpl;



@SpringBootApplication
public class CDay16BackendApplication implements CommandLineRunner{

	@Autowired
	private IUserService userService;
	@Autowired
	private UserServiceImpl userServiceImpl; 
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(CDay16BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
		System.out.println("Starting code");
//		User user=new User();
//		user.setFirstName("Janhvi");
//		user.setLastName("Raut");
//		user.setUsername("ja");
//		user.setPassword(this.bCryptPasswordEncoder.encode("7854"));
//		user.setEmail("janhvi@gmail.com");
//		user.setProfile("profile.png");
//		
//		Role role1=new Role();
//		role1.setRoleId(45L);
//		role1.setRoleName("Normal");
//		
//		Set<UserRole>userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		
//		userRoleSet.add(userRole);
//		
//		User user1=this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
//		
}catch (Exception e) {
	e.printStackTrace();
}
	}



}
