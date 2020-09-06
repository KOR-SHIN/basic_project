package com.advanceteam.vo;

/**
 * 
 * @author shink
 * @since 2020-08-30
 * @see 2020-09-01 seat_no의 타입을 int에서 String으로 변경함 2020-09-01 seat_row를 영화관처럼
 *      알파벳으로 구분하기 위해 String으로 변경함 (A열, B열 ..) 2020-09-01 임시적으로 사용중인 좌석을 구분하기 위해
 *      seat_use를 추가함 (추후 예약가능좌석을 불러오는 메서드를 수정하면서 삭제할 예정, 테스트를 위해 임시추가한 것)
 */
public class SeatVO {

	private String seat_no; // PK
	private int show_no; // ShowVO FK
	private int seat_row;
	private int seat_col;
	private boolean seat_use;
	
	public boolean isSeat_use() {
		return seat_use;
	}

	public void setSeat_use(boolean seat_use) {
		this.seat_use = seat_use;
	}

	public String getSeat_no() {
		return seat_no;
	}

	public int getShow_no() {
		return show_no;
	}

	public int getSeat_row() {
		return seat_row;
	}

	public int getSeat_col() {
		return seat_col;
	}

	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}

	public void setShow_no(int show_no) {
		this.show_no = show_no;
	}

	public void setSeat_row(int seat_row) {
		this.seat_row = seat_row;
	}

	public void setSeat_col(int seat_col) {
		this.seat_col = seat_col;
	}

}
