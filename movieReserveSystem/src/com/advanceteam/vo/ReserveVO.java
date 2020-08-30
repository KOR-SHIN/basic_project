package com.advanceteam.vo;

public class ReserveVO {

	private int res_no; // ReserveVO PK
	private String mem_id; // MemberVO FK
	private String show_id; // ShowVO FK
	private int seat_no; // SeatVO FK
	private String theater_id; // TheaterVO FK
	private String sale_id; // SaleVO FK
	private int res_price;

	public int getRes_no() {
		return res_no;
	}

	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getShow_id() {
		return show_id;
	}

	public void setShow_id(String show_id) {
		this.show_id = show_id;
	}

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

	public String getSale_id() {
		return sale_id;
	}

	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}

	public int getRes_price() {
		return res_price;
	}

	public void setRes_price(int res_price) {
		this.res_price = res_price;
	}

}
