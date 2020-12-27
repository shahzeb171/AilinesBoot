package com.airlines.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airlines.pojos.Cities;
import com.airlines.repos.CitiesRepository;


@Component
public class CitiesDao{

	@Autowired
	CitiesRepository crepo;
	public Set<String> cities(){
		
		List<Cities> list = crepo.findAll();
		
		Set<String> set = new HashSet<String>();
		for(Cities c : list){
			String s = c.getCname()+"("+c.getCcode()+")";
			set.add(s);
		}
		System.out.println("from city set "+set);
		return set;
	}
	public boolean addCity(Cities city) {
		
		crepo.save(city);
		System.out.println("City added Successfully "+city);
		
		return true;
	}
}
