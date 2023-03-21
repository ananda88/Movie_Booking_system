package com.bms.payment.dto;

import java.util.List;

public class PaymentEvent {
	
	private Long bookingId;
	
	private String status;
	
	private List<Long> seatIds;
	
	public PaymentEvent() {
		// TODO Auto-generated constructor stub
	}

	public PaymentEvent(Long bookingId, String status) {
		super();
		this.bookingId = bookingId;
		this.status = status;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Long> getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(List<Long> seatIds) {
		this.seatIds = seatIds;
	}

	public PaymentEvent(Long bookingId, String status, List<Long> seatIds) {
		super();
		this.bookingId = bookingId;
		this.status = status;
		this.seatIds = seatIds;
	}
	
	

}
