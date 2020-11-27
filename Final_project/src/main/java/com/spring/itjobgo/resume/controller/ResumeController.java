package com.spring.itjobgo.resume.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.itjobgo.portfolio.model.vo.Attachment;
import com.spring.itjobgo.resume.model.service.ResumeService;
import com.spring.itjobgo.resume.model.vo.Rboard;
import com.spring.itjobgo.resume.model.vo.RboardAttachment;

@RestController
public class ResumeController {

	@Autowired
	private ResumeService service;
	
	@Autowired
	private Logger logger;
	
	@ResponseBody
	@RequestMapping(value="resume/rboardList.do",method=RequestMethod.GET)
	public List<Rboard> selectRboardList() {
		System.out.println("********이력서 리스트 컨트롤러 *********");
		List<Rboard> list=service.selectListRboard();

		for(Rboard i : list) {
			System.out.println(i);
		}
		System.out.println(list);
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
}
