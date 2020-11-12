package com.spring.itjobgo.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private Logger logger;
	
	@Override
	public int insertMember(SqlSession session, Member member) {
		
		return session.insert("member.insertMember",member);
	}

	@Override
	public Member selectOneMember(SqlSession session,Map param) {				
		
		return session.selectOne("member.selectOneMember",param); 
	}

	@Override
	public Member selectPhoneNum(SqlSession session, Map param) {
		return session.selectOne("member.selectPhoneNum", param);
	}

	
}
