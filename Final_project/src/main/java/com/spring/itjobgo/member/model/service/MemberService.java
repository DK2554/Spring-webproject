package com.spring.itjobgo.member.model.service;

import java.util.Map;

import com.spring.itjobgo.member.model.vo.Member;

public interface MemberService {

	int insertMember(Member member);

	Member selectOneMember(Map param);

	Member selectPhoneNum(Map param);

}
