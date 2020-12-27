package com.airlines.controllers;

import java.sql.SQLException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.airlines.pojos.Bookings;
import com.airlines.pojos.Cities;
import com.airlines.pojos.Flights;
import com.airlines.pojos.Time_Table;
import com.airlines.pojos.Users;
import com.airlines.dao.BookingsDao;
import com.airlines.dao.CitiesDao;
import com.airlines.dao.FlightsDao;
import com.airlines.dao.TimeTableDao;
import com.airlines.dao.UsersDao;

@Controller
public class AddController {

	@Autowired
	CitiesDao cd;
	@Autowired
	FlightsDao fd;	
	@Autowired
	BookingsDao bd; 
	@Autowired
	TimeTableDao ttd;
	@Autowired
	UsersDao udao;
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView getAdd() throws ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView();
		
		Set<String> set = cd.cities();
		Set<String> setF = fd.flights();
		Set<Bookings> setB = bd.historyOfAll();
		
		mv.addObject("Set", set);
		mv.addObject("BookingsLength", setB.size());
		mv.addObject("SetFlight", setF);
		mv.addObject("SetBooking", setB);
		
		mv.setViewName("add");
		
		return mv;
	}
	
	@RequestMapping(value="/addCity",method=RequestMethod.POST)
	public ModelAndView postAddCity(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView(new RedirectView("add"));
		
		HttpSession session = request.getSession();
		
		String code = request.getParameter("code");
		String name = request.getParameter("city");
		
		Cities city = new Cities();
		
		city.setCcode(code);
		city.setCname(name);
		
		System.out.println("City "+city);
		
		if( cd.addCity(city) ) {
			session.setAttribute("cityAdded", true);
		}
		else{
			session.setAttribute("cityAdded", false);
		}
		
		return mv;		
	}
	
	@RequestMapping(value="/addFlights",method=RequestMethod.POST)
	public ModelAndView postAddFlight(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView(new RedirectView("add"));
		
		String code = request.getParameter("code");
		String name = request.getParameter("name");
	
		Flights f = new Flights();
		
		f.setFid(code);
		f.setFname(name);
		
		
		if( fd.added(f) ){
			request.getSession().setAttribute("flightAdded", true);
		}
		else{
			request.getSession().setAttribute("flightAdded", false);
		}
		
		return mv;
	}
	
	@RequestMapping(value="/addTimeTable",method=RequestMethod.POST)
	public ModelAndView postAddTimeTable(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView(new RedirectView("add"));
		
		HttpSession session = request.getSession();
		
		String fid = request.getParameter("flights");
		String departure_city = request.getParameter("fromCity");
		String arrival_city = request.getParameter("toCity");
		String departure_time = request.getParameter("departureTime");
		String arrival_time = request.getParameter("arrivalTime");

		int price = Integer.parseInt(request.getParameter("price"));
	
		fid = fid.substring(fid.indexOf("(")+1,fid.length()-1);
		departure_city = departure_city.substring(departure_city.indexOf("(")+1,departure_city.length()-1);
		arrival_city = arrival_city.substring(arrival_city.indexOf("(")+1,arrival_city.length()-1);
	
		Time_Table tt = new Time_Table();
		
		tt.setArrivalCcode(arrival_city);;
		tt.setArrival_time(arrival_time);
		tt.setDepartureCcode(departure_city);
		tt.setDeparture_time(departure_time);
		tt.setFid(fid);
		tt.setPrice(price);
		
		if(ttd.added(tt)){
			session.setAttribute("timeTableAdded", true);
		}
		else{
			session.setAttribute("timeTableAdded", false);
		}

		
		
		return mv;
		
	}
	@RequestMapping(value="/addAdmin" ,method=RequestMethod.POST)
	public ModelAndView postSignup(@RequestParam String name
			,@RequestParam String username, 
			@RequestParam String password,
			HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView(new RedirectView("add"));
		
		
		Users user = new Users();
		
		user.setName(name);
		user.setUsername(username);
		new BCrypt();
		user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(12)));
		user.setRole("ADMIN");
		
		boolean get = udao.add(user);
		
		HttpSession session = request.getSession();
		
		
		if( !get )
			session.setAttribute("failedAdding", true);
		
		else
			session.setAttribute("addedAdmin", true);
		
		return mv;
	}
}
