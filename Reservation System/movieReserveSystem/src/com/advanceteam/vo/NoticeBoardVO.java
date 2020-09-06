package com.advanceteam.vo;

import java.util.Date;

/**
 * 
 * @author shink
 * @since 2020-08-30
 */
public class NoticeBoardVO {

	private int board_no; // NoticeBoard PK
	private static int board_sq;
	private String mem_id; // MemverVO FK
	private String board_title;
	private String board_text;
	private int board_views; // 조회수
	private Date board_postDate;
	private boolean isDelete;
	

	public int getBoard_no() {
		return board_no;
	}

	public static int getBoard_sq() {
		return board_sq;
	}

	public String getMem_id() {
		return mem_id;
	}

	public String getBoard_title() {
		return board_title;
	}

	public String getBoard_text() {
		return board_text;
	}

	public int getBoard_views() {
		return board_views;
	}

	public Date getBoard_postDate() {
		return board_postDate;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
		board_sq = board_no+1;
	}

	public static void setBoard_sq(int board_sq) {
		NoticeBoardVO.board_sq = board_sq;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public void setBoard_text(String board_text) {
		this.board_text = board_text;
	}

	public void setBoard_views(int board_views) {
		this.board_views = board_views;
	}

	public void setBoard_postDate(Date board_postDate) {
		this.board_postDate = board_postDate;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	
}
