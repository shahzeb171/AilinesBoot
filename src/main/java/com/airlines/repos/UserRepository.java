package com.airlines.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlines.pojos.Users;

public interface UserRepository extends JpaRepository<Users, String> {
Users findByUsername(String username);
}
