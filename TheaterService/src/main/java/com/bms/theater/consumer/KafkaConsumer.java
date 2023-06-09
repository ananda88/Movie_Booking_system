package com.bms.theater.consumer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bms.booking.dto.BookingRequest;
import com.bms.booking.dto.TheaterUpdateEvent;
import com.bms.theater.model.Seat;
import com.bms.theater.repository.SeatRepository;

@Service
public class KafkaConsumer {
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private KafkaTemplate<Long, Object> kafkaTemplate; 
	
	@KafkaListener(topics = "booking_theater", groupId ="theater")
	public void consumeBookingEvent(BookingRequest event) {
		try {
		List<Long> ids = event.getSeats().stream().map(s -> s.getId()).collect(Collectors.toList());
		Iterable<Seat> seats = seatRepository.findAllById(ids);
		seats.forEach(seat -> seat.setBooked(true));
		seatRepository.saveAll(seats);
		// publish event to theater_booking
		kafkaTemplate.send("theater_booking", new TheaterUpdateEvent(event.getId(), "SUCCESS"));
		}catch(Exception e) {
			kafkaTemplate.send("", new TheaterUpdateEvent(event.getId(), "FAILURE"));
		}
	}
	
	@KafkaListener(topics = "booking_theater_two", groupId ="theater")
	public void consumeSecondBookingEvent(BookingRequest event) {
		try {
		List<Long> ids = event.getSeats().stream().map(s -> s.getId()).collect(Collectors.toList());
		Iterable<Seat> seats = seatRepository.findAllById(ids);
		seats.forEach(seat -> seat.setBooked(false));
		seatRepository.saveAll(seats);
		}catch(Exception e) {
		}
	}

}
