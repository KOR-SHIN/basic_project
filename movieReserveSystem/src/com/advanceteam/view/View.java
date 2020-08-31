package com.advanceteam.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.advanceteam.vo.MemberVO;
import com.advanceteam.vo.MovieVO;
import com.advanceteam.database.Database;
import com.advanceteam.service.*;

public class View {
	Database db = new Database();
	Calendar cal = Calendar.getInstance();
	IServiceImpl sv = new IServiceImpl();
	Regex rg = new Regex();
	Scanner sc = new Scanner(System.in);
	MemberVO member = new MemberVO();
	
	
	
	public void run() {
		while(true){
			System.out.println("=== GGV ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 나가기");
			
			System.out.print("번호를 입력해 이동 : ");
			int cmd = sc.nextInt();
			
			switch(cmd) {
			case 1:
				addMember(); // 회원가입
				break;
				
			case 2:
				memlogIn(); // 로그인
				break;
			case 3:
				System.exit(0); //나가기
				break;
			}
		}
	}
	
	
	/**
	 * 회원가입하는 메소드
	 * @author 김선준
	 */
	private void addMember() {
		
		//1. 이름입력받음
		String mem_name = inputName();
		
		//2. 주민번호입력받음
		String mem_regno1 = inputRegno1();
		String mem_regno2 = inputRegno2();
		
		//3. 이미 가입되어있는지 확인
		boolean check = memOverlapCheck(mem_name, mem_regno1, mem_regno2);
		if(check){
			System.out.println("※이미 가입된 회원ID가 있습니다.");
			return;
		}
		
		//3. 아이디
		String mem_id = inputId();
		
		//4. 비밀번호
		String mem_pw = inputPw();
		
		//5. 휴대번호
		String mem_hp = inputHp();
		
		//6. 주소
		String mem_add = inputAdd();
		String mem_add2 = inputAdd2();
		
		//7. 예산
		int budget = inputBudget();
		
		//모두 메서드로 작성해서 member객체에 setter로 값을 지정하여 Service로 객체를 넘겨줘야함.
		member.setMem_name(mem_name);
		member.setMem_regno1(mem_regno1);
		member.setMem_regno2(mem_regno2);
		member.setMem_id(mem_id);
		member.setMem_pw(mem_pw);
		member.setMem_hp(mem_hp);
		member.setMem_add(mem_add);
		member.setMem_add2(mem_add2);
		member.setDelete(false);
		member.setBudget(budget);
		member.setMem_auth("member");
		member.setMem_rank("platinum"); 
		member.setMem_signUpDate(cal.getTime());
		
		boolean result = sv.addMember(member);
		
		if(result) {
			System.out.println(mem_name +"고객님의 가입을 환영합니다!");
		} else {
			System.out.println("회원가입 실패");
		}
	}
	
	
	/**
	 * 회원으로 로그인하면 나오는 회원페이지
	 * @author 김선준
	 */
	private void memPage(MemberVO mb) {
		while(true){
			System.out.println("=== "+ mb.getMem_name()+"님 환영합니다! ===");
			System.out.println("1. 영화예매");
			System.out.println("2. 예매취소");
			System.out.println("3. 상영중인 영화보기");
			System.out.println("4. 마이페이지");
			System.out.println("5. 나가기");
			
			System.out.print("번호를 입력해 이동 : ");
			int cmd = sc.nextInt();
			
			switch(cmd) {
			case 1:
				ticketing(mb); // 영화예매
				break;
			case 2:
				ticketingCancle(mb); // 예매취소
				break;
			case 3:
				MovieListPage(); //상영중인 영화보기
				break;
			case 4:
				myPage(mb); //마이페이지
			case 5:
				System.exit(0); //나가기
				break;
			}
		}
	}

	




	/**
	 * 로그인 - 회원페이지 - 영화예매
	 * 영화예매하는 페이지
	 * @author 김선준
	 */
	private void ticketing(MemberVO mb) {
		List<MovieVO> mvList = db.readMovie(); //service로 바꿔야함
		while(true){
			System.out.println("=== 상영중인 영화 ===");
			movieList();
			System.out.print("예매할 영화를 선택 : ");
			int select = sc.nextInt()-1;
			timeSelect(mb, mvList.get(select));
			
		}
		
	}
	
