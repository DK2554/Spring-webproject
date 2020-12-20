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
import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;
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
	@RequestMapping(value="ref/selectsiteImg{no}",method=RequestMethod.GET,produces=MediaType.IMAGE_JPEG_VALUE)
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
		String ext = fileNm.substring(fileNm.lastIndexOf(".") + 1);
		String image=realFile+"\\"+fileNm;
		
		logger.debug("realFile:"+realFile+"fileNm:"+fileNm+"ext:"+ext);
		logger.debug(realFile+"\\"+fileNm);
		
		InputStream in =new FileInputStream(image);
		byte[] imageByteArray=IOUtils.toByteArray(in);
		in.close();
		
		return imageByteArray;
	}
	
	//상세화면 seletOne
	@RequestMapping(value="ref/refView{refNo}",method=RequestMethod.GET)
	public REF_SITE refSiteView(@PathVariable int refNo)throws JsonMappingException,JsonGenerationException,IOException{
		
		REF_SITE refsite=service.selectOne(refNo);
		logger.debug(refsite.toString());
		return refsite;
	}
	
	//글 삭제하기
	@RequestMapping(value="ref/deletesite{refNo}",method=RequestMethod.POST)
	public String deleteSite(@PathVariable int refNo, HttpServletRequest request)
		throws JsonMappingException, JsonGenerationException, IOException{
		
		System.out.println("refNo : "+refNo);
		//첨부파일이 있다면 삭제 후 게시글에 삭제하도록
		String msg="";
		logger.debug("게시글 삭제 맵핑 성공 > 첨부파일 있는지 확인 후 > 게시글 삭제 > 첨부파일 삭제! ");
		
		REF_SITE_ATTACHMENT refAttach = service.selectAttach(refNo);
		//첨부파일이 있을 때 게시글 삭제
		if(refAttach!=null) {
			String ReNameFile =refAttach.getRenamedfilename();
			String saveDir =request.getServletContext().getRealPath("/resources/upload/refsite");
		
			//게시글 먼저 삭제
			int result = service.deleteSite(refNo);
			
			if(result>0) {
				msg="reference 사이트 삭제 성공";
				//첨부파일 삭제 실행
				File file=new File(saveDir+"/"+ReNameFile);
				if(file.exists()) {
					if(file.delete()) logger.debug("첨부파일 삭제 성공");
					else logger.debug("첨부파일 석제 실패");
				}
			}
			else {
				msg = "첨부파일 삭제 실패";
			}
		}else {
			int result = service.deleteSite(refNo);
			msg=(result>0)?"사이트 삭제 성공":"사이트 삭제 실패";
		}
		logger.debug(msg);
		return msg;

	}
	
	//Update페이지로 첨부파일테이블 불러오기
	@RequestMapping(value="ref/refUpdate{refNo}",
									method=RequestMethod.GET)
	public REF_SITE_ATTACHMENT selectAttach(@PathVariable int refNo) {
		
		REF_SITE_ATTACHMENT refAttach = service.selectAttach(refNo);
		
		return refAttach;

	}
	//게시판 수정
	@RequestMapping(value="ref/updateEnd",
									method=RequestMethod.POST,
									consumes = {"multipart/form-data"})
	public String updateEnd(REF_SITE refsite,
											@RequestBody(required = false) MultipartFile[] file,
											HttpServletRequest request) {
		
		System.out.println("업데이트 메서드 맵핑 성공");
		
		if(file.length>0) {
			int refNo= refsite.getRefNo();
			
			String saveDir = request.getServletContext().getRealPath("/resources/upload/refsite");
			
			File dir = new File(saveDir);
			if(!dir.exists()) {
				dir.mkdir();
			}
			List<REF_SITE_ATTACHMENT>files = new ArrayList();
			
			for(MultipartFile f:file) {
				if(!f.isEmpty()) {
					
				     String originalFileName=f.getOriginalFilename();
			         String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			         SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
			         int rndNum=(int)(Math.random()*1000);
			         String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
			         
			            try {
			                //파일저장하기
			                //스프링이 제공하는 멀티파트가 메소드를 제공한다
			                //transfer to(파일) 메소드를 이용한다.
			                f.transferTo(new File(saveDir+"/"+renameFileName));
			             }catch(IOException e) {
			                e.printStackTrace();
			             }
			             
			            REF_SITE_ATTACHMENT file2 =new REF_SITE_ATTACHMENT(0,refNo,originalFileName,renameFileName,null,null);
			             files.add(file2);
			             
			          }
			       }
			       int result=0;
			       try {
			          //게시판 글 업데이트
			          result =service.updateSite(refsite,files);
			       }catch(RuntimeException e) {
			          e.printStackTrace();
			       }
			       String msg="";
			       if(result>0) msg="게시글 수정 성공";
			       else msg="게시글 수정 실패";
			       
			       }//파일이 없을때 게시판 업데이트
			       else {
			          int result = service.updateSite(refsite);
			       }
			       return "업데이트 테스트";
		
	}
	
	@RequestMapping(value="ref/refStatus",method=RequestMethod.POST)
	public void status(REF_SITE site) {
		
		int status = service.updateStatus(site.getRefNo());
		System.out.println("관리자 승인 업데이트~~~");
		
	}
	
	
	
	
	
	
	
}
