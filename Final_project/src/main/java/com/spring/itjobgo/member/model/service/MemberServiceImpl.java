package com.spring.itjobgo.member.model.service;

import java.util.Map;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.member.model.dao.MemberDao;
import com.spring.itjobgo.member.model.vo.Member;
import com.spring.itjobgo.member.model.vo.MemberPhoto;

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

}
