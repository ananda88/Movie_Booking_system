package com.bms.booking.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.booking.dto.BookingRequest;
import com.bms.booking.dto.BookingResponse;
import com.bms.booking.service.BookingService;

@RestController
@RequestMapping("bookings")
public class BookingController {
	
	private final BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public BookingResponse createBooking(@RequestBody BookingRequest bookingRequest) {
		return bookingService.createBooking(bookingRequest);
		
	}
	
	@GetMapping("/{bookingId}")
	@CrossOrigin(origins = "*")
	public BookingResponse getBookingDetails(@PathVariable Long bookingId) {
		return bookingService.getBookingById(bookingId);
	}
}
