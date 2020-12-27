package com.airlines.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airlines.pojos.Flights;
import com.airlines.repos.FlightsRepository;

@Component
public class FlightsDao {

	@Autowired
	FlightsRepository frepo;
	public Set<String> flights(){
		List<Flights> allFlights = frepo.findAll();
		 
		Set<String> set = new HashSet<String>();
         for(Flights f : allFlights) {
        	 String s = f.getFname()+"("+f.getFid()+")";
        	 set.add(s);
         }
         return set;
	}
	public boolean added(Flights f) {
		
		frepo.save(f);
		
		System.out.println("Flight added successfully "+f);
		
		return true;
	}
}
