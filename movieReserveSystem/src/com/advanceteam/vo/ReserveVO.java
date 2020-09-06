package com.advanceteam.vo;

/**
 * 
 * @author shink
 * @since 2020-08-30
 * @see
 * 	2020-09-01 예약정보 조회시 영화제목을 출력해주기 위해 movie_title을 추가하였음.
 * 	2020-09-01 SeatVO에서 가져온 외래키 seat_no를 int형 변수에서 String으로 변경함.
 */
public class ReserveVO {

	private int res_no; // ReserveVO PK
	private String mem_id; // MemberVO FK
	private String show_id; // ShowVO FK
	private String seat_no; // SeatVO FK
	private String theater_id; // TheaterVO FK
	private String sale_id; // SaleVO FK
	private String movie_title; // MovieVO FK
	private int res_price;
	private boolean isDelete;
	
	public boolean isDelete() {
		return isDelete;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

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

	public String getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(String seat_no) {
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
