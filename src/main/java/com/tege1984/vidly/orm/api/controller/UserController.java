package com.tege1984.vidly.orm.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tege1984.vidly.orm.api.dao.GenreDao;
import com.tege1984.vidly.orm.api.dao.UserDao;
import com.tege1984.vidly.orm.api.model.Genre;
import com.tege1984.vidly.orm.api.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao dao;

	@PostMapping("/saveUser")
	public String save(@RequestBody User user) {
		dao.saveUser(user);
		return "success";
	}

	@GetMapping("/getAll")
	public List<User> getAllGenres() {
		return dao.getUsers();
	}

}
