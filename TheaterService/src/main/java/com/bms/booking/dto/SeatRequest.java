package com.bms.booking.dto;

public class SeatRequest {
	
	private Long id;
	
	private String seatNumber;
	
	private String category;
	
	private double price;
	
	private boolean booked;
	
	public SeatRequest() {
		// TODO Auto-generated constructor stub
	}

	public SeatRequest(Long id, String seatNumber, String category, double price, boolean booked) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.category = category;
		this.price = price;
		this.booked = booked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

}
