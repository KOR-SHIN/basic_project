package com.advanceteam.vo;

public class TheaterVO {

	private String theater_id; // TheaterVO PK
	private int theater_price;

	public int getTheater_price() {
		return theater_price;
	}

	public void setTheater_price(int theater_price) {
		this.theater_price = theater_price;
	}

	public String getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(String theater_id) {
		this.theater_id = theater_id;
	}
}
