package com.airlines.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.airlines.dao.BookingsDao;
import com.airlines.dao.TimeTableDao;
import com.airlines.pojos.Bookings;
import com.airlines.pojos.Time_Table;


@Controller
public class BookingController {

	@Autowired
	BookingsDao bd;
	@Autowired
	TimeTableDao ttd;
	
	
	@RequestMapping(value="/book" ,method=RequestMethod.GET)
	public ModelAndView postBooking(HttpServletRequest request, HttpServletResponse response ,Principal p) throws IOException {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		
		/*if(p == null)
			return new ModelAndView(new RedirectView("login"));
		*/
		
		String username = p.getName();
	
		if(request.getParameter("sno") != null) {
		int sno = Integer.parseInt(request.getParameter("sno").toString());
		Time_Table tt = ttd.checkTimeTable(sno);
		
		if(tt.getFid() == null)
			return new ModelAndView(new RedirectView("index"));
		
		Bookings b = new Bookings();
		
		b.setArrival_ccode(tt.getArrivalCcode());
		b.setArrival_time(tt.getArrival_time());
		b.setDeparture_ccode(tt.getDepartureCcode());
		b.setDeparture_time(tt.getDeparture_time());
		b.setPrice(tt.getPrice());
		b.setUsername(username);
		
		
		if( bd.booked(b) ){
			session.setAttribute("booked", true);
			session.setAttribute("Bookings", bd.history(username));
			session.setAttribute("BookingsLength", bd.history(username).size());
			
			
			
			//response.sendRedirect("/book");
		}
		
		else
			return new ModelAndView(new RedirectView("index"));
		}
		else {
			session.setAttribute("Bookings", bd.history(username));
			session.setAttribute("BookingsLength", bd.history(username).size());
		}
		mv.setViewName("book");
		
		return mv;
	}
}
