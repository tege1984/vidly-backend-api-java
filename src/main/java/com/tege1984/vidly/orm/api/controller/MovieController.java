package com.tege1984.vidly.orm.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tege1984.vidly.orm.api.dao.MovieDao;
import com.tege1984.vidly.orm.api.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieDao dao;

	@PostMapping("/saveMovie")
	public String save(@RequestBody Movie movie) {
		dao.saveMovie(movie);
		return "success";
	}

	@GetMapping("/getAll")
	public List<Movie> getAllGenres() {
		return dao.getMovies();
	}

}
