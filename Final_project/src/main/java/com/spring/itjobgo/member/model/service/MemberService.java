package com.spring.itjobgo.member.model.service;

import java.util.Map;

import com.spring.itjobgo.member.model.vo.Member;

public interface MemberService {
	//public String createToken(LoginRequest loginRequest)

	int insertMember(Member member);

	Member selectOneMember(Map param);

	Member selectPhoneNum(Map param);

	Member selectEmailPhone(Map param);

	int updatePwd(Member member);

	Member selectPhone(Map param);


}
