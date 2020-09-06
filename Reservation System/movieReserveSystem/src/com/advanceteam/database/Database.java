package com.advanceteam.database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.advanceteam.vo.*;

public class Database {

	/*
	 * 데이터베이스의 정보는 3년간 유효하다. 회원이 탈퇴하거나, 글을 지우거나 했다고해서 데이터베이스에서 삭제되면 안된다. 따라서
	 * VO에서 Boolean으로 삭제됐는지 안됐는지를 판단해야한다.
	 */

	private List<MemberVO> memberList = new ArrayList<MemberVO>();
	private List<MovieVO> movieList = new ArrayList<MovieVO>();
	private List<NoticeBoardVO> noticeList = new ArrayList<NoticeBoardVO>();
	private List<ReserveVO> reserveList = new ArrayList<ReserveVO>();
	private List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
	private List<SaleVO> saleList = new ArrayList<SaleVO>();
	private List<SeatVO> seatList = new ArrayList<SeatVO>();
	private List<ShowVO> showList = new ArrayList<ShowVO>();
	private List<TheaterVO> theaterList = new ArrayList<TheaterVO>();

	private List<ArrayList<SeatVO>> s_list = new ArrayList<ArrayList<SeatVO>>();
	Calendar cal = Calendar.getInstance();

	public Database() {
		// singleTon Pattern 적용전이기 때문에, 데이터베이스의 객체생성에 제한을 두지않는다.
	}

	{
		// ====initialize Member====
		MemberVO master = new MemberVO();
		master.setMem_name("관리자");
		master.setMem_id("admin");
		master.setMem_pw("system");
		master.setBudget(Integer.MAX_VALUE);
		master.setMem_regno1("890514");
		master.setMem_regno2("1XXXXXX");
		master.setMem_add("대전광역시");
		master.setMem_add2("유성 XXX");
		cal.set(2020, 7, 10);
		master.setMem_signUpDate(cal.getTime());
		master.setMem_rank("admin");
		master.setMem_auth("admin");
		master.setMem_hp("010-XXXX-XXXX");
		master.setDelete(false);
		memberList.add(master);

		MemberVO member_1 = new MemberVO();
		member_1.setMem_name("신광진");
		member_1.setMem_id("tlsrhkdwls23");
		member_1.setMem_pw("java");
		member_1.setBudget(100000);
		member_1.setMem_regno1("950130");
		member_1.setMem_regno2("1XXXXXX");
		member_1.setMem_add("대전광역시");
		member_1.setMem_add2("홍도동 XXX");
		member_1.setDelete(false);
		cal.set(2020, 8, 20);
		member_1.setMem_signUpDate(cal.getTime());
		member_1.setMem_rank("Diamond");
		member_1.setMem_auth("member");
		member_1.setMem_hp("010-5361-4713");
		memberList.add(member_1);

		MemberVO member_2 = new MemberVO();
		member_2.setMem_name("전수빈");
		member_2.setMem_id("wjstnqls23");
		member_2.setMem_pw("java");
		member_2.setBudget(100000);
		member_2.setMem_regno1("981230");
		member_2.setMem_regno2("1XXXXXX");
		member_2.setMem_add("대전광역시");
		member_2.setMem_add2("유성 XXX");
		member_2.setDelete(false);
		cal.set(2020, 9, 1);
		member_2.setMem_signUpDate(cal.getTime());
		member_2.setMem_rank("Diamond");
		member_2.setMem_auth("member");
		member_2.setMem_hp("010-1234-5678");
		memberList.add(member_2);

		MemberVO member_3 = new MemberVO();
		member_3.setMem_name("김선준");
		member_3.setMem_id("rlatjswns23");
		member_3.setMem_pw("java");
		member_3.setBudget(100000);
		member_3.setMem_regno1("960820");
		member_3.setMem_regno2("1XXXXXX");
		member_3.setMem_add("대전광역시");
		member_3.setMem_add2("홍제동 XXX");
		member_3.setDelete(false);
		cal.set(2020, 7, 30);
		member_3.setMem_signUpDate(cal.getTime());
		member_3.setMem_rank("Diamond");
		member_3.setMem_auth("member");
		member_3.setMem_hp("010-2321-4231");
		memberList.add(member_3);

		MemberVO member_4 = new MemberVO();
		member_4.setMem_name("이상헌");
		member_4.setMem_id("dltkdgjs23");
		member_4.setMem_pw("java");
		member_4.setBudget(100000);
		member_4.setMem_regno1("960314");
		member_4.setMem_regno2("1XXXXXX");
		member_4.setMem_add("대전광역시");
		member_4.setMem_add2("선화동 XXX");
		member_4.setDelete(false);
		cal.set(2020, 9, 1);
		member_4.setMem_signUpDate(cal.getTime());
		member_4.setMem_rank("Diamond");
		member_4.setMem_auth("member");
		member_4.setMem_hp("010-1352-3951");
		memberList.add(member_4);
	}

