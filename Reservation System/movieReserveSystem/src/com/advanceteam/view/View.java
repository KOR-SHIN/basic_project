package com.advanceteam.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.advanceteam.vo.MemberVO;
import com.advanceteam.vo.MovieVO;
import com.advanceteam.vo.ReserveVO;
import com.advanceteam.vo.ReviewVO;
import com.advanceteam.vo.SeatVO;
import com.advanceteam.vo.ShowVO;
import com.advanceteam.database.Database;
import com.advanceteam.service.*;

//광진이 형이 하던거
public class View {
	Database db = new Database();
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat signUpSdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	SimpleDateFormat showTimeSdf = new SimpleDateFormat("yy년 MM월 dd일 HH시mm분");
	IServiceImpl sv = new IServiceImpl();
	Regex rg = new Regex();
	Scanner sc = new Scanner(System.in);
	MemberVO member = new MemberVO();
	AddView addview = new AddView(sv);

	public void run() {
		while (true) {
			printHeader("GGV에 오신것을 환영합니다");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 나가기");

			System.out.print("번호를 입력해 이동 : ");

			int cmd = sc.nextInt();

			switch (cmd) {
			case 1:
				addMember(); // 회원가입
				break;
			case 2:
				logIn(); // 로그인
				break;
			case 3:
				System.out.println("종료 - 이용해주셔서 감사합니다.");
				System.exit(0); // 나가기
				break;
			default:
				System.out.println("메뉴번호를 정확히 입력하세요");
				break;
			}
		}
	}

	private static void printHeader(String text) {
		System.out.println("────────────────────────────────────");
		System.out.println(text);
		System.out.println("────────────────────────────────────");
	}

	/**
	 * 로그인 - 회원페이지 - 영화예매 영화예매하는 페이지
	 * 
	 * @author 신광진
	 * @see 2020-09-01 신광진 : 기존 영화예약 순서(영화선택 -> 시간선택 -> 좌석선택)를 한 단계로 줄임
	 */
	public boolean resMovie(MemberVO mem) {

		while (true) {
			// 상영중인 상영정보리스트를 가져오는 메서드
			List<ShowVO> showList = readShow();
			ReserveVO newRes = new ReserveVO();
			List<SeatVO> seatList = null;

			printHeader("\t상영 리스트");
			for (int i = 0; i < showList.size(); i++) {
				System.out.println("================================");
				System.out.println("No. " + (i + 1));
				System.out.println("영화제목 : " + showList.get(i).getMovie_title());
				System.out.println("상영관 : " + showList.get(i).getTheater_no() + "관");
				System.out.println("상영관 종류 : " + showList.get(i).getTheater_name());
				System.out.println("상영시간 : " + showTimeSdf.format(showList.get(i).getShow_date()));
				System.out.println("================================");
				System.out.println();
			}
			System.out.println("예매하고싶은 영화의 번호를 입력해주세요.");

			int cmd = 0;
			try {
				cmd = sc.nextInt() - 1;
				sc.nextLine();

				newRes.setMem_id(mem.getMem_id()); // 예약자 아이디
				newRes.setMovie_title(showList.get(cmd).getMovie_title()); // 영화제목
				newRes.setShow_no(showList.get(cmd).getShow_no()); // 상영번호
				newRes.setTheater_no(showList.get(cmd).getTheater_no()); // 상영관번호
			} catch (IndexOutOfBoundsException e) {
				System.out.println("<예매번호를 정확히 입력해주세요>");
				continue;
			}
			// 예약가능한 좌석을 보여준다.
			seatList = readSeat(showList.get(cmd).getShow_no());

			printHeader("\t예약가능 좌석정보");
			for (int i = 1; i < 11; i++) {
				System.out.print("\t" + i);
			}
			System.out.println();

			int cnt = 0;
			for (int i = 1; i < seatList.size() + 1; i++) { // 1~100 1일때찍고 10일때
															// 20일떄

				if (i % 10 == 1) {
					System.out.print((char) ('A' + cnt));
					cnt++;
				}

				if (seatList.get(i - 1).isSeat_use()) {
					System.out.print("\t■");
				} else {
					System.out.print("\t□");
				}
				if (i % 10 == 0) {
					System.out.println();
				}
			}

			String seat_row = null;
			int seat_col = 0;

			while (true) {
				System.out.println("<좌석행과 좌석열을 정확히 입력하세요>");
				System.out.println("예약하실 좌석행을 입력해주세요(ex : A) : ");
				seat_row = sc.next();

				System.out.println("예약하실 좌석행을 입력해주세요(ex : 1) : ");
				seat_col = sc.nextInt();
				sc.nextLine();

				if ((0 < seat_col && seat_col < 11) && ('A' <= seat_row.charAt(0) && seat_row.charAt(0) < 'K')) {
					break;
				}

			}

			// 사용자가 지정한 좌석을 block처리하기 위해 필요한 자료를 담는 Hash
			Map<String, String> info = new HashMap<String, String>();
			info.put("seat_row", seat_row);
			info.put("seat_col", Integer.toString(seat_col));
			info.put("show_no", Integer.toString(showList.get(cmd).getShow_no()));

			String seat_no = showList.get(cmd).getTheater_no() + "-" + seat_row.substring(0, 1) + seat_col;

			if (dupSeat(seat_no)) {
				System.out.println("이미 예악중인 좌석입니다.");
				return false;
			}

			setUseSeat(info); // 사용자가 지정한 좌석을 예약된 좌석으로 변경한다.

			newRes.setSeat_no(seat_no); // showList.get(cmd).getShow_no()
			newRes.setRes_no(newRes.getRes_sq()); // 예약번호 부여
			System.out.println(newRes.getRes_no());

			printHeader("\t예약정보 확인");
			if (!addRes(newRes)) {
				// 예약추가에 실패한 경우
				System.out.println("동일한 예약정보가 존재합니다.");
				return false;
			}

			System.out.println("예약이 완료되었습니다.");
			return true;

		}
	}

