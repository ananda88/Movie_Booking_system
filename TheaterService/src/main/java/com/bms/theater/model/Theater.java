package com.bms.theater.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String address;
	
	private String city;
	
	@ManyToMany
	@JoinTable(name="theater_movie", joinColumns=@JoinColumn(name="theater_id"), inverseJoinColumns=@JoinColumn(name="movie_id"))
	@JsonManagedReference
	private List<Movie> movies;
	
	@OneToMany(mappedBy="theater")
	@JsonIgnore
	private List<TimeSlot> timeSlots;
	
	public Theater() {
		// TODO Auto-generated constructor stub
	}

	public Theater(Long id, String name, String address, String city, List<Movie> movies) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.movies = movies;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}
	
	

}