	{
		// ====initialize Movie====
		MovieVO movie_1 = new MovieVO();
		movie_1.setMovie_actor("황정민, 이정재");
		movie_1.setMovie_ageGrade(19);
		movie_1.setMovie_director("봉준호");
		movie_1.setMovie_genre("액션");
		cal.set(2020, 8, 15);
		movie_1.setMovie_open(cal.getTime());
		movie_1.setMovie_no(1);
		movie_1.setMovie_price(13000);
		movie_1.setMovie_runTime(130);
		movie_1.setMovie_title("다만 악에서 구하소서");
		movie_1.setDelete(false);
		movieList.add(movie_1);

		MovieVO movie_2 = new MovieVO();
		movie_2.setMovie_actor("이선균, 조여정");
		movie_2.setMovie_ageGrade(19);
		movie_2.setMovie_director("봉준호");
		movie_2.setMovie_genre("스릴러");
		cal.set(2020, 8, 10);
		movie_2.setMovie_open(cal.getTime());
		movie_2.setMovie_no(2);
		movie_2.setMovie_price(13000);
		movie_2.setMovie_runTime(150);
		movie_2.setMovie_title("기생충");
		movie_2.setDelete(false);
		movieList.add(movie_2);

		MovieVO movie_3 = new MovieVO();
		movie_3.setMovie_actor("드웨인 존슨");
		movie_3.setMovie_ageGrade(15);
		movie_3.setMovie_director("크리스토퍼 놀란");
		movie_3.setMovie_genre("액션");
		cal.set(2020, 8, 7);
		movie_3.setMovie_open(cal.getTime());
		movie_3.setMovie_no(3);
		movie_3.setMovie_price(13000);
		movie_3.setMovie_runTime(160);
		movie_3.setMovie_title("스카이 스크래퍼");
		movie_3.setDelete(false);
		movieList.add(movie_3);

		MovieVO movie_4 = new MovieVO();
		movie_4.setMovie_actor("최민식, 하정우");
		movie_4.setMovie_ageGrade(15);
		movie_4.setMovie_director("유상민");
		movie_4.setMovie_genre("범죄");
		cal.set(2020, 7, 30);
		movie_4.setMovie_open(cal.getTime());
		movie_4.setMovie_no(4);
		movie_4.setMovie_price(11000);
		movie_4.setMovie_runTime(150);
		movie_4.setMovie_title("범죄와의 전쟁");
		movie_4.setDelete(false);
		movieList.add(movie_4);

	}

	{
		// ====initialize NoticeBoard====

		NoticeBoardVO notice_1 = new NoticeBoardVO();
		notice_1.setBoard_no(1);
		notice_1.setBoard_postDate(cal.getTime());
		notice_1.setBoard_text("GGV 파격 할인 이벤트를 진행중입니다. 많은 참여 부탁드립니다");
		notice_1.setBoard_title("할인 이벤트 안내");
		notice_1.setBoard_views(21);
		notice_1.setMem_id("admin");
		notice_1.setDelete(false);
		noticeList.add(notice_1);

		NoticeBoardVO notice_2 = new NoticeBoardVO();
		notice_2.setBoard_no(2);
		notice_2.setBoard_postDate(cal.getTime());
		notice_2.setBoard_text("다만 악에서 구하소서 굿즈를 판매합니다. 많은 사랑 부탁드립니다.");
		notice_2.setBoard_title("다만 악에서 구하소서 굿즈안내");
		notice_2.setBoard_views(222);
		notice_2.setMem_id("admin");
		notice_2.setDelete(false);
		noticeList.add(notice_2);

		NoticeBoardVO notice_3 = new NoticeBoardVO();
		notice_2.setBoard_no(3);
		notice_3.setBoard_postDate(cal.getTime());
		notice_3.setBoard_text("Lol Champions League 상영관 이벤트를 진행중입니다.");
		notice_3.setBoard_title("롤챔스 상영관 이벤트 안내");
		notice_3.setBoard_views(4231);
		notice_3.setMem_id("admin");
		notice_3.setDelete(false);
		noticeList.add(notice_3);

		NoticeBoardVO notice_4 = new NoticeBoardVO();
		notice_4.setBoard_no(4);
		notice_4.setBoard_postDate(cal.getTime());
		notice_4.setBoard_text("GGV는 매일 방역을 하고있습니다. 안심하고 이용해주세요.");
		notice_4.setBoard_title("코로나 방역조치 관련 안내");
		notice_4.setBoard_views(23);
		notice_4.setDelete(false);
		notice_4.setMem_id("admin");
		noticeList.add(notice_4);
	}

