package com.advanceteam.service;

import java.util.ArrayList;
import java.util.List;

import com.advanceteam.vo.MemberVO;

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
	
}
