package com.airlines.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.airlines.dao.UsersDao;
import com.airlines.pojos.Users;

@Controller
public class SignupController {

	@Autowired
	UsersDao udao;
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView getSignup(Principal p) {
		
		ModelAndView mv = new ModelAndView();
		
		if(p != null)
			return new ModelAndView(new RedirectView("index"));
		
		mv.setViewName("signup");
		
		return mv;
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView postSignup(Principal p
			,@RequestParam String name
			,@RequestParam String username, 
			@RequestParam String password,
			HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView(new RedirectView("index"));
		
		if(p != null)
			return mv;
		
		Users user = new Users();
		
		user.setName(name);
		user.setUsername(username);
		new BCrypt();
		user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(12)));
		user.setRole("USER");
		
		boolean get = udao.add(user);
		
		
		HttpSession session = request.getSession();
		
		if( !get )
			session.setAttribute("failedSignup", true);
		else
			session.setAttribute("signed", true);
		
		return mv;
	}
}
