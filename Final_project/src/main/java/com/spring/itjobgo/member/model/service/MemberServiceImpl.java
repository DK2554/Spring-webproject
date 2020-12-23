package com.spring.itjobgo.member.model.service;

import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.member.model.dao.MemberDao;
import com.spring.itjobgo.member.model.vo.Member;
import com.spring.itjobgo.member.model.vo.MemberPhoto;
import com.spring.itjobgo.member.model.vo.MemberScrap;

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
		return dao.insertMember(session, member);
	}

	@Override
	public Member selectOneMember(Map param) {
		return dao.selectOneMember(session, param);
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

		return dao.updatePwd(session, member);
	}

	@Override
	public Member selectPhone(Map param) {
		return dao.selectPhone(session, param);
	}

	@Override
	public int updateInfo(Member login) {
		return dao.updateInfo(session, login);
	}

	@Override
	public int deleteMember(String email) {
		return dao.deleteMember(session, email);
	}

	@Override
	public int insertPhoto(Member member, MemberPhoto mp) {
		System.out.println("mp in service: " +mp);
		int result = 0;
		if (mp != null) {
			result = dao.insertPhoto(session, mp);
			System.out.println("result: " + result);
			if (result == 0)
				throw new RuntimeErrorException(null, "입력오류");
		}
		return result;
	}

	@Override
	public String selectPhoto(String memberSq) {
		return dao.selectPhoto(session, memberSq);
	}

	@Override
	public int updatePhoto(Member member, MemberPhoto mp) {
		return dao.updatePhoto(session, mp);
	}

	@Override
	public int insertScrap(Map param) {
		return dao.insertScrap(session, param);
	}

	@Override
	public int deleteScrap(Map param) {
		return dao.deleteScrap(session, param);
	}

	@Override
	public List<MemberScrap> selectScrapList(Map param) {
		return dao.selectScrapList(session, param);
		
	}

	@Override
	public int selectScrap(Map param) {
		return dao.selectScrap(session, param);
	}

	//이력서 전문가 등록
	@Override
	public int updateConsultant(int memberSq) {
		return dao.updateConsultant(session, memberSq);
	}

	
}
