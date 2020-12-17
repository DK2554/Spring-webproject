package com.spring.itjobgo.resume.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.resume.model.service.ResumeService;
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
		String saveDir=request.getServletContext().getRealPath("/resources/upload/resume");
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
			ResumeAttachment file2=new ResumeAttachment(0,memberNo,originalFileName,renameFileName,null,null);
			
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
}