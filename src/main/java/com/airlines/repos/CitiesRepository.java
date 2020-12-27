package com.airlines.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlines.pojos.Cities;

public interface CitiesRepository extends JpaRepository<Cities, String> {

}
