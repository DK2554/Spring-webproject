package com.spring.itjobgo.meeting.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spring.itjobgo.meeting.model.service.MeetingService;
import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.portfolio.model.vo.Attachment;

@RestController
public class MeetingController {
	@Autowired
	private MeetingService service;
	
	@Autowired
	private Logger logger;
	//vue에서 보낸 첨부파일을 받기위한 설정
	@RequestMapping(value="/meeting/enrollmeeting.do",method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String meetingFromEnd(@RequestParam Map param,@RequestBody MultipartFile[] upfile,HttpServletRequest request) {
		String msg="";
		System.out.println(param);	
		if(upfile.length>0) {
			
			String saveDir=request.getServletContext().getRealPath("/resources/upload/meeting");
			File dir=new File(saveDir);
			if(!dir.exists()) {
				//지정된 경로의 폴더가 없으면 생성해라
				dir.mkdirs();
			}
			List<Mattachment> files=new ArrayList();
			for(MultipartFile f:upfile) {
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
			Mattachment file2=new Mattachment(0,0,originalFileName,renameFileName,null,null);
				files.add(file2);
				}
			}
			int result=0;
			try {
				result=service.insertMboard(param,files);
			}catch(RuntimeException e) {
				e.printStackTrace();
			}
			
			if(result>0) msg="등록성공";
			else msg="등록실패";
		}
		return msg;
	}
	@RequestMapping(value="meeting/meetingList.do" ,method = RequestMethod.GET)
	public int meetingList()throws JsonMappingException,JsonGenerationException,IOException{
		int data=service.selectMlist();
		
		logger.debug("여기오면 매핑성공");
		return data;
	}
	
	
	

}
