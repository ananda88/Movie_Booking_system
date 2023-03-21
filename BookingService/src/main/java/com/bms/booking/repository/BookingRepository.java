package com.bms.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.bms.booking.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {

}
