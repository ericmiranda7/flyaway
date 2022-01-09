package com.flyAway.data;

import java.io.Serializable;

public class RegistrationDetails implements Serializable {
	private String fullName;
	private String address;
	private int age;
	private String mobile;
	private String username;
	private int idType;
	private String country;

	public String getFullName() {
		return fullName;
	}

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public String getMobile() {
		return mobile;
	}

	public String getUsername() {
		return username;
	}

	public int getIdType() {
		return idType;
	}

	public String getCountry() {
		return country;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
