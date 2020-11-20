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

	@Override
	public Member selectEmailPhone(SqlSession session, Map param) {
		System.out.println("dao: " + param);
		return session.selectOne("member.selectEmailPhone", param);
	}

	@Override
	public int updatePwd(SqlSession session,Member member) {
		System.out.println("update dao: " + member);
		
		return session.update("member.updatePwd", member);
	}

	@Override
	public Member selectPhone(SqlSession session, Map param) {
		return session.selectOne("member.selectPhone", param);
	}


	
}