	{
		// ====initialize Theater====
		TheaterVO theater_1 = new TheaterVO();
		theater_1.setTheater_no(1);
		theater_1.setTheater_price(5000);
		theater_1.setDelete(false);
		theater_1.setTheater_name("2D");
		theaterList.add(theater_1);

		TheaterVO theater_2 = new TheaterVO();
		theater_2.setTheater_no(2);
		theater_2.setTheater_price(6000);
		theater_2.setDelete(false);
		theater_2.setTheater_name("3D");
		theaterList.add(theater_2);

		TheaterVO theater_3 = new TheaterVO();
		theater_3.setTheater_no(3);
		theater_3.setTheater_price(1000);
		theater_3.setDelete(false);
		theater_3.setTheater_name("4D");
		theaterList.add(theater_3);

		TheaterVO theater_4 = new TheaterVO();
		theater_3.setTheater_no(4);
		theater_4.setTheater_price(3500);
		theater_4.setDelete(false);
		theater_4.setTheater_name("IMAX");
		theaterList.add(theater_4);
	}

	{
		// ====initialize Sale
		SaleVO sale_1 = new SaleVO();
		sale_1.setSale_id("child");
		sale_1.setSale_price(-7000);

		SaleVO sale_2 = new SaleVO();
		sale_2.setSale_id("coupon");
		sale_2.setSale_price(-5000);

		SaleVO sale_3 = new SaleVO();
		sale_3.setSale_id("lateNight");
		sale_3.setSale_price(-2000);

		SaleVO sale_4 = new SaleVO();
		sale_4.setSale_id("morning");
		sale_4.setSale_price(-3000);

		SaleVO sale_5 = new SaleVO();
		sale_5.setSale_id("senior");
		sale_5.setSale_price(-8000);

		SaleVO sale_6 = new SaleVO();
		sale_6.setSale_id("teenager");
		sale_6.setSale_price(-4000);
	}

	{
		// ====initialize Seat====

		// 영화관의 행은 A~J까지 존재하며, 열을 10번까지 존재한다.

		// 현재 상영관은 1~4까지있다.

		for (int row = 1; row < 11; row++) {
			for (int col = 1; col < 11; col++) {

				SeatVO seat = new SeatVO();

				seat.setSeat_row(row);
				seat.setSeat_col(col);
				seat.setShow_no(1);
				seat.setSeat_use(false);
				seat.setSeat_no(1 + "-" + seat.getSeat_row()
						+ seat.getSeat_col());
				// seat_no는 "1(상영관번호)-A1"의 형식으로 저장된다.
				// seat.getSeat_row() + seat.getSeat_col() +
				// seat.getShow_no()
				seatList.add(seat);
			}
		}

		for (int row = 1; row < 11; row++) {
			for (int col = 1; col < 11; col++) {

				SeatVO seat = new SeatVO();

				seat.setSeat_row(row);
				seat.setSeat_col(col);
				seat.setShow_no(2);
				seat.setSeat_use(false);
				seat.setSeat_no(2 + "-" + seat.getSeat_row()
						+ seat.getSeat_col());
				seatList.add(seat);
			}
		}

		for (int row = 1; row < 11; row++) {
			for (int col = 1; col < 11; col++) {

				SeatVO seat = new SeatVO();

				seat.setSeat_row(row);
				seat.setSeat_col(col);
				seat.setShow_no(3);
				seat.setSeat_use(false);
				seat.setSeat_no(3 + "-" + seat.getSeat_row()
						+ seat.getSeat_col());

				seatList.add(seat);
			}
		}

		for (int row = 1; row < 11; row++) {
			for (int col = 1; col < 11; col++) {

				SeatVO seat = new SeatVO();

				seat.setSeat_row(row);
				seat.setSeat_col(col);
				seat.setShow_no(4);
				seat.setSeat_use(false);
				seat.setSeat_no(4 + "-" + seat.getSeat_row()
						+ seat.getSeat_col());

				seatList.add(seat);
			}
		}

	}

	{
		// ====initialize Show====
		ShowVO show_1 = new ShowVO();
		show_1.setMovie_title("다만 악에서 구하소서");
		cal.set(2020, 8, 19, 18, 40);
		show_1.setShow_date(cal.getTime());
		show_1.setShow_no(1);
		show_1.setTheater_no(1);
		show_1.setDelete(false);
		show_1.setTheater_name("2D");
		showList.add(show_1);

		ShowVO show_2 = new ShowVO();
		show_2.setMovie_title("기생충");
		cal.set(2020, 8, 16, 19, 20);
		show_2.setShow_date(cal.getTime());
		show_2.setShow_no(2);
		show_2.setTheater_no(2);
		show_2.setDelete(false);
		show_2.setTheater_name("3D");
		showList.add(show_2);

		ShowVO show_3 = new ShowVO();
		show_3.setMovie_title("스카이 스크래퍼");
		cal.set(2020, 8, 21, 22, 5);
		show_3.setShow_date(cal.getTime());
		show_3.setShow_no(3);
		show_3.setTheater_no(3);
		show_3.setDelete(false);
		show_3.setTheater_name("4D");
		showList.add(show_3);

		ShowVO show_4 = new ShowVO();
		show_4.setMovie_title("범죄와의 전쟁");
		cal.set(2020, 8, 30, 24, 20);
		show_4.setShow_date(cal.getTime());
		show_4.setShow_no(4);
		show_4.setTheater_no(4);
		show_4.setDelete(false);
		show_4.setTheater_name("4D");
		showList.add(show_4);

		// 4관 비워놓음

	}

