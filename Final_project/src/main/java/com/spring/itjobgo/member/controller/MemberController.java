package com.spring.itjobgo.member.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.spring.itjobgo.member.model.service.MemberService;
import com.spring.itjobgo.member.model.vo.Member;
import com.spring.itjobgo.member.model.vo.MemberPhoto;
import com.spring.itjobgo.member.model.vo.MemberScrap;
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
	public int memberRegister(@RequestBody Member member) {
		System.out.println("member: " + member);
		String encodePw = encoder.encode(member.getMemberPwd());
		member.setMemberPwd(encodePw);
		//0:관리자 1: 일반 회원 2: 이력서 첨삭 관리자 
		//3: 카카오 4:네이버 5: 구글
		member.setMemberLevel("1");// 일반회원 :0
		int result = 0;

		System.out.println(member);

		result = service.insertMember(member);

		if (result > 0) {
			return result;
		} else {
			return -1;
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
				return 1;
			} else {// 비밀번호 매치x
				return 0;
			}
		} else {
			return 0;
		}
	}

	// 이력서 사진 업데이트
	@RequestMapping(value = "/updatePhoto", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public int updatePhoto(@RequestParam Map param, @RequestBody MultipartFile upFile, HttpServletRequest request)
			throws IOException {

		int memberSq = Integer.parseInt(param.get("memberSq").toString());

		System.out.println("memberSq: " + memberSq);

		String savePhoto = request.getServletContext().getRealPath("/resources/upload/member");// 경로지정
		File file = new File(savePhoto);

		if (!file.exists()) {// 디렉토리 유무화인 후 생성여부 결정
			file.mkdirs();
		}

		String originalFileName = upFile.getOriginalFilename();// file이름 String으로

		logger.debug("originFile: " + originalFileName);
		String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
		logger.debug("ext: " + ext);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
		int rndNum = (int) (Math.random() * 1000);

		String renamedFileName = sdf.format(new Date(System.currentTimeMillis())) + "_" + rndNum + "." + ext;
		logger.debug("renamedFileName: " + renamedFileName);
		try {
			/* renamedFileName으로 파일을 저장하기 -> transferTo(파일) */
			upFile.transferTo(new File(savePhoto + "/" + renamedFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		MemberPhoto mp = new MemberPhoto();
		mp.setMemberSq(memberSq);
		mp.setOriginalFileName(originalFileName);
		mp.setRenamedFileName(renamedFileName);

		// 파일 디비에 저장
		int result = 0;

		Member member = new Member();

		String tempImg = service.selectPhoto(param.get("memberSq").toString());

		if (tempImg == null) {// 이미지가 존재하지 않는경우 사진 insert
			result = service.insertPhoto(member, mp);
			if (result > 0) {

			} else {
				result = -1;
			}
		} else {// 존재하는 경우 사진 업데이트
			result = service.updatePhoto(member, mp);
			if (result > 0) {
				System.out.println(result);
			} else {
				result = -1;
			}
		}
		return result;

	}

	// 이력서 사진 로드 : 마이페이지
	@RequestMapping(value = "/loadPhoto", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] loadPhoto(HttpServletRequest request, @RequestParam Map param) throws IOException {

		String memberSq = param.get("memberSq").toString();

		String tempImg = service.selectPhoto(memberSq);
		String imagePath = null;
		if (tempImg != null) {// 등록된 사진이 있는경우
			imagePath = request.getServletContext().getRealPath("/resources/upload/member/" + tempImg);
			InputStream imageStream = new FileInputStream(imagePath);
			byte[] imageByteArray = IOUtils.toByteArray(imageStream);
			imageStream.close();
			return imageByteArray;
		} else {
			return null;
		}

	}

	// job스크랩
	@RequestMapping(value = "/scrapJob", method = RequestMethod.POST)
	public int scrapJob(@RequestBody Map param) {
		System.out.println("param: " + param);

		int result = 0;
		result = service.insertScrap(param);

		if (result > 0) {
			return result;
		} else {
			return -1;
		}

	}

	// job스크랩제거
	@RequestMapping(value = "/unscrapJob", method = RequestMethod.POST)
	public int unscrapJob(@RequestBody Map param) {
		System.out.println("param: " + param);

		int result = 0;
		result = service.deleteScrap(param);

		if (result > 0) {
			return result;
		} else {
			return -1;
		}

	}

	// 스크랩확인용 : 구직정보 상세페이지
	@RequestMapping(value = "/getScrapStatus", method = RequestMethod.GET)
	public List<MemberScrap> getScrapStatus(@RequestParam Map param) throws IOException {
		System.out.println("scrap멤버호출: " + param);
		List<MemberScrap> ms = null;
		
		if (!(param.get("memberSq").equals("undefined"))) {
			ms = service.selectScrapList(param);
		}
		System.out.println("ms: " + ms);
		return ms;
	}

	// 스크랩확인용 : 마이페이지
	@RequestMapping(value = "/getScrap", method = RequestMethod.GET)
	public int getScrap(@RequestParam Map param) throws IOException {
		System.out.println("멤버호출: " + param);

		int result = service.selectScrap(param);
		System.out.println("멤버호출: " + result);

		return result;
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
				map.put("memberSq", login.getMemberSq());
				logger.debug("map: " + map);
				return map;
			} else {// 비밀번호 매치x
				return null;
			}
		} else {
			return null;
		}

	}

	// 카카오로그인
	@RequestMapping(value = "/kakaoRegister", method = RequestMethod.POST)
	public int kakaoRegister(@RequestBody Member member) {
		System.out.println("member: " + member);
		String encodePw = encoder.encode(member.getMemberPwd());
		member.setMemberPwd(encodePw);
		member.setMemberLevel("3");// 소셜회원 : 3으로 초기화
		
		int result = 0;

		logger.debug("member: ", member);
		ObjectMapper objectMapper = new ObjectMapper();
		Map param = objectMapper.convertValue(member, Map.class); // pojo->Map

		Member login = service.selectOneMember(param);// 가입한 회원인지 확인

		if (login == null) {// 디비에 없는 경우

			result = service.insertMember(member);
			if (result > 0) {
				return result;
			} else {
				return -1;
			}
		} else { // 디비에 존쟈하는 경우
			return 1;

		}

	}

	// 네이버 로그인
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/naverLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public void naverLogin(@RequestParam(value = "code") String code, @RequestParam(value = "state") String state,
			HttpServletResponse httpServletResponse) throws Exception, IOException {
		String clientId = "aYgNgGmIwR3wysmlCfRd";// 애플리케이션 클라이언트 아이디값";
		String naverClientSecret = "voZaFcwXXi";// 시크릿값
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + naverClientSecret;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		String access_token = "";
		int result = 0;
		String memberName, memberEmail = null, tmp;
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

				logger.debug("memberEmail: " + memberEmail);
				// member 객체 생성 insert용
				Member member = new Member();
				member.setMemberName(memberName);
				member.setMemberEmail(memberEmail);

				member.setMemberPwd("0000");// 비번 초기화
				String encodePw = encoder.encode(member.getMemberPwd());
				member.setMemberPwd(encodePw);
				member.setMemberToken(access_token);
				member.setMemberLevel("4");
				Random rand = new Random();

				int ranPhone = rand.nextInt(999999999);
				member.setMemberPhone(String.valueOf(ranPhone));
				System.out.println("member: " + member);

				// 네이버에서 받은 토큰에 유저 정보 넣어서 토큰 생성
				access_token = createJWTToken(id, memberName, memberEmail);

				logger.debug("memberEmail: " + memberEmail);
				System.out.println(member);

				ObjectMapper objectMapper = new ObjectMapper();
				Map param = objectMapper.convertValue(member, Map.class); // pojo->map

				Member login = service.selectOneMember(param);// db에 저장된 회원인지 확인

				if (login == null) {// 디비에 없으면insert

					result = service.insertMember(member);

					if (result > 0) { // 잘들어가면 페이지 이동
						httpServletResponse.setHeader("access_token", access_token);// 헤더에 토큰 저장
						httpServletResponse.sendRedirect(
								"http://localhost:8081/naverLogin?token=" + access_token + "&email=" + memberEmail);

					}

				} else {// 디비에 있으면그냥 바로 토큰 저장하고 이동
					httpServletResponse.setHeader("access_token", access_token);// 헤더에 토큰 저장
					httpServletResponse.sendRedirect(
							"http://localhost:8081/naverLogin?token=" + access_token + "&email=" + memberEmail);
				}

			}
		} catch (Exception e) {

			System.out.println(e);
		}
		logger.debug("result: " + result);

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
