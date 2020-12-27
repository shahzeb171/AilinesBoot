package com.airlines.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
@Id
private String username;
private String password,name,role;

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Users [username=" + username + ", password=" + password + ", name=" + name + ", role=" + role + "]";
}

}