	{
		// ====initialize Review====
		ReviewVO review_1 = new ReviewVO();
		review_1.setMem_id("shinkwang23");
		review_1.setMovie_title("기생충");
		review_1.setReview_no(1);
		review_1.setReview_grade(4);
		review_1.setReview_hate(0);
		review_1.setReview_like(132);
		review_1.setReview_text("너무 재밌습니다. 봉준호 감독 최고!!");
		review_1.setDelete(false);
		reviewList.add(review_1);

		ReviewVO review_2 = new ReviewVO();
		review_2.setMem_id("shinkwang23");
		review_2.setMovie_title("다만 악에서 구하소서");
		review_2.setReview_no(2);
		review_2.setReview_grade(1);
		review_2.setReview_hate(11);
		review_2.setReview_like(1332);
		review_2.setReview_text("황정민, 이정재 연기력 최고");
		review_2.setDelete(false);
		reviewList.add(review_2);

		ReviewVO review_3 = new ReviewVO();
		review_3.setMem_id("wjstnqls23");
		review_3.setMovie_title("범죄와의 전쟁");
		review_3.setReview_no(3);
		review_3.setReview_grade(4);
		review_3.setReview_hate(0);
		review_3.setReview_like(132);
		review_3.setReview_text("너무 재밌습니다. 하정우 짱");
		review_3.setDelete(false);
		reviewList.add(review_3);

		ReviewVO review_4 = new ReviewVO();
		review_4.setMem_id("shinkwang23");
		review_4.setMovie_title("기생충");
		review_4.setReview_no(4);
		review_4.setReview_grade(4);
		review_4.setReview_hate(222);
		review_4.setReview_like(41);
		review_4.setReview_text("너무 재미없어요.");
		review_4.setDelete(false);
		reviewList.add(review_4);
	}

	// member Method - 새로운 멤버를 회원테이블에 추가하는 메서드
	public boolean addMember(MemberVO member) {

		// View class에서 이름과 주민등록번호를 통해 가입여부를 판단하고 넘어온다.
		memberList.add(member);
		return true;
	}

	/**
	 * 회원의 아이디 활성화 비활성화 메서드 MemberVO member 의 인자값을 받으면 memberList에서 member의 인덱스
	 * 번호를 저장하고. 해당 인덱스 위치에 ArrayList에 저장되어있는 setDelete의 값이 true 이면 false로 바꿔주고
	 * false 이면 true값으로 바꿔준다.
	 * 
	 * @since 2020-09-02
	 * @author sangheon
	 * @param member
	 * @return
	 */
	public boolean deleteMember(MemberVO member) {

		for (MemberVO mem : memberList) {
			if (mem.getMem_id().equals(member.getMem_id())) {
				int memberListindex = memberList.indexOf(member);
				if (memberList.get(memberListindex).getDelete() == false) {
					memberList.get(memberListindex).setDelete(true);
				} else {
					memberList.get(memberListindex).setDelete(false);
				}
				return true;
			}
		}
		return false;
	}

	// member Method - 회원가입하기 위한 아이디가 중복되는지 검사하는 메서드 (중복되는 경우 true를 반환한다)
	public boolean isDuplicated(MemberVO member) {

		for (MemberVO mem : memberList) {
			if (member.getMem_id().equals(mem.getMem_id())) {
				return true;
			}
		}

		return false;
	}

	// login Method - 로그인 허용 메서드 (멤버테이블에 추가되어 있는 멤버인 경우 true를 반환하고 멤버테이블에 없는 경우
	// false를 반환한다)
	public boolean logIn(MemberVO member) {

		for (MemberVO mem : memberList) {
			if (member.getMem_id().equals(mem.getMem_id())
					&& member.getMem_pw().equals(mem.getMem_pw())) {
				return true;
			}
		}
		return false;
	}

	// memberMethod - 회원조회 메서드 (관리자용 메서드로, 멤버테이블에 있는 삭제되지 않은 멤버의 리스트를 반환한다)
	public List<MemberVO> readMember() {

		List<MemberVO> retList = new ArrayList<MemberVO>();

		for (MemberVO member : memberList) {
			// 탈퇴하지 않은 회원만 return한다.
			if (member.isDelete() == false) {
				retList.add(member);
			}
		}
		return retList;
	}
	
//	// memberreadname method
//	public List<MemberVO> readMembername() { 
//		List<MemberVO> retList = new ArrayList<MemberVO>();
//		for (MemberVO member : memberList) {
//			// 탈퇴하지 않은 회원만 return한다.
//			if (member.isDelete() == false) {
//				retList.add(member.getMem_name());
//			}
//		}
//		return retList;
//	}

