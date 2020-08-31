package com.advanceteam.vo;

import java.util.Date;

/**
 * 
 * @author shink
 * @since 2020-08-30
 */
public class MemberVO {

	private String mem_id; // MemberVO PK
	private String mem_pw;
	private String mem_name;
	private String mem_hp; 
	private String mem_regno1; 
	private String mem_regno2; 
	private String mem_add;
	private String mem_add2;
	private String mem_rank;
	private Date mem_signUpDate;
	private String mem_auth;
	private int budget;
	

	private boolean isDelete;
	

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getMem_auth() {
		return mem_auth;
	}

	public void setMem_auth(String mem_auth) {
		this.mem_auth = mem_auth;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_hp() {
		return mem_hp;
	}

	public void setMem_hp(String mem_hp) {
		this.mem_hp = mem_hp;
	}

	public String getMem_regno1() {
		return mem_regno1;
	}

	public void setMem_regno1(String mem_regno1) {
		this.mem_regno1 = mem_regno1;
	}

	public String getMem_regno2() {
		return mem_regno2;
	}

	public void setMem_regno2(String mem_regno2) {
		this.mem_regno2 = mem_regno2;
	}

	public String getMem_add() {
		return mem_add;
	}

	public void setMem_add(String mem_add) {
		this.mem_add = mem_add;
	}

	public String getMem_add2() {
		return mem_add2;
	}

	public void setMem_add2(String mem_add2) {
		this.mem_add2 = mem_add2;
	}

	public String getMem_rank() {
		return mem_rank;
	}

	public void setMem_rank(String mem_rank) {
		this.mem_rank = mem_rank;
	}

	public Date getMem_signUpDate() {
		return mem_signUpDate;
	}

	public void setMem_signUpDate(Date mem_signUpDate) {
		this.mem_signUpDate = mem_signUpDate;
	}


}
