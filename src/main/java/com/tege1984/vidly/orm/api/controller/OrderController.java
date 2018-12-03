package com.tege1984.vidly.orm.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tege1984.vidly.orm.api.dao.GenreDao;
import com.tege1984.vidly.orm.api.dao.OrderDao;
import com.tege1984.vidly.orm.api.model.Genre;
import com.tege1984.vidly.orm.api.model.Order;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderDao dao;

	@PostMapping("/saveOrder")
	public String save(@RequestBody Order order) {
		dao.saveOrder(order);
		return "success";
	}

	@GetMapping("/getAll")
	public List<Order> getAllGenres() {
		return dao.getOrders();
	}

}