	// Member Method - 회원아이디를 변경하는 메서드
	public boolean reviseMemId(Map<String, String> info) {
		String mem_id = info.get("mem_id");
		String new_id = info.get("new_id");

		MemberVO mem = null;

		for (MemberVO m : memberList) {
			if (m.getMem_id().equals(mem_id)) {
				mem = m;
				break;
			}
		}

		if (mem != null) {
			mem.setMem_id(new_id);
			return true;
		}

		return false;
	}

	// Member Method - 회원 비밀번호를 변경하는 메서드
	public boolean reviseMemPw(Map<String, String> info) {
		String mem_id = info.get("mem_id");
		String new_pw = info.get("new_pw");

		MemberVO mem = null;

		for (MemberVO m : memberList) {
			if (m.getMem_id().equals(mem_id)) {
				mem = m;
				break;
			}
		}

		if (mem != null) {
			mem.setMem_pw(new_pw);
			return true;
		}

		return false;
	}

	// Member Method - 회원 전화번호를 변경하는 메서드
	public boolean reviseMemHp(Map<String, String> info) {
		String mem_id = info.get("mem_id");
		String new_hp = info.get("new_hp");

		MemberVO mem = null;

		for (MemberVO m : memberList) {
			if (m.getMem_id().equals(mem_id)) {
				mem = m;
				break;
			}
		}

		if (mem != null) {
			mem.setMem_hp(new_hp);
			return true;
		}

		return false;
	}

	// Member Method - 회원 주소지를 변경하는 메서드
	public boolean reviseMemAdd(Map<String, String> info) {
		String mem_id = info.get("mem_id");
		String new_add = info.get("new_add");
		String new_add2 = info.get("new_add2");

		MemberVO mem = null;

		for (MemberVO m : memberList) {
			if (m.getMem_id().equals(mem_id)) {
				mem = m;
				break;
			}
		}

		if (mem != null) {
			mem.setMem_add(new_add);
			mem.setMem_add(new_add2);
			return true;
		}

		return false;
	}

	// Member Method - 회원이름을 변경하는 메서드
	public boolean reviseMemName(Map<String, String> info) {
		String mem_id = info.get("mem_id");
		String new_name = info.get("new_name");

		MemberVO mem = null;

		for (MemberVO m : memberList) {
			if (m.getMem_id().equals(mem_id)) {
				mem = m;
				break;
			}
		}

		if (mem != null) {
			mem.setMem_name(new_name);
			return true;
		}

		return false;
	}

	// Movie Method - 영화등록 메서드 (새로운 영화를 추가하는 메서드, 영화추가에 성공하면 true, 실패하면 false를
	// 반환한다.)
	public boolean addMovie(MovieVO movie) {

		for (MovieVO mv : movieList) {
			// 기존의 영화리스트에 추가되어 있는 영화인지 검사한다.
			if (mv.getMovie_no() == movie.getMovie_no()) {
				// System.out.println("영화등록에 실패했습니다.");
				// System.out.println("이미 등록되어 있는 영화입니다.");
				return false;
			}
		}
		movieList.add(movie);
		return true;
	}

	// Movie Method - 영화조회 메서드 (관리자용 메서드로서, 현재 추가되어 있는 영화 리스트를 반환한다)
	public List<MovieVO> readMovie() {

		List<MovieVO> ret = new ArrayList<MovieVO>();

		for (MovieVO mv : movieList) {
			// 기존의 영화 리스트에서 삭제되지 않은 리스트만을 새로운 리스트에 저장해서 반환한다.
			if (mv.isDelete() == false) {
				ret.add(mv);
			}
		}

		// View class에서 ret.isEmpty()를 수행하여 반환결과가 true라면 상영중인 영화가 없다는 메세지를 띄워준다.
		return ret;
	}

	// Movie Method - 영화삭제 메서드 (관리자용 메서드로서, 특정 영화를 삭제하는 경우 사용한다. 삭제에 성공하면 true,
	// 실패하면 false를 리턴한다)
	public boolean deleteMovie(MovieVO movie) {

		for (MovieVO mv : movieList) {
			// 삭제하고자 하는 영화가 등록되어 있는 영화인지 검사한다.
			if (movie.getMovie_no() == mv.getMovie_no()) {
				movieList.remove(movie);
				// System.out.println(movie.getMovie_title() + "을 삭제하였습니다.");
				return true;
			}
		}

		// System.out.println("등록되어 있지 않은 영화입니다.");
		return false;
	}