	/**
	 * 회원이 예약하려는 좌석이 이미 예약되어있는 좌석인지 확인함
	 * @author 신광진
	 * @param seat_no
	 */
	private boolean dupSeat(String seat_no) {
		return sv.dupSeat(seat_no);
	}

	/**
	 * 회원이 예약한 좌석을 예약된 좌석으로 상태를 변경함
	 * @author 신광진
	 * @param info
	 */
	private boolean setUseSeat(Map<String, String> info) {
		return sv.setUseSeat(info);
	}

	/**
	 * 현재 상영중인 영화리스트를 가져오는 메서드
	 * @author 신광진
	 * @return
	 */
	private List<ShowVO> readShow() {

		List<ShowVO> showList = sv.readShow();

		return showList;
	}

	/**
	 * 예약가능한 좌석을메서드 반환해주는
	 * 
	 * @author 신광진
	 */
	private List<SeatVO> readSeat(int show_no) {
		return sv.readSeat(show_no);
	}

	/**
	 * 매개변수로 받은 객체를 데이터베이스의 예약테이블에 추가하는 메서드
	 * 
	 * @author 신광진
	 */
	private boolean addRes(ReserveVO newRes) {

		if (sv.addRes(newRes)) {
			return true;
		}
		return false;

	}

	/**
	 * 회원의 예약정보가 예매 테이블에 존재하는지 확인하는 메서드
	 * @author 신광진
	 * @param mem_id
	 */
	private boolean readMemRes(String mem_id) {

		return sv.readMemRes(mem_id);
	}

	/**
	 * 회원정보 수정을 선택할 경우, 수정할 정보를 선택할 수 있는 페이지
	 * 
	 * @author 신광진
	 * @param mb
	 */
	private void infoRevise(MemberVO mb) {
		printHeader("\t" + mb.getMem_name() + "고객님의 회원정보");
		printMember(mb);
		System.out.println("1. 아이디 변경하기");
		System.out.println("2. 비밀번호 변경하기");
		System.out.println("3. 전화번호 변경하기");
		System.out.println("4. 주소 변경하기");
		System.out.println("5. 이름 변경하기");
		System.out.println("6. 뒤로가기");

		System.out.print("입력 : ");
		int cmd = sc.nextInt();

		switch (cmd) {

		case 1:
			reviseMemId(mb.getMem_id());
			break;

		case 2:
			reviseMemPw(mb.getMem_id());
			break;

		case 3:
			reviseMemHp(mb.getMem_id());
			break;

		case 4:
			reviseMemAdd(mb.getMem_id());
			break;

		case 5:
			reviseMemName(mb.getMem_id());
			break;
		default:
			break;
		}

		return;

	}

