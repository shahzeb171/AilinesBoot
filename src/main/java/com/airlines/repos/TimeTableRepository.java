package com.airlines.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlines.pojos.Time_Table;

public interface TimeTableRepository extends JpaRepository<Time_Table, Integer> {

	List<Time_Table> findByArrivalCcodeAndDepartureCcode(String ar,String dep);
}
