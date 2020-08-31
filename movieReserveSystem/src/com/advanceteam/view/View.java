package com.advanceteam.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.advanceteam.vo.MemberVO;
import com.advanceteam.service.*;

public class View {

	Calendar cal = Calendar.getInstance();
	IServiceImpl sv = new IServiceImpl();
	
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("===temp ViewClass===");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원조회");
		
		
		Scanner scan = new Scanner(System.in);
		
		int cmd = scan.nextInt();
		
		switch(cmd) {
		
		case 1:
			addMember();
			break;
			
		case 2:
			readMember();
			break;
		}
		
	}


	private void readMember() {
		// TODO Auto-generated method stub
		printMember(sv.readMember());
	}


	private void printMember(List<MemberVO> memberList) {
		// TODO Auto-generated method stub
		
		for(MemberVO member : memberList) {
			System.out.println("회원이름 : " + member.getMem_name());
			System.out.println("회원등급 : " + member.getMem_rank());
			System.out.println("회원아이디 : " + member.getMem_id());
			System.out.println("회원패스워드 : " + member.getMem_pw());
			System.out.println("회원 예산 : " + member.getBudget());
			System.out.println("회원 주민번호 앞자리 : " + member.getMem_regno1());
			System.out.println("회원주소 : " + member.getMem_add() + " " + member.getMem_add2());
			System.out.println("회원가입 날짜 : " + member.getMem_signUpDate());
			System.out.println("회원탈퇴 여부 : " + member.isDelete());
			System.out.println("회원 전화번호 : " + member.getMem_hp());
			System.out.println();
		}
		
	}


	private void addMember() {
		// TODO Auto-generated method stub
		MemberVO member = new MemberVO();
		
		//모두 메서드로 작성해서 member객체에 setter로 값을 지정하여 Service로 객체를 넘겨줘야함.
		member.setBudget(100000);
		member.setMem_add("서울특별시");
		member.setMem_add2("삼성동");
		member.setMem_auth("member");
		member.setDelete(false);
		member.setMem_hp("010-5343-1234");
		member.setMem_id("tempId");
		member.setMem_name("김임시");
		member.setMem_pw("temp");
		member.setMem_rank("platinum");
		member.setMem_regno1("830112");
		member.setMem_regno2("1XXXXXX");
		member.setMem_signUpDate(cal.getTime());
		
		boolean result = sv.addMember(member);
		
		if(result) {
			System.out.println("회원추가 성공");
		} else {
			System.out.println("회원추가 실패");
		}
		
	}

}
