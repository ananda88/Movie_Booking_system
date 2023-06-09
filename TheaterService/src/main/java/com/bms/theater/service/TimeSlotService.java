package com.bms.theater.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.bms.theater.model.TimeSlot;
import com.bms.theater.repository.TimeSlotRepository;

@Service
public class TimeSlotService {

	public final TimeSlotRepository timeSlotRepository;

	public TimeSlotService(TimeSlotRepository timeSlotRepository) {
		super();
		this.timeSlotRepository = timeSlotRepository;
	};
	
	public Collection<TimeSlot> getTimeSlotForMovieAndTheater(Long theaterId, Long movieId){
		return timeSlotRepository.findTimeSlotBytheaterIdAndMovieId(theaterId, movieId);
	}
	
}
