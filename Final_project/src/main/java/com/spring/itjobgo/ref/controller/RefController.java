package com.spring.itjobgo.ref.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
	@RequestMapping(value="ref/insertsite",method = RequestMethod.POST, consumes= {"multipart/form-data"})
	public String insertSite(@RequestParam Map param, @RequestBody MultipartFile[] upfile,HttpServletRequest request) {
		String msg="";
		System.out.println(param);
		if(upfile.length>0) {
			
			String saveDir=request.getServletContext().getRealPath("/resources/upload/refsite");
			File dir=new File(saveDir);
			if(!dir.exists()) {
				
				dir.mkdirs();
			}
			
			List<REF_SITE_ATTACHMENT> files=new ArrayList();
			for(MultipartFile f:upfile) {
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
				REF_SITE_ATTACHMENT file2=new REF_SITE_ATTACHMENT(0,0,originalFileName,renameFileName,null,null);
				files.add(file2);
				}
			}
			int result=0;
			try {
				result=service.insertSite(param,files);
			}catch(RuntimeException e) {
				e.printStackTrace();
			}
			
			if(result>0) msg="등록성공";
			else msg="등록실패";
		}
		return msg;
	}
	
	//리스트 불러오기(조회)
	@RequestMapping(value="ref/selectsite",method = RequestMethod.GET)
	public List<REF_SITE> selectList()throws JsonMappingException,JsonGenerationException,IOException{
		List<REF_SITE> list=service.selectList();
					logger.debug("list 불러오기 성공");
					logger.debug(list.toString());
			return list;
	}
	
	//리스트 이미지 불러오기
	@RequestMapping(value="ref/selectsiteImg",method=RequestMethod.GET,produces=MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] selectImage(@PathVariable int no, HttpServletRequest request, HttpServletResponse res)throws Exception{
		logger.debug("이미지요청~");
		//받아온 번호로 해당 첨부파일 db가서 받아오는 로직수행
		REF_SITE_ATTACHMENT mt=service.selectImage(no);
		
		logger.debug(mt.toString());
		//파일경로
		String realFile = request.getServletContext().getRealPath("/resources/upload/refsite");
		//파일이름
		String fileNm = mt.getRenamedfilename();
		//파일확장자
		String ext = fileNm.substring(fileNm.lastIndexOf(".")+1);
		String image=realFile+"//"+fileNm;
		
		logger.debug("realFile : "+realFile+"fileNm : "+fileNm+"ext : "+ext);
		logger.debug(realFile+"\\"+fileNm);
		
		InputStream in = new FileInputStream(image);
		byte[] imageByteArray=IOUtils.toByteArray(in);
		in.close();
		
		return imageByteArray;
	}
	
	
	
	
	
	
}
