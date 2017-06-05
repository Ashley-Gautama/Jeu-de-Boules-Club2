package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Clinic {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String datum;
	
	private String trainer;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Team> deelnemers;
	
	public Clinic() {
		this(null, null);
	}
	
	public Clinic(String datum, String trainer) {
		super();
		this.id = 0;
		this.datum = datum;
		this.trainer = trainer;
		this.deelnemers = new ArrayList<Team>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Team> getDeelnemers() {
		return deelnemers;
	}

	public void setDeelnemers(List<Team> deelnemers) {
		this.deelnemers = deelnemers;
	}
}
