package com.airlines.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airlines.pojos.Bookings;
import com.airlines.repos.BookingRepository;

@Component
@Transactional
public class BookingsDao {

	@Autowired
	BookingRepository brepo;
	
	public boolean booked(Bookings b) {
		
		brepo.save(b);
		
		System.out.println("Booked successfully "+b);
		
		return true;
	}
	public Set<Bookings> history(String username){
		
		List<Bookings> list = brepo.findAllByUsernameOrderByBsno(username);
		
		Set<Bookings> set = new HashSet<Bookings>(list);
		
		return set;
	}
	
	public Set<Bookings> historyOfAll(){
		
		List<Bookings> list = brepo.findAll();
		
		Set<Bookings> set = new HashSet<Bookings>(list);
		
		return set;
		
	}
	
	public boolean checkBookings(String username,int bsno) {
		
		Bookings b = brepo.findByUsernameAndBsno(username, bsno);
		
		return (b != null) ? true : false;
	}
	public boolean cancelled(int bsno , String username) {
		
		brepo.removeByBsnoAndUsername(bsno, username);
		
		return true;
	}
}
