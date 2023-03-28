package com.bms.payment.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {
	
	@Id
	private String paymentSecret;
	
	private Long bookingId;
	
	private double price;
	
	@ElementCollection()
	private List<Long> seatIds;

	public String getPaymentSecret() {
		return paymentSecret;
	}
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	public Payment(String paymentSecret, Long bookingId, double price, List<Long> seatIds) {
		super();
		this.paymentSecret = paymentSecret;
		this.bookingId = bookingId;
		this.price = price;
		this.seatIds = seatIds;
	}

	public void setPaymentSecret(String paymentSecret) {
		this.paymentSecret = paymentSecret;
	}

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
