package com.bms.theater.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.bms.theater.model.TimeSlot;

public interface TimeSlotRepository extends CrudRepository<TimeSlot, Long> {
	
	Collection<TimeSlot> findTimeSlotBytheaterIdAndMovieId(Long theaterId, Long movieId);

}
