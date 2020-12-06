package com.spring.itjobgo.member.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.member.model.vo.Member;
import com.spring.itjobgo.member.model.vo.MemberPhoto;

public interface MemberService {
	//public String createToken(LoginRequest loginRequest)

	int insertMember(Member member);

	Member selectOneMember(Map param);

	Member selectPhoneNum(Map param);

	Member selectEmailPhone(Map param);

	int updatePwd(Member member);

	Member selectPhone(Map param);

	int updateInfo(Member login);

	int deleteMember(String email);

	int insertPhoto(Member member, MemberPhoto mp);

	String selectPhoto(String memberSq);

	int updatePhoto(Member member, MemberPhoto mp);

	int insertScrap(Map param);

	int deleteScrap(Map param);

	


}
