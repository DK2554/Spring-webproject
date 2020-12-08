package com.spring.itjobgo.ref.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
import com.spring.itjobgo.ref.model.service.RefService;
import com.spring.itjobgo.ref.model.vo.REF_SITE;
import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

@RestController
public class RefController {
	@Autowired
	private RefService service;
	
	@Autowired
	private Logger logger;
	
	//사이트 등록하기 insert
	@RequestMapping(value="ref/insertsite.do",
										method = RequestMethod.POST, consumes= {"multipart/form-data"})
	public String insertSite(REF_SITE REFSITE, @RequestParam(value="memberSq")int memberno,
			@RequestBody MultipartFile[] file, HttpServletRequest request)
										{
	System.out.println("멤버번호 : "+memberno);
	REFSITE.setMemberNum(memberno);
	
	logger.debug("매핑확인");
	logger.debug("======vue에서 전송한 파일========");
	//파일이 있다면
	if(file.length>0) {
		logger.debug("파일명"+file[0].getOriginalFilename());
		logger.debug("파일크기"+file[0].getSize());
	}
	logger.debug(REFSITE.toString());
	
	//업로드 경로 설정
	//파일 리네임 처리 후 파일 저장하기
	String saveDir=request.getServletContext().getRealPath("/resources/upload/refsite");
	
	File dir=new File(saveDir);
	if(!dir.exists()) {
		//지정된경로의 폴더가 없으면
		dir.mkdirs(); //mk > make directory
		}
		
		List<REF_SITE_ATTACHMENT> files=new ArrayList<REF_SITE_ATTACHMENT>();
		
		for(MultipartFile f:file) {
		
		if(!f.isEmpty()) {
		
		String originalFileName=f.getOriginalFilename();
		String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
		
		int rndNum=(int)(Math.random()*1000);
		
		String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
		
		try {
			//파일저장하기
			//스프링이 제공하는 멀티파트가 메소드를 제공한다 tansferTo(파일)라는 메소드를 제공한다
				f.transferTo(new File(saveDir+"/"+renameFileName));
			}catch(IOException e) {
				e.printStackTrace();
			}
				REF_SITE_ATTACHMENT file2=new REF_SITE_ATTACHMENT(0,0,originalFileName,renameFileName,null,null);
			files.add(file2);
			}
		}
		int result=0;
			
			try {
			//게시판 글 작성
			result=service.insertSite(REFSITE,files);
			
			}catch(RuntimeException e) {
			e.printStackTrace();
			}
			
			String msg="";
			if(result>0) msg="등록성공";
			
			else msg="등록실패";
			
			return msg;
		}
		
	
	
}
