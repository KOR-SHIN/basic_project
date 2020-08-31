package com.advanceteam.service;

import com.advanceteam.database.Database;
import com.advanceteam.vo.MemberVO;

public class IServiceImple {

	Database db = new Database();
	
	public boolean addMember(MemberVO member) {
		// TODO Auto-generated method stub
		boolean ret = db.addMember(member);
		return ret;
	}

}
