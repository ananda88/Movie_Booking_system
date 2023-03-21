package com.bms.theater.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.bms.theater.model.Theater;
import com.bms.theater.repository.TheaterRepository;

@Service
public class TheaterService {

	private final TheaterRepository theaterRepository;

	public TheaterService(TheaterRepository theaterRepository) {
		super();
		this.theaterRepository = theaterRepository;
	}

	public Collection<Theater> getAllTheaterByCity(String city){
		return theaterRepository.findTheaterByCity(city);
	}
	
	
	
}
