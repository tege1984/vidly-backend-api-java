package com.tege1984.vidly.orm.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "movie_table")
public class Movie {
	@Id
	@GeneratedValue
	@Column(name="movie_id")
	private int id;
	@Column(name="movie_title")
	private String title;
	@Column(name="movie_numberInStock")
	private Number numberInStock;
	@Column(name="movie_rating")
	private Double rating;
	@JsonFormat(pattern = "dd/mm/yyyy")
	@Type(type="date")
	@Column(name="movie_publishedDate")
	private Date publishedDate;	
	@OneToMany(fetch = FetchType.EAGER)
    private List<Genre> genres = new ArrayList<Genre>();	
	public int getId() {
		return id;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Number getNumberInStock() {
		return numberInStock;
	}
	public void setNumberInStock(Number numberInStock) {
		this.numberInStock = numberInStock;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
		

}
