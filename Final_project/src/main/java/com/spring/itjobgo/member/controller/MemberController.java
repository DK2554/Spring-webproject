package com.spring.itjobgo.member.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.itjobgo.member.model.service.MemberService;
import com.spring.itjobgo.member.model.vo.Member;
import com.spring.itjobgo.security.service.SecurityService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private Logger logger;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void memberRegister(@RequestBody Member member) {

		String encodePw = encoder.encode(member.getMemberPwd());
		member.setMemberPwd(encodePw);
		int result = service.insertMember(member);

	}

	// 이메일 중복검사
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	public Member checkEmail(@RequestBody Map param) throws IOException {

		Member m = service.selectOneMember(param);
		return m;
	}

	// 전화번호 중복검사
	@RequestMapping(value = "/checkPhone", method = RequestMethod.POST)
	public Member checkPhone(@RequestBody Map param) throws IOException {

		Member m = service.selectPhoneNum(param);
		return m;
	}

	// 전화번호 이메일 비교 : 비밀번호 업데이트
	@RequestMapping(value = "/compareEmailPhone", method = RequestMethod.POST)
	public Member compareEmailPhone(@RequestBody Map param) throws IOException {

		Member m = service.selectEmailPhone(param);
		// TODO: nullpt 에러
		return m;
	}

	// 전화번호 이메일 비교 : 비밀번호 업데이트
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	public void UpdatePwd(@RequestBody Map param) throws IOException {

		Member m = service.selectOneMember(param);

		String encodePw = encoder.encode((String) param.get("memberPwd"));// 업데이트된 비번 암호화
		m.setMemberPwd(encodePw);

		System.out.println(m);
		service.updatePwd(m);

	}
	
	//이메일찾기
	@RequestMapping(value = "/selectPhone", method = RequestMethod.POST)
	public Member selectPhone(@RequestBody Map param) throws IOException {

		Member m = service.selectPhone(param);		
		return m;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map loginMember(@RequestBody Map param) throws IOException {

		logger.debug("param:" + param);

		Member login = service.selectOneMember(param);

		logger.debug("login:" + login);

		if (login != null) {// id값이 존재하는 경우

			if (encoder.matches((String) param.get("memberPwd"), login.getMemberPwd())) {// 비밀번호 비교
				// 비밀번호 매치o
				// 토큰값 생성해야됨
				String token = securityService.createToken((String) param.get("memberEmail"), (2 * 1000 * 60));
				Map<String, Object> map = new LinkedHashMap<String, Object>();
				// 토큰값!!!
				map.put("token", token);
				logger.debug("map: " + map);
				return map;
			} else {// 비밀번호 매치x
				return null;
			}
		} else {
			return null;
		}

	}

}
