package com.advanceteam.vo;
/**
 * 
 * @author shink
 * @since 2020-08-30
 */
public class TheaterVO {

	private int theater_no; // TheaterVO PK
	private static int theater_sq;
	private String theater_name;
	private int theater_price;
	private boolean isDelete;

	public int getTheater_no() {
		return theater_no;
	}

	public static int getTheater_sq() {
		return theater_sq;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public int getTheater_price() {
		return theater_price;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setTheater_no(int theater_no) {
		this.theater_no = theater_no;
		theater_sq = theater_no + 1;
	}

	public static void setTheater_sq(int theater_sq) {
		TheaterVO.theater_sq = theater_sq;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

	public void setTheater_price(int theater_price) {
		this.theater_price = theater_price;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}


}
