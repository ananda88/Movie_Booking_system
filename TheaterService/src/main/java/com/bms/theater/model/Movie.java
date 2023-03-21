package com.bms.theater.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movie {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String genere;
	
	@ManyToMany(mappedBy="movies", fetch= FetchType.LAZY)
	@JsonBackReference
	private List<Theater> theaters;
	
	@OneToMany(mappedBy="movie")
	@JsonIgnore
	private List<TimeSlot> slots;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(Long id, String name, String genere, List<Theater> theaters) {
		super();
		this.id = id;
		this.name = name;
		this.genere = genere;
		this.theaters = theaters;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public List<Theater> getTheaters() {
		return theaters;
	}

	public void setTheaters(List<Theater> theaters) {
		this.theaters = theaters;
	}

	public List<TimeSlot> getSlots() {
		return slots;
	}

	public void setSlots(List<TimeSlot> slots) {
		this.slots = slots;
	}
	
	
}