	// 회원정보 수정
	// 회원 아이디 변경 메서드
	private boolean reviseMemId(String mem_id) {
		String new_id = inputId();

		Map<String, String> info = new HashMap<String, String>();
		info.put("mem_id", mem_id);
		info.put("new_id", new_id);

		if (sv.reviseMemId(info)) {
			printHeader("\t 아이디 변경 안내");
			System.out.println("회원님의 아이디가 [" + new_id + "] 로 변경되었습니다.");
			return true;
		}
		System.out.println("아이디 변경에 실패하였습니다.");
		return false;
	}

	// 회원 비밀번호 변경 메서드
	private boolean reviseMemPw(String mem_id) {
		String new_pw = inputPw();

		Map<String, String> info = new HashMap<String, String>();
		info.put("mem_id", mem_id);
		info.put("new_pw", new_pw);

		if (sv.reviseMemPw(info)) {
			printHeader("\t 비밀번호 변경 안내");
			System.out.println("회원님의 비밀번호가 [ " + new_pw + "] 로 변경되었습니다.");
			return true;
		}
		System.out.println("비밀번호 변경에 실패하였습니다.");
		return false;

	}

	// 회원 전화번호 변경 메서드
	private boolean reviseMemHp(String mem_id) {
		String new_hp = inputHp();

		Map<String, String> info = new HashMap<String, String>();
		info.put("mem_id", mem_id);
		info.put("new_hp", new_hp);

		if (sv.reviseMemHp(info)) {
			printHeader("\t 전화번호 변경 안내");
			System.out.println("회원님의 전화번호가 [" + new_hp + "] 로 변경되었습니다.");
			return true;
		}
		System.out.println("전화번호 변경에 실패하였습니다.");
		return false;
	}

	// 회원 주소(상세주소 포함)변경 메서드
	private boolean reviseMemAdd(String mem_id) {
		String new_add = inputAdd();
		String new_add2 = inputAdd2();

		Map<String, String> info = new HashMap<String, String>();
		info.put("mem_id", mem_id);
		info.put("new_add", new_add);
		info.put("new_add2", new_add2);

		if (sv.reviseMemAdd(info)) {
			printHeader("\t 주소 변경 안내");
			System.out.println("회원님의 주소가 [" + new_add + new_add2 + "] 로 변경되었습니다.");
			return true;
		}
		System.out.println("주소 변경에 실패하였습니다.");
		return false;
	}

	// 회원이름 변경 메서드
	private boolean reviseMemName(String mem_id) {
		String new_name = inputName();

		Map<String, String> info = new HashMap<String, String>();
		info.put("mem_id", mem_id);
		info.put("new_name", new_name);

		if (sv.reviseMemName(info)) {
			printHeader("\t 이름 변경 안내");
			System.out.println("회원님의 주소지가 [" + new_name + "] 로 변경되었습니다.");
			return true;
		}
		System.out.println("이름 변경에 실패하였습니다.");
		return false;
	}