	// Review Method - 새로운 한줄평을 등록하는 메서드 (한줄평 등록에 성공하면 true, 실패하면 false를 반환한다)
	public boolean addReview(ReviewVO review) {

		for (ReviewVO re : reviewList) {
			// 기존의 reviewList에서 파라미터로 받은 review의 회원id, 영화id, 리뷰번호가 같은 객체가 있는지
			// 확인한다.
			// 기존 reviewList에 동일한 정보를 가진 객체가 있는 경우 리뷰등록에 실패한다.
			if (re.getMem_id().equals(review.getMem_id())
					&& re.getMovie_title().equals(review.getMovie_title())
					&& re.getReview_no() == review.getReview_no()) {
				// System.out.println("해당 영화에 대한 리뷰를 이미 작성하셨습니다.");
				return false;
			}
		}
		reviewList.add(review);
		System.out.println(review.getMovie_title() + " 영화에 대한 한줄평 등록에 성공했습니다.");
		return true;

	}

	//

	// Review Method - 기존의 리뷰를 조회하는 메서드 (관리자용 메서드로서, 삭제되지 않은 모든 리뷰를 반환한다)
	public List<ReviewVO> readReview() {

		List<ReviewVO> ret = new ArrayList<ReviewVO>();
		// 기존의 reivewList에서 삭제되지 않은 review만을 저장해서 리스트로 반환한다.
		for (ReviewVO re : reviewList) {
			if (re.isDelete() == false) {
				ret.add(re);
			}
		}

		return ret;
	}

	// Review Method - 기존의 리뷰를 삭제하는 메서드
	public boolean deleteReview(ReviewVO review) {

		for (ReviewVO re : reviewList) {
			// 기존의 reviewList에서 파라미터로 받은 review의 mem_id, movie_id, reivew_no가 같은
			// 객체가 있는지 확인하고, 존재한다면 해당 리뷰를 reviewList에서 삭제한다.
			if (re.getMem_id().equals(review.getMem_id())
					&& re.getMovie_title().equals(review.getMovie_title())
					&& re.getReview_no() == review.getReview_no()) {

				reviewList.remove(review);
				// System.out.println("리뷰삭제를 성공하였습니다.");
				return true;
			}
		}

		// System.out.println("등록되어 있지 않은 리뷰입니다.");
		return false;
	}

	// Review Method - 파라미터로 받은 영화의 movie_id와 일치하는 movie_id를 가진 객체만을 리스트로 반환한다.
	public List<ReviewVO> readMovieReview(MovieVO movie) {

		List<ReviewVO> ret = new ArrayList<ReviewVO>();

		for (ReviewVO re : reviewList) {
			// reviewVO의 외래키 movie_id를 이용하여, 기존의 reviewList에서
			// 파라미터로 받은 movie_id와 일치하는 review 객체만을 리스트에 추가한다.
			if (re.getMovie_title().equals(movie.getMovie_title())) {
				ret.add(re);
			}
		}

		return ret;

	}

	// Theater Method - 상영관정보를 추가하는 메서드
	public boolean addTheater(TheaterVO theater) {

		for (TheaterVO th : theaterList) {
			// 파라미터로 받은 상영관정보가 기존의 theaterList에 존재한다면 추가하지 않는다.
			if (th.getTheater_no() == theater.getTheater_no()) {
				// System.out.println("이미 추가되어 있는 상영관입니다.");
				return false;
			}
		}

		// System.out.println("상영관 추가에 성공하였습니다.");
		return true;
	}

	// Theater Method - 현재 등록되어 있는 상영관을 리스트로 반환하는 메서드
	public List<TheaterVO> readTheater() {
		List<TheaterVO> ret = new ArrayList<TheaterVO>();

		for (TheaterVO th : theaterList) {
			// 삭제되지 않은 상영관 객체만을 리스트로 반환한다.
			if (th.isDelete() == false) {
				ret.add(th);
			}
		}

		return ret;
	}

	// Theater Method - 상영관 삭제메서드
	public boolean deleteTheater(TheaterVO theater) {

		for (TheaterVO th : theaterList) {
			// 기존의 theaterList에서 파라미터로 받은 theater와 같은 정보를 가지는
			// 객체를 조회하여, 존재하면 해당 객체를 theaterList에서 삭제한다.
			if (th.getTheater_no() == theater.getTheater_no()) {
				// System.out.println("상영관 삭제를 성공하였습니다.");
				theaterList.remove(theater);
				return true;
			}
		}

		return false;

	}

	// Show Method - 상영 영화 추가 메서드
	public boolean addShow(ShowVO show) {

		for (ShowVO sh : showList) {
			if (show.getShow_no() == sh.getShow_no()) {
				// && show.getMovie_id().equals(sh.getMovie_id())
				// && show.getShow_date().equals(sh.getShow_date())
				// && show.getTheater_id().equals(sh.getTheater_id())) {
				// System.out.println("이미 상영등록이 되어있습니다.");
				return false;
			}
		}

		return true;
	}

