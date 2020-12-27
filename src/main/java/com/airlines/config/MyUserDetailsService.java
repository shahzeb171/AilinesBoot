package com.airlines.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.airlines.pojos.Users;
import com.airlines.repos.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository urepo;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user =  urepo.findByUsername(username);
		
		if(user == null)
			throw new UsernameNotFoundException("USER NOT FOUND");
		
			return new UserPrincipal(user);
	}

}
