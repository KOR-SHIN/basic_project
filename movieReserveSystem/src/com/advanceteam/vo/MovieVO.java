package com.advanceteam.vo;

import java.util.Date;

public class MovieVO {

	private String movie_id; // MovieVO PK
	private String movie_director;
	private String movie_actor;
	private Date movie_open;
	private Date movie_close;
	private String movie_title;
	private int movie_ageGrade;
	private String movie_genre;
	private int movie_runTime; //분 단위로 입력 (if 1시간 30분 -> 150)
	private int movie_price;

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_director() {
		return movie_director;
	}

	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}

	public String getMovie_actor() {
		return movie_actor;
	}

	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}

	public Date getMovie_open() {
		return movie_open;
	}

	public void setMovie_open(Date movie_open) {
		this.movie_open = movie_open;
	}

	public Date getMovie_close() {
		return movie_close;
	}

	public void setMovie_close(Date movie_close) {
		this.movie_close = movie_close;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public int getMovie_ageGrade() {
		return movie_ageGrade;
	}

	public void setMovie_ageGrade(int movie_ageGrade) {
		this.movie_ageGrade = movie_ageGrade;
	}

	public String getMovie_genre() {
		return movie_genre;
	}

	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}

	public int getMovie_runTime() {
		return movie_runTime;
	}

	public void setMovie_runTime(int movie_runTime) {
		this.movie_runTime = movie_runTime;
	}

	public int getMovie_price() {
		return movie_price;
	}

	public void setMovie_price(int movie_price) {
		this.movie_price = movie_price;
	}

}
