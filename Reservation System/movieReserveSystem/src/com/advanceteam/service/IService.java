package com.advanceteam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.advanceteam.vo.MemberVO;
import com.advanceteam.vo.MovieVO;
import com.advanceteam.vo.NoticeBoardVO;
import com.advanceteam.vo.ReserveVO;
import com.advanceteam.vo.ReviewVO;
import com.advanceteam.vo.SeatVO;
import com.advanceteam.vo.ShowVO;

public interface IService {

	/**
	 * 신규회원가입을 하면 데이터베이스 접근하여 회원정보를 추가하는 메서드
	 * @param member - View class에서 사용자입력을 통해 변수값이 정해진 MemberVO 객체
	 * @return boolean - 회원가입이 정상적으로 실행된 경우 true, 아닌경우 false를 View class로 반환한다. 
	 * @since 2020.08.31
	 */
	public boolean addMember(MemberVO member);
	
	
	/**
	 * 데이터베이스에 접근하여 현재 Member테이블에 존재하는 회원정보를 반환하는 메서드
	 * 
	 * @return List<MemberVO>
	 * @since 2020.08.31
	 */
	public List<MemberVO> readMember();

	
	/**
	 * 데이터베이스에 접근하여 현재 상영중인 showList를 반환하는 메서드
	 * @return
	 */
	public List<ShowVO> readShow();
	
	/**
	 * 데이터베이스에 접근하여 예약가능한 좌석을 리스트로 반환한다.
	 * @param show_id
	 * @return
	 */
	public List<SeatVO> readSeat(String show_id);
	
	
	/**
	 *  회원이 영화예매를 하는경우, 예매정보를 담은객체를 파라미터로 받아 예약자리스트에 추가시킨다.
	 * @param newRes
	 * @return
	 */
	public boolean addRes(ReserveVO newRes);
	
	
	/**
	 * 영화예매를 취소하기 위한 메서드
	 * @param delRes
	 * @return
	 */
	public boolean deleteMemRes(int res_no);
	
	
	/**
	 * 회원의 예매정보를 조회해주는 메서드
	 * @param mem_id
	 * @return
	 */
	public boolean readMemRes(String mem_id);

	
	/**
	 * 회원의 예매정보를 ReserveVO 타입의 객체를 담은 리스트로 반환해주는 메서드
	 * 회원의 예매정보가 다수일 수 있으므로 리스트로 반환해준다.
	 * @param mem_id
	 * @return
	 */
	public List<ReserveVO> loadMemRes(String mem_id);
	
	
	/**
	 * 데이터베이스로에 현재 상영중인 영화객체들을 리스트로 요청한다.
	 * @return
	 */
	public List<MovieVO> readMovie();
	
	
	/**
	 * 기존 리뷰를 조회하는 메서드
	 * db에 있는 리뷰 조회 메서드 추가했음
	 * 2020-09-01
	 * @author subin
	 * @return
	 */
	public List<ReviewVO> readReview();
	
	
	/**
	 * 기존 리뷰를 추가하는 메서드
	 * db에 있는 리뷰 추가 메서드 추가했음
	 * 2020-09-01
	 * @author subin
	 * @param review
	 * @return
	 */
	public boolean addReview(ReviewVO review);
	
	
	/**
	 * 기존의 리뷰를 삭제하는 메서드
	 * db에 있는 리뷰 삭제 메서드 추가했음
	 * 2020-09-01
	 * @author subin
	 * @param review
	 * @return
	 */
	public boolean deleteReview(ReviewVO review);
	
	
	/**
	 * 영화등록 메서드
	 * db에 있는 영화등록 메서드 추가했음
	 * 2020-09-01
	 * @author subin
	 * @param movie
	 * @return
	 */
	public boolean addMovie(MovieVO movie);
	
	
	/**
	 * 영화삭제 메서드
	 * db에 있는 영화삭제 메서드 추가했음
	 * 2020-09-01
	 * @author subin
	 * @param movie
	 * @return
	 */
	public boolean deleteMovie(MovieVO movie);
	
	
	/**
	 * 회원 비활성화 메서드
	 * 
	 * Database에 있는 deleteMember메서드를 일부 수정하였음
	 * 회원정보가 있으면 setDelete 의 값을 true로 바꾸어서
	 * 비활성화 실행하고 ture 값을 반환.
	 * 
	 * 회원정보가 없다면 false 값을 반환. 
	 * @since 2020-09-02
	 * @author sangheon
	 * @param member
	 * @return boolean
	 */
	public boolean deleteMember(MemberVO member);
	
	
	/**
	 * 게시글 조회 메서드
	 * db에 있는 게시글 조회 메서드 추가했음
	 * 2020-09-01
	 * @author sangheon
	 * @return
	 */
	public List<NoticeBoardVO> readPost();
	
	
	/**
	 * 게시글 추가 메서드
	 * db에 있는 게시글 추가 메서드 추가했음
	 * 2020-09-01
	 * @author sangheon
	 * @param notice
	 * @return
	 */
	public boolean addPost(NoticeBoardVO notice);
	
	
	/**
	 * 게시글 삭제 메서드
	 * db에 있는 게시글 삭제 메서드 추가했음
	 * 2020-09-01
	 * @author sangheon
	 * @param notice
	 * @return
	 */
	public boolean deletePost(NoticeBoardVO notice);
	
