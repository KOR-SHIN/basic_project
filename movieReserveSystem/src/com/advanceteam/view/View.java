package com.advanceteam.view;

import java.util.Calendar;
import java.util.Scanner;

import com.advanceteam.vo.MemberVO;
import com.advanceteam.service.*;

public class View {

	Calendar cal = Calendar.getInstance();
	
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("temp ViewClass");
		System.out.println("1. 회원가입");
		
		Scanner scan = new Scanner(System.in);
		
		int cmd = scan.nextInt();
		
		switch(cmd) {
		
		case 1:
			join();
			break;
			
		}
		
	}

	
	private void join() {
		// TODO Auto-generated method stub
		MemberVO member = new MemberVO();
		
		//모두 메서드로 작성해서 member객체에 setter로 값을 지정하여 Service로 객체를 넘겨줘야함.
		member.setBudget(100000);
		member.setMem_add("서울특별시");
		member.setMem_add2("삼성동");
		member.setMem_auth("member");
		member.setMem_deleteDate(null);
		member.setMem_hp("010-5343-1234");
		member.setMem_id("tempId");
		member.setMem_name("김임시");
		member.setMem_pw("temp");
		member.setMem_rank("platinum");
		member.setMem_regno1("830112");
		member.setMem_regno2("1XXXXXX");
		member.setMem_signUpDate(cal.getTime());
		
		IServiceImple sv = new IServiceImple();
		boolean result = sv.addMember(member);
		
		if(result) {
			System.out.println("회원추가 성공");
		} else {
			System.out.println("회원추가 실패");
		}
		
	}

}
