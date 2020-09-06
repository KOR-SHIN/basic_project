package com.advanceteam.vo;
/**
 * 
 * @author shink
 * @since 2020-08-30
 */
public class ReviewVO {

	private int review_no; // PK
	private static int review_sq;
	private String mem_id; // MemberVO FK
	private String movie_title; // MovieVO FK
	private int review_grade;
	private String review_text;
	private int review_like;
	private int review_hate;
	private boolean isDelete;

	public int getReview_no() {
		return review_no;
	}

	public static int getReview_sq() {
		return review_sq;
	}

	public String getMem_id() {
		return mem_id;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public int getReview_grade() {
		return review_grade;
	}

	public String getReview_text() {
		return review_text;
	}

	public int getReview_like() {
		return review_like;
	}

	public int getReview_hate() {
		return review_hate;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
		review_sq = review_no+1;
	}

	public static void setReview_sq(int review_sq) {
		ReviewVO.review_sq = review_sq;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public void setReview_grade(int review_grade) {
		this.review_grade = review_grade;
	}

	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}

	public void setReview_like(int review_like) {
		this.review_like = review_like;
	}

	public void setReview_hate(int review_hate) {
		this.review_hate = review_hate;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}


	
	

}
