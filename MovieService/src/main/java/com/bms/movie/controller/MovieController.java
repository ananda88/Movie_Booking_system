package com.bms.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.movie.model.Movie;
import com.bms.movie.repository.MovieRepository;

@RestController
@RequestMapping("movies")
public class MovieController {
	
	private final MovieRepository movieRepository;
	
	

	public MovieController(com.bms.movie.repository.MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}



	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable("id") Long id) {
		return movieRepository.findById(id).get();
	}
	
}
