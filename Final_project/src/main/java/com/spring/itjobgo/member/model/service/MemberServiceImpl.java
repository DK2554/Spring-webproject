package com.spring.itjobgo.member.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.member.model.dao.MemberDao;
import com.spring.itjobgo.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private Logger logger;
	
	@Override
	public int insertMember(Member member) {
		return dao.insertMember(session,member);
	}	

	@Override
	public Member selectOneMember(Map param) {
		return dao.selectOneMember(session,param);
	}

	@Override
	public Member selectPhoneNum(Map param) {
		return dao.selectPhoneNum(session, param);
	}

	@Override
	public Member selectEmailPhone(Map param) {
		return dao.selectEmailPhone(session, param);
	}

	@Override
	public int updatePwd(Member member) {
		
		return dao.updatePwd(session,member);
	}

	@Override
	public Member selectPhone(Map param) {
		return dao.selectPhone(session, param);
	}

	
			
}
