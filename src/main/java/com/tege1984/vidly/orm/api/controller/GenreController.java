package com.tege1984.vidly.orm.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tege1984.vidly.orm.api.dao.GenreDao;
import com.tege1984.vidly.orm.api.model.Genre;

@RestController
//@RequestMapping("/genre")
public class GenreController {

	@Autowired
	private GenreDao dao;


	@GetMapping("/genres")
	public List<Genre> getAllGenres() {
		return dao.getGenres();
	}
	
	@GetMapping("/genres/{id}")
	public String getGener(@PathVariable("id") Long id) {

		Genre gener = dao.getGenre(id);
		if (gener == null) {
			return  HttpStatus.NOT_FOUND.getReasonPhrase();
		}

		return  HttpStatus.OK.getReasonPhrase();
	}
	
	@PostMapping(value = "/genres")
	public String save(@RequestBody Genre genre) {
		dao.saveGenre(genre);
		return HttpStatus.OK.getReasonPhrase();
	}
	
	@PutMapping("/geners/{id}")
	public String updateGener(@PathVariable Long id, @RequestBody Genre genre) {

		dao.updateGenre(genre);

		return HttpStatus.OK.getReasonPhrase();
	}
	@DeleteMapping("/geners/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		dao.deleteGener(id);
		return HttpStatus.OK.getReasonPhrase();

	}


}
