package com.tege1984.vidly.orm.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tege1984.vidly.orm.api.model.Genre;
import com.tege1984.vidly.orm.api.model.Order;

@Repository
@Transactional
public class OrderDao {

	@Autowired
	private SessionFactory factory;

	public void saveOrder(Order order) {
		getSession().save(order);
		
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrders() {
		return getSession().createCriteria(Order.class).list();
	}
	

	private Session getSession() {
		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}

}
