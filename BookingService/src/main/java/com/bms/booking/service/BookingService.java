package com.bms.booking.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bms.booking.dto.BookingRequest;
import com.bms.booking.dto.BookingResponse;
import com.bms.booking.model.Booking;
import com.bms.booking.repository.BookingRepository;

@Service
public class BookingService {

	
	private final BookingRepository bookingRepository;
	
	private final KafkaTemplate<Long, Object> kafkaTemplate;

	public BookingService(BookingRepository bookingRepository, KafkaTemplate<Long, Object> kafkaTemplate) {
		super();
		this.bookingRepository = bookingRepository;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public BookingResponse createBooking(BookingRequest bookingRequest) {
		Booking bookingResponse = bookingRepository.save(new Booking("BOOKING_INITIATED", bookingRequest.getSlot().getId()));
		// publish event to booking_theater topic
		bookingRequest.setId(bookingResponse.getId());
		kafkaTemplate.send("booking_theater", bookingRequest);
		return new BookingResponse(bookingResponse.getId(), bookingResponse.getStatus());
	}
	
	public BookingResponse getBookingById(Long id) {
		Booking bookingResponse = bookingRepository.findById(id).orElseThrow(RuntimeException::new);
		return new BookingResponse(bookingResponse.getId(), bookingResponse.getStatus());
	}
}
