package com.tege1984.vidly.orm.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tege1984.vidly.orm.api.model.Genre;
import com.tege1984.vidly.orm.api.model.Movie;

@Repository
@Transactional
public class MovieDao {

	@Autowired
	private SessionFactory factory;

	public void saveMovie(Movie movie) {
		getSession().save(movie);
		
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMovies() {
		return getSession().createCriteria(Movie.class).list();
	}
	

	private Session getSession() {
		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}

}
