package com.bms.theater.repository;

import org.springframework.data.repository.CrudRepository;

import com.bms.theater.model.Seat;

public interface SeatRepository extends CrudRepository<Seat, Long> {

}
