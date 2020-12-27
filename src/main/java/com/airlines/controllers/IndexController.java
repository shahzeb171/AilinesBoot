package com.airlines.controllers;

import java.security.Principal;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.airlines.dao.CitiesDao;
import com.airlines.dao.UsersDao;
import com.airlines.pojos.Users;

@Controller
public class IndexController {
	
	@Autowired
	CitiesDao cd;
	@Autowired
	UsersDao udao ;
	@RequestMapping("/")
	public ModelAndView getHTML() {

		return new ModelAndView(new RedirectView("index"));
	
	}
	
	@RequestMapping("/index")
	public ModelAndView getIndex(HttpServletRequest request,Principal p) {
	
		ModelAndView mv = new ModelAndView();
		Set<String> set = cd.cities();
		
		mv.addObject("Set", set);
		mv.setViewName("index");

		Users user = udao.getUser(p);
		
		HttpSession session = request.getSession();
		
		
		if( p != null) {
			session.setAttribute("loggedin", true);
		
		
		if( user.getRole().equals("ADMIN"))
			session.setAttribute("loggedinAdmin", true);
		else if( user.getRole().equals("USER"))
			session.setAttribute("loggedinUser", true);
	}
		 return mv;
	}
}
