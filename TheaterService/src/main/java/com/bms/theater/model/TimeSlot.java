package com.bms.theater.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class TimeSlot {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String slot;
	
	@ManyToOne
	@JsonIgnore
	private Theater theater;
	
	@ManyToOne
	@JsonIgnore
	private Movie movie;
	
	@OneToMany(mappedBy = "slot")
	@JsonManagedReference
	private List<Seat> seats;
	
	public TimeSlot() {
		// TODO Auto-generated constructor stub
	}

	public TimeSlot(Long id, String slot) {
		super();
		this.id = id;
		this.slot = slot;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
