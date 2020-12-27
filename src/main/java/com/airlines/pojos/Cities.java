package com.airlines.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cities {
	@Id
	String ccode;
	String cname;
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Cities [ccode=" + ccode + ", cname=" + cname + "]";
	}
	
}
