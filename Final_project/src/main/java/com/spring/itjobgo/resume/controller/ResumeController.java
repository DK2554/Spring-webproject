package com.spring.itjobgo.resume.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
import com.spring.itjobgo.qna.model.vo.QB_COMMENT;
import com.spring.itjobgo.qna.model.vo.QnaBoard;
import com.spring.itjobgo.resume.model.service.ResumeService;
import com.spring.itjobgo.resume.model.vo.Consult;
import com.spring.itjobgo.resume.model.vo.ConsultAttachment;
import com.spring.itjobgo.resume.model.vo.Rboard;
import com.spring.itjobgo.resume.model.vo.RboardAttachment;
import com.spring.itjobgo.resume.model.vo.Resume;
import com.spring.itjobgo.resume.model.vo.ResumeAbroad;
import com.spring.itjobgo.resume.model.vo.ResumeActivity;
import com.spring.itjobgo.resume.model.vo.ResumeAll;
import com.spring.itjobgo.resume.model.vo.ResumeAttachment;
import com.spring.itjobgo.resume.model.vo.ResumeLanguage;
import com.spring.itjobgo.resume.model.vo.ResumeLicense;
import com.spring.itjobgo.resume.model.vo.ResumeList;
import com.spring.itjobgo.resume.model.vo.ResumeProject;
import com.spring.itjobgo.resume.model.vo.ResumeSchool;
import com.spring.itjobgo.resume.model.vo.ResumeWork;

@RestController
public class ResumeController {

	@Autowired
	private ResumeService service;
	
	@Autowired
	private Logger logger;
	
	@ResponseBody
	@RequestMapping(value="resume/rboardList.do",method=RequestMethod.GET)
	public List<Rboard> selectRboardList() {
		System.out.println("********이력서컨설팅 리스트 컨트롤러 *********");
		List<Rboard> list=service.selectListRboard();

		for(Rboard i : list) {
			System.out.println(i);
		}
		System.out.println(list);
		return list;
	}
	
