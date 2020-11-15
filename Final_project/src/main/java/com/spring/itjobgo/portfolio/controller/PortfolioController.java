package com.spring.itjobgo.portfolio.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spring.itjobgo.portfolio.model.service.PortfolioService;
import com.spring.itjobgo.portfolio.model.vo.Attachment;
import com.spring.itjobgo.portfolio.model.vo.Pboard;

@RestController
public class PortfolioController {
	@Autowired
	private PortfolioService service;
	@Autowired
	private Logger logger;
//	@ResponseBody
//	@RequestMapping(value="/portfoilo/portfoiloenroll.do",method = RequestMethod.POST, consumes = { "multipart/form-data" })
//	//@ModelAttribute 생략가능  써주는것이 좋음 
//	public ModelAndView portboard(@RequestBody MultipartFile file,ModelAndView mv) {
//		System.out.println(file);
//	
//		logger.debug("매핑확인");
//		
//		
//		return mv;
//		
//			
//	}
	
	@RequestMapping(value="/portfolio/portfolioenroll.do",method = RequestMethod.POST, consumes = { "multipart/form-data" })
	//@ModelAttribute 생략가능  써주는것이 좋음 
	public String portboard(Pboard pboard,@RequestBody MultipartFile[] file,HttpServletRequest request) {
		pboard.setPboardId(1);
		logger.debug("매핑확인");
		logger.debug("======vue에서 전송한  파일========");
		logger.debug("파일명"+file[0].getOriginalFilename());
		logger.debug("파일크기 : "+file[0].getSize());
		logger.debug(pboard.toString());
		String saveDir=request.getServletContext().getRealPath("/resources/upload/portfolio");
		File dir=new File(saveDir);
		if(!dir.exists()) {
			//지정된 경로의 폴더가 없으면 생성해라
			dir.mkdirs();
		}
		List<Attachment> files=new ArrayList();
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
			Attachment file2=new Attachment(0,0,originalFileName,renameFileName,null,null);
			files.add(file2);
			}
		}
		int result=0;
		try {
			result=service.insertPboard(pboard,files);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		String msg="";
		if(result>0) msg="등록성공";
		else msg="등록실패";
	
		
		return msg;
		
			
	}
	@RequestMapping(value="/portfolio/portfolioList.do",method = RequestMethod.GET)
	public List<Pboard> responsePboard()throws JsonMappingException,JsonGenerationException,IOException{
		List<Pboard> list=service.selectListPboard();
		for(Pboard a:list) {
			logger.debug(a.toString());
		}
		
		return list;
		
	}
	@RequestMapping(value="/poryfolio/pboardinfo{pboardNo}.do",method = RequestMethod.GET)
	public Pboard pboardinfo(@PathVariable int pboardNo) 
	throws JsonMappingException,JsonGenerationException,IOException{
	
		logger.debug("pbaordNo"+Integer.toString(pboardNo));
		Pboard bp=service.selectPboardOne(pboardNo);
		//return pb;
		return bp;
	}
}
