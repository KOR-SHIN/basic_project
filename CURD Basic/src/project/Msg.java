package project;

public class Msg {

	/**
	 * 회원의 정보수정이 완료되었음을 알려주는 메세지 출력 메서드
	 * @author 신광진
	 */
	public void updateMsg() {
		
		System.out.println("회원님의 개인정보가 수정되었습니다.");
		System.out.println("수정된 정보를 확인하고 싶은경우 다시 로그인 해주세요.");
	}
	
	public void updateFailMsg() {
		
		System.out.println("요청하신 서비스 실행에 실패하였습니다.");
		System.out.println("다시 시도해주세요.");
	}

	
	
}
