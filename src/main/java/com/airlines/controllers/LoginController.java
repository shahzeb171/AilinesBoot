package com.airlines.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView getLoginAdmin() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login");
		
		return mv;
	}
	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal p) {
		System.out.println(p);
		return p;
	}
}