	/**
	 * 회원의 아이디를 변경하는 메서드
	 * @author 신광진
	 * @param info => 기존회원아이디(key : mem_id), 새로운아이디(key : new_id)
	 * @return
	 */
	public boolean reviseMemId(Map<String, String> info);
	
	/**
	 * 
	 * @param info => 회원아이디(key : mem_id), 새로운 비밀번호(key : new_pw)
	 * @return
	 */
	public boolean reviseMemPw(Map<String, String> info);
	
	/**
	 * 
	 * @param info => 회원아이디(key : mem_id), 새로운 주소(key : new_add), 새로운 상세주소(key : new_add2)
	 * @return
	 */
	public boolean reviseMemAdd(Map<String, String> info);

	/**
	 * 
	 * @param info => 회원아이디(key : mem_id), 새로운 전화번호 (key : new_hp)
	 * @return
	 */
	public boolean reviseMemHp(Map<String, String> info);
	
	/**
	 * 
	 * @param info => 회원아이디(key : mem_id), 새로운 이름(key : new_name)
	 * @return
	 */
	public boolean reviseMemName(Map<String, String> info);
	
	/**
	 * 사용자가 지정한 좌석을 예약중인 좌석으로 변경한다
	 * @param seatStr
	 * @return
	 */
	public boolean setUseSeat(Map<String, String> seatStr);
	
	/**
	 * 예약을 중복선택했는지 조회한다.
	 * @param seatStr
	 * @return
	 */
	public boolean dupSeat(String seat_no);
	
	/**
	 * 회원이 예약을 취소했을때 좌석을 예약가능 상태로 전환하는 메서드
	 * @param info
	 * @return
	 */
	public boolean cancelSeat(Map<String, String> info);
	
	/**
	 * 무비 리스트를 가져옴
	 * @author 김선준
	 */
	public List<MovieVO> movieList();
	
	/**
	 * 로그인할때 아이디 패스워드 비교 (회원용)
	 * @author 김선준
	 * @param 회원아이디, 패스워드
	 */
	public boolean checkLogin(Map<String, String> map);
	
	/**
	 * 로그인할때 아이디 패스워드 비교 (비회원용)
	 * @author 김선준
	 * @param 회원아이디, 패스워드
	 */
	public boolean admin_checkLogin(Map<String, String> map);
	
	/**
	 * 회원가입할때 이미 가입한 회원인지 체크용
	 * @author 김선준
	 */
	public boolean memOverlapCheck(Map<String, String> map);
	
	/**
	 * 로그인할 때 회원의 객체를 받아오는 메서드
	 * @author 김선준
	 * @return
	 */
	public MemberVO getMemberVO(String mem_id);
	

	public List<ReserveVO> readAllRes();
	
}
