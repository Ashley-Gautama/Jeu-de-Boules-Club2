/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstName = null;
	private String lastName = null;

	@ManyToOne
	private Team team;
	@OneToMany(mappedBy="member")
	private List<Adress> adress;

	public Member() {
		this(null, null, null);
	}

	public Member(String firstName, String lastName, Team team) {
		super();
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.team = team;
		this.adress=new ArrayList<Adress>();
	}
	
	public String getFullName(){
		return this.firstName+" "+this.lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Team getTeam() {
		return team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
