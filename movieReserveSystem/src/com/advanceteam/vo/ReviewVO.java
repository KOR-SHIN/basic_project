package com.advanceteam.vo;

public class ReviewVO {

	private int review_no; // PK
	private String mem_id; // MemberVO FK
	private String movie_id; // MovieVO FK
	private int review_grade;
	private String review_text;
	private int review_like;
	private int review_hate;
	private boolean isDelete;
	

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public int getReview_grade() {
		return review_grade;
	}

	public void setReview_grade(int review_grade) {
		this.review_grade = review_grade;
	}

	public String getReview_text() {
		return review_text;
	}

	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}

	public int getReview_like() {
		return review_like;
	}

	public void setReview_like(int review_like) {
		this.review_like = review_like;
	}

	public int getReview_hate() {
		return review_hate;
	}

	public void setReview_hate(int review_hate) {
		this.review_hate = review_hate;
	}

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

}