	// Show Method - 상영 영화 리스트 조회 메서드
	public List<ShowVO> readShow() {

		List<ShowVO> ret = new ArrayList<ShowVO>();

		for (ShowVO show : showList) {
			// 기존의 showList에서 삭제되지 않은 객체들을 리스트로 반환한다.
			if (show.isDelete() == false) {
				ret.add(show);
			}
		}

		return ret;
	}

	// Reserve Method - 예약을 추가하는 메서드 (회원이 영화를 예매하면 reserveList에 추가해준다)
	public boolean addRes(ReserveVO newRes) {

		for (ReserveVO res : reserveList) {
			// 예약테이블에 일치하는 예약정보가 없는 경우 추가한다.
			if (newRes.getRes_no() == res.getRes_no()) {
				return false;
			}
		}
		reserveList.add(newRes);

		return true;
	}

	// Reserve Method - 예약을 취소하는 메서드
	public boolean deleteMemRes(int res_no) {

		ReserveVO res = null;
		for (int i = 0; i < reserveList.size(); i++) {
			if (reserveList.get(i).getRes_no() == res_no) {
				reserveList.remove(i);
				return true;
			}
		}

		return false;
	}

	// Reserve Method - 예약을 조회하는 메서드 (관리자용 메서드, 모든 예약정보를 리스트로 반환함)
	public List<ReserveVO> readAllRes() {
		List<ReserveVO> ret = new ArrayList<ReserveVO>();

		for (ReserveVO res : reserveList) {
			if (res.isDelete() == false) {
				ret.add(res);
			}
		}

		return ret;
	}

	// Reserve Method - 예약을 조회하는 메서드(reserveList에서 회원 id를 조회하여 예약이 되어있는지 확인해준다.)
	public boolean readMemRes(String mem_id) {

		for (ReserveVO res : reserveList) {
			if (res.getMem_id().equals(mem_id)) {
				return true;
			}
		}
		return false;
	}

	// Reserve Method - 고객의 예약정보를 담은 객체를 반환해준다
	public List<ReserveVO> loadMemRes(String mem_id) {

		List<ReserveVO> ret = new ArrayList<ReserveVO>();

		for (ReserveVO res : reserveList) {
			if (res.getMem_id().equals(mem_id)) {
				ret.add(res);
			}
		}

		return ret;
	}

	// noticeBoard Method - 새로운 게시글을 추가하는 메서드 (게시글은 중복되어 상관없으므로 무조건 추가된다)
	public boolean addPost(NoticeBoardVO notice) {
		noticeList.add(notice);
		return true;
	}

	// noticeBoard Method - 기존의 noticeList에 존재하는 게시글 중에 파라미터로 받은 게시글과
	// notice_no가 같은 게시글을 삭제한다.
	/**
	 * noticeBoard Method - 기존의 noticeList에 존재하는 게시글 중에 파라미터로 받은 게시글과
	 * notice_no가 같은 게시글을 삭제한다.
	 * @author SANGHEON
	 * @param notice
	 * @return
	 * @see noticeList.remove(notice.getBoard_no()); 
	 * 		-> noticeList.remove(notice);  
	 * 
	 */
//	public boolean deletePost(NoticeBoardVO notice) {
//
//		for (NoticeBoardVO nb : noticeList) {
//			if (nb.getBoard_no() == notice.getBoard_no()) {
//				noticeList.remove(notice.getBoard_no());
//				return true;
//			}
//		}
//		return false;
//	}
	public boolean deletePost(NoticeBoardVO notice) {

		for (NoticeBoardVO nb : noticeList) {
			if (nb.getBoard_no() == notice.getBoard_no()) {
				noticeList.remove(notice);
				return true;
			}
		}
		return false;
	}

	// noticeBoard Method - 게시판의 모든 게시글을 조회하는 메서드
	public List<NoticeBoardVO> readPost() {

		List<NoticeBoardVO> ret = new ArrayList<NoticeBoardVO>();

		for (NoticeBoardVO notice : noticeList) {
			if (notice.isDelete() == false) {
				ret.add(notice);
			}
		}

		return ret;
	}

	// Seat Method - 예매가능한 좌석을 출력해주는 메서드 (예약테이블을 조회)
	public List<SeatVO> readSeat(int show_no) {
		// 예약테이블과 좌석테이블을 함께 조회해서 일치하는 번호의 좌석은 0으로 표시해야함

		List<SeatVO> emptySeatList = new ArrayList<SeatVO>();

		for (SeatVO s : seatList) {
			if (show_no == s.getShow_no()) {
				emptySeatList.add(s);
			}
		}

		return emptySeatList;
	}

	// 무비 리스트를 보내주는것
	public List<MovieVO> movieList() {
		List<MovieVO> nowMovieList = new ArrayList<MovieVO>();
		for (MovieVO movie : movieList) {
			nowMovieList.add(movie);
		}
		return nowMovieList;
	}

