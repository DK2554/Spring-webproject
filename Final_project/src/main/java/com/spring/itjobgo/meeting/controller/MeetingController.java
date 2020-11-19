package com.spring.itjobgo.meeting.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.itjobgo.meeting.model.service.MeetingService;

@Controller
public class MeetingController {
	@Autowired
	private MeetingService service;
	
	@Autowired
	private Logger logger;
	
	@RequestMapping("/meeting/meetingenroller.do")
	public String meetingFromEnd(MultipartFile upFile,HttpServletRequest request) {
		
		String saveDir=request.getServletContext().getRealPath("/resources/upload/meeting");
		File dir=new File(saveDir);
		if(!dir.exists()) {
			//지정된 경로의 폴더가 없으면
			dir.mkdir();
		}
		//파일 업로드 로직 처리하기
		if(!upFile.isEmpty()) {
			String originalFileName=upFile.getOriginalFilename();
			String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSS");
			int rndNum=(int)(Math.random()*1000);
			String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
			try {
				//renameFileName으로 파일을 저장하기 -> transferTo(파일)
				upFile.transferTo(new File(saveDir+"/"+renameFileName));
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		return "매핑테스트";
	}
	
	

}
