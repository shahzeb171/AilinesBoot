package com.airlines.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new  ModelAndView(new RedirectView("index"));
		HttpSession session = request.getSession();
		if(session.getAttribute("loggedinAdmin")!=null && (Boolean)session.getAttribute("loggedinAdmin")){
		session.removeAttribute("failedAdminLogin");
		session.removeAttribute("usernameAdmin");
		session.removeAttribute("loggedinAdmin");
		session.setAttribute("loggedoutAdmin",true);
		session.removeAttribute("nameAdmin");
		}
		
		else{
		session.removeAttribute("loggedin");
		session.removeAttribute("failedLogin");
		session.removeAttribute("username");
		session.setAttribute("loggedoutUser",true);
		}
		return mv;
	}
}