	public boolean setUseSaet(Map<String, String> info) {

		String seat_row = info.get("seat_row");
		String seat_col = info.get("seat_col");
		int show_no = Integer.parseInt(info.get("show_no"));

		int row = seat_row.charAt(0) - 64; // A->1
		int col = seat_col.charAt(0) - 48; // (char) 1 -> (int) 1

		if (seat_col.length() > 1) { // 좌석열중에 두 글자인 것은 10번밖에 없다.
			col = 10;
		}

		for (int i = 0; i < seatList.size(); i++) {
			if (seatList.get(i).getShow_no() == show_no
					&& seatList.get(i).getSeat_col() == col
					&& seatList.get(i).getSeat_row() == row) {
				System.out.println(seatList.get(i).getShow_no() + " = "
						+ seatList.get(i).getSeat_row() + " = "
						+ seatList.get(i).getSeat_col());
				seatList.get(i).setSeat_use(true);
				break;
			}
		}

		return true;
	}

	/**
	 * 회원이 예매할 좌석이 이미 예약되어 있는지 검사하는 메소드
	 * 
	 * @param seat_no
	 * @return
	 */
	public boolean dupSeat(String seat_no) {
		// TODO Auto-generated method stub

		for (ReserveVO res : reserveList) {
			if (res.getSeat_no().equals(seat_no)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 회원이 예약취소한 좌석을 예약가능 상태로 바꿔주는 메소드
	 * 
	 * @param info
	 * @return
	 */
	public boolean cancelSeat(Map<String, String> info) {
		// TODO Auto-generated method stub
		String seat_no = info.get("seat_no");
		int show_no = Integer.parseInt(info.get("show_no"));

		String row = seat_no.substring(2, 3);
		String col = seat_no.substring(3);

		int seat_row = row.charAt(0) - 64; // A->1
		int seat_col = col.charAt(0) - 48; // (char) 1 -> (int) 1

		if (col.length() > 1) { // 좌석열중에 두 글자인 것은 10번밖에 없다.
			seat_col = 10;
		}

		for (int i = 0; i < seatList.size(); i++) {
			if (seatList.get(i).getShow_no() == show_no
					&& seatList.get(i).getSeat_col() == seat_col
					&& seatList.get(i).getSeat_row() == seat_row) {
				System.out.println(seatList.get(i).getShow_no() + " = "
						+ seatList.get(i).getSeat_row() + " = "
						+ seatList.get(i).getSeat_col());
				seatList.get(i).setSeat_use(false);
				break;
			}
		}

		return true;
	}

	/**
	 * 이미 가입된 회원인지 체크하는 메서드
	 * 
	 * @author 김선준
	 */
	public boolean memOverlapCheck(Map<String, String> map) {

		// 중복체크
		for (int i = 0; i < memberList.size(); i++) { // 리스트에 담긴 이름의 갯수만큼 반복
			if (map.get("mem_name").equals(memberList.get(i).getMem_name())
					&& map.get("mem_regno1").equals(
							memberList.get(i).getMem_regno1())
					&& map.get("mem_regno2").equals(
							memberList.get(i).getMem_regno2())) { // 이름과
				return true; // 중복이면 참
			}
		}
		return false;
	}

	/**
	 * 로그인 시 아이디와 패스워드가 일치하는지 확인 (회원용)
	 * 
	 * @author 김선준
	 */
	public boolean checkLogin(Map<String, String> map) {
		String mem_id = map.get("mem_id");
		String mem_pw = map.get("mem_pw");
		boolean memCheck = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (mem_id.equals(memberList.get(i).getMem_id())
					&& mem_pw.equals(memberList.get(i).getMem_pw())
					&& false == memberList.get(i).getDelete()
					&& memberList.get(i).getMem_auth().equals("member")) {
				memCheck = true;
			}
		}
		
		
		return memCheck;
	}
	
	/**
	 * 로그인 시 아이디와 패스워드가 일치하는지 확인 (관리자용)
	 */
	public boolean admin_checkLogin(Map<String, String> map) {
		String mem_id = map.get("mem_id");
		String mem_pw = map.get("mem_pw");
		boolean memCheck = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (mem_id.equals(memberList.get(i).getMem_id())
					&& mem_pw.equals(memberList.get(i).getMem_pw())
					&& false == memberList.get(i).getDelete()
					&& memberList.get(i).getMem_auth().equals("admin")) {
				memCheck = true;
			}
		}
		
		
		return memCheck;
	}

	/**
	 * 로그인에 성공했을 때 해당 회원의 객체를 얻기위해 만든 메소드
	 * 
	 * @author 김선준
	 */
	public MemberVO getMemberVO(String mem_id) {
		int num = 0;
		for (int i = 0; i < memberList.size(); i++) {
			// 아이디가 일치하는 객체
			if (mem_id.equals(memberList.get(i).getMem_id())) {
				num = i;
			}
		}
		return memberList.get(num);
	}

}
