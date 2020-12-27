package com.airlines.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity

public class Flights {

	@Id
String fid;
String fname;
public String getFid() {
	return fid;
}
public void setFid(String fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
@Override
public String toString() {
	return "Flight [fid=" + fid + ", fname=" + fname + "]";
}

}
