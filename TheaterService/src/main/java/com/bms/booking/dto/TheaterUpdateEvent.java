package com.bms.booking.dto;

public class TheaterUpdateEvent {

	private Long bookingId;
	
	private String updateStatus;
	
	public TheaterUpdateEvent() {
		// TODO Auto-generated constructor stub
	}

	public TheaterUpdateEvent(Long bookingId, String updateStatus) {
		super();
		this.bookingId = bookingId;
		this.updateStatus = updateStatus;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(String updateStatus) {
		this.updateStatus = updateStatus;
	}
	
}
