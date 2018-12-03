package com.tege1984.vidly.orm.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "order_table")
public class Order {
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int id;
	@JsonFormat(pattern = "dd/mm/yyyy")
	@Type(type="date")
	@Column(name="order_orderDate")
	private Date orderDate;
	@IndexColumn(name="INDEX_COL")
	@OneToMany(fetch = FetchType.EAGER)
	private List<Movie> movies = new ArrayList<Movie>(); 
	@IndexColumn(name="INDEX_COL")
	@OneToOne(fetch = FetchType.EAGER)
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	


}
