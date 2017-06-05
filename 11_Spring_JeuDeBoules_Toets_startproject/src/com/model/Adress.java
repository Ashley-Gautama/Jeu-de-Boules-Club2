package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Adress {
	
	@Id
	@GeneratedValue
	private long id;
	private String street;
	private String city;
	private String zipcode;
	@ManyToOne
	private Member member;
	
	public Adress() {
		super();
	}

	public Adress( String street, String city, String zipcode, Member member) {
		super();
		this.id = 0;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.member = member;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
	

}