	@RequestMapping(value="resume/rboardView/{rboardNo}.do",method=RequestMethod.GET)
	public Rboard selectRboard(@PathVariable int rboardNo,
			HttpServletRequest request,HttpServletResponse response)
					throws JsonMappingException,JsonGenerationException,IOException {
		
		System.out.println("********이력서 컨설팅 상세화면 컨트롤러 *********");
		System.out.println("rboardNo : "+rboardNo);
		
		//조회수 증가로직 쿠키이용
		Cookie[] cookies = request.getCookies();
		String boardHistory="";
		boolean hasRead=false;
				
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
						
				if("boardHistory".equals(name)) {
					boardHistory=value; //현재 저장된 값 대입 덮어쓰기 하면서 누적
							
					if(value.contains("|"+rboardNo+"|")) {
						hasRead=true;
						break;
					}
				}
			}//for
		}//if
				
		if(!hasRead) {
			Cookie c = new Cookie("boardHistory",boardHistory+"|"+rboardNo+"|");
			c.setMaxAge(-1);
			response.addCookie(c);
							
		}		
		
		Rboard rboard=service.selectRboard(rboardNo,hasRead);
		System.out.println("rboard : "+rboard);
		return rboard;
	}
	
	//첨부파일 표시
	@RequestMapping(value="resume/rboardAttachment/{rboardNo}.do",method=RequestMethod.GET)
	public RboardAttachment selectRboardAttachment(@PathVariable int rboardNo) {
		
		System.out.println("이력서 게시판 상세정보 첨부파일");
		System.out.println("controller rboardNo: "+rboardNo);

		RboardAttachment rboardAttachment=service.selectRboardAttachment(rboardNo);
		System.out.println(rboardAttachment);
		
		if(rboardAttachment==null) return null;
		else return rboardAttachment;
	}
	
	//이력서 상세게시판 첨부파일 다운로드(이름 보내기)
	@RequestMapping(value="resume/rboardFileDownload",method=RequestMethod.GET)
		public void rboardFileDownload(HttpServletRequest request, HttpServletResponse response,
			@RequestHeader(name="user-agent")String header,
			@RequestParam(value="oriName")String oriName,
			@RequestParam(value="reName")String reName){
		
			System.out.println("oriName : "+oriName);
			System.out.println("reName : "+reName);
			
			String path=request.getServletContext().getRealPath("/resources/upload/rboard");
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
	
	@RequestMapping(value="resume/resumeList/{memberSq}.do",method=RequestMethod.GET)
	public List<ResumeList> selectResumeList(@PathVariable int memberSq) {
		System.out.println("********이력서 리스트 컨트롤러 *********");
		System.out.println(memberSq);
		List<ResumeList> list=service.selectResumeList(memberSq);

		for(ResumeList i : list) {
			System.out.println(i);
		}
		System.out.println("controller : "+list);
		return list;
	}
	
	@RequestMapping(value="/resume/rboardEnroll.do",method = RequestMethod.POST, consumes = { "multipart/form-data" })

	public String rboardEnroll(Rboard rboard,@RequestParam(value="memberSq") int memberno,
			@RequestBody MultipartFile[] file,HttpServletRequest request) {
		//로그인한 사용자의 키를 넣을거임
		
		
		System.out.println("***********rboard 등록 컨트롤러 *********");
		System.out.println("*******memberno : "+memberno);
		System.out.println("*******upfile : "+file);
		System.out.println("*******upfile.length : "+file.length);
		logger.debug("======vue에서 전송한  파일========");
		if(file.length>0) {
			//오류나는 이유 로거에서 파일출력하는 부분에서 걸렸음
			logger.debug("파일명"+file[0].getOriginalFilename());
			logger.debug("파일크기 : "+file[0].getSize());
		}
		rboard.setRboardId(memberno);
		
		//업로드 경로
		String saveDir=request.getServletContext().getRealPath("/resources/upload/rboard");
		File dir=new File(saveDir);
		
		System.out.println("업로더 경로 : "+dir);
		//폴더 만들기
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		//첨부파일 객체 저장
		List<RboardAttachment> files=new ArrayList();
		System.out.println("객체 저장 : "+files);
		for(MultipartFile f : file) {
			System.out.println("f : "+f);
			if(!f.isEmpty()) {
				String originalFileName=f.getOriginalFilename();
				String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
				int rndNum=(int)(Math.random()*1000);
				String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
				
				try {
					//리네임 파일저장하기
					//스프링이 제공하는 멀티파트가 메소드를 제공한다 tansferTo(파일)라는 메소드를 제공한다
					f.transferTo(new File(saveDir+"/"+renameFileName));
				}catch(IOException e) {
					e.printStackTrace();
				}
				RboardAttachment file2=new RboardAttachment(0,0,originalFileName,renameFileName,null,null);
				files.add(file2);
			}
		}
		
		//data DB 저장하기
		int result=0;
		try {
			result=service.insertRboard(rboard,files);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		String msg="";
		if(result>0) msg="등록성공";
		else msg="등록실패";
	
		
		return msg;
		
			
	}
	
	//이력서 컨설팅 게시판 수정
	@RequestMapping(value="/resume/updateRboard.do", method=RequestMethod.POST, consumes= {"multipart/form-data"})
		public String updateRboard(Rboard rboard, @RequestBody(required=false)
			MultipartFile[] file, HttpServletRequest request) {
		
		System.out.println("이력서 컨설팅 게시판 글 업데이트");
		String msg="";
		if(file.length>0) {
			int rboardNo = rboard.getRboardNo();
			
			String saveDir=request.getServletContext().getRealPath("/resources/upload/rboard");
			File dir = new File(saveDir);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			List<RboardAttachment> files = new ArrayList();
			
			//원래 파일이 존재한다면 get해서 가져와서 변수에 저장해두기
			for(MultipartFile f:file) {
				if(!f.isEmpty()) {
				String originalFileName=f.getOriginalFilename();
				String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
				int rndNum=(int)(Math.random()*1000);
				String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
			
					try {
						f.transferTo(new File(saveDir+"/"+renameFileName));
					}catch(IOException e) {
						e.printStackTrace();
					}
					
					RboardAttachment file2 = new RboardAttachment(0,rboardNo,originalFileName,renameFileName,null,null);
					files.add(file2);
				}
			}
			int result=0;
			
			try {
				result = service.updateRboard(rboard,files);
			}catch(RuntimeException e) {
				e.printStackTrace();
			}
			
			if(result>0) msg="게시글 수정 성공";
			else msg="게시글 수정 실패";
		
		}//193번째줄 if > 파일이 있다면 / 게시판 정보만 업데이트
		else {
			int result = service.updateRboard(rboard);
			if(result>0) msg="게시글 수정 성공";
			else msg="게시글 수정 실패";
		
		}
		
		return msg;
		
		}
	
	//이력서 등록하기
	@RequestMapping(value="/resume/insertResume.do",method = RequestMethod.POST, consumes = { "multipart/form-data" })
		public String insertResume(Resume resume, ResumeAbroad abroad, ResumeActivity activity,
				ResumeLanguage language, ResumeLicense license, ResumeProject project, ResumeSchool school, 
				ResumeWork work, ResumeList resumelist,
				@RequestParam Map param,@RequestBody MultipartFile[] upfile,HttpServletRequest request) {
		
		System.out.println("***********resume in 등록 컨트롤러 *********");
		System.out.println("param : "+ param);
		System.out.println("resume : "+ resume);
		System.out.println("abroad : "+ abroad);
		System.out.println("activity : "+ activity);
		System.out.println("language : "+ language);
		System.out.println("license : "+ license);
		System.out.println("project : "+ project);
		System.out.println("school : "+ school);
		System.out.println("work : "+ work);
		System.out.println("file :" + upfile);
//		Object memberno=Request.getInstance(param.get(resume.getMemberNo()));
//		System.out.println("param.getMemberNo"+Request.getInstance(param.get(resume.getMemberNo())));
		
		System.out.println("resume.getMemberNo"+resume.getMemberNo());
		int memberNo=resume.getMemberNo();
		
		//resumeList 값 채우기
		String resumeTitle=resume.getRtitle();
		String resumeWriter=resume.getRname();
		String resumeAttachment="";
		if(upfile.length>0) {			
			resumeAttachment="Y";
		}
		else {
			resumeAttachment="N";
		}
		
		resumelist.setMemberNo(memberNo);
		resumelist.setResumelistTitle(resumeTitle);
		resumelist.setResumelistWriter(resumeWriter);
		resumelist.setResumelistAttachment(resumeAttachment);
		
		System.out.println("controller resumelist : "+ resumelist);
		
		
		if(upfile.length>0) {
			//오류나는 이유 로거에서 파일출력하는 부분에서 걸렸음
			logger.debug("파일명"+upfile[0].getOriginalFilename());
			logger.debug("파일크기 : "+upfile[0].getSize());
		}
		
		//업로드 경로
		String saveDir=request.getServletContext().getRealPath("/resources/upload/resume");
		File dir=new File(saveDir);
		
		System.out.println("업로더 경로 : "+dir);
		//폴더 만들기
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		//첨부파일 객체 저장
		List<ResumeAttachment> files=new ArrayList();
		for(MultipartFile f : upfile) {
			System.out.println("f : "+f);
			if(!f.isEmpty()) {
				String originalFileName=f.getOriginalFilename();
				String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
				int rndNum=(int)(Math.random()*1000);
				String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
				
				try {

					f.transferTo(new File(saveDir+"/"+renameFileName));
				}catch(IOException e) {
					e.printStackTrace();
				}
				ResumeAttachment file2=new ResumeAttachment(0,memberNo,originalFileName,renameFileName,null,null);
				
				files.add(file2);
			}
		}
		
		//data DB 저장하기
		int result=0;
		try {
			result=service.insertResume(resume, school, work, license, language, activity, project, abroad, files, resumelist);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		String msg="";
		if(result>0) msg="등록성공";
		else msg="등록실패";
	
		
		return msg;
	}
	
	@RequestMapping(value="resume/selectResume/{resumeNo}.do",method=RequestMethod.GET)
	public ResumeAll selectResume(ResumeAll resumeall, @PathVariable int resumeNo) {
		System.out.println("********controller : 이력서 불러오기*********");
		System.out.println("controller memberSq param : "+resumeNo);
		ResumeAll list=service.selectResume(resumeNo);

		System.out.println(list);
		return list;
	}
	
	// 이력서 사진 로드 
	@RequestMapping(value = "/resume/selectAttachment", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] selectAttachment(HttpServletRequest request, @RequestParam Map param) throws IOException {
		System.out.println("이력서 사진 controller 들어옴");
		
		String resumeNo = param.get("resumeNo").toString();
		System.out.println("controller : "+resumeNo);
		String tempImg = service.selectAttachment(resumeNo);
		System.out.println("controller tempImg :"+tempImg);
		
		String imagePath = null;
		if (tempImg != null) {// 등록된 사진이 있는경우

			imagePath = request.getServletContext().getRealPath("/resources/upload/resume/" + tempImg);

			InputStream imageStream = new FileInputStream(imagePath);
			byte[] imageByteArray = IOUtils.toByteArray(imageStream);
			imageStream.close();
			return imageByteArray;
		} else {
			return null;
		}

	}
	
	
	@RequestMapping(value="/resume/updateResume.do",method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String updateResume(Resume resume, ResumeAbroad abroad, ResumeActivity activity,
			ResumeLanguage language, ResumeLicense license, ResumeProject project, ResumeSchool school, 
			ResumeWork work, ResumeList resumelist,
			@RequestParam Map param,@RequestBody MultipartFile[] upfile,HttpServletRequest request) {
	
	System.out.println("***********resume update 컨트롤러 *********");
	System.out.println("param : "+ param);
	System.out.println("resume : "+ resume);
	System.out.println("abroad : "+ abroad);
	System.out.println("activity : "+ activity);
	System.out.println("language : "+ language);
	System.out.println("license : "+ license);
	System.out.println("project : "+ project);
	System.out.println("school : "+ school);
	System.out.println("work : "+ work);
	System.out.println("file :" + upfile);

	
	System.out.println("resume.resumeNo"+resume.getResumeNo());
	System.out.println("resume.resumeNo"+resume.getMemberNo());
	int resumeNo=resume.getResumeNo();
	int memberNo=resume.getMemberNo();
	
	//resumeList 값 채우기
	String resumeTitle=resume.getRtitle();
	String resumeWriter=resume.getRname();
	String resumeAttachment="";
	if(upfile.length>0) {			
		resumeAttachment="Y";
	}
	else {
		resumeAttachment="N";
	}
	
	resumelist.setMemberNo(memberNo);
	resumelist.setResumeNo(resumeNo);
	resumelist.setResumelistTitle(resumeTitle);
	resumelist.setResumelistWriter(resumeWriter);
	resumelist.setResumelistAttachment(resumeAttachment);
	
	System.out.println("controller resumelist : "+ resumelist);
	
	
	if(upfile.length>0) {
		//오류나는 이유 로거에서 파일출력하는 부분에서 걸렸음
		logger.debug("파일명"+upfile[0].getOriginalFilename());
		logger.debug("파일크기 : "+upfile[0].getSize());
	}
	
	//업로드 경로
	String saveDir=request.getServletContext().getRealPath("/resources/upload/resume");
	File dir=new File(saveDir);
	
	System.out.println("업로더 경로 : "+dir);
	//폴더 만들기
	if(!dir.exists()) {
		dir.mkdirs();
	}
	
	//첨부파일 객체 저장
	List<ResumeAttachment> files=new ArrayList();
	for(MultipartFile f : upfile) {
		System.out.println("f : "+f);
		if(!f.isEmpty()) {
			String originalFileName=f.getOriginalFilename();
			String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
			int rndNum=(int)(Math.random()*1000);
			String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
			
			try {

				f.transferTo(new File(saveDir+"/"+renameFileName));
			}catch(IOException e) {
				e.printStackTrace();
			}
			ResumeAttachment file2=new ResumeAttachment(0,resumeNo,originalFileName,renameFileName,null,null);
			
			files.add(file2);
		}
	}
	
	//data DB 저장하기
	int result=0;
	try {
		result=service.updateResume(resume, school, work, license, language, activity, project, abroad, files, resumelist);
	}catch(RuntimeException e) {
		e.printStackTrace();
	}
	String msg="";
	if(result>0) msg="이력서 수정 성공";
	else msg="이력서 수정실패";

	
	return msg;
}
	
	//이력서 삭제하기
	@RequestMapping(value="resume/deleteResume/{resumeNo}.do",method=RequestMethod.GET)
	public String delmeeting(@PathVariable int resumeNo ,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("controller 이력서 삭제  들어옴");
		System.out.println("controller resumeNo : "+resumeNo);
		int result=0;
		
		ResumeAll resume=service.selectResume(resumeNo);
		if(resume!=null) {
			String renamedFilename=resume.getRenamedFilename();
			if(renamedFilename!=null) {
				result=service.deleteResume(resumeNo);
			}else {
				result=service.deleteResume1(resumeNo);
			}
		}
		String msg="";
		if(result>0) msg="이력서 삭제 성공";
		else msg="이력서 삭제 실패";
		
		return msg;
	}
	
	
	@RequestMapping(value="/resume/insertconsult.do",method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String insertResume(Consult consult, @RequestBody MultipartFile[] upfile,HttpServletRequest request) {
	
		System.out.println("***********resume in 등록 컨트롤러 *********");
		System.out.println("consult : "+ consult);
		System.out.println("file :" + upfile);

		int consultNo=consult.getConsultNo();
		System.out.println(consultNo);
		
		String consultAttachment="";
		if(upfile.length>0) {			
			consultAttachment="Y";
		}
		else {
			consultAttachment="N";
		}

		consult.setConsultAttachment(consultAttachment);
		
		System.out.println("controller consult : "+ consult);
		
		
		if(upfile.length>0) {
			//오류나는 이유 로거에서 파일출력하는 부분에서 걸렸음
			logger.debug("파일명"+upfile[0].getOriginalFilename());
			logger.debug("파일크기 : "+upfile[0].getSize());
		}
		
		//업로드 경로
		String saveDir=request.getServletContext().getRealPath("/resources/upload/consult");
		File dir=new File(saveDir);
		
		System.out.println("업로더 경로 : "+dir);
		//폴더 만들기
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		//첨부파일 객체 저장
		List<ConsultAttachment> files=new ArrayList();
		for(MultipartFile f : upfile) {
			System.out.println("f : "+f);
			if(!f.isEmpty()) {
				String originalFileName=f.getOriginalFilename();
				String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
				int rndNum=(int)(Math.random()*1000);
				String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
				
				try {
	
					f.transferTo(new File(saveDir+"/"+renameFileName));
				}catch(IOException e) {
					e.printStackTrace();
				}
				ConsultAttachment file2=new ConsultAttachment(0,consultNo,originalFileName,renameFileName,null,null);
				
				files.add(file2);
			}
		}
		
		//data DB 저장하기
		int result=0;
		try {
			result=service.insertConsult(consult, files);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		String msg="";
		if(result>0) msg="전문가 등록성공";
		else msg="전문가 등록실패";
	
		
		return msg;
	}
	//이력서 게시판 삭제하기
		@RequestMapping(value="resume/deleteRboard/{rboardNo}.do",method=RequestMethod.GET)
		public String deleteRboard(@PathVariable int rboardNo, HttpServletRequest request) 
				throws JsonMappingException,JsonGenerationException,IOException{
			
				System.out.println("게시판 삭제 controller");
				String msg="";

				
				//먼저 게시글 번호를 가지고 해당 첨부파일을 가져오는 메서드
				RboardAttachment rboardAttachment = service.selectRboardAttachment(rboardNo);
				System.out.println("rboardAttachment");
				
				//첨부파일이 있을경우
				if(rboardAttachment!=null) {

				//첨부파일을 가져온 후 첨부파일을 서버에서(/resources/upload/communityBoard)삭제
				String ReNameFile = rboardAttachment.getRenamedFilename();
				String saveDir = request.getServletContext().getRealPath("/resources/upload/rboard");
				
				//먼저 게시글 삭제 후 첨부파일 삭제
				int result =service.deleteRboard(rboardNo);
				
				if(result>0) {
					msg="qna게시판 글 삭제 성공";
					//게시글 삭제를 성공했을때 첨부파일이 있다면 첨부파일도 삭제
					File file = new File(saveDir+"/"+ReNameFile);
					if(file.exists()) {
						if(file.delete()) logger.debug("첨부파일 삭제 성공");
						else logger.debug("첨부파일 삭제 실패");
					}
				}
				
				else {
					msg="qna게시판 글 삭제 실패";
				}
				//첨부파일이 없는 게시글 삭제
				}else {
					int result = service.deleteRboard(rboardNo);
					msg =(result>0)? "qna게시판 글 삭제 성공" : "qna게시판 글 삭제 실패";
				}
				logger.debug(msg);
				return msg;
		}
		

	@RequestMapping(value="resume/Consultant.do",method=RequestMethod.GET)
		public List<Consult> selectConsultant() {
			System.out.println("********이력서 전문가 신청 리스트 컨트롤러 *********");
			List<Consult> list=service.selectConsultant();

			for(Consult i : list) {
				System.out.println(i);
			}
			System.out.println(list);
			return list;
		}
	
	
	// 댓글작성하기
//		@RequestMapping(value="qna/qnacomment",method = RequestMethod.POST)
//		public String comment(QB_COMMENT cm) {
//			String msg="댓글 insert";
//			int result = service.insertComment(cm);
//			
//			if(result>0) {
//				//답글이 달리면 N->Y로 변경.
//				int comment = service.insertCommentText(cm.getQboardNo());
//				System.out.println("댓글작성하기~~~성공");
//				
//				//댓글갯수 증가로직 +1
//				int result2=service.updateCommentCount(cm);
//				System.out.println("댓글갯수 증가 성공여부 : "+result2);
//			}
//			
//			logger.debug(cm.toString());
//			logger.debug("댓글달기 매핑테스트");
//			return msg;
//		}
	
	
	
}