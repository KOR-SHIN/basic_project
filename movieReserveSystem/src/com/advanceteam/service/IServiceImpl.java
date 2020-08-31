package com.advanceteam.service;

import java.util.ArrayList;
import java.util.List;

import com.advanceteam.database.Database;
import com.advanceteam.vo.MemberVO;

public class IServiceImpl implements IService {

	Database db = new Database();
	
	public boolean addMember(MemberVO member) {
		// TODO Auto-generated method stub
		boolean ret = db.addMember(member);
		return ret;
	}

	public List<MemberVO> readMember() {
		// TODO Auto-generated method stub
		return db.readMember();
	}

}
