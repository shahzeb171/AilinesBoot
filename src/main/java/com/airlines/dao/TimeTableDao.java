package com.airlines.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airlines.pojos.Time_Table;
import com.airlines.repos.TimeTableRepository;

@Component
public class TimeTableDao {

	@Autowired
	TimeTableRepository ttrepo;
	
	
	public List<Time_Table> TimeTableFetcher(String arrival_ccode,String departure_ccode){
		
		System.out.println("FETCHING");
		
		List<Time_Table> list = ttrepo.findByArrivalCcodeAndDepartureCcode(arrival_ccode, departure_ccode);
		
		System.out.println("FETCHED "+list);
		
		return list;
	}
	
	
	public  Time_Table checkTimeTable(int sno) {
		
		Time_Table tt = ttrepo.findById(sno).orElse(new Time_Table());
		
		return tt ;
	}
	
	public boolean added(Time_Table tt) {
		
		ttrepo.save(tt);
		System.out.println("Time Table added "+tt);
		
		return true;
	}
}
