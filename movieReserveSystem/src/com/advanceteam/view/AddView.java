package com.advanceteam.view;

import java.lang.reflect.Member;
import java.util.Calendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;





import com.advanceteam.vo.MemberVO;
import com.advanceteam.vo.MovieVO;
import com.advanceteam.service.*;
import com.advanceteam.database.*;
//import package_VO.MovieVO;

public class AddView {
	IServiceImpl sc = new IServiceImpl();
	Calendar cal = Calendar.getInstance();
	List<MemberVO> mem_manage = sc.readMember();
	boolean exit = true;
	Database db = new Database();
	Regex reg = new Regex();	
	
//	public void masterList(){				// 관리자 권한 리스트
//		do{
//			System.out.println("관리자 list");
//			System.out.println("1. 영화 관리");
//			System.out.println("2. 예매 관리");
//			System.out.println("3. 회원 관리");
//			System.out.println("4. 공지 사항");
//			System.out.println("5. 관리자 모드 종료");
//			Scanner sc = new Scanner(System.in);
//			int input = 0;
//			try {
//				input = sc.nextInt();
//			} catch (NumberFormatException e) {
//				System.out.println("! 목록에 해당하는 숫자만 입력하세요 !");
//				continue;
//			} catch (InputMismatchException e) {
//				System.out.println("! 목록에 해당하는 숫자만 입력하세요 !");
//				continue;
//			}
//
//			switch(input) {
//			case 1:
////				managerMove();		// 영화 관리 메소드
//				break;
//			case 2:
////				managerTicket();	// 예매 관리
//				break;
//			case 3:
//				managerMember();	// 회원 관리
//				break;
//			case 4:
//				managerNotice();	// 공지 사항
//				break;
//			default:
//				exit = true;
//				System.out.println("관리자 모드 종료");
//				break;
//			}
//			
//		} while(exit);
//	}
	public void adminList(){				// 관리자 권한 리스트
		do{
			System.out.println("\t관리자 list");
			System.out.println("1. 영화 관리");
			System.out.println("2. 예매 관리");
			System.out.println("3. 회원 관리");
			System.out.println("4. 공지 사항");
			System.out.println("5. 리뷰 관리");
			System.out.println("6. 나가기");
			Scanner sc = new Scanner(System.in);
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("찾으시는 메뉴는 해당 목록에 존재하지 않습니다.");
				continue;
			} catch (InputMismatchException e) {
				System.out.println("찾으시는 메뉴는 해당 목록에 존재하지 않습니다.");
				continue;
			}

			switch(input) {
			case 1:
				managerMove();					// 영화 관리
				break;
			case 2:
				managerTicket();				// 예매 관리
				break;
			case 3:
				System.out.println("회원관리에유");		//managerMember();	// 회원 관리
				managerMember();
				break;
			case 4:
				System.out.println("공지사항 관리에유");	//managerNotice();	// 공지 사항
				break;
			case 5:
				 managerNotice();					// 리뷰 관리
				break;
			case 6:									// adminList() 종료
				return;						
			default:
				System.out.println("찾으시는 메뉴는 해당 목록에 존재하지 않습니다.");		// 숫자 범위 넘어가면 default
				break;
			}
			
		} while(true);
	}
	
	private void managerMove() {						// 영화 관리
		do {
			System.out.println("\tMovie list");
			db.readMovie();								// DATABASE에서 영화 리스트를 가져옴..
			System.out.println("---------------------------------");
			System.out.println("1. 영화 추가");
			System.out.println("2. 영화 삭제");
			System.out.println("3. 나가기");
			Scanner sc = new Scanner(System.in);
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("찾으시는 메뉴는 해당 목록에 존재하지 않습니다.");
				continue;
			} catch (InputMismatchException e) {
				System.out.println("찾으시는 메뉴는 해당 목록에 존재하지 않습니다.");
				continue;
			}
			switch(input) {
			case 1 :
				managerMovieAdd();		// 영화 추가
				break;
			case 2 :
										// 영화 삭제
				break;
			case 3 :					// managerMove() 종료
				return;	
			default :
				System.out.println("찾으시는 메뉴는 해당 목록에 존재하지 않습니다.");
				break;
			}
		} while(true);
	}
	
	private void managerMovieAdd() {
		MovieVO movie = new MovieVO();
		do {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\tADD MOVIE");
			
			System.out.println("추가할 영화의 id를 입력해주세요");
			movie.setMovie_id(sc.nextLine());
			
			System.out.println("추가할 영화의 제목를 입력해주세요");
			movie.setMovie_title(sc.nextLine());
			
			System.out.println("추가할 영화의 장르를 입력해주세요");
			movie.setMovie_genre(sc.nextLine());
			
			System.out.println("추가할 영화의 감독를 입력해주세요");
			movie.setMovie_id(sc.nextLine());
			
			System.out.println("추가할 영화의 배우를 입력해주세요");
			try {
				movie.setMovie_id(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("등록 실패!");
				continue;
			} catch (InputMismatchException e) {
				System.out.println("등록 실패!");
				continue;
			}
			
			System.out.println("추가할 영화의 등급를 입력해주세요");
			try {
				movie.setMovie_ageGrade(sc.nextInt());
			} catch (NumberFormatException e) {
				System.out.println("등록 실패!");
				continue;
			} catch (InputMismatchException e) {
				System.out.println("등록 실패!");
				continue;
			}
			
			System.out.println("추가할 영화의 상영일를 입력해주세요");
			movie.setMovie_ageGrade(sc.nextInt());
			try {
				movie.setMovie_ageGrade(sc.nextInt());
			} catch (NumberFormatException e) {
				System.out.println("등록 실패!");
				continue;
			} catch (InputMismatchException e) {
				System.out.println("등록 실패!");
				continue;
			}
			
			System.out.println("추가할 영화의 상영종료일를 입력해주세요");
			movie.setMovie_ageGrade(sc.nextInt());
			
			System.out.println("추가할 영화의 가격를 입력해주세요");
			movie.setMovie_price(sc.nextInt());
			
			if(db.addMovie(movie)) {
				break;
			}
		} while(true);
	}
	
	private void managerTicket() {
		do {
			System.out.println("\tMovie list");
			db.readMovie();
			System.out.println("---------------------------------");
			System.out.println("정보를 조회할 영화의 번호를 입력해주세요.");
			Scanner sc = new Scanner(System.in);
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("찾으시는 메뉴는 해당 목록에 존재하지 않습니다.");
				continue;
			} catch (InputMismatchException e) {
				System.out.println("찾으시는 메뉴는 해당 목록에 존재하지 않습니다.");
				continue;
			}
		} while(true);
	}
	
	private void managerNotice() {
		do {
			System.out.println("\tMovie list");
			db.readMovie();
			System.out.println("---------------------------------");
			System.out.println("리뷰를 조회할 영화의 번호를 입력해주세요.");
			Scanner sc = new Scanner(System.in);
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("찾으시는 메뉴는 해당 목록에 존재하지 않습니다.");
				continue;
			} catch (InputMismatchException e) {
				System.out.println("찾으시는 메뉴는 해당 목록에 존재하지 않습니다.");
				continue;
			}
		} while(true);
	}
	
	//관리자 3번 메소드 ---------------------------------------------------------------------------------------
	private void managerMember() {
		
		while(true){
			System.out.println("----------------------");
			System.out.println("\t회원목록");
			System.out.println("----------------------");
			
			for (int memnum = 0; memnum < mem_manage.size(); memnum++) {
				if(mem_manage.get(0).getMem_name() == mem_manage.get(memnum).getMem_name()){
					continue;
				}else{
					System.out.println(memnum + "번 " + "회원이름 : \t" + mem_manage.get(memnum).getMem_name());
					System.out.println();
				}
			}
			
			System.out.println();
			System.out.println("확인할 회원 번호 입력");
			System.out.println("0 : 이전단계로");
			// 이상헌거 ㄴㄴ 이상한거 입력했을떄 예외처리 아직 이거 사용미숙해서 미완
			Scanner memindex = new Scanner(System.in);
			int cekmemindex = memindex.nextInt();
			int temp = 0;
			try {
				temp = cekmemindex;
				if(temp == 0){
					return;
				}
				cgrank_delete_Member(temp);
			}catch(NumberFormatException e) {
		    	System.out.println("! 목록에 해당하는 숫자만 입력하세요 !");
		    	continue;
		    }catch(InputMismatchException e){
		    	System.out.println("! 목록에 해당하는 숫자만 입력하세요 !");
		    	continue;
		    }catch(NullPointerException e){
		    	System.out.println("! 목록에 해당하는 숫자만 입력하세요 !");
		    }catch(IndexOutOfBoundsException e){
		    	System.out.println("! 목록에 해당하는 숫자만 입력하세요 !");
		    }
			return;
		}
		
	}

	private void read_Member_info(int num){ // 회원정보를 전부 가져오는 메서드
		
		List<MemberVO> mem_manage = sc.readMember();
		
		System.out.println("회원이름 : \t" + mem_manage.get(num).getMem_name());
		System.out.println("등급 : \t\t" + mem_manage.get(num).getMem_rank());
		System.out.println("아이디 : \t\t" + mem_manage.get(num).getMem_id());
		System.out.println("생년월일 : \t" + mem_manage.get(num).getMem_regno1());
		System.out.println("주소 : \t\t" + mem_manage.get(num).getMem_add());
		System.out.println("상세주소 : \t" + mem_manage.get(num).getMem_add2());
		System.out.println("핸드폰 번호 : \t" + mem_manage.get(num).getMem_hp());
		System.out.println("가입일 : \t" + cal.getTime());
		System.out.println();

	}
	
	private void cgrank_delete_Member(int num){ //등급변경, 회원삭제 선텍
		System.out.println("----------------------");
		System.out.println("  회원등급 변경 및 회원 삭제");
		System.out.println("----------------------");
		read_Member_info(num);
		
		System.out.println();
		System.out.println("1. 회원 등급 변경");
		System.out.println("2. 회원 삭제");
		System.out.println("3. 뒤로가기");
		Scanner seletnum = new Scanner(System.in);
		int sele = seletnum.nextInt();
		switch (sele) {
		case 1:
			chang_Mem_rank(num);
			break;
		case 2:
			delete_Mem(num);
			break;
		default:
			break;
		}
		
		
	}
	
	private void chang_Mem_rank(int num){ //회원 등급변경
		System.out.println("변경 전 등급 " + mem_manage.get(num).getMem_rank());
		System.out.println("변경할 등급을 적어주세요.");
		Scanner changerank = new Scanner(System.in);
		String chrank = changerank.next();
		mem_manage.get(num).setMem_rank(chrank);
		System.out.println();
		System.out.println(mem_manage.get(num).getMem_name() + " 회원님의 등급이 " + 
								mem_manage.get(num).getMem_rank() + "로 변경 되었습니다.");
		return;
	}
	
	private void delete_Mem(int num) { //회원삭제
		System.out.println("선택한 회원을 삭제합니다.");
		System.out.println("삭제되는 회원 이름 : " + mem_manage.get(num).getMem_name());
		mem_manage.remove(mem_manage.get(num));
	}
	// 관리자 3번 메소드 끝---------------------------------------------------------------------------------------
	
	// 관리자 4번 메소드----------------------------------------------------------------------------------------
//	private void managerNotice() {
//		// TODO  Auto-generated method stub
//		
//	}
	
	// 관리자 4번 메소드 끝-------------------------------------------------------------------------------------


}