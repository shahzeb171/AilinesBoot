package com.airlines.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlines.pojos.Flights;

public interface FlightsRepository extends JpaRepository<Flights, String> {

}
