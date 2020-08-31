package com.advanceteam.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
		movie_1.setMovie_close(null);
		movie_1.setMovie_director("봉준호");
		movie_1.setMovie_genre("액션");
		movie_1.setMovie_id("A0001");
		movie_1.setMovie_open(cal.getTime());
		movie_1.setMovie_price(13000);
		movie_1.setMovie_runTime(130);
		movie_1.setMovie_title("다만 악에서 구하소서");
		movie_1.setDelete(false);
		movieList.add(movie_1);

		MovieVO movie_2 = new MovieVO();
		movie_2.setMovie_actor("이선균, 조여정");
		movie_2.setMovie_ageGrade(19);
		movie_2.setMovie_close(null);
		movie_2.setMovie_director("봉준호");
		movie_2.setMovie_genre("스릴러");
		movie_2.setMovie_id("A0002");
		movie_2.setMovie_open(cal.getTime());
		movie_2.setMovie_price(13000);
		movie_2.setMovie_runTime(150);
		movie_2.setMovie_title("기생충");
		movie_2.setDelete(false);
		movieList.add(movie_2);

		MovieVO movie_3 = new MovieVO();
		movie_3.setMovie_actor("드웨인 존슨");
		movie_3.setMovie_ageGrade(15);
		movie_3.setMovie_close(null);
		movie_3.setMovie_director("크리스토퍼 놀란");
		movie_3.setMovie_genre("액션");
		movie_3.setMovie_id("A0003");
		movie_3.setMovie_open(cal.getTime());
		movie_3.setMovie_price(13000);
		movie_3.setMovie_runTime(160);
		movie_3.setMovie_title("스카이 스크래퍼");
		movie_3.setDelete(false);
		movieList.add(movie_3);

		MovieVO movie_4 = new MovieVO();
		movie_4.setMovie_actor("최민식, 하정우");
		movie_4.setMovie_ageGrade(15);
		movie_4.setMovie_close(null);
		movie_4.setMovie_director("유상민");
		movie_4.setMovie_genre("범죄");
		movie_4.setMovie_id("A0004");
		movie_4.setMovie_open(cal.getTime());
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
		notice_3.setBoard_no(3);
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
		theater_1.setTheater_id("4DX");
		theater_1.setTheater_price(5000);
		theater_1.setDelete(false);
		theaterList.add(theater_1);

		TheaterVO theater_2 = new TheaterVO();
		theater_2.setTheater_id("IMAX");
		theater_2.setTheater_price(6000);
		theater_2.setDelete(false);
		theaterList.add(theater_2);

		TheaterVO theater_3 = new TheaterVO();
		theater_3.setTheater_id("2D");
		theater_3.setTheater_price(1000);
		theater_3.setDelete(false);
		theaterList.add(theater_3);

		TheaterVO theater_4 = new TheaterVO();
		theater_4.setTheater_id("3D");
		theater_4.setTheater_price(3500);
		theater_4.setDelete(false);
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
	}

	{
		// ====initialize Show====
		ShowVO show_1 = new ShowVO();
		show_1.setMovie_id("A0001");
		show_1.setShow_date(cal.getTime());
		show_1.setShow_id("AAA");
		show_1.setTheater_id("2D");
		show_1.setDelete(false);
		showList.add(show_1);

		ShowVO show_2 = new ShowVO();
		show_2.setMovie_id("A0002");
		show_2.setShow_date(cal.getTime());
		show_2.setShow_id("AAB");
		show_2.setTheater_id("2D");
		show_2.setDelete(false);
		showList.add(show_2);

		ShowVO show_3 = new ShowVO();
		show_3.setMovie_id("A0002");
		show_3.setShow_date(cal.getTime());
		show_3.setShow_id("AAC");
		show_3.setTheater_id("4DX");
		show_3.setDelete(false);
		showList.add(show_3);

		ShowVO show_4 = new ShowVO();
		show_4.setMovie_id("A0003");
		show_4.setShow_date(cal.getTime());
		show_4.setShow_id("AAD");
		show_4.setTheater_id("3D");
		show_4.setDelete(false);
		showList.add(show_4);
	}

	{
		// ====initialize Review====
		ReviewVO review_1 = new ReviewVO();
		review_1.setMem_id("shinkwang23");
		review_1.setMovie_id("기생충");
		review_1.setReview_no(1);
		review_1.setReview_grade(4);
		review_1.setReview_hate(0);
		review_1.setReview_like(132);
		review_1.setReview_text("너무 재밌습니다. 봉준호 감독 최고!!");
		review_1.setDelete(false);
		reviewList.add(review_1);

		ReviewVO review_2 = new ReviewVO();
		review_2.setMem_id("shinkwang23");
		review_2.setMovie_id("다만 악에서 구하소서");
		review_2.setReview_no(1);
		review_2.setReview_grade(1);
		review_2.setReview_hate(11);
		review_2.setReview_like(1332);
		review_2.setReview_text("황정민, 이정재 연기력 최고");
		review_2.setDelete(false);
		reviewList.add(review_2);

		ReviewVO review_3 = new ReviewVO();
		review_3.setMem_id("wjstnqls23");
		review_3.setMovie_id("범죄와의 전쟁");
		review_3.setReview_no(1);
		review_3.setReview_grade(4);
		review_3.setReview_hate(0);
		review_3.setReview_like(132);
		review_3.setReview_text("너무 재밌습니다. 하정우 짱");
		review_3.setDelete(false);
		reviewList.add(review_3);

		ReviewVO review_4 = new ReviewVO();
		review_4.setMem_id("shinkwang23");
		review_4.setMovie_id("기생충");
		review_4.setReview_no(2);
		review_4.setReview_grade(4);
		review_4.setReview_hate(222);
		review_4.setReview_like(41);
		review_4.setReview_text("너무 재미없어요.");
		review_4.setDelete(false);
		reviewList.add(review_4);
	}

	// memberMethod - 새로운 멤버를 회원테이블에 추가하는 메서드
	public boolean addMember(MemberVO member) {

		// View class에서 이름과 주민등록번호를 통해 가입여부를 판단하고 넘어온다.
		memberList.add(member);
		return true;
	}

	// memberMethod - 회원가입하기 위한 아이디가 중복되는지 검사하는 메서드 (중복되는 경우 true를 반환한다)
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

	// Movie Method - 영화등록 메서드 (새로운 영화를 추가하는 메서드, 영화추가에 성공하면 true, 실패하면 false를
	// 반환한다.)
	public boolean addMovie(MovieVO movie) {

		for (MovieVO mv : movieList) {
			// 기존의 영화리스트에 추가되어 있는 영화인지 검사한다.
			if (mv.getMovie_id().equals(movie.getMovie_id())) {
				System.out.println("영화등록에 실패했습니다.");
				System.out.println("이미 등록되어 있는 영화입니다.");
				return false;
			}
		}

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
			if (movie.getMovie_id().equals(mv.getMovie_id())) {
				movieList.remove(movie);
				System.out.println(movie.getMovie_title() + "을 삭제하였습니다.");
				return true;
			}
		}

		System.out.println("등록되어 있지 않은 영화입니다.");
		return false;
	}

	// Review Method - 새로운 한줄평을 등록하는 메서드 (한줄평 등록에 성공하면 true, 실패하면 false를 반환한다)
	public boolean addReview(ReviewVO review) {

		for (ReviewVO re : reviewList) {
			// 기존의 reviewList에서 파라미터로 받은 review의 회원id, 영화id, 리뷰번호가 같은 객체가 있는지
			// 확인한다.
			// 기존 reviewList에 동일한 정보를 가진 객체가 있는 경우 리뷰등록에 실패한다.
			if (re.getMem_id().equals(review.getMem_id())
					&& re.getMovie_id().equals(review.getMovie_id())
					&& re.getReview_no() == review.getReview_no()) {
				System.out.println("해당 영화에 대한 리뷰를 이미 작성하셨습니다.");
				return false;
			}
		}

		System.out.println(review.getMovie_id() + " 영화에 대한 한줄평 등록에 성공했습니다.");
		return true;

	}
	// Review Method - 기존의 리뷰를 조회하는 메서드 (관리자용 메서드로서, 삭제되지 않은 모든 리뷰를 반환한다)
	public List<ReviewVO> readReview() {

		List<ReviewVO> ret = new ArrayList<ReviewVO>();
		//기존의 reivewList에서 삭제되지 않은 review만을 저장해서 리스트로 반환한다.
		for (ReviewVO re : reviewList) {
			if (re.isDelete() == false) {
				ret.add(re);
			}
		}

		return ret;
	}

	//Review Method - 기존의 리뷰를 삭제하는 메서드 
	public boolean deleteReview(ReviewVO review) {

		for (ReviewVO re : reviewList) {
			//기존의 reviewList에서 파라미터로 받은 review의 mem_id, movie_id, reivew_no가 같은
			//객체가 있는지 확인하고, 존재한다면 해당 리뷰를 reviewList에서 삭제한다.
			if (re.getMem_id().equals(review.getMem_id())
					&& re.getMovie_id().equals(review.getMovie_id())
					&& re.getReview_no() == review.getReview_no()) {
				
				reviewList.remove(review);
				System.out.println("리뷰삭제를 성공하였습니다.");
				return true;
			}
		}
		
		System.out.println("등록되어 있지 않은 리뷰입니다.");
		return false;
	}
	
	//Review Method - 파라미터로 받은 영화의 movie_id와 일치하는 movie_id를 가진 객체만을 리스트로 반환한다.
	public List<ReviewVO> readMovieReview(MovieVO movie){
		
		List<ReviewVO> ret = new ArrayList<ReviewVO>();
		
		for(ReviewVO re : reviewList) {
			//reviewVO의 외래키 movie_id를 이용하여, 기존의 reviewList에서
			//파라미터로 받은 movie_id와 일치하는 review객체만을 리스트에 추가한다.
			if(re.getMovie_id().equals(movie.getMovie_id())) {
				ret.add(re);
			}
		}
		
		return ret;
		
	}
	
	public boolean addTheater(TheaterVO theater) {
		
		for(TheaterVO th : theaterList) {
			if(th.getTheater_id().equals(theater.getTheater_id())) {
				System.out.println("이미 추가되어 있는 상영관입니다.");
				return false;
			}
		}
		
		System.out.println("상영관 추가에 성공하였습니다.");
		return true;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
