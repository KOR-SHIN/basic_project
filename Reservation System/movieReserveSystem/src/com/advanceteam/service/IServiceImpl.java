package com.advanceteam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.advanceteam.database.Database;
import com.advanceteam.vo.MemberVO;
import com.advanceteam.vo.MovieVO;
import com.advanceteam.vo.NoticeBoardVO;
import com.advanceteam.vo.ReserveVO;
import com.advanceteam.vo.ReviewVO;
import com.advanceteam.vo.SeatVO;
import com.advanceteam.vo.ShowVO;

public class IServiceImpl implements IService {

	Database db = new Database();
	
	public boolean addMember(MemberVO member) {
		// TODO Auto-generated method stub
		boolean ret = db.addMember(member);
		return ret;
	}

	public List<MemberVO> readMember() {
		// TODO Auto-generated method stub
		return db.readMember();
	}

	public List<ShowVO> readShow() {
		// TODO Auto-generated method stub
		return db.readShow();
	}

	public List<SeatVO> readSeat(int show_no) {
		// TODO Auto-generated method stub
		return db.readSeat(show_no);
	}

	public boolean addRes(ReserveVO newRes) {
		// TODO Auto-generated method stub
		return db.addRes(newRes);
	}

	public boolean readMemRes(String mem_id) {
		// TODO Auto-generated method stub
		return db.readMemRes(mem_id);
	}

	public List<ReserveVO> loadMemRes(String mem_id) {
		// TODO Auto-generated method stub
		return db.loadMemRes(mem_id);
	}

	public List<MovieVO> readMovie() {
		// TODO Auto-generated method stub
		return db.readMovie();
	}

	public List<ReviewVO> readReview() {
		// TODO Auto-generated method stub
		return db.readReview();
	}

	public boolean addReview(ReviewVO review) {
		// TODO Auto-generated method stub
		return db.addReview(review);
	}

	public boolean deleteReview(ReviewVO review) {
		// TODO Auto-generated method stub
		return db.deleteReview(review);
	}

	public boolean addMovie(MovieVO movie) {
		// TODO Auto-generated method stub
		return db.addMovie(movie);
	}

	public boolean deleteMovie(MovieVO movie) {
		// TODO Auto-generated method stub
		return db.deleteMovie(movie);
	}

	public boolean deleteMember(MemberVO member) {
		// TODO Auto-generated method stub
		return db.deleteMember(member);
	}

	public List<NoticeBoardVO> readPost() {
		// TODO Auto-generated method stub
		return db.readPost();
	}

	public boolean addPost(NoticeBoardVO notice) {
		// TODO Auto-generated method stub
		return db.addPost(notice);
	}

	public boolean deletePost(NoticeBoardVO notice) {
		// TODO Auto-generated method stub
		return db.deletePost(notice);
	}

	public List<SeatVO> readSeat(String show_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean reviseMemId(Map<String, String> info) {
		// TODO Auto-generated method stub
		return db.reviseMemId(info);
	}

	public boolean reviseMemPw(Map<String, String> info) {
		// TODO Auto-generated method stub
		return db.reviseMemPw(info);
	}

	public boolean reviseMemAdd(Map<String, String> info) {
		// TODO Auto-generated method stub
		return db.reviseMemAdd(info);
	}

	public boolean reviseMemHp(Map<String, String> info) {
		// TODO Auto-generated method stub
		return db.reviseMemHp(info);
	}

	public boolean reviseMemName(Map<String, String> info) {
		// TODO Auto-generated method stub
		return db.reviseMemName(info);
	}

	public boolean deleteMemRes(int res_no) {
		// TODO Auto-generated method stub
		return db.deleteMemRes(res_no);
	}
	
	public List<MovieVO> movieList() {
	    // TODO Auto-generated method stub
	    return db.movieList();
	}

	public boolean setUseSeat(Map<String, String> info) {
		// TODO Auto-generated method stub
		return db.setUseSaet(info);
	}

	public boolean dupSeat(String seat_no) {
		// TODO Auto-generated method stub
		return db.dupSeat(seat_no);
	}

	public boolean cancelSeat(Map<String, String> info) {
		// TODO Auto-generated method stub
		return db.cancelSeat(info);
	}

	@Override
	public boolean checkLogin(Map<String, String> map) {
		// TODO Auto-generated method stub
		return db.checkLogin(map);
	}
	

	@Override
	public boolean memOverlapCheck(Map<String, String> map) {
		// TODO Auto-generated method stub
		return db.memOverlapCheck(map);
	}

	public MemberVO getMemberVO(String mem_id) {
		// TODO Auto-generated method stub
		return db.getMemberVO(mem_id);
	}

	@Override
	public boolean admin_checkLogin(Map<String, String> map) {
		// TODO Auto-generated method stub
		return db.admin_checkLogin(map);
	}

	@Override
	public List<ReserveVO> readAllRes() {
		// TODO Auto-generated method stub
		return db.readAllRes();
	}
	
	

}
