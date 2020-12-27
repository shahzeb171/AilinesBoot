package com.airlines.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.airlines.dao.BookingsDao;


@Controller
public class CancelController {

	@Autowired
	BookingsDao bd;
	
	@RequestMapping(value="/cancel",method=RequestMethod.GET)
	public ModelAndView getCancel(HttpServletRequest request, HttpServletResponse response, @RequestParam int bsno, Principal p) {
	
		ModelAndView mv = new ModelAndView( new RedirectView("book"));
		
		
		HttpSession session = request.getSession();
		

		String username = p.getName();
		
		if( bd.cancelled( bsno, username) ){
			session.setAttribute("cancelled",true);
		}
		else{
			session.setAttribute("cancellationFailed",true);
		}
		
		return mv;
	}
}
