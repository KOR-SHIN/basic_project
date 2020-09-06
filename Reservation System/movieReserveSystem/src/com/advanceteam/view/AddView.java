package com.advanceteam.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.advanceteam.database.Database;
import com.advanceteam.service.*;
import com.advanceteam.vo.MemberVO;
import com.advanceteam.vo.MovieVO;
import com.advanceteam.vo.NoticeBoardVO;
import com.advanceteam.vo.ReserveVO;
import com.advanceteam.vo.ReviewVO;
import com.advanceteam.vo.ShowVO;

public class AddView {
	IService service;
	
	MemberVO member = new MemberVO();
	Database db = new Database();
	SimpleDateFormat signUpSdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	SimpleDateFormat showTimeSdf = new SimpleDateFormat("yy년 MM월 dd일 HH시mm분");
	
	AddView(IService service){
		this.service = service;
	}
	
	private void Banner(String title){						// title 중간에 오게 수정 할거임
		System.out.println("────────────────────────────────────");
		System.out.println(title);
		System.out.println("────────────────────────────────────");
	}
	
	public void adminList(){
		do{
			Banner("admin List");
			System.out.println("1. 영화관리");
			System.out.println("2. 예매 관리");
			System.out.println("3. 회원 관리");
			System.out.println("4. 공지 사항");
			System.out.println("5. 리뷰 관리");
			System.out.println("6. 로그아웃");
			System.out.print("번호를 선택해서 이동 : ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			
			switch(input){
			case 1:					// 1. 영화 관리
				managerMovie();								 	
				break;
			case 2:					// 2. 예매 관리
				managerTicket();	
				break;
			case 3:
				worklist();						// 회원 관리 메서드() : 이상헌
				break;
			case 4:
				selectNoticeWork();						// 공지 사항() : 이상헌
				break;
			case 5:					// 5. 리뷰 관리
				managerReview();
				break;
			case 6:					// 6. 나가기  -> adminList() 메서드 종료  
				System.out.println("이용해주셔서 감사합니다.");
				return;		
			default :										
				System.out.println("해당 목록이 존재하지 않거나 접근 권한이 없습니다.");
				break;
			}
			
		} while(true);
	}


	/*
	 * ===================================================
	 * 						영화 관리
	 * ===================================================
	 */

	/**
	 * 영화 관리 뷰
	 * @method  managerMovie
	 * @param	
	 * @return	void
	 * @author	JSB
	 * @since	2020. 9. 3
	 */
	private void managerMovie(){
		do{
			Banner("movie list");
			movieList();
			Banner("MENUE");
			System.out.println("1. 영화 추가");
			System.out.println("2. 영화 삭제");
			System.out.println("3. 나가기");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch(input){
			case 1:					// 영화 추가
				System.out.println("영화 추가를 진행합니다.");
				addMovie();
				break;
			case 2:					// 영화 삭제
				System.out.println("영화 삭제를 진행합니다.");
				deleteMovie();
				break;
			case 3:					// managerMovie() 종료
				System.out.println("나가세욧!");
				return;
			default:			
				System.out.println("해당목록은 존재 하지 않습니다.");
				break;
			}
		} while(true);
	}
	
	/**
	 * 상영중인 영화 목록 출력 메서드
	 * @method  movieList
	 * @param	
	 * @return	void
	 * @author	JSB
	 * @since	2020. 9. 3
	 */
	void movieList() {
		if(service.readMovie().isEmpty()) {
			System.out.println("상영중인 영화가 없습니다!");
			return;
		}
		int movie_num = 0;
		for (MovieVO movie : service.readMovie()) {
			System.out.println("────────────────────────────────────");
			System.out.println("NO." + ++movie_num);
			System.out.println("영화 제목 : " + movie.getMovie_title());
			System.out.println("연령 제한 : " + movie.getMovie_ageGrade());
			System.out.println("가격 : " + movie.getMovie_price());
			System.out.println("개봉일 : " + movie.getMovie_open());
			System.out.println("────────────────────────────────────");
		}
	}
	
	/**
	 * 상영 영화 추가 메서드
	 * 영화 추가 실패시 오류 문구 출력 후 뒤로 가기
	 * @method  addMovie
	 * @return	void
	 * @author	JSB
	 * @since	2020. 9. 3
	 */
	
	  //1. 영화 상영관 추가를 동시에 진행 할건지?
	  //2. 날짜는... 캘린더 이용해서 입력이 가능한지?
	  //3. 
	void addMovie() {
		do {
			Scanner sc = new Scanner(System.in);
			MovieVO movie = new MovieVO();
			Calendar cal = Calendar.getInstance();
			int year = 0;
			int month = 0;
			int day = 0;
			Banner("MOVIE SETTING.....");
			// 문자열 입력
			System.out.println("영화 제목을 입력해주세요.");
			movie.setMovie_title(sc.nextLine());
			System.out.println("영화 감독명을입력해주세요.");
			movie.setMovie_director(sc.nextLine());
			System.out.println("영화 배우명을 입력해주세요.");
			movie.setMovie_actor(sc.nextLine());
			
			// int형 타입 입력 예외 처리
			try {
				System.out.println("영화 연령등급을 입력해주세요.");
				movie.setMovie_ageGrade(sc.nextInt());
				System.out.println("영화 상영시간을 입력해주세요.");
				movie.setMovie_runTime(sc.nextInt());
				System.out.println("영화 티켓 가격을 입력해주세요.");
				movie.setMovie_price(sc.nextInt());
				
				// 정규식으로 수정 할 예정. if로 처리?
				System.out.println("영화 개봉년도(Year) 숫자 4자리를 입력해주세요.(YYYY)");
				year = sc.nextInt();
				System.out.println("영화 개봉월(Month) 1 ~ 12를 입력해주세요.(MM)");
				month = sc.nextInt();
				System.out.println("영화 개봉일(Day) 1 ~ 31를 입력해주세요.(DD)");
				day = sc.nextInt();
				
			} catch(IndexOutOfBoundsException e){
				System.out.println("올바른 입력 형태가 아닙니다.!");
				System.out.println("다시 시도해주세요!");
				return;
			} catch(InputMismatchException e){
				System.out.println("올바른 입력 형태가 아닙니다.!");
				System.out.println("다시 시도해주세요!");
				return;
			}
			cal.set(year, month - 1, day);
			movie.setMovie_open(cal.getTime());
			MovieVO.setMovie_sq(MovieVO.getMovie_sq());
			if(service.addMovie(movie)) {
				System.out.println("영화 등록에 성공하였습니다.");
			} else {
				System.out.println("영화 등록 실패!");
				System.out.println("다시 시도해 주세요!");
			}
			break;	
		} while(true);
	}
	
	/**
	 * 영화 삭제 메서드
	 * 영화 삭제 실패시 오류 문구 출력 후 뒤로 가기
	 * @method  deleteMovie
	 * @return	void
	 * @author	JSB
	 * @since	2020. 9. 3
	 */
	void deleteMovie() {
		if(service.readMovie().isEmpty()) {
			System.out.println("상영중인 영화가 없습니다.");
			return;
		}
		Scanner sc = new Scanner(System.in);
		int input = 0;
		movieList();
		System.out.println("삭제할 영화의 번호를 입력해주세요.");
		try {
			input = sc.nextInt() - 1;	// 예외 처리
		} catch(IndexOutOfBoundsException e){
			System.out.println("올바른 입력 형태가 아닙니다.!");
			System.out.println("다시 시도해주세요!");
			return;
		} catch(InputMismatchException e){
			System.out.println("올바른 입력 형태가 아닙니다.!");
			System.out.println("다시 시도해주세요!");
			return;
		}		
		if(service.deleteMovie(service.readMovie().get(input))) {
			System.out.println("영화 삭제에 성공했습니다!");
		} else {
			System.out.println("영화 삭제에 실패했습니다...");
		}
	}
	
	/*
	 * ===================================================
	 * 						영화 예매 현황
	 * ===================================================
	 */

	/**
	 * 영화 예매 관리 뷰
	 * @method  managerTicket
	 * @param	
	 * @return	void
	 * @author	JSB
	 * @since	2020. 9. 4오전 12:12:21
	 */
	private void managerTicket(){
		if(service.readAllRes().isEmpty()) {
			System.out.println("예매목록 없음");
		} else {
			for (ReserveVO res : service.readAllRes()) {
				for (ShowVO show : service.readShow()) {
					if (show.getShow_no() == res.getShow_no()) {
						System.out.println("==============================");
						System.out.println("영화제목 : " + res.getMovie_title());
						System.out.println("예약자 회원 ID : " + res.getMem_id());
						System.out.println("상영관 : " + res.getTheater_no() + "관");
						System.out.println("좌석 : " + res.getSeat_no().substring(2));
						System.out.println("상영시간 : " + showTimeSdf.format(show.getShow_date()));
						System.out.println("==============================");
						System.out.println();
					}
				}
			}
		}
		
	}
	/*
	 *===================================================
	 * 						영화 리뷰 관리
	 *===================================================	
	 */
	
	/**
	 * 영화 리뷰 관리 뷰
	 * @method  managerReview
	 * @return	void
	 * @author	JSB
	 * @since	2020. 9. 3
	 */
	private void managerReview(){
		do{
			if(service.readReview().isEmpty()){
				System.out.println("등록된 리뷰가 없습니다!");
				return;
			}
			Scanner sc = new Scanner(System.in);
			int input = 0;
			reviewList();
			System.out.println(service.readReview().size() + 1 + ". 나가기");
			System.out.println("삭제할 리뷰를 선택해주세요");
			try{
				input = sc.nextInt();
				service.deleteReview(service.readReview().get(input - 1));
				System.out.println("리뷰 삭제에 성공했습니다!");
			} catch(IndexOutOfBoundsException e){
				System.out.println("올바른 입력 형태가 아닙니다.!");
				System.out.println("다시 시도해주세요!");
				return;
			} catch(InputMismatchException e){
				System.out.println("올바른 입력 형태가 아닙니다.!");
				System.out.println("다시 시도해주세요!");
				return;
			}		
		} while(true);
	}

	/**
	 * 선택한 영화의 리뷰 목록 출력
	 * @method 	reviewList
	 * @param	@param movie
	 * @return 	void
	 * @author 	PC-NEW02
	 * @since  	2020. 9. 3.오전 10:01:28
	 */
	private void reviewList() {
		int review_num = 0;
		for(ReviewVO review : service.readReview()) {
			review_num++;
			System.out.println("────────────────────────────────────");
			System.out.println("NO." + review_num);
			System.out.println("영화 제목 : " + review.getMovie_title());
			System.out.println("평점" + review.getReview_grade());
			System.out.println("작성자");
			System.out.println(review.getMem_id() + " : " + review.getReview_text());
			System.out.println("────────────────────────────────────");			
		}
		System.out.println("리뷰조회 종료");
	}
	//===========================================
	/*
	 * 회원관리
	 * managerMember()
	 * 들어오면 저장되어있는 회원의 이름이 번호가 부여되서 출력되고 해당 이름의 번호를 입력시
	 * 회원의 정보를 출력해주고 등급변경과 회원정보삭제 로 넘어감
	 * 
	 * 받아와야 되는 것 회원리스트및 정보
	 */
	/**
	 * 회원관리 작업매뉴 선택 View 메소드
	 * @return 
	 * 
	 */
	private void worklist() {
		do{
			Banner("회원 관리 작업 목록");
			System.out.println("1. 회원 정보");
			System.out.println("2. 회원 계정");
			System.out.println("3. 뒤로가기");
			System.out.print("번호를 선택해서 이동 : ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch(input){
			case 1:
				changeMemberinfor();
				break;
			case 2:
				memberActivestate();
				break;
			default:
				return;
			}
		}while(true);
	}
	
	
	
	/**
	 * 회원 정보 에서 수행할 작업 목록 출력 메서드
	 * 나중에 작업 추가를 생각해서 만듬
	 * 
	 * @since 2020-09-02
	 * @author 이상헌
	 */
	private void changeMemberinfor() {
		do{
			Banner("회원 정보 작업 목록");
			System.out.println("1. 회원 정보 조회");
			System.out.println("2. 뒤로가기");
			System.out.print("번호를 선택해서 이동 : ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch(input){
			case 1:
				selectMember();
				break;
			default:
				return;
			}
		}while(true);
	}
	
	
	/**
	 * 정보를 조회할 회원을 고르는 메소드
	 * 회원목록을 불러오고 번호를 선택할 수 있다.
	 * 
	 * @param 없음
	 * @author 이상헌
	 * @return void
	 */
	private void selectMember() {
		do{
			Banner("회원 목록");
			for (int memnum = 0; memnum < service.readMember().size(); memnum++) {
				if(service.readMember().get(memnum).getMem_rank() == "admin"){
					continue;
				}
				System.out.println(memnum + "번 : " + service.readMember().get(memnum).getMem_name());
			}
			System.out.println();
			System.out.println("뒤로가기 : 0 입력");
			System.out.print("조회할 회원의 번호를 입력해주세요 : ");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			
			if(input == 0){
				break;
			}else if(1 <= input && input <= (service.readMember().size()-1)){
				printMemberInfo(input);
				break;
			}else{
				System.out.print("조회할 회원의 번호를 다시 입력해주세요 : ");
				continue;
			}
			
		}while(true);
	}
	
	
	/**
	 * 선택한 회원의 정보를 출력해주는 메소드
	 * 
	 * @since 2020-09-03
	 * @author 이상헌
	 * @param int input
	 */
	private void printMemberInfo(int input){
		do{
			admin_View_memberlist(service.readMember().get(input));
			System.out.println();
			System.out.println("1. " + service.readMember().get(input).getMem_name() + "회원님의 등급변경");
			System.out.println("2. 뒤로가기");
			System.out.print("번호를 선택해서 이동 : ");
			Scanner sc = new Scanner(System.in);
			int selectwork = sc.nextInt();
			switch(selectwork){
			case 1:
				changeMemberRank(input);
				break;
			default:
				return;
			}
		}while(true);
		
	}
	
	
	
	/**
	 * 회원 등급 변경 메소드
	 * 이전의 selectChangeRankMember()에서 입력한 input의
	 * 값을 이용하여 변경할 회원을 찾고 등급을 입력한 값으로 바꿔준다
	 * 
	 * @since 2020-09-03
	 * @author 이상헌
	 * @param int input
	 */
	private void changeMemberRank(int input){
		System.out.println("현재" + service.readMember().get(input).getMem_name() + "님의 등급은 " +
								service.readMember().get(input).getMem_rank() + "입니다.");
		System.out.print("변경할 등급을 입력해주세요 : ");
		
		Scanner sc = new Scanner(System.in);
		String chrank = sc.nextLine();
		
		service.readMember().get(input).setMem_rank(chrank);
		System.out.println(service.readMember().get(input).getMem_name() + "님의 등급이 " +
				service.readMember().get(input).getMem_rank() + "로 변경되었습니다.");
		System.out.println();
	}
	
	
	/**
	 * 회원계정 작업 View 메소드
	 * 
	 * @author 이상헌
	 * @since 2020-09-03
	 */
	
	/*
	 * 회원 정보 수정 및 삭제
	 * cgran_Delete_Member(int num)
	 * 매개변수 int num은 회원관리 메인 메소드(managerMember())에서 입력받은 숫자를 기반으로
	 * 회원정보를 표시해준다.
	 * 
	 * 1. 회원 등급 변경
	 * 2. 회원 정보 삭제
	 * 3. 뒤로가기
	 * 
	 * 받아와야 하는 리스트 : readMember():관리자용 회원조회, readAllRes():관리자용 예약조회 메서드
	 * db에서 받아와야하는 메소드 deleteMember(MemberVO member):회원삭제
	 */
	
	
	/**
	 * 각 회원 계정의 활성화 상태를 보여주고
	 * 작업을 선택
	 * @author 이상헌
	 * @since 2020-09-03
	 */
	private void memberActivestate(){
//		List<MemberVO> member = member;
		do{
			Banner("회원별 계정 활성화 상태");
			
			for (int memnum = 0; memnum < service.readMember().size(); memnum++) {
				if(service.readMember().get(memnum).getMem_rank() == "admin"){
					continue;
				} else {
					System.out.print(memnum + "번 : " + service.readMember().get(memnum).getMem_name() + "\t계정 상태 : ");
					if(service.readMember().get(memnum).getDelete() == true){
						System.out.println("비활성");									
					} else {
						System.out.println("활성");
					}
				}
			}
			System.out.println();
			System.out.println("뒤로가기 : 0 입력");
			System.out.print("선택할 계정의 번호를 입력해주세요 : ");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			
			if(input == 0){
				break;
			}else if(1 <= input && input <= service.readPost().size()){
				changememberActivestate(input);
				break;
			}else{
				System.out.println("선택할 계정의 번호를 다시 입력해주세요.");
				continue;
			}
		}while(true);
	}
	
	
	/**
	 * 선택한 계정의 활성화 상태를 변경하는 메서드
	 * memberActivestate()에서 인덱스 값을 가져와서
	 * 계정을 선택하고 변경
	 * 
	 * @author 이상헌
	 * @since 2020-09-03
	 * @param int input
	 */
	
	private void changememberActivestate(int input) {
		do{
			System.out.print(service.readMember().get(input).getMem_name() + "\t계정 상태 : ");
			if(service.readMember().get(input).getDelete() == true){
				System.out.println("비활성");
				System.out.println();
				System.out.println("선택한 계정을 활성화 하시겠습니까? (y/n)");
			} else {
				System.out.println("활성");
				System.out.println();
				System.out.println("선택한 계정을 비활성화 하시겠습니까? (y/n)");
			}
			Scanner sc = new Scanner(System.in);
			String select = sc.nextLine();
			if(select.equalsIgnoreCase("y") || select.equalsIgnoreCase("Y")){
				service.deleteMember(service.readMember().get(input));
				break;
			}else if(select.equalsIgnoreCase("n") || select.equalsIgnoreCase("N")){
				System.out.println("작업을 취소하고 뒤로갑니다.");
				return;
			}else{
				System.out.println("조건에 맞게 정확하게 입력해주세요.");
				continue;
			}
		}while(true);
		
		
	}
	
	
	/**
	 * 관리자 모드에서 선택한 member의
	 * 회원의 정보를 출력해주는 메소드
	 * 
	 * @since 2020-09-02
	 * @author sangheon
	 * @param MemberVO member
	 * @return void
	 */
	private void admin_View_memberlist(MemberVO member){
		System.out.println("이름 : " + member.getMem_name());
		System.out.println("아이디 : " + member.getMem_id());
		System.out.println("보유 포인트? : " + member.getBudget());
		System.out.println("생년월일 : " + member.getMem_regno1());
		System.out.println("주소 : " + member.getMem_add());
		System.out.println("상세 주소 : " + member.getMem_add2());
		System.out.println("등급 : " + member.getMem_rank());
		System.out.println("전화번호 : " + member.getMem_hp());
	}
	
	/**
	 * 공지사항 작업 선텍 메소드
	 * 
	 * @author 이상헌
	 * @since 2020-09-03
	 */
	private void selectNoticeWork(){
		do{
			Banner("공지 사항");
			System.out.println("1. 공지사항 조회");
			System.out.println("2. 공지사항 추가");
			System.out.println("3. 뒤로가기");
			System.out.print("번호로 이동 : ");
			
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch(input){
			case 1:
				managerNotice();
				break;
				
			case 2:
				add_Notice();
				break;
			default:
				return;
			}
		}while(true);
	}
	
	/*
	 * 공지사항 관리를 위한 메인 메소드
	 * managerNotice()
	 * 
	 * 받아와야 하는 db메소드 : addPost(NoticeBoardVO notice):게시글추가,
	 * 				     deletePost(NoticeBoardVO notice):게시글 삭제,
	 * 		            	readPost():모든게시글 조회
	 */
	private void managerNotice(){
		do{
			Banner("공지 사항");
			
			for (int noticenum = 0; noticenum < service.readPost().size(); noticenum++) {
				System.out.println((noticenum+1) + "번 : " + service.readPost().get(noticenum).getBoard_title());
			}
			System.out.println((service.readPost().size()+1) + ". 뒤로가기");
			System.out.print("번호로 이동 : ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			if(1 <= input && input <= (service.readPost().size())){
				int input_2 = input-1;
				NoticeBoardVO notice = service.readPost().get(input_2);
				admin_View_Noticelist(notice);
				return;
			} else {
				return;
			}
			
		}while(true);	
	}
	
	/**
	 * 공지사항을 추가 메서드
	 * @author SNAGHEON
	 * 
	 */
	private void add_Notice(){
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		System.out.println("제목을 입력해 주세요 : ");
		String title = sc.nextLine();
		System.out.println("내용을 입력해 주세요 : ");
		String text = sc.nextLine();
		
		NoticeBoardVO notice = new NoticeBoardVO();
		notice.setBoard_no(service.readPost().size()+1);
		notice.setBoard_postDate(cal.getTime());
		notice.setBoard_text(text);
		notice.setBoard_title(title);
		notice.setBoard_views(21);
		notice.setMem_id("admin");
		notice.setDelete(false);
		service.addPost(notice);
		System.out.println("추가완료");
	}
	
	/**
	 * 관리자 모드에서 선택한 공지의
	 * 내용을 출력해주는 메소드
	 * @author 이상헌
	 * @since 2020-09-03
	 */
	
	private void admin_View_Noticelist(NoticeBoardVO notice){
		Banner(notice.getBoard_title());
		System.out.println("제목 : " + notice.getBoard_title());
		System.out.println("날짜 : " + notice.getBoard_postDate());
		System.out.println("내용 : " + notice.getBoard_text());
		System.out.println("조회수 : " + notice.getBoard_views());
		System.out.println();
		System.out.println("1. 공지사항 삭제");
		System.out.println("2. 뒤로가기");
		System.out.print("번호로 이동 : ");
		Scanner sc = new Scanner(System.in);
		int dbwl = sc.nextInt();
		if(dbwl == 2){
			return;
		} else {
			amin_View_Notice_Delete(notice);
		}
	}
	
	
	/**
	 * 공지사항을 삭제하는 메서드
	 */
	private void amin_View_Notice_Delete(NoticeBoardVO notice){
		service.deletePost(notice);
		System.out.println("삭제완료");
	}
}