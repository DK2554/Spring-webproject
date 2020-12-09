package com.spring.itjobgo.ref.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;
import com.spring.itjobgo.ref.model.service.RefService;
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
	
}
