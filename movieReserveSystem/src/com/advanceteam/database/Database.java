package com.advanceteam.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.advanceteam.vo.*;

public class Database {

	List<MemberVO> memberList = new ArrayList<MemberVO>();
	List<MovieVO> movieList = new ArrayList<MovieVO>();
	List<NoticeBoardVO> noticeList = new ArrayList<NoticeBoardVO>();
	List<ReserveVO> reserveList = new ArrayList<ReserveVO>();
	List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
	List<SaleVO> saleList = new ArrayList<SaleVO>();
	List<SeatVO> seatList = new ArrayList<SeatVO>();
	List<ShowVO> showList = new ArrayList<ShowVO>();
	List<TheaterVO> theaterList = new ArrayList<TheaterVO>();

	Calendar cal = Calendar.getInstance();

	public Database() {
		// singleTon Pattern 적용전이기 때문에, 데이터베이스의 객체생성에 제한을 두지않는다.

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
		master.setMem_deleteDate(null);
		master.setMem_signUpDate(cal.getTime());
		master.setMem_rank("admin");
		master.setMem_auth("admin");
		master.setMem_hp("010-XXXX-XXXX");
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
		member_1.setMem_deleteDate(null);
		member_1.setMem_signUpDate(cal.getTime());
		member_1.setMem_rank("Diamond");
		member_1.setMem_auth("member");
		member_1.setMem_hp("010-5361-4713");
		memberList.add(member_1);

		MemberVO member_2 = new MemberVO();
		member_1.setMem_name("전수빈");
		member_1.setMem_id("wjstnqls23");
		member_1.setMem_pw("java");
		member_1.setBudget(100000);
		member_1.setMem_regno1("981230");
		member_1.setMem_regno2("1XXXXXX");
		member_1.setMem_add("대전광역시");
		member_1.setMem_add2("유성 XXX");
		member_1.setMem_deleteDate(null);
		member_1.setMem_signUpDate(cal.getTime());
		member_1.setMem_rank("Diamond");
		member_1.setMem_auth("member");
		member_1.setMem_hp("010-1234-5678");
		memberList.add(member_2);

		MemberVO member_3 = new MemberVO();
		member_1.setMem_name("김선준");
		member_1.setMem_id("rlatjswns23");
		member_1.setMem_pw("java");
		member_1.setBudget(100000);
		member_1.setMem_regno1("960820");
		member_1.setMem_regno2("1XXXXXX");
		member_1.setMem_add("대전광역시");
		member_1.setMem_add2("홍제동 XXX");
		member_1.setMem_deleteDate(null);
		member_1.setMem_signUpDate(cal.getTime());
		member_1.setMem_rank("Diamond");
		member_1.setMem_auth("member");
		member_1.setMem_hp("010-2321-4231");
		memberList.add(member_3);

		MemberVO member_4 = new MemberVO();
		member_1.setMem_name("이상헌");
		member_1.setMem_id("dltkdgjs23");
		member_1.setMem_pw("java");
		member_1.setBudget(100000);
		member_1.setMem_regno1("960314");
		member_1.setMem_regno2("1XXXXXX");
		member_1.setMem_add("대전광역시");
		member_1.setMem_add2("선화동 XXX");
		member_1.setMem_deleteDate(null);
		member_1.setMem_signUpDate(cal.getTime());
		member_1.setMem_rank("Diamond");
		member_1.setMem_auth("member");
		member_1.setMem_hp("010-1352-3951");
		memberList.add(member_4);

		// ====initialize Movie====
		MovieVO movie_1 = new MovieVO();
		movie_1.setMovie_actor("황정민, 이정재");
		movie_1.setMovie_ageGrade(19);
		movie_1.setMovie_close(null);
		movie_1.setMovie_director("봉준호");
		movie_1.setMovie_genre("액션");
		movie_1.setMovie_id("A0001");
		movie_1.setMovie_open(cal.getTime());
		movie_1.setMovie_price(13000);
		movie_1.setMovie_runTime(130);
		movie_1.setMovie_title("다만 악에서 구하소서");
		movieList.add(movie_1);

		MovieVO movie_2 = new MovieVO();
		movie_1.setMovie_actor("이선균, 조여정");
		movie_1.setMovie_ageGrade(19);
		movie_1.setMovie_close(null);
		movie_1.setMovie_director("봉준호");
		movie_1.setMovie_genre("스릴러");
		movie_1.setMovie_id("A0002");
		movie_1.setMovie_open(cal.getTime());
		movie_1.setMovie_price(13000);
		movie_1.setMovie_runTime(150);
		movie_1.setMovie_title("기생충");
		movieList.add(movie_2);

		MovieVO movie_3 = new MovieVO();
		movie_1.setMovie_actor("드웨인 존슨");
		movie_1.setMovie_ageGrade(15);
		movie_1.setMovie_close(null);
		movie_1.setMovie_director("크리스토퍼 놀란");
		movie_1.setMovie_genre("액션");
		movie_1.setMovie_id("A0003");
		movie_1.setMovie_open(cal.getTime());
		movie_1.setMovie_price(13000);
		movie_1.setMovie_runTime(160);
		movie_1.setMovie_title("스카이 스크래퍼");
		movieList.add(movie_3);

		MovieVO movie_4 = new MovieVO();
		movie_1.setMovie_actor("최민식, 하정우");
		movie_1.setMovie_ageGrade(15);
		movie_1.setMovie_close(null);
		movie_1.setMovie_director("유상민");
		movie_1.setMovie_genre("범죄");
		movie_1.setMovie_id("A0004");
		movie_1.setMovie_open(cal.getTime());
		movie_1.setMovie_price(11000);
		movie_1.setMovie_runTime(150);
		movie_1.setMovie_title("범죄와의 전쟁");
		movieList.add(movie_4);

		// ====initialize NoticeBoard====
		NoticeBoardVO notice_1 = new NoticeBoardVO();
		notice_1.setBoard_no(1);
		notice_1.setBoard_postDate(cal.getTime());
		notice_1.setBoard_text("GGV 파격 할인 이벤트를 진행중입니다. 많은 참여 부탁드립니다");
		notice_1.setBoard_title("할인 이벤트 안내");
		notice_1.setBoard_views(21);
		notice_1.setMem_id("admin");
		noticeList.add(notice_1);

		NoticeBoardVO notice_2 = new NoticeBoardVO();
		notice_2.setBoard_no(2);
		notice_2.setBoard_postDate(cal.getTime());
		notice_2.setBoard_text("다만 악에서 구하소서 굿즈를 판매합니다. 많은 사랑 부탁드립니다.");
		notice_2.setBoard_title("다만 악에서 구하소서 굿즈안내");
		notice_2.setBoard_views(222);
		notice_2.setMem_id("admin");
		noticeList.add(notice_2);

		NoticeBoardVO notice_3 = new NoticeBoardVO();
		notice_1.setBoard_no(3);
		notice_1.setBoard_postDate(cal.getTime());
		notice_1.setBoard_text("Lol Champions League 상영관 이벤트를 진행중입니다.");
		notice_1.setBoard_title("롤챔스 상영관 이벤트 안내");
		notice_1.setBoard_views(4231);
		notice_1.setMem_id("admin");
		noticeList.add(notice_3);

		NoticeBoardVO notice_4 = new NoticeBoardVO();
		notice_1.setBoard_no(4);
		notice_1.setBoard_postDate(cal.getTime());
		notice_1.setBoard_text("GGV는 매일 방역을 하고있습니다. 안심하고 이용해주세요.");
		notice_1.setBoard_title("코로나 방역조치 관련 안내");
		notice_1.setBoard_views(23);
		notice_1.setMem_id("admin");
		noticeList.add(notice_4);

		// ====initialize Theater====
		TheaterVO theater_1 = new TheaterVO();
		theater_1.setTheater_id("4DX");
		theater_1.setTheater_price(5000);
		theaterList.add(theater_1);

		TheaterVO theater_2 = new TheaterVO();
		theater_2.setTheater_id("IMAX");
		theater_2.setTheater_price(6000);
		theaterList.add(theater_2);

		TheaterVO theater_3 = new TheaterVO();
		theater_3.setTheater_id("2D");
		theater_3.setTheater_price(1000);
		theaterList.add(theater_3);

		TheaterVO theater_4 = new TheaterVO();
		theater_4.setTheater_id("3D");
		theater_4.setTheater_price(3500);
		theaterList.add(theater_4);

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

		// ====initialize Seat====
		int seat_no = 1;
		for (int row = 0; row > 10; row++) {
			for (int col = 0; col > 10; col++) {
				SeatVO seat = new SeatVO();
				seat.setSeat_row(row);
				seat.setSeat_col(col);
				seat.setSeat_no(seat_no++);
				seat.setTheater_id("4DX");
				seatList.add(seat);
			}
		}

		// ====initialize Show====
		ShowVO show_1 = new ShowVO();
		show_1.setMovie_id("A0001");
		show_1.setShow_date(cal.getTime());
		show_1.setShow_id("AAA");
		show_1.setTheater_id("2D");
		showList.add(show_1);

		ShowVO show_2 = new ShowVO();
		show_1.setMovie_id("A0002");
		show_1.setShow_date(cal.getTime());
		show_1.setShow_id("AAB");
		show_1.setTheater_id("2D");
		showList.add(show_2);

		ShowVO show_3 = new ShowVO();
		show_1.setMovie_id("A0002");
		show_1.setShow_date(cal.getTime());
		show_1.setShow_id("AAC");
		show_1.setTheater_id("4DX");
		showList.add(show_3);

		ShowVO show_4 = new ShowVO();
		show_1.setMovie_id("A0003");
		show_1.setShow_date(cal.getTime());
		show_1.setShow_id("AAD");
		show_1.setTheater_id("3D");
		showList.add(show_4);

		// ====initialize Review====
		ReviewVO review_1 = new ReviewVO();
		review_1.setMem_id("shinkwang23");
		review_1.setMovie_id("기생충");
		review_1.setReview_no(1);
		review_1.setReview_grade(4);
		review_1.setReview_hate(0);
		review_1.setReview_like(132);
		review_1.setReview_text("너무 재밌습니다. 봉준호 감독 최고!!");
		reviewList.add(review_1);

		ReviewVO review_2 = new ReviewVO();
		review_2.setMem_id("shinkwang23");
		review_2.setMovie_id("다만 악에서 구하소서");
		review_2.setReview_no(1);
		review_2.setReview_grade(1);
		review_2.setReview_hate(11);
		review_2.setReview_like(1332);
		review_2.setReview_text("황정민, 이정재 연기력 최고");
		reviewList.add(review_2);

		ReviewVO review_3 = new ReviewVO();
		review_3.setMem_id("wjstnqls23");
		review_3.setMovie_id("범죄와의 전쟁");
		review_3.setReview_no(1);
		review_3.setReview_grade(4);
		review_3.setReview_hate(0);
		review_3.setReview_like(132);
		review_3.setReview_text("너무 재밌습니다. 하정우 짱");
		reviewList.add(review_3);

		ReviewVO review_4 = new ReviewVO();
		review_4.setMem_id("shinkwang23");
		review_4.setMovie_id("기생충");
		review_4.setReview_no(2);
		review_4.setReview_grade(4);
		review_4.setReview_hate(222);
		review_4.setReview_like(41);
		review_4.setReview_text("너무 재미없어요.");
		reviewList.add(review_4);

		

	}

	public boolean addMember(MemberVO member) {
		// TODO Auto-generated method stub
		
		for(MemberVO e : memberList) {
			if(member.getMem_id().equals(e.getMem_id()) && member.getMem_pw().equals(e.getMem_pw())) {
				System.out.println("이미 가입된 회원입니다.");
				return false;
			}
		}
		
		memberList.add(member);
		return true;
	}
}
