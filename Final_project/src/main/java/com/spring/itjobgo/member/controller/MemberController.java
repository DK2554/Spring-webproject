package com.spring.itjobgo.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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
		System.out.println("member: " + member);
		String encodePw = encoder.encode(member.getMemberPwd());
		member.setMemberPwd(encodePw);
		int result = 0;
		System.out.println(member);
		try {
			result = service.insertMember(member);

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

	// 멤버 탈퇴
	@RequestMapping(value = "/deleteMember", method = RequestMethod.POST)
	public int memberDelete(@RequestBody Map param) {
		logger.debug("param: " + param);
		Member login = service.selectOneMember(param);// param값 존재하는 지 확인용

		int result = 0;

		if (encoder.matches((String) param.get("memberPwd"), login.getMemberPwd())) {
			logger.debug("비밀번호 맞음");
			result = service.deleteMember(login.getMemberEmail());
			System.out.println("result: " + result);
			
			return result;
		} else {
			logger.debug("비밀번호 틀림");
			result = -1;
			return result;
		}
	}

	// 인포 업데이트
	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public int memberUpdate(@RequestBody Map param) {
		System.out.println("parma: " + param);
		Member login = service.selectOneMember(param);// param값 존재하는 지 확인용

		login.setMemberPhone((String) param.get("memberPhone"));
		login.setMemberPostCode((String) param.get("memberPostCode"));
		login.setMemberAddr((String) param.get("memberAddr"));
		login.setMemberAddrDtl((String) param.get("memberAddrDtl"));
		login.setMemberAddrExtra((String) param.get("memberAddrExtra"));
		login.setMemberPosition((String) param.get("memberPosition"));
		System.out.println(login);

		int result = 0;

		if (encoder.matches((String) param.get("memberPwd"), login.getMemberPwd())) {
			logger.debug("비밀번호 맞음");
			result = service.updateInfo(login);
			return result;
		} else {
			result = -1;
			return result;
		}
	}

	// 비밀번호 변경 : 회원정보 수정
	@RequestMapping(value = "/updatePwdInfo", method = RequestMethod.POST)
	public int updatePwdInfo(@RequestBody Map param) {
		System.out.println(param);
		Member login = service.selectOneMember(param);// param값 존재하는 지 확인용
		System.out.println(login);

		int result = 0;

		if (encoder.matches((String) param.get("memberPwd"), login.getMemberPwd())) {// 비밀번호 비교
			logger.debug("비밀번호매치");
			String encodePw = encoder.encode((String) param.get("memberNewPwd"));// 업데이트된 비번 암호화
			login.setMemberPwd(encodePw);
			System.out.println(login);
			result = service.updatePwd(login);
			return result;
		} else {

			result = -1;
			return result;
		}

	}

	// 이메일 중복검사
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	public Member checkEmail(@RequestBody Map param) throws IOException {
		System.out.println(param);
		Member m = service.selectOneMember(param);
		return m;
	}

	// 회원 정보 가져오기
	@RequestMapping(value = "/getMember", method = RequestMethod.GET)
	public Member getMember(@RequestParam Map param) throws IOException {
		System.out.println("멤버호출: " + param);
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
		return m;
	}

	// 전화번호 이메일 비교 : 비밀번호 업데이트
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	public int UpdatePwd(@RequestBody Map param) throws IOException {
		System.out.println("update controller: " + param);
		Member m = service.selectOneMember(param);

		String encodePw = encoder.encode((String) param.get("memberPwd"));// 업데이트된 비번 암호화
		m.setMemberPwd(encodePw);
		System.out.println(m);
		int result = 0;

		result = service.updatePwd(m);

		if (result > 0) {
			return result;
		} else {
			return result;
		}

	}

	// 이메일찾기
	@RequestMapping(value = "/selectPhone", method = RequestMethod.POST)
	public Member selectPhone(@RequestBody Map param) throws IOException {
		Member m = service.selectPhone(param);
		return m;
	}

	// 이메일 비밀번호 확인 : 회원정보 수정
	@RequestMapping(value = "/checkInfo", method = RequestMethod.POST)
	public int checkMember(@RequestBody Map param) throws IOException {
		System.out.println("controller: " + param);
		Member login = service.selectOneMember(param);
		System.out.println("login: " + login);
		if (login != null) {// id값이 존재하는 경우

			if (encoder.matches((String) param.get("memberPwd"), login.getMemberPwd())) {// 비밀번호 비교
				// 비밀번호 매치o
				System.out.println("비밀번호 ok");
				return 1;
			} else {// 비밀번호 매치x
				System.out.println("비밀번호 no");
				return 0;
			}
		} else {
			System.out.println("비밀번호 no");
			return 0;
		}
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

	 @SuppressWarnings("deprecation")
	@RequestMapping(value = "/naverLogin", method = {RequestMethod.GET, RequestMethod.POST})
	public void naverLogin(@RequestParam(value = "code") String code, @RequestParam(value = "state") String state,HttpServletResponse httpServletResponse)
			throws Exception,IOException   {
		String clientId = "aYgNgGmIwR3wysmlCfRd";// 애플리케이션 클라이언트 아이디값";
		String naverClientSecret = "voZaFcwXXi";// 시크릿값
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + naverClientSecret;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		String access_token = "";

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;

			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();

			if (responseCode == 200) {// 토큰 잘 가져오는 경우
				int id;
				String memberName, memberEmail, tmp;

				JsonParser parser = new JsonParser();

				JsonElement accessElement = parser.parse(res.toString());// access_token, refresh_token
				logger.debug("accessElement: " + accessElement);

				access_token = accessElement.getAsJsonObject().get("access_token").getAsString(); // access_token

				tmp = getUserInfo(access_token);// 유저정보 가져오기
				
				System.out.println("temp: " + tmp);

				JsonElement userInfoElement = parser.parse(tmp);
				id = userInfoElement.getAsJsonObject().get("response").getAsJsonObject().get("id").getAsInt();
				System.out.println("response: " + userInfoElement.getAsJsonObject().get("response").getAsJsonObject());

				memberEmail = userInfoElement.getAsJsonObject().get("response").getAsJsonObject().get("email")
						.getAsString();
				memberName = userInfoElement.getAsJsonObject().get("response").getAsJsonObject().get("name")
						.getAsString();
				
				Member member = new Member();
				member.setMemberName(memberName);
				member.setMemberEmail(memberEmail);
				member.setMemberPwd("0000");
				member.setMemberToken(access_token);
				Random rand = new Random();
				
				int ranPhone = rand.nextInt(9); 
				member.setMemberPhone(String.valueOf(ranPhone));
				System.out.println("member: " + rand);
				
				
				// 네이버에서 받은 토큰에 유저 정보 넣어서 토큰 생성
				access_token = createJWTToken(id, memberName, memberEmail);
				
				
				
				
				logger.debug("memberEmail: " + memberEmail);

				

				
				int result = 0;
				System.out.println(member);
				try {
					result = service.insertMember(member);

				} catch (RuntimeException e) {
					e.printStackTrace();
				}
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		httpServletResponse.setHeader("access_token", access_token);
		httpServletResponse.sendRedirect("http://localhost:8081/");

	}

	private String getUserInfo(String access_token) {
		String header = "Bearer " + access_token; // Bearer 다음에 공백 추가 + 토큰

		try {
			String apiURL = "https://openapi.naver.com/v1/nid/me"; // 정보요청
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;

			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			logger.debug("getUserInfo: " + res.toString()); // 받아온 정보
			return res.toString();

		} catch (Exception e) {
			System.err.println(e);
			return "Err";
		}
	}

	private String createJWTToken(int id, String memberEmail, String memberName) {// 토큰 발행용
		String token = null;
		DecodedJWT jwt = null;

		try {
			Long EXPIRATION_TIME = 1000L * 60L * 10L;
			Date issuedAt = new Date();
			Date notBefore = new Date(issuedAt.getTime());
			Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME);

			Algorithm algorithm = Algorithm.HMAC256("iouytrdfcvghjkluytfgcvbnjkliuytfdcvbhj");
			token = JWT.create().withIssuer("auth0").withSubject(memberName).withAudience("itjobgo").withClaim("id", id)
					.withClaim("memberEmail", memberEmail).withNotBefore(notBefore).withExpiresAt(expiresAt)
					.sign(algorithm);
		} catch (Exception e) {
			System.err.println("err: " + e);
		}
		logger.debug("token: " + token);
		return token;
	}

}
