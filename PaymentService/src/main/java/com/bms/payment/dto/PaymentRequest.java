package com.bms.payment.dto;

import java.util.List;

public class PaymentRequest {

	private Long bookingId;
	
	private double price;
	
	private List<Long> seatIds;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Long> getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(List<Long> seatIds) {
		this.seatIds = seatIds;
	}
	
	
	
	
}
