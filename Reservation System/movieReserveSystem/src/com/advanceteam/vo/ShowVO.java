package com.advanceteam.vo;

import java.util.Date;
/**
 * 
 * @author shink
 * @since 2020-08-30
 */
public class ShowVO {

	private int show_no;
	private static int show_sq;
	private String movie_title; // MovieVO FK
	private int theater_no; // TheaterVO FK
	private Date show_date;
	private String theater_name;
	private boolean isDelete;
	private String seat_no;

	public int getShow_no() {
		return show_no;
	}


	public static int getShow_sq() {
		return show_sq;
	}


	public String getMovie_title() {
		return movie_title;
	}


	public int getTheater_no() {
		return theater_no;
	}


	public Date getShow_date() {
		return show_date;
	}


	public String getTheater_name() {
		return theater_name;
	}


	public boolean isDelete() {
		return isDelete;
	}


	public String getSeat_no() {
		return seat_no;
	}


	public void setShow_no(int show_no) {
		this.show_no = show_no;
		show_sq = show_no+1;
	}


	public static void setShow_sq(int show_sq) {
		ShowVO.show_sq = show_sq;
	}


	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}


	public void setTheater_no(int theater_no) {
		this.theater_no = theater_no;
	}


	public void setShow_date(Date show_date) {
		this.show_date = show_date;
	}


	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}


	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}


	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}



}
