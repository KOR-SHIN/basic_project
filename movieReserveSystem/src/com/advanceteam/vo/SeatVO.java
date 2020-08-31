package com.advanceteam.vo;

public class SeatVO {

	private int seat_no; // PK
	private String theater_id; // Theater FK
	private int seat_row;
	private int seat_col;

	public int getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}

	public String getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(String theater_id) {
		this.theater_id = theater_id;
	}

	public int getSeat_row() {
		return seat_row;
	}

	public void setSeat_row(int seat_row) {
		this.seat_row = seat_row;
	}

	public int getSeat_col() {
		return seat_col;
	}

	public void setSeat_col(int seat_col) {
		this.seat_col = seat_col;
	}

}
