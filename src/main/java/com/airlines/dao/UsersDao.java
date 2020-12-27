package com.airlines.dao;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airlines.pojos.Users;
import com.airlines.repos.UserRepository;

@Component
public class UsersDao {

	@Autowired
	UserRepository urepo;
	
	public Users getUser(Principal principal) {
		
		if(principal == null)
			return new Users();
			
		Users user = urepo.findByUsername(principal.getName());
		
		return user;
	}
	public boolean add(Users u) {
		
		Users user = urepo.findByUsername(u.getUsername());
		System.out.println(user);
		if(user != null)
			return false;
		
		urepo.save(u);
		
		return true;
		
	}
	
	
}
