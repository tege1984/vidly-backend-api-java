package com.tege1984.vidly.orm.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tege1984.vidly.orm.api.model.Genre;

@Repository
@Transactional
public class GenreDao {

	@Autowired
	private SessionFactory factory;

	public long saveGenre(Genre genre) {
		getSession().save(genre);
		return genre.getId();
				
	}

	@SuppressWarnings("unchecked")
	public List<Genre> getGenres() {
		return getSession().createCriteria(Genre.class).list();
	}
	
	public Genre getGenre(long id) {
	      return getSession().get(Genre.class, id);
	}
	
	public long updateGenre(Genre genre) {
		getSession().update(genre);
		return genre.getId();
				
	}
	
	public void deleteGener(long id) {
	      Genre genre = getSession().byId(Genre.class).load(id);
	      getSession().delete(genre);
	}
	

	private Session getSession() {
		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}

}
