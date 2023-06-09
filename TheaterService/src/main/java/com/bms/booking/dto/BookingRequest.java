package com.bms.booking.dto;

import java.util.List;



public class BookingRequest {
	
    private Long id;
	
	private TheaterRequest theater;
	
	private MovieRequest movie;
	
	private TimeSlotRequest slot;
	
	private List<SeatRequest> seats;
	
	public BookingRequest() {
		// TODO Auto-generated constructor stub
	}

	public BookingRequest(TheaterRequest theater, MovieRequest movie, TimeSlotRequest slot,
			List<SeatRequest> seats) {
		super();
		this.theater = theater;
		this.movie = movie;
		this.slot = slot;
		this.seats = seats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TheaterRequest getTheater() {
		return theater;
	}

	public void setTheater(TheaterRequest theater) {
		this.theater = theater;
	}

	public MovieRequest getMovie() {
		return movie;
	}

	public void setMovie(MovieRequest movie) {
		this.movie = movie;
	}

	public TimeSlotRequest getSlot() {
		return slot;
	}

	public void setSlot(TimeSlotRequest slot) {
		this.slot = slot;
	}

	public List<SeatRequest> getSeats() {
		return seats;
	}

	public void setSeats(List<SeatRequest> seats) {
		this.seats = seats;
	}
	
}
