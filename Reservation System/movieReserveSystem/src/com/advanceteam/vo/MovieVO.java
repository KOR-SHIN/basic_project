package com.advanceteam.vo;

import java.util.Date;
/**
 * 
 * @author shink
 * @since 2020-08-30
 */
public class MovieVO {

	private int movie_no;
	private static int movie_sq;
	private String movie_director;
	private String movie_actor;
	private Date movie_open;
	private String movie_title;
	private int movie_ageGrade;
	private String movie_genre;
	private int movie_runTime; //분 단위로 입력 (if 1시간 30분 -> 150)
	private int movie_price;
	private boolean isDelete;


	public int getMovie_no() {
		return movie_no;
	}


	public static int getMovie_sq() {
		return movie_sq;
	}


	public String getMovie_director() {
		return movie_director;
	}


	public String getMovie_actor() {
		return movie_actor;
	}


	public Date getMovie_open() {
		return movie_open;
	}


	public String getMovie_title() {
		return movie_title;
	}


	public int getMovie_ageGrade() {
		return movie_ageGrade;
	}


	public String getMovie_genre() {
		return movie_genre;
	}


	public int getMovie_runTime() {
		return movie_runTime;
	}


	public int getMovie_price() {
		return movie_price;
	}


	public boolean isDelete() {
		return isDelete;
	}


	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
		movie_sq = movie_no+1;
	}


	public static void setMovie_sq(int movie_sq) {
		MovieVO.movie_sq = movie_sq;
	}


	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}


	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}


	public void setMovie_open(Date movie_open) {
		this.movie_open = movie_open;
	}


	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}


	public void setMovie_ageGrade(int movie_ageGrade) {
		this.movie_ageGrade = movie_ageGrade;
	}


	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}


	public void setMovie_runTime(int movie_runTime) {
		this.movie_runTime = movie_runTime;
	}


	public void setMovie_price(int movie_price) {
		this.movie_price = movie_price;
	}


	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	
	
	
}
