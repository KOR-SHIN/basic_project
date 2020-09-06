package com.advanceteam.vo;

/**
 * 
 * @author shink
 * @since 2020-08-30
 * @see 2020-09-01 예약정보 조회시 영화제목을 출력해주기 위해 movie_title을 추가하였음. 2020-09-01
 *      SeatVO에서 가져온 외래키 seat_no를 int형 변수에서 String으로 변경함.
 */
public class ReserveVO {

	private int res_no;
	private static int res_sq;
	private String mem_id; // MemberVO FK
	private int show_no; // ShowVO FK
	private String seat_no; // SeatVO FK 
	private int theater_no; // TheaterVO FK
	private String sale_id; // SaleVO FK
	private String movie_title; // MovieVO FK
	private int res_price;
	private boolean isDelete;

	public int getRes_no() {
		return res_no;
	}

	public static int getRes_sq() {
		return res_sq;
	}

	public String getMem_id() {
		return mem_id;
	}

	public int getShow_no() {
		return show_no;
	}

	public String getSeat_no() {
		return seat_no;
	}

	public int getTheater_no() {
		return theater_no;
	}

	public String getSale_id() {
		return sale_id;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public int getRes_price() {
		return res_price;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setRes_no(int res_no) {
		this.res_no = res_no;
		res_sq = res_no+1;
	}

	public static void setRes_sq(int res_sq) {
		ReserveVO.res_sq = res_sq;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public void setShow_no(int show_no) {
		this.show_no = show_no;
	}

	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}

	public void setTheater_no(int theater_no) {
		this.theater_no = theater_no;
	}

	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public void setRes_price(int res_price) {
		this.res_price = res_price;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	

	
}
