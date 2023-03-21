package com.bms.theater.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.bms.theater.model.Theater;

public interface TheaterRepository extends CrudRepository<Theater, Long> {

	Collection<Theater> findTheaterByCity(String city);
	
}