	/**
	 * 로그인 - 회원페이지 - 영화예매 - 시간선택
	 * 시간선택하는 페이지
	 * @author 김선준
	 */
	private void timeSelect(MemberVO mb, MovieVO movieVO) {
		while(true){
			//관람 시간 리스트가 출력될 곳
			
			System.out.print("관람 시간을 선택해주세요");
			sc.nextInt();
		}
		
	}
	
	/**
	 * 예매취소하는 페이지
	 * @author 김선준
	 */
	private void ticketingCancle(MemberVO mb) {
		while(true){
			//예매리스트가 출력될 곳
			System.out.print("예매취소할 영화를 선택해주세요 : ");
			sc.nextInt();
		}
	}
	
	/**
	 * 로그인 - 회원페이지 - 상영중인 영화보기
	 * 상영영화페이지
	 * @author 김선준
	 */
	private void MovieListPage() {
		List<MovieVO> mvList = db.readMovie(); // service로 바꿔야함
		while(true){
			System.out.println("=== 상영중인 영화정보 ===");
			movieList();
			System.out.print("영화를 선택 : ");
			int select = sc.nextInt()-1;
			movieInfo(mvList.get(select)); //선택한영화의 정보창으로 이동
		}
	}

	

	private void movieInfo(MovieVO mv) {
		printMovie(mv);
	}


	private void printMovie(MovieVO mv) {
		System.out.println("=== " +mv.getMovie_title() + " ===");
		System.out.println("상영시간 : "+mv.getMovie_runTime());
		System.out.println("관람등급 : "+ mv.getMovie_ageGrade());
		System.out.println("장르 : " + mv.getMovie_genre());
		System.out.println("감독 : "+ mv.getMovie_director());
		System.out.println("주연 : "+ mv.getMovie_actor());
		System.out.println("가격 : "+ mv.getMovie_price());
		
	}


	/**
	 * 로그인 - 회원페이지 - 마이페이지
	 * @author 김선준
	 */
	private void myPage(MemberVO mb) {
		while(true){
			System.out.println("=== 마이페이지 ===");
			printMember(mb); //회원 정보 출력
			System.out.println("1. 정보수정");
			System.out.println("2. 회원탈퇴");
			System.out.println("3. 뒤로가기");
			
			System.out.print("번호 선택해서 이동 : ");
			int cmd = sc.nextInt();
			
			switch(cmd) {
			case 1:
				infoRevise(mb); // 정보수정
				break;
			case 2:
				memOut(mb); // 회원탈퇴
				break;
			case 3:
				return; //뒤로가기
			}
		}
	}
	
	private void infoRevise(MemberVO mb) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * 로그인 - 회원페이지 - 마이페이지 - 회원탈퇴창
	 * 회원탈퇴창 메소드
	 * @author 김선준
	 */
	private void memOut(MemberVO mb) {
		while(true){
			System.out.println("정말 회원을 탈퇴하시겠습니까?");
			System.out.println("1. 탈퇴하겠습니다.");
			System.out.println("2. 아니요");
			System.out.print("번호 입력 : ");
			switch(sc.nextInt()){
			case 1:
				if(db.deleteMember(mb)){ //service로 바꿔야함
					run(); // 스택에서 순차적으로 다 빼야하는데 아직 방법을 모름
				}
				break;
			case 2:
				return;
			}
		}
	}


	/**
	 * 영화리스트 출력하는 메소드
	 * @author 김선준
	 */
	private void movieList() {
		List<MovieVO> mvList = db.readMovie(); //service로 바꿔야함
	    for (int i = 0; i< mvList.size(); i++) {
	    	System.out.println((i+1) + ". " + mvList.get(i).getMovie_title());
	    }
	}

	/**
	 * 회원으로 로그인하는 메소드
	 * @author 김선준
	 */
	private void memlogIn() {
		System.out.println("1. 관리자");
		System.out.println("2. 회원");
	
		int tmp = sc.nextInt();
		
		if(tmp == 1) {
			//test를 위해 임시로 넣어놓은 부분입니다.
			AddView temp = new AddView();
			temp.adminList();
		}
		
		while(true){
			String mem_id = logInId();
			String mem_pw = logInPw();
			if(checkLogin(mem_id, mem_pw)){
				MemberVO mb = getMemberVO(mem_id);
				memPage(mb);
				return;
			}else{
				System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
			}
		}
	}

