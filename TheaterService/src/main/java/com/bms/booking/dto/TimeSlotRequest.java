package com.bms.booking.dto;

public class TimeSlotRequest {
	
	private Long id;
	
	private String slot;
	
	public TimeSlotRequest() {
		// TODO Auto-generated constructor stub
	}

	public TimeSlotRequest(Long id, String slot) {
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

	
}
