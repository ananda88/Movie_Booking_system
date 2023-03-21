package com.bms.booking.dto;

public class BookingResponse {
	
	private Long id;
	
	private String status;
	
	public BookingResponse() {
		// TODO Auto-generated constructor stub
	}

	public BookingResponse(Long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
