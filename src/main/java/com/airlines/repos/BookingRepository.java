package com.airlines.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlines.pojos.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Integer> {

	List<Bookings> findAllByUsernameOrderByBsno(String username);
	
	Integer removeByBsnoAndUsername(int bsno,String username);
	
	Bookings findByUsernameAndBsno(String username,int bsno);
	
}
