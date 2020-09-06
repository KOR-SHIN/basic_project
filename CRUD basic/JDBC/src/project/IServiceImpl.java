package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IServiceImpl implements IService {

	private IDao dao = new IDaoImpl();
	
	@Override
	public String logIn(Map<String, String> params) {
		return dao.logIn(params);
	}

	@Override
	public List<MemberVO> readAllMember() {
		return dao.readAllMember();
	}

	@Override
	public MemberVO readMemInfo(String login_id) {
		return dao.readMemInfo(login_id);
	}

	@Override
	public boolean createMember(MemberVO newMember) {
		return dao.createMember(newMember);
	}

	@Override
	public boolean updateMemHp(Map<String, String> info) {
		return dao.updateMemHp(info);
	}

	@Override
	public boolean checkDupId(String mem_id) {
		return dao.checkDupId(mem_id);
	}

	@Override
	public boolean updateMemAdd(Map<String, String> info) {
		return dao.updateMemAdd(info);
	}

	@Override
	public boolean updateMemMail(Map<String, String> info) {
		return dao.updateMemMail(info);
	}

	@Override
	public boolean deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}



}
