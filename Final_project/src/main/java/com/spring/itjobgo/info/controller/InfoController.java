package com.spring.itjobgo.info.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.info.model.service.InfoService;
import com.spring.itjobgo.info.model.vo.Info;

@RestController
@RequestMapping("/info")
public class InfoController {
	@Autowired
	private Logger logger;
	
	@Autowired
	private InfoService service;
	
	//화면전환용 메서드
	@ResponseBody
	@RequestMapping(value="/info/infoList" , method=RequestMethod.GET)
	public List<Info> Info()  {
		
			List<Info> list = service.selectInfoList();
			
			for(Info i : list){
			    System.out.println(i);
			}
			   return list;
	}

	 //info 글쓰기
	   @RequestMapping(value="/info/infoForm",
	                           method = RequestMethod.POST, consumes = { "multipart/form-data" })
	   public String cbBoard(Info cboard,
	                                 @RequestBody MultipartFile[] file, HttpServletRequest request) 
	   
	                                                                                                                  {
		   cboard.setInfoSq(1);
	      
	      logger.debug("매핑확인");
	      logger.debug("======vue에서 전송한  파일========");
	      logger.debug("파일명"+file[0].getOriginalFilename());
	      logger.debug("파일크기 : "+file[0].getSize());
	      logger.debug(cboard.toString());
	      
	      //업로드 경로 설정
	      //파일 리네임 처리후 파일 저장하기
	      String saveDir=request.getServletContext().getRealPath("/resources/upload/info");
	      
	      File dir=new File(saveDir);
	      
	      if(!dir.exists()) {
	         //지정된경로의 폴더가 없으면
	         dir.mkdirs(); //mk > make directory
	      }
	      
	      List<CB_ATTACHMENT> files=new ArrayList<CB_ATTACHMENT>();
	      
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
	         CB_ATTACHMENT file2=new CB_ATTACHMENT(0,0,originalFileName,renameFileName,null,null);
	         files.add(file2);
	         }
	      }
	      int result=0;

	      
	      try {
	         //글 작성
	       result=service.insertInfo(cboard,files);
	         
	      }catch(RuntimeException e) {
	         e.printStackTrace();
	      }
	      
	      String msg="";
	      if(result>0) msg="등록성공";
	      
	      else msg="등록실패";

	      return msg;
	     	      
       }
	}//클래스