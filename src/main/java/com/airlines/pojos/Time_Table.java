package com.airlines.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Time_Table {
@Id
int sno;
String fid;
@Column(name="departure_ccode")
String departureCcode;
@Column(name="arrival_ccode")
String arrivalCcode;
int price;
String arrival_time;
String departure_time;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getFid() {
	return fid;
}
public void setFid(String fid) {
	this.fid = fid;
}

public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getArrival_time() {
	return arrival_time;
}
public void setArrival_time(String arrival_time) {
	this.arrival_time = arrival_time;
}
public String getDeparture_time() {
	return departure_time;
}
public void setDeparture_time(String departure_time) {
	this.departure_time = departure_time;
}
public String getDepartureCcode() {
	return departureCcode;
}
public void setDepartureCcode(String departureCcode) {
	this.departureCcode = departureCcode;
}
public String getArrivalCcode() {
	return arrivalCcode;
}
public void setArrivalCcode(String arrivalCcode) {
	this.arrivalCcode = arrivalCcode;
}
@Override
public String toString() {
	return "Time_Table [sno=" + sno + ", fid=" + fid + ", departureCcode=" + departureCcode + ", arrivalCcode="
			+ arrivalCcode + ", price=" + price + ", arrival_time=" + arrival_time + ", departure_time="
			+ departure_time + "]";
}

}
