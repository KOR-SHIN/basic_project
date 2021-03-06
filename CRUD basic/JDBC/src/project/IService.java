package project;

import java.util.List;
import java.util.Map;

public interface IService {
	
	/**
	 * 로그인을 위한 메서드
	 * @author 신광진
	 * @param params (mem_id 회원아이디, mem_pass 회원비밀번호)
	 * @return id과 pw가 일치하는 한명의 아이디, 일치하는 사람이 없으면 null
	 * @since 2020-09-04
	 * @see
	 */
	String logIn(Map<String, String> params);

	/**
	 * 모든 회원의 정보를 조회하는 메서드
	 * @author 신광진
	 * @return List<MemberVO>
	 * @since 2020-09-04
	 * @see
	 */
	List<MemberVO> readAllMember();

	/**
	 * 회원 한 명의 상세정보를 조회하는 메서드
	 * @author 신광진
	 * @param login_id
	 * @return memberVO
	 */
	MemberVO readMemInfo(String login_id);

	/**
	 * 회원가입을 위한 메서드
	 * @author 신광진
	 * @param newMember
	 * @return boolean 
	 */
	boolean createMember(MemberVO newMember);

	/**
	 * 회원의 전화번호를 수정하는 메서드
	 * @author 신광진
	 * @param newHp
	 * @return boolean
	 */
	boolean updateMemHp(Map<String, String> info);

	/**
	 * 회원가입시 중복된 아이디가 있는지 조회하는 메서드
	 * @author 신광진
	 * @param mem_id
	 * @return boolean
	 */
	boolean checkDupId(String mem_id);

	/**
	 * 회원의 주소지를 변경하는 메서드
	 * @author 신광진
	 * @param info [ key : new_add1, new_add2, mem_id ]
	 * @return boolean
	 */
	boolean updateMemAdd(Map<String, String> info);

	/**
	 * 회원의 이메일을 변경하는 메서드
	 * @author 신광진
	 * @param info [ key : new_mail, mem_id ]
	 * @return boolean
	 */
	boolean updateMemMail(Map<String, String> info);

	/**
	 * 회원탈퇴를 위한 메서드
	 * @author 신광진
	 * @return boolean
	 */
	boolean deleteMember(String mem_id);

	
	
	
	
	
	
	
	
	
	
}