	// 회원 예약조회
	/**
	 * @author 신광진
	 * 회원의 예약정보를 조회하는 메서드
	 */
	private boolean lookMemRes(String mem_id) {

		while (true) {
			List<ReserveVO> resList = loadMemRes(mem_id);
			List<ShowVO> showList = readShow();

			printHeader("\t 예매정보조회 결과");
			if (resList.size() < 1) {
				System.out.println("예매정보가 존재하지 않습니다.");
				return false;
			}

			for (ReserveVO res : resList) {
				for (ShowVO show : showList) {
					if (show.getShow_no() == res.getShow_no()) { // 좌석도 출력해줘야할듯
						System.out.println("==============================");
						System.out.println("영화제목 : " + res.getMovie_title());
						System.out.println("상영관 : " + res.getTheater_no() + "관");
						System.out.println("좌석 : " + res.getSeat_no().substring(2));
						System.out.println("상영시간 : " + showTimeSdf.format(show.getShow_date()));
						System.out.println("==============================");
						System.out.println();
					}
				}
			}

			System.out.println("1. 예매취소");
			System.out.println("2. 뒤로가기");

			int cmd = sc.nextInt();
			sc.nextLine();

			if (cmd == 2) {
				return false;
			}

			printHeader("\t 예매취소 ");
			for (ReserveVO res : resList) {
				for (ShowVO show : showList) {
					if (show.getShow_no() == res.getShow_no()) { // 좌석도 출력해줘야할듯
						System.out.println("No. " + res.getRes_no());
						System.out.println("==============================");
						System.out.println("영화제목 : " + res.getMovie_title());
						System.out.println("상영관 : " + res.getTheater_no() + "관");
						System.out.println("좌석 : " + res.getSeat_no().substring(2));
						System.out.println("상영시간 : " + showTimeSdf.format(show.getShow_date()));
						System.out.println("==============================");
						System.out.println();
					}
				}
			}

			System.out.println("취소하고싶은 예매정보의 번호를 입력하세요.");

			try {
				cmd = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("<예매정보 번호를 정확히 입력하세요>");
				continue;
			}

			int res_no = 0;
			String seat_no = null;
			String show_no = null;

			try {
				res_no = resList.get(cmd).getRes_no();
				seat_no = resList.get(cmd).getSeat_no();
				show_no = Integer.toString(resList.get(cmd).getShow_no());
			} catch (IndexOutOfBoundsException e) {
				System.out.println("<예매정보 번호를 정확히 입력하세요>");
				continue;
			}
			Map<String, String> info = new HashMap<String, String>();
			info.put("seat_no", seat_no);
			info.put("show_no", show_no);

			if (!cencelSeat(info)) {
				System.out.println("Error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}

			printHeader("\t 예약취소 정보 안내");
			if (!deleteMemRes(res_no)) {
				System.out.println("예약취소를 실패하였습니다.");
				return false;
			}

			System.out.println("예약이 정상적으로 취소되었습니다.");
			return true;
		}
	}

	/**
	 * 회원이 예약을 취소했을경우, 회원이 예약했던 좌석을 예약가능 상태로 만드는 메서드 
	 * @param info
	 * key : seat_no, show_no
	 * value : seat_no, show_no
	 */
	private boolean cencelSeat(Map<String, String> info) {
		// TODO Auto-generated method stub
		return sv.cancelSeat(info);
	}

	/**
	 * 회원의 예약을 취소하는 메서드
	 * @param res_no
	 * @author 신광진
	 */
	public boolean deleteMemRes(int res_no) {
		return sv.deleteMemRes(res_no);
	}

	/**
	 * 회원의 예약정보 리스트를 가져오는 메서드
	 * 
	 * @author 신광진
	 * @param mem_id
	 */
	private List<ReserveVO> loadMemRes(String mem_id) {
		return sv.loadMemRes(mem_id);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 메인 - 로그인 - 회원페이지
	 * 
	 * @author 김선준
	 */
	private void pageMember(MemberVO mb) {
		while (true) {
			try {
				printHeader("\t" + mb.getMem_name() + "님 환영합니다!");
				System.out.println("1. 영화 예매하기");
				System.out.println("2. 내 정보 조회하기");
				System.out.println("3. 영화 리뷰");
				System.out.println("4. 로그아웃");

				System.out.print("번호를 입력해 이동 : ");

				int cmd = sc.nextInt();

				switch (cmd) {
				case 1:
					// 1. 영화 예매하기
					resMovie(mb);
					break;
				case 2:
					// 3. 내 정보 조회하기
					pageMyInfo(mb); // 인자값으로 회원객체
					break; // 뒤로가기
				case 3:
					// 4. 영화 리뷰보기
					pageReview(mb.getMem_id()); // 인자값으로 회원의 기본키
					break;
				case 4:
					return; // 로그아웃
				default:
					System.out.println("제대로 입력하세요");
					break;
				}
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 메인 - 로그인 - 회원페이지 - 마이페이지
	 * 
	 * @author 김선준
	 */
	private void pageMyInfo(MemberVO mb) {
		while (true) {
			try {
				printHeader("\t마이페이지");
				// 1. 회원정보 출력메소드
				printMember(mb);

				System.out.println("1. 내 정보 수정하기");
				System.out.println("2. 회원탈퇴");
				System.out.println("3. 예약조회");
				System.out.println("4. 뒤로가기");

				System.out.print("번호를 입력해 이동 : ");
				int cmd = sc.nextInt();

				switch (cmd) {
				case 1:
					infoRevise(mb); // 내정보 수정하기
					return;
				case 2:
					memOut(mb); // 회원탈퇴
					break;
				case 3:
					lookMemRes(mb.getMem_id()); // 예약조회
				default:
					return; // 뒤로가기
				}
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 메인 - 로그인 - 회원페이지 - 마이페이지 - 회원탈퇴창 회원탈퇴창 메소드
	 * 
	 * @author 김선준
	 */
	private void memOut(MemberVO mb) {
		while (true) {
			try {
				System.out.println("정말 회원을 탈퇴하시겠습니까?");
				System.out.println("1. 탈퇴하겠습니다.");
				System.out.println("2. 아니요");

				System.out.print("번호 입력 : ");
				switch (sc.nextInt()) {
				case 1:
					if (sv.deleteMember(mb)) {
						run();
					} else {
						System.out.println("탈퇴에 실패하였습니다.");
					}
					break;
				case 2:
					return;
				}
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 메인 - 로그인
	 * 
	 * @author 김선준
	 */
	private void logIn() {
		while (true) {
			try {
				printHeader("관리자 또는 회원으로 로그인");
				System.out.println("1. 관리자 로그인");
				System.out.println("2. 회원 로그인");
				System.out.println("3. 뒤로가기");

				System.out.print("번호를 입력해 이동 : ");
				int cmd = sc.nextInt(); // 후에 try-catch 처리

				switch (cmd) {
				case 1:
					// 1. 관리자 로그인
					admin_logInMember();
					break;
				case 2:
					// 2. 회원 로그인
					logInMember();
					break;
				case 3:
					return; // 뒤로가기
				default:
					System.out.println("제대로 입력하세요");
					break;
				}
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 회원으로 로그인하는 메소드
	 * 
	 * @author 김선준
	 */
	private void logInMember() {
		while (true) {
			try {
				String mem_id = logInId();// 아이디 입력받는 메소드 반환타입 String
				String mem_pw = logInPw();// 비밀번호 입력받는 메소드 반환타입 String
				Map<String, String> member = new HashMap<>();// 아이디와 패스워드를 담는
																// map
				member.put("mem_id", mem_id); // id를 담음
				member.put("mem_pw", mem_pw);// 위에서 if문돌려서 true면 회원페이지로 넘어가게

				if (sv.checkLogin(member)) { // 후에 교체
					MemberVO mb = sv.getMemberVO(mem_id);

					pageMember(mb); // 회원페이지로 이동
					return;
				} else {
					System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
				}
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}
	
	/**
	 * 관리자으로 로그인하는 메소드
	 * 
	 * @author 김선준
	 */
	private void admin_logInMember() {
		while (true) {
			try {
				String mem_id = logInId();// 아이디 입력받는 메소드 반환타입 String
				String mem_pw = logInPw();// 비밀번호 입력받는 메소드 반환타입 String
				Map<String, String> member = new HashMap<>();// 아이디와 패스워드를 담는
																// map
				member.put("mem_id", mem_id); // id를 담음
				member.put("mem_pw", mem_pw);// 위에서 if문돌려서 true면 회원페이지로 넘어가게

				if (sv.admin_checkLogin(member)) { // 후에 교체
					MemberVO mb = sv.getMemberVO(mem_id);

					addview.adminList();; // 회원페이지로 이동
					return;
				} else {
					System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
				}
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 로그인할 때 아이디를 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private String logInId() {
		while (true) {
			try {
				System.out.print("아이디를 입력해주세요 : ");
				String mem_id = sc.next(); // 입력받아서

				if (rg.checkId(mem_id)) { // 양식이 맞으면
					return mem_id; // 반환
				}
				System.out.println("※양식에 맞게 입력해주세요."); // 틀릴 시
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 로그인할 때 패스워드를 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private String logInPw() {
		while (true) {
			try {
				System.out.print("패스워드를 입력해주세요 : ");
				String mem_pw = sc.next(); // 입력받아서

				if (rg.checkPw(mem_pw)) { // 양식이 맞으면
					return mem_pw; // 반환
				}
				System.out.println("※양식에 맞게 입력해주세요."); // 틀릴 시
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 회원페이지에서 본인 정보만 불러올때 사용하는 메소드
	 * 
	 * @author 김선준
	 */
	private void printMember(MemberVO mb) {
		System.out.println("=== 회원 정보 ===");
		System.out.println("이름 : " + mb.getMem_name());
		System.out.println("전화번호 : " + mb.getMem_hp());
		System.out.println("보유 금액 : " + mb.getBudget());
		System.out.println("가입날짜 : "
				+ signUpSdf.format((mb.getMem_signUpDate())));
		System.out.println("회원님의 등급은 " + mb.getMem_rank() + "입니다.");
		System.out.println();
	}

	/**
	 * 메인 - 로그인 - 회원페이지 - 영화리뷰
	 * 
	 * @author 김선준
	 */
	private void pageReview(String mem_id) {
		while (true) {
			try {
				printHeader("영화 리뷰");
				System.out.println("1. 영화 리뷰 보기");
				System.out.println("2. 영화 리뷰 작성하기");
				System.out.println("3. 뒤로가기");

				System.out.print("입력 : ");
				int cmd = sc.nextInt();

				switch (cmd) {
				case 1:
					mvReview();
					break;
				case 2:
					writeReview(mem_id);
					break;
				case 3:
					return;
				default:
					System.out.println("제대로 입력하세요");
					break;
				}
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 영화 리뷰작성하는 페이지
	 * 
	 * @author 김선준
	 */
	private void writeReview(String mem_id) {
		List<ReserveVO> myList = loadMemRes(mem_id);
		if (myList.isEmpty()) {
			printHeader("상영이력 조회결과");
			System.out.println("관람했던 영화가 없어서 리뷰 작성이 불가합니다.");
			return;
		}
		while (true) {
			try {
				printHeader("관람했던 영화 목록");
				printMyMovie(mem_id);
				System.out.print("리뷰를 남기고 싶은 영화를 선택하세요 : ");
				int select = sc.nextInt() - 1; // 후에 try-catch 처리,
				// -1 해주는 이유 : 인덱스가 0부터시작이라 1눌렀을때 0번인덱스의 영화선택

				setReviewVO(select, mem_id);

				return;
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 리뷰볼 영화를 선택하는 페이지
	 * 
	 * @author 김선준
	 */
	private void mvReview() {
		List<MovieVO> mvList = sv.readMovie();
		if (mvList.isEmpty()) {
			System.out.println("영화 목록을 불러올 수 없습니다.");
			return;
		}
		while (true) {
			try {
				printHeader("번호를 선택해 영화 리뷰창으로 이동합니다");
				int i = 1;
				for (MovieVO movie : mvList) {
					System.out.println(i + ". " + movie.getMovie_title());
					i++;
				}
				System.out.println(i + ". 뒤로가기");

				System.out.print("입력 : ");
				int select = sc.nextInt();

				if (select == i) {
					return;
				} else if (select >= 1 && select <= mvList.size() + 1) {
					String movie_title = (mvList.get(select - 1))
							.getMovie_title();
					seeReview(movie_title);
				} else {
					System.out.println("제대로 입력하세요");
				}
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 리뷰보는 페이지
	 * 
	 * @author 김선준
	 */
	private void seeReview(String movie_title) {
		List<ReviewVO> rvList = sv.readReview();

		printHeader(movie_title);
		for (int i = 0; i < rvList.size(); i++) {
			ReviewVO rv = rvList.get(i);
			if (movie_title == rv.getMovie_title()) {
				System.out.println("==============================");
				System.out.print("평점 ");
				for (int j = 0; j < rv.getReview_grade(); j++) {
					System.out.print("★");
				}
				System.out.println("\n리뷰내용 : " + rv.getReview_text());
				System.out.println("작성자 : " + rv.getMem_id());
				System.out.println("==============================");
			}
		}

		while (true) {
			try {
				System.out.print("돌아가려면 1을 눌러주세요 :");
				int cmd = sc.nextInt();
				if (cmd == 1) {
					return;
				}
				System.out.println("돌아가려면 1을 눌러주세요");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 예매했던 영화들을 출력함
	 * 
	 * @author 김선준
	 */
	private void printMyMovie(String mem_id) {
		List<ReserveVO> myList = loadMemRes(mem_id);
		int i = 1;
		for (ReserveVO list : myList) {
			System.out.print(i + ". " + list.getMovie_title());
			System.out.println(" - 상영관 : " + list.getTheater_no());
			i++;
		}
	}

	/**
	 * 리뷰 객체 만들기 (새로운 리뷰 작성을 위한 객체)
	 * 
	 * @author 김선준
	 * @return
	 */
	public void setReviewVO(int select, String mem_id) {
		List<ReserveVO> myList = loadMemRes(mem_id); // 해당 회원의 예매기록을 가져옴
		ReviewVO rv = new ReviewVO(); // 리뷰객체 생성
		while (true) {
			try {
				String movie_title = myList.get(select).getMovie_title();
				String review_text = reviewWrite(); // 50자이내작성해서 옴
				int review_grade = reviewGrade(); // 평점입력받음

				rv.setReview_no(rv.getReview_no()); // 리뷰넘버
				rv.setMem_id(mem_id);
				rv.setMovie_title(movie_title);
				rv.setReview_text(review_text);
				rv.setReview_grade(review_grade);

				boolean check = sv.addReview(rv);
				if (check) {
					printHeader("리뷰작성 완료");
					System.out.println(movie_title + "의 리뷰가 등록되었습니다.");
					return;
				}
				System.out.println("리뷰 등록이 실패하였습니다.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 리뷰 작성
	 * 
	 * @author 김선준
	 */
	private String reviewWrite() {
		while (true) {
			try {
				printHeader("리뷰내용을 간단히 작성해주세요 (한글 50자 이내)");
				System.out.print("입력 : ");
				String write = sc.nextLine();
				if (rg.checkReview(write)) { // 정규식 메소드가 안됩니다
					return write;
				}
				System.out.println("50글자 이내로 작성해주세요");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 리뷰 평점 입력
	 * 
	 * @author 김선준
	 */
	private int reviewGrade() {
		while (true) {
			try {
				printHeader("평점을 입력해주세요 (1~5)");
				System.out.print("입력 : ");
				int grade = sc.nextInt();
				if (grade >= 1 && grade <= 5) {
					return grade;
				}
				System.out.println("1~5 사이로 입력해주세요");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 회원가입하는 메소드
	 * 
	 * @author 김선준
	 */
	private void addMember() {
		// 1. String 이름
		String mem_name = inputName();

		// 2. String 주민번호
		String mem_regno1 = inputRegno1();
		String mem_regno2 = inputRegno2();

		// 3. boolean 이미 가입했는지 확인
		// 있으면 if문으로 리턴시킴
		Map<String, String> map = new HashMap<>();
		map.put("mem_name", mem_name);
		map.put("mem_regno1", mem_regno1);
		map.put("mem_regno2", mem_regno2);
		boolean check = sv.memOverlapCheck(map);
		if (check) {
			System.out.println("※이미 가입된 회원ID가 있습니다.");
			return;
		}

		// 4. String 아이디, 패스워드
		String mem_id = inputId();
		String mem_pw = inputPw();

		// 5. String 휴대번호
		String mem_hp = inputHp();

		// 6. String 주소, 상세주소
		String mem_add = inputAdd();
		String mem_add2 = inputAdd2();

		// 7. int 예산
		int budget = inputBudget();

		// 8. memberVo 인스턴스화
		MemberVO member = new MemberVO();

		// 9. setter로 멤버객체에 위에서 받은 정보 다 set
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

		// 10. db에 메서드호출해서 객체 넘겨주고 boolean 반환
		sv.addMember(member);
		boolean result = sv.addMember(member);

		// 11. if로 가입성공, 실패 유무
		if (result) {
			System.out.println(mem_name + "고객님의 가입을 환영합니다!");
		} else {
			System.out.println("회원가입 실패");
		}
	};

	/**
	 * 회원가입 시 아이디를 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private String inputName() {
		while (true) {
			try {
				printHeader("(한글) 이름을 입력해주세요");
				System.out.print("입력 : ");
				String mem_name = sc.next();
				if (rg.checkName(mem_name)) { // 양식이 맞으면
					return mem_name;
				}
				System.out.println("");
				System.out.println("※양식에 맞게 입력해주세요.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 회원가입 시 주민번호 앞자리를 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private String inputRegno1() {
		while (true) {
			try {
				printHeader("주민등록번호 앞 6자리를 입력해주세요");
				System.out.print("입력 : ");
				String mem_regno1 = sc.next();
				if (rg.checkRegno1(mem_regno1)) { // 양식이 맞으면
					return mem_regno1;
				}
				System.out.println("");
				System.out.println("※양식에 맞게 입력해주세요.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 회원가입 시 주민번호 뒷자리를 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private String inputRegno2() {
		while (true) {
			try {
				printHeader("주민등록번호 뒷 7자리를 입력해주세요");
				System.out.print("입력 : ");
				String mem_regno2 = sc.next();
				if (rg.checkRegno2(mem_regno2)) { // 양식이 맞으면
					return mem_regno2;
				}
				System.out.println("");
				System.out.println("※양식에 맞게 입력해주세요.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 회원가입할때 ID 입력 시 이미 있는 ID인지 체크하는 메서드
	 * 
	 * @author 김선준
	 */
	private boolean idOverlapCheck(String mem_id) {
		List<MemberVO> memList = sv.readMember();
		boolean sameId = false; // 중복체크용
		// 중복체크
		for (int i = 0; i < memList.size(); i++) { // 리스트에 담긴 이름의 갯수만큼 반복
			if (mem_id.equals(memList.get(i).getMem_id())) { // 이름과 주민번호가 같은사람이
																// 이미 있으면
				sameId = true; // 중복이면 참
			}
		}
		if (sameId) { // 중복이었으면
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 회원가입 시 아이디를 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private String inputId() {
		while (true) {
			try {
				printHeader("아이디를 입력해주세요 \n(첫 문자는 영어, 5~15자리)");
				System.out.print("입력 : ");
				String mem_id = sc.next(); // 입력받아서

				if (rg.checkId(mem_id)) { // 양식이 맞으면
					if (idOverlapCheck(mem_id)) { // 아이디가 중복되면
						System.out.println("이미 존재하는 ID입니다");
					} else {
						return mem_id; // 반환
					}
				}
				System.out.println("");
				System.out.println("※양식에 맞게 입력해주세요."); // 틀릴 시
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}

		}
	}

	/**
	 * 회원가입 시 패스워드를 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private String inputPw() {
		while (true) {
			try {
				printHeader("패스워드를 입력해주세요 \n(대소문자구분없는 알파벳, 특수문자를 포함하는 4~11자리)");
				System.out.print("입력 : ");
				String mem_pw = sc.next(); // 입력받아서
				sc.nextLine();
				if (rg.checkPw(mem_pw)) { // 양식이 맞으면
					return mem_pw; // 반환
				}
				System.out.println("");
				System.out.println("※양식에 맞게 입력해주세요."); // 틀릴 시
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 회원가입 시 전화번호를 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private String inputHp() {
		while (true) {
			try {
				printHeader("전화번호를 입력해주세요");
				System.out.print("입력 : ");
				String mem_hp = sc.nextLine(); // 입력받아서
				if (rg.checkHp(mem_hp)) { // 양식이 맞으면
					return mem_hp; // 반환
				}
				System.out.println("");
				System.out.println("※양식에 맞게 입력해주세요."); // 틀릴 시
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("제대로 입력하세요");
			}
		}
	}

	/**
	 * 회원가입 시 주소를 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private String inputAdd() {
		printHeader("주소를 입력해주세요 (시.도/시.군.구/도로명)");
		System.out.print("입력 : ");
		String mem_add = sc.nextLine(); // 입력받아서
		return mem_add; // 반환
	}

	/**
	 * 회원가입 시 상세주소를 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private String inputAdd2() {
		printHeader("상세주소를 입력해주세요 (아파트/동/호 등)");
		System.out.print("입력 : ");
		String mem_add2 = sc.nextLine(); // 입력받아서
		return mem_add2; // 반환
	}

	/**
	 * 회원가입 시 보유금액을 입력받는 메소드
	 * 
	 * @author 김선준
	 */
	private int inputBudget() {
		printHeader("충전할 금액을 입력해주세요");
		System.out.print("입력 : ");
		int budget = sc.nextInt(); // 입력받아서
		return budget;
	}

}
