package com.spring.itjobgo.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.spring.itjobgo.member.model.vo.Member;

public interface MemberDao {

	int insertMember(SqlSession session, Member member);

	Member selectOneMember(SqlSession session, Map param);
	
	Member selectPhoneNum(SqlSession session, Map param);

	Member selectEmailPhone(SqlSession session, Map param);

	int updatePwd(SqlSession session, Member member);


}
