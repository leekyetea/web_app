package org.study.model;

import java.util.Date;

public class Application {

	String userId;
	String major;
	Date dob;
	String email;
	Country country;
	
	public Application(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Application [userId=" + userId + ", major=" + major + ", dob=" + dob + ", email=" + email + ", country="
				+ country + "]";
	}

}
