package com.spring.itjobgo.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.member.model.vo.Member;
import com.spring.itjobgo.member.model.vo.MemberPhoto;
import com.spring.itjobgo.member.model.vo.MemberScrap;

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

	@Override
	public int updateInfo(SqlSession session, Member login) {
		return session.update("member.updateInfo", login);
	}

	@Override
	public int deleteMember(SqlSession session, String email) {
		System.out.println("login: " + email);
		return session.delete("member.deleteMember", email);
	}

	@Override
	public int insertPhoto(SqlSession session, MemberPhoto mp) {
		System.out.println("mp: " + mp);
		return session.insert("member.insertPhoto", mp);
	}

	@Override
	public String selectPhoto(SqlSession session, String memberSq) {
		return session.selectOne("member.selectPhoto", memberSq);
	}

	@Override
	public int updatePhoto(SqlSession session, MemberPhoto mp) {
		return session.update("member.updatePhoto", mp);
	}

	@Override
	public int insertScrap(SqlSession session, Map param) {
		
		return session.insert("member.insertScrap", param);
	}

	@Override
	public int deleteScrap(SqlSession session, Map param) {
		return session.delete("member.deleteScrap", param);
	}

	@Override
	public List<MemberScrap> selectScrapList(SqlSession session, Map param) {
	
		return session.selectList("member.selectScrapList", param);
	}

	@Override
	public int selectScrap(SqlSession session, Map param) {
		return session.selectOne("member.selectScrap", param);
	}

	//이력서 전문가 등록
	@Override
	public int updateConsultant(SqlSession session, int memberSq) {
		return session.update("member.updateConsultant", memberSq);
	}


	
	
}
