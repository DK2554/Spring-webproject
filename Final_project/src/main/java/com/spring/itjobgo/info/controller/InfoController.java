package com.spring.itjobgo.info.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spring.itjobgo.info.model.service.InfoService;
import com.spring.itjobgo.info.model.vo.INFO_ATTACHMENT;
import com.spring.itjobgo.info.model.vo.Info;

@RestController
public class InfoController {

	@Autowired
	private Logger logger;

	@Autowired
	private InfoService service;

	// 화면전환 하는 메서드
	@RequestMapping(value = "/info/infoList", method = RequestMethod.GET)
	public List<Info> info() throws JsonMappingException, JsonGenerationException, IOException {
		List<Info> list = service.selectInfoList();
		
		for (Info i : list) {
			System.out.println(i);
		}
		return list;
	}
	// info 게시판 글쓰기
	@RequestMapping(value = "/info/infoForm", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String ifBoard(Info iboard, @RequestParam(value = "memberSq") int memberno,
			@RequestBody MultipartFile[] file, HttpServletRequest request) {

		System.out.println("멤버번호  : " + memberno);
		iboard.setMemberNum(memberno);

		logger.debug("매핑확인");
		logger.debug("======vue에서 전송한  파일========");
		// 파일이 있다면
		if (file.length > 0) {
			logger.debug("파일명" + file[0].getOriginalFilename());
			logger.debug("파일크기 : " + file[0].getSize());
		}
		
		logger.debug(iboard.toString());

		// 업로드 경로 설정
		// 파일 리네임 처리후 파일 저장하기
		String saveDir = request.getServletContext().getRealPath("/resources/upload/info");

		File dir = new File(saveDir);

		if (!dir.exists()) {
			// 지정된경로의 폴더가 없으면
			dir.mkdirs(); // mk > make directory
		}

		List<INFO_ATTACHMENT> files = new ArrayList<INFO_ATTACHMENT>();

		for (MultipartFile f : file) {

			if (!f.isEmpty()) {

				String originalFileName = f.getOriginalFilename();
				String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");

				int rndNum = (int) (Math.random() * 1000);

				String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "_" + rndNum + "." + ext;

				try {
					// 파일저장하기
					// 스프링이 제공하는 멀티파트가 메소드를 제공한다 tansferTo(파일)라는 메소드를 제공한다
					f.transferTo(new File(saveDir + "/" + renameFileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				INFO_ATTACHMENT file2 = new INFO_ATTACHMENT(0, 0, originalFileName, renameFileName, null, null);
				files.add(file2);
			}
		}
		int result = 0;

		try {

			// Info 글 작성하기
			result = service.insertInfo(iboard, files);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}	
		String msg = "";
		if (result > 0) msg = "등록 성공!";
		else msg = "등록 실패!";
		return msg;
	}

	// 취업정보 게시판 상세화면 전환 페이지
	@RequestMapping(value = "/info/infoDetail{infoSq}", method = RequestMethod.GET)
	public Info selectInfoOne(@PathVariable int infoSq, HttpServletRequest request, HttpServletResponse response)
			throws JsonMappingException, JsonGenerationException, IOException {

		logger.debug("infoSq" + Integer.toString(infoSq));

		// 조회수 증가
		Cookie[] cookies = request.getCookies();
		String boardHistory = "";
		boolean hasRead = false;

		if (cookies != null) {
			for (Cookie c : cookies) {

				String name = c.getName();
				String value = c.getValue();

				if ("boardHistory".equals(name)) {
					boardHistory = value;

					if (value.contains("|" + infoSq + "|")) {
						hasRead = true;
						break;
					}
				}
			} // for
		} // if

		if (!hasRead) {
			Cookie c = new Cookie("boardHistory", boardHistory + "|" + infoSq + "|");
			c.setMaxAge(-1);
			response.addCookie(c);

		}

		Info iboard = service.selectInfoOne(infoSq, hasRead);

		return iboard;

	}

	// 취업정보 글 삭제하기
	@RequestMapping(value = "info/infoDelete{infoSq}", method = RequestMethod.POST)
	public String deleteInfo(@PathVariable int infoSq, HttpServletRequest request)
			throws JsonMappingException, JsonGenerationException, IOException {
System.out.println("게시판 삭제 맵");
		// 먼저 첨부파일이 삭제가 되면 그 그결과값이 result>0이면 게시글 삭제로 이어지도록
		String msg = "";
		logger.debug("첨부파일 삭제 후 게시글 삭제 로직 수행 logger");

		// 먼저 게시글 번호를 가지고 해당 첨부파일을 가져오는 메서드
		INFO_ATTACHMENT ifa = service.selectAttach(infoSq);
		System.out.println(ifa);
		// 첨부파일이 있을경우
		if (ifa != null) {
			// 첨부파일을 가져온 후 첨부파일을 서버에서(/resources/upload/info)삭제
			String ReNameFile = ifa.getRenamedfilename();
			String saveDir = request.getServletContext().getRealPath("/resources/upload/info");

			// 게시글 삭제 후 -> 첨부파일 삭제
			int result = service.deleteInfo(infoSq);

			if (result > 0) {
				msg = "게시글 삭제 완료";
				// 삭제를 완료했을때, 첨부파일 있을시 함께 삭제
				File file = new File(saveDir + "/" + ReNameFile);
				if (file.exists()) {
					if (file.delete())
						logger.debug("첨부파일 삭제 성공");
					else
						logger.debug("첨부파일 삭제 실패");
				}
			} else {
				msg = " info 게시글 삭제 실패 ";
			}
			// 첨부파일이 없는 게시글 삭제
		} else {
			int result = service.deleteInfo(infoSq);
			msg = (result > 0) ? " info 삭제 성공" : " info 삭제 실패";
		}
		logger.debug(msg);
		return msg;

	}

	// 첨부파일 먼저 불러오기 (update form 으로)

	@RequestMapping(value = "/info/infoUpdate{infoSq}", 
								method = RequestMethod.GET)
	public INFO_ATTACHMENT selectAttach(@PathVariable int infoSq) {

		System.out.println("==첨부파일 불러오기 맵핑 시작==");

		INFO_ATTACHMENT ifa = service.selectAttach(infoSq);

		System.out.println(ifa);

		return ifa;
	}

	// 게시판 수정(update)
	@RequestMapping(value = "/info/infoUpdateEnd",
						method = RequestMethod.POST, 
						consumes = { "multipart/form-data" })
	public String infoUpdate(Info ifo, 
							@RequestBody(required = false) 
							MultipartFile[] file,
							HttpServletRequest request) {

		System.out.println("==업데이트 메서드 실행==");

		if (file.length > 0) {
			// 파일이 존재한다면 게시판 번호를 변수에 넣어둔다.
			int infoSq = ifo.getInfoSq();

			String saveDir = request.getServletContext().getRealPath("/resources/upload/info");

			File dir = new File(saveDir);
			if (!dir.exists()) {
				// 지정된 경로가 없으면 폴더를 생성해주는 메서드 mkdirs()
				dir.mkdirs();
			}

			List<INFO_ATTACHMENT> files = new ArrayList();

			// 원래 파일이 존재한다면! get해서 가져와서 변수에 저장해두기
			   for(MultipartFile f:file) {
			         if(!f.isEmpty()) {
			         String originalFileName=f.getOriginalFilename();
			         String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			         SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
			         int rndNum=(int)(Math.random()*1000);
			         String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
			         		            
					try {
						// 파일 저장
						f.transferTo(new File(saveDir + "/" + renameFileName));
					} catch (IOException e) {
						e.printStackTrace();
					}

					INFO_ATTACHMENT file2 = new INFO_ATTACHMENT(0, infoSq, originalFileName, renameFileName, null,null);
					files.add(file2);

				}
			}
			    int result=0;
			      try {
			         //게시판 글 업데이트
			         result =service.updateInfo(ifo,files);
			      }catch(RuntimeException e) {
			         e.printStackTrace();
			      }
			      String msg="";
			      if(result>0) msg="게시글 수정 성공";
			      else msg="게시글 수정 실패";
			      
			      }//193번째줄 if > 파일이 있다면 / 게시판 정보만 업데이트
			      else {
			         int result = service.updateInfo(ifo);
			      }
			      return "업데이트 테스트";
			   
	}
	
	//첨부파일 표시
	@RequestMapping(value="info/infoAttachment{infoSq}",
	                        method=RequestMethod.GET)
	public INFO_ATTACHMENT downLoad(@PathVariable int infoSq) {
	   
	   System.out.println("==첨부파일 다운로드 매핑 시작==");
	   logger.debug(Integer.toString(infoSq));
	   INFO_ATTACHMENT ifa = service.selectAttach(infoSq);
	   if(ifa==null) return null;
	   else return ifa;
	}
	  
	//첨부파일 다운로드(이름 보내기)
	@RequestMapping(value="info/filedownload",method=RequestMethod.GET)
	public void filedownload(HttpServletRequest request,HttpServletResponse response,
	                                 @RequestHeader(name="user-agent")String header,
	                                 @RequestParam(value="oriName") String oriName,
	                                 @RequestParam(value="reName")  String reName) 
	                                 {
	   
	   logger.debug(oriName);
	   logger.debug(reName);
	   String path=request.getServletContext().getRealPath("/resources/upload/info");
	   File saveFile=new File(path+"/"+reName);
	   BufferedInputStream bis=null;
	   ServletOutputStream sos=null;
	   
	   try {
	      bis=new BufferedInputStream(new FileInputStream(saveFile));
	      sos=response.getOutputStream();
	      boolean isMSIE=header.indexOf("Trident")!=-1||header.indexOf("MSIE")!=-1;
	      String encodeRename="";
	      if(isMSIE) {
	         encodeRename=URLEncoder.encode(oriName,"UTF-8").replaceAll("\\+","%20");
	         
	      }else {
	         encodeRename=new String(oriName.getBytes("UTF-8"),"ISO-8859-1");
	      }
	      response.setContentType("application/octet-stream;charset=utf-8");
	      response.setHeader("Content-Disposition", "attachment;filename=\""+encodeRename+"\"");
	      response.setHeader("Content-Transfer-Encoding", "binary;");
	      response.setContentLength((int)saveFile.length());
	      int read=-1;
	      while((read=bis.read())!=-1) {
	         sos.write(read);
	      }
	   }catch(IOException e) {
	      e.printStackTrace();
	   }finally {
	      try {
	         sos.close();
	         bis.close();
	      }catch(IOException e) {
	         e.printStackTrace();
	      }
	   }
	}
	   
	}//클래스