	/**
	 * 로그인할 때 아이디를 입력받는 메소드
	 * @author 김선준
	 */
	private String logInId() {
		while(true){
			System.out.print("아이디를 입력해주세요 : ");
			String mem_id = sc.next(); //입력받아서

			if(rg.checkId(mem_id)){ //양식이 맞으면
				return mem_id; //반환
			}
			System.out.println("※양식에 맞게 입력해주세요."); //틀릴 시
		}
	}
	
	/**
	 * 로그인할 때 패스워드를 입력받는 메소드
	 * @author 김선준
	 */
	private String logInPw() {
		while(true){
			System.out.print("패스워드를 입력해주세요 : ");
			String mem_pw = sc.next(); //입력받아서

			if(rg.checkPw(mem_pw)){ //양식이 맞으면
				return mem_pw; //반환
			}
			System.out.println("※양식에 맞게 입력해주세요."); //틀릴 시
		}
	}
	
	/**
	 * 로그인 시 아이디와 패스워드가 일치하는지 확인
	 * @author 김선준
	 */
	private boolean checkLogin(String mem_id, String mem_pw){
		List<MemberVO> memList = sv.readMember();
		boolean memCheck = false;
		for(int i = 0; i<memList.size(); i++){ 
			//아이디와 패스워드가 일치하면
			if(mem_id.equals(memList.get(i).getMem_id())
					&& mem_pw.equals(memList.get(i).getMem_pw())){
				memCheck = true;
			}
		}
		if(memCheck){ //
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 로그인에 성공했을 때 해당 회원의 객체를 얻기위해 만든 메소드
	 * @author 김선준
	 */
	private MemberVO getMemberVO(String mem_id) {
		List<MemberVO> memList = sv.readMember();
		int num = 0;
		for(int i = 0; i<memList.size(); i++){ 
			//아이디가 일치하는 객체
			if(mem_id.equals(memList.get(i).getMem_id())){
				num = i; 
			}
		}
		return memList.get(num);
	}


	


	private void readMember() {
		printMember(sv.readMember());
	}

	
	private void printMember(List<MemberVO> memberList) {
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
	
	/**
	 * 회원페이지에서 본인 정보만 불러올때 사용하는 메소드
	 * @author 김선준
	 */
	private void printMember(MemberVO mb) {
		System.out.println("=== 회원 정보 ===");
		System.out.println("이름 : " + mb.getMem_name());
		System.out.println("전화번호 : " + mb.getMem_hp());
		System.out.println("보유 금액 : " + mb.getBudget());
		System.out.println("가입날짜 : " + mb.getMem_signUpDate());
		System.out.println("회원님의 등급은 " + mb.getMem_rank() + "입니다.");
		System.out.println();
	}


	

	/**
	 * 회원가입 시 아이디를 입력받는 메소드
	 * @author 김선준
	 */
	private String inputName() {
		while(true){
			System.out.print("이름을 입력해주세요 (한글만) : ");
			String mem_name = sc.next();
			if(rg.checkName(mem_name)){ //양식이 맞으면
				return mem_name;
			}
			System.out.println("※양식에 맞게 입력해주세요.");
		}
	}


	/**
	 * 회원가입 시 주민번호 앞자리를 입력받는 메소드
	 * @author 김선준
	 */
	private String inputRegno1() {
		while(true){
			System.out.print("주민등록번호 앞 6자리를 입력해주세요 : ");
			String mem_regno1 = sc.next();
			if(rg.checkRegno1(mem_regno1)){ //양식이 맞으면
				return mem_regno1;
			}
			System.out.println("※양식에 맞게 입력해주세요.");
		}
	}
	
	/**
	 * 회원가입 시 주민번호 뒷자리를 입력받는 메소드
	 * @author 김선준
	 */
	private String inputRegno2() {
		while(true){
			System.out.print("주민등록번호 뒷 7자리를 입력해주세요 : ");
			String mem_regno2 = sc.next();
			if(rg.checkRegno2(mem_regno2)){ //양식이 맞으면
				return mem_regno2;
			}
			System.out.println("※양식에 맞게 입력해주세요.");
		}
	}
	
	/**
	 * 이미 가입된 회원인지 체크하는 메서드
	 * @author 김선준
	 */
	private boolean memOverlapCheck(String mem_name, String mem_regno1, String mem_regno2){
		List<MemberVO> memList = sv.readMember();
		boolean sameMem = false; //중복체크용
		//중복체크
		for(int i = 0; i<memList.size(); i++){ //리스트에 담긴 이름의 갯수만큼 반복 
			if(mem_name.equals(memList.get(i).getMem_name())
					&& mem_regno1.equals(memList.get(i).getMem_regno1())
					&& mem_regno2.equals(memList.get(i).getMem_regno2())){ //이름과 주민번호가 같은사람이 이미 있으면
				sameMem = true; // 중복이면 참
			}
		}
		if(sameMem){ //중복이었으면
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 회원가입할때 ID 입력 시 이미 있는 ID인지 체크하는 메서드
	 * @author 김선준
	 */
	private boolean idOverlapCheck(String mem_id){
		List<MemberVO> memList = sv.readMember();
		boolean sameId = false; //중복체크용
		//중복체크
		for(int i = 0; i<memList.size(); i++){ //리스트에 담긴 이름의 갯수만큼 반복 
			if(mem_id.equals(memList.get(i).getMem_id())){ //이름과 주민번호가 같은사람이 이미 있으면
				sameId = true; // 중복이면 참
			}
		}
		if(sameId){ //중복이었으면
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 회원가입 시 아이디를 입력받는 메소드
	 * @author 김선준
	 */
	private String inputId() {
		while(true){
			System.out.print("아이디를 입력해주세요 : ");
			String mem_id = sc.next(); //입력받아서
			
			if(rg.checkId(mem_id)){ //양식이 맞으면
				if(idOverlapCheck(mem_id)){ //아이디가 중복되면
					System.out.println("이미 존재하는 ID입니다");
				}else{
					return mem_id; //반환
				}
			}
			System.out.println("※양식에 맞게 입력해주세요."); //틀릴 시
		}
	}

	/**
	 * 회원가입 시 패스워드를 입력받는 메소드
	 * @author 김선준
	 */
	private String inputPw() {
		while(true){
			System.out.print("패스워드를 입력해주세요 : ");
			String mem_pw = sc.next(); //입력받아서
			sc.nextLine();
			if(rg.checkPw(mem_pw)){ //양식이 맞으면
				return mem_pw; //반환
			}
			System.out.println("※양식에 맞게 입력해주세요."); //틀릴 시
		}
	}
	
	/**
	 * 회원가입 시 전화번호를 입력받는 메소드
	 * @author 김선준
	 */
	private String inputHp() {
		while(true){
			System.out.print("전화번호를 입력해주세요 : ");
			String mem_hp = sc.nextLine(); //입력받아서
			if(rg.checkHp(mem_hp)){ //양식이 맞으면
				return mem_hp; //반환
			}
			System.out.println("※양식에 맞게 입력해주세요."); //틀릴 시
		}
	}

	/**
	 * 회원가입 시 주소를 입력받는 메소드
	 * @author 김선준
	 */
	private String inputAdd() {
		System.out.print("주소를 입력해주세요 : ");
		String mem_add = sc.nextLine(); //입력받아서
		return mem_add; //반환
	}
	
	/**
	 * 회원가입 시 상세주소를 입력받는 메소드
	 * @author 김선준
	 */
	private String inputAdd2() {
		System.out.print("상세주소를 입력해주세요 : ");
		String mem_add2 = sc.nextLine(); //입력받아서
		return mem_add2; //반환
	}

	/**
	 * 회원가입 시 보유금액을 입력받는 메소드
	 * @author 김선준
	 */
	private int inputBudget() {
		System.out.print("보유금액을 입력해주세요 : ");
		int budget = sc.nextInt(); //입력받아서
		return budget;
	}

}
