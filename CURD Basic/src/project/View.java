package project;

import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
	private Scanner sc = new Scanner(System.in);
	private IService sv = new IServiceImpl();
	private String login_id;
	private Regex reg = new Regex();
	private Msg msg = new Msg();
	
	public void run() {
		System.out.println("ViewClass Start");
		
		while(true){
			// TODO Auto-generated method stub
			
			System.out.println("원하는 메뉴를 골라주세요.");
			System.out.println("1. 회원가입"); // Create
			System.out.println("2. 로그인"); // Read
			System.out.println("3. 끝내기");
			
			int cmd = 0;
			
			// 고르기
			try {
				cmd = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력 가능합니다.");
				continue;
			}
	
			// 메서드 이동하기
			switch (cmd) {
			case 1:
				// 회원가입
				createMember();
				break;
	
			case 2:
				logIn();
				// 로그인
				break;
	
			case 3:
				// 종료
				System.exit(0);;
				
			default:
				System.exit(0);;
			}
		}
	}

	private void logIn() {
		// logIn -> 회원리스트출력 -> 한 회원의 번호를 선택함 -> 선택된 회원의 상세내용출력 -> 상세내용 수정할 수 있도록
		// 만들어야함.
		System.out.println("아이디를 입력해주세요");
		String mem_id = sc.next();

		System.out.println("비밀번호를 입력해주세요");
		String mem_pass = sc.next();

		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		params.put("mem_pass", mem_pass);

		login_id = sv.logIn(params);

		if (login_id == null) {
			System.out.println("로그인 실패");
		} else {
			System.out.println(login_id + "회원님 환영합니다.");
			showMemInfo(login_id);
		}
	}

	// 회원의 상세정보를 조회하는 메서드 (READ)
	private void showMemInfo(String login_id) {

		MemberVO member = sv.readMemInfo(login_id);
		int cmd = -1;
		
		while(true) {
			System.out.println("-----------------------------------------------");
			System.out.println("회원이름 : " + member.getMem_name() + "( " + login_id
					+ " )");
			System.out.println("핸드폰 번호 : " + member.getMem_hp());
			System.out.println("주민등록번호 : " + member.getMem_regno1() + "-"
					+ member.getMem_regno2());
			System.out.println("주소지 : " + member.getMem_add1() + " "
					+ member.getMem_add2());
			System.out.println("이메일 : " + member.getMem_mail());
			System.out.println("직업 : " + member.getMem_job());
			System.out.println("마일리지 : " + member.getMem_mileage() + " Point");
			System.out.println("-----------------------------------------------");
			
			System.out.println("1. 회원정보 수정하기");
			System.out.println("2. 회원 탈퇴하기");
			System.out.println("3. 뒤로가기");
			
			cmd = sc.nextInt();
			sc.nextLine();
			
			switch(cmd) {
			case 1:
				updateMeminfo();
				break;
			case 2:
				deleteMember();
				return;
			case 3:
				return;
			}
		}
	}

	private void deleteMember() {
		
		System.out.println("정말 탈퇴하시겠습니까? (Y/N)");
		String cmd = sc.next();
		sc.nextLine();
		
		if(cmd.toUpperCase().equals("Y")) {
			if( sv.deleteMember(login_id) ) {
				System.out.println("회원탈퇴가 완료되었습니다.");
				return;
			}
			
		} else {
			System.out.println("좋은 선택입니다 회원님!");;
			return;
		}
		
	}

	//회원정보수정 메서드
	private void updateMeminfo() {

		int cmd = -1;
		
		while(true){
			
			System.out.println("수정하고 싶은 정보에 해당하는 번호를 누르세요.");
			System.out.println("1. 핸드폰 번호");
			System.out.println("2. 주소");
			System.out.println("3. 이메일");
			System.out.println("4. 뒤로가기");
			cmd = sc.nextInt();
			sc.nextLine();
			
			switch(cmd) {
			case 1:
				updateMemHp();
				break;
				
			case 2:
				updateMemAdd();
				break;
			
			case 3:
				updateMemMail();
				break;
			
			case 4:
				return;
				
			default :
				return;
			}
		}
		
	}

	private void updateMemMail() {
		
		String new_mail = inputMail();
		
		Map<String, String> info = new HashMap<>();
		info.put("mem_id", login_id);
		info.put("new_mail", new_mail);
		
		if( sv.updateMemMail(info) ) {
			msg.updateMsg();
			return;
		}
		
		msg.updateFailMsg();
		return;
	}

	/**
	 * 회원의 주소를 수정하는 메서드
	 * @author 신광진
	 */
	private void updateMemAdd() {
		
		String new_add1 = inputAdd1();
		String new_add2 = inputAdd2();
		
		Map<String, String> info = new HashMap<>();
		info.put("new_add1", new_add1);
		info.put("new_add2", new_add2);
		info.put("mem_id", login_id);
		
		if( sv.updateMemAdd(info) ) {
			msg.updateMsg();
			return;
		}
		
		msg.updateFailMsg();
		return;
	}

	/**
	 * 회원의 전화번호를 수정하는 메서드
	 * @param newHp
	 */
	private void updateMemHp() {
		
		String new_hp = inputHp();
		
		Map<String, String> info = new HashMap<>();
		info.put("mem_id", login_id);
		info.put("new_hp", new_hp);
		
		if( sv.updateMemHp(info) ) {
			msg.updateMsg();
			return;
		}
		
		msg.updateFailMsg();
		return;
		
	}

	/**
	 * 회원가입을 위한 메서드
	 * @author 신광진
	 */
	private boolean createMember() {
		// TODO Auto-generated method stub
		MemberVO newMember = new MemberVO();

		// mem_name
		String mem_name = inputName();
		newMember.setMem_name(mem_name);

		// mem_id
		String mem_id = inputId();
		newMember.setMem_id(mem_id);

		// mem_pass
		String mem_pass = inputPass();
		newMember.setMem_pass(mem_pass);

		// mem_add1
		String mem_add1 = inputAdd1();
		newMember.setMem_add1(mem_add1);

		// mem_add2
		String mem_add2 = inputAdd2();
		newMember.setMem_add2(mem_add2);

		// mem_regno1
		String mem_regno1 = inputRegno1();
		newMember.setMem_regno1(mem_regno1);

		// mem_regno2
		String mem_regno2 = inputRegno2();
		newMember.setMem_regno2(mem_regno2);

		// mem_hp
		String mem_hp = inputHp();
		newMember.setMem_hp(mem_hp);

		// mem_mail
		String mem_mail = inputMail();
		newMember.setMem_mail(mem_mail);

		// mem_job
		String mem_job = inputJob();
		newMember.setMem_job(mem_job);

		return sv.createMember(newMember);
	}

	/**
	 * 회원의 이름을 입력하는 메서드
	 * 
	 * @author 신광진
	 * @return mem_name
	 */
	private String inputName() {

		String mem_name = null;

		while (true) {

			System.out.print("이름을 입력해주세요(한글) : ");
			try {
				mem_name = sc.next();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("!! 이름을 정확히 입력해주세요.");
				continue;
			}

			if (reg.checkName(mem_name)) {
				break;
			} else {
				System.out.println("!! 이름을 정확히 입력해주세요");
			}
		}
		return mem_name;
	}

	/**
	 * 회원의 직업을 입력하는 메서드
	 * 
	 * @author 신광진
	 * @return mem_job
	 */
	private String inputJob() {
		
		System.out.print("직업을 입력해주세요 : ");
		String mem_job = sc.nextLine();
			
		return mem_job;
	}

	/**
	 * 회원의 이메일을 입력하는 메서드
	 * 
	 * @author 신광진
	 * @return mem_mail
	 */
	private String inputMail() {

		String mem_mail = null;

		while (true) {
			System.out.print("이메일을 입력해주세요 : ");

			try {
				mem_mail = sc.next();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("!! 이메일을 정확히 입력해주세요.");
				continue;
			}

			if (reg.checkEmail(mem_mail)) {
				break;
			} else {
				System.out.println("!! 이메일을 정확히 입력해주세요.");
			}

		}

		return mem_mail;
	}

	/**
	 * 회원의 핸드폰 번호를 입력하는 메서드
	 * 
	 * @author 신광진
	 * @return mem_hp
	 */
	private String inputHp() {

		String mem_hp = null;

		while (true) {

			try {
				System.out.print("핸드폰 번호를 입력해주세요(01X-XXXX-XXXX) : ");
				mem_hp = sc.next();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("!! 양식에 맞게 정확히 입력해주세요.");
				continue;
			}

			if (reg.checkHp(mem_hp)) {
				break;
			} else {
				System.out.println("!! 양식에 맞게 정확히 입력해주세요.");
			}
		}
		return mem_hp;
	}

	/**
	 * 회원의 주민등록번호 뒷자리를 입력하는 메서드
	 * 
	 * @author 신광진
	 * @return mem_regno2
	 */
	private String inputRegno2() {

		String mem_regno2 = null;

		while (true) {
			System.out.print("주민등록번호 앞자리를 입력해주세요(7자리) : ");
			try {
				mem_regno2 = sc.next();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("!! 정확하게 입력해주세요");
				continue;
			}

			if (reg.checkRegno2(mem_regno2)) {
				break;
			} else {
				System.out.println("!! 정확하게 입력해주세요.");
			}
		}

		return mem_regno2;
	}

	/**
	 * 회원의 주민등록번호 앞자리를 입력하는 메서드
	 * 
	 * @author 신광진
	 * @return mem_regno1
	 */
	private String inputRegno1() {
		String mem_regno1 = null;

		while (true) {
			System.out.print("주민등록번호 앞자리를 입력해주세요 (6자리) : ");
			try {
				mem_regno1 = sc.next();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("!! 정확하게 입력해주세요");
				continue;
			}

			if (reg.checkRegno1(mem_regno1)) {
				break;
			} else {
				System.out.println("!! 정확하게 입력해주세요.");
			}
		}

		return mem_regno1;
	}

	/**
	 * 회원의 상세주소를 입력받는 메서드
	 * 
	 * @author 신광진
	 * @return mem_add2
	 */
	private String inputAdd2() {

		System.out.print("상세주소를 입력해주세요 : ");
		String mem_add2 = sc.nextLine();

		return mem_add2;
	}

	/**
	 * 회원의 주소를 입력받는 메서드
	 * 
	 * @author 신광진
	 * @return mem_add1
	 */
	private String inputAdd1() {

		System.out.print("주소를 입력해주세요(시, 군, 구) : ");
		String mem_add1 = sc.nextLine();

		return mem_add1;
	}

	/**
	 * 회원의 비밀번호를 입력하는 메서드
	 * 
	 * @author 신광진
	 * @return mem_pass
	 */
	private String inputPass() {
		String mem_pass = null;

		while (true) {
			try {
				System.out.print("비밀번호를 입력해주세요 (영어로만 특수문자 포함 4~11글자) : ");
				mem_pass = sc.next();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("!! 양식에 맞게 정확히 입력하세요");
				continue;
			}

			if (reg.checkPw(mem_pass)) {
				break;
			} else {
				System.out.println("!! 양식에 맞게 정확히 입력하세요.");
			}

		}
		return mem_pass;
	}

	/**
	 * 회원의 아이디를 입력받는 메서드
	 * 
	 * @author 신광진
	 * @return mem_id
	 */
	private String inputId() {

		String mem_id = null;

		while (true) {

			try {
				System.out.print("아이디를 입력해주세요 (영어와 숫자만을 포함한 5~15자리) : ");
				mem_id = sc.next();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("!! 양식에 맞게 정확히 입력하세요.");
				continue;
			}
			
			if( checkDupId(mem_id) ) {
				System.out.println("이미 사용중인 아이디입니다.");
				continue;
			}

			if (reg.checkId(mem_id)) {
				break;
			} else {
				System.out.println("!! 양식에 맞게 정확히 입력하세요.");
			}

		}
		return mem_id;
	}

	/**
	 * 회원가입시 중복되는 아이디가 있는지 조회하는 메서드
	 * @param mem_id
	 * @return
	 */
	private boolean checkDupId(String mem_id) {
		return sv.checkDupId(mem_id);
	}

	/**
	 * 모든회원의 정보를 조회하는 메서드
	 * 
	 * @author 신광진
	 * 
	 */
	private void printAllMember() {

		List<MemberVO> memberList = sv.readAllMember();

		for (MemberVO mem : memberList) {
			System.out.print(mem.getMem_add1() + mem.getMem_add2());
			System.out.println();
		}
	}

}
