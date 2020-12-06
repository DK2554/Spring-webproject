package com.spring.itjobgo.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.spring.itjobgo.member.model.vo.Member;
import com.spring.itjobgo.member.model.vo.MemberPhoto;

public interface MemberDao {

	int insertMember(SqlSession session, Member member);

	Member selectOneMember(SqlSession session, Map param);
	
	Member selectPhoneNum(SqlSession session, Map param);

	Member selectEmailPhone(SqlSession session, Map param);

	int updatePwd(SqlSession session, Member member);

	Member selectPhone(SqlSession session, Map param);

	int updateInfo(SqlSession session, Member login);

	int deleteMember(SqlSession session, String email);

	int insertPhoto(SqlSession session, MemberPhoto mp);

	String selectPhoto(SqlSession session, String memberSq);

	int updatePhoto(SqlSession session, MemberPhoto mp);

	int insertScrap(SqlSession session, Map param);

	int deleteScrap(SqlSession session, Map param);


}
