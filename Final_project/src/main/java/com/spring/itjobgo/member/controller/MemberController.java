0package com.spring.itjobgo.member.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.itjobgo.member.model.service.MemberService;
import com.spring.itjobgo.member.model.vo.Member;

@RestController
@RequestMapping("/member")
public class MemberController{
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping(value="/register", method = RequestMethod.POST )
	public void memberRegister(@RequestBody Member member) {
		
		String encodePw=encoder.encode(member.getMemberPwd());
		member.setMemberPwd(encodePw);		
		int result = service.insertMember(member);
		
	}
	
	//이메일 중복검사
	@RequestMapping(value="/checkEmail", method=RequestMethod.POST)
	public Member checkEmail( @RequestBody Map param) throws IOException {
		
		Member m = service.selectOneMember(param);		
		return m;
	}
	
	//전화번호 중복검사
	@RequestMapping(value="/checkPhone", method=RequestMethod.POST)
	public Member checkPhone( @RequestBody Map param) throws IOException {
		
		Member m = service.selectPhoneNum(param);
		return m;
	}
	
	
//	@RequestMapping(value="/login", method=RequestMethod.POST) 
//	public Member loginMember (@RequestBody Map param, Model m, HttpSession session) throws IOException {
//		System.out.println("param: " + param);
//		
//		Member login=service.selectOneMember(param);
//		
//		System.out.println("login: " + login);
//		
//		if(login!=null) {//id있음
//		
//				if(encoder.matches((String)param.get("memberPwd"), login.getMemberPwd())) {
//					//비번매치
//					System.out.println("비번매치");
//					
//					m.addAttribute("loginMember",login);
//					System.out.println("m: " + login.getMemberPwd());
//					return login;
//				}
//				return null;
//			}else {
//				return null;
//			}
//		
//		
//	}
	
//	@GetMapping("/login")
//	public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest){
//		String token = service.createToken(loginRequest);
//		return ResponseEntity.ok().body(new TokenResponse(token, "bearer"));
//	}
	 

}
