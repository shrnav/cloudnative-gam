package com.precisely.gam.gamclient;

import java.util.Objects;

public class Address {

	private String country;
	private String input;
	private String city;
	private String sp;
	private String postCode;

	public Address(String country, String input, String city, String sp, String postCode) {
		super();
		this.country = country;
		this.input = input;
		this.city = city;
		this.sp = sp;
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, input, postCode, sp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(input, other.input) && Objects.equals(postCode, other.postCode)
				&& Objects.equals(sp, other.sp);
	}

}
