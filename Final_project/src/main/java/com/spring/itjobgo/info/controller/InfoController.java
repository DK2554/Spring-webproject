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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.spring.itjobgo.info.model.vo.INFO_ATTACHMENT;
import com.spring.itjobgo.info.model.vo.Info;

@RestController
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

	 //글쓰기
	   @RequestMapping(value="/info/infoForm",
	                           method = RequestMethod.POST, consumes = { "multipart/form-data" })
	   public String infoBoard(Info cboard,
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
	      
	      List<INFO_ATTACHMENT> files=new ArrayList<INFO_ATTACHMENT>();
	      
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
	         INFO_ATTACHMENT file2=new INFO_ATTACHMENT(0,0,originalFileName,renameFileName,null,null);
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
  
     }//클래스
   		/* return msg; */

   	
   	//상세화면 전환 페이지
   	@RequestMapping(value="/info/InfoDetail{infoSq}",
   									method=RequestMethod.GET)
   	public Info selectInfoOne(@PathVariable int infoSq) {
   		
   		logger.debug("infoSq"+Integer.toString(infoSq));
   		
   		Info cboard = service.selectInfoOne(infoSq);
   		
   		return cboard;
   	
   	}
   	
   	//삭제하기
   	@RequestMapping(value="/info/infoDelete{infoSq}",
   									method=RequestMethod.POST)
   	public String deleteBoard(@PathVariable int infoSq , HttpServletRequest request) {
   		
   		//먼저 첨부파일이 삭제가 되면 그 그결과값이 result>0이면 게시글 삭제로 이어지도록
   		String msg = "";
   		logger.debug("첨부파일 삭제 후 게시글 삭제 로직 수행 logger");
   		
   		//먼저 게시글 번호를 가지고 해당 첨부파일을 가져오는 메서드
   		INFO_ATTACHMENT cba = service.selectAttach(infoSq);
   		System.out.println(cba);
   		
   		//첨부파일을 가져온 후 첨부파일을 서버에서(/resources/upload/info)삭제
   		String ReNameFile =cba.getRenamedfilename();
   		String saveDir = request.getServletContext().getRealPath("/resources/upload/info");
   		
   		//먼저 게시글 삭제 후 첨부파일 삭제
   		int result = service.deleteBoard(infoSq);
   		
   		if(result>0) {
   			msg="자유게시판 글삭제 성공";
   			//게시글 삭제를 성공했을때 첨부파일이 있다면 첨부파일도 삭제
   			File file = new File(saveDir+"/"+ReNameFile);
   			if(file.exists()) {
   				if(file.delete()) logger.debug("첨부파일 삭제 성공");
   				else logger.debug("첨부파일 삭제 실패");
   			}
   		}
   		else {
   			msg="자유게시판 글삭제 실패";
   		}
   		return msg;
   	}
   	
   	//수정화면으로 전환시 게시글 번호를 통해 첨부파일을 가져오는 메서드
   	@RequestMapping(value="/info/infoUpdate{infoSq}",method = RequestMethod.GET)
   	public INFO_ATTACHMENT selectAttach(@PathVariable int infoSq) {
   		
   		System.out.println(infoSq);
   		
   		logger.debug("infoSq" + Integer.toString(infoSq));
   		INFO_ATTACHMENT cba = service.selectAttach(infoSq);
   		logger.debug(cba.toString());
   		
   		System.out.println(cba);
   		
   		return cba;
   		
    	}

   	
   }//클래스

