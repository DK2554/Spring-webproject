package com.spring.itjobgo.portfolio.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
import com.spring.itjobgo.portfolio.model.vo.Comment;
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
	public String portboard(Pboard pboard,@RequestParam(value="memberSq") int memberno,@RequestBody MultipartFile[] file,HttpServletRequest request) {
		//로그인한 사용자의 키를 넣을거임
		pboard.setPboardId(memberno);
		logger.debug("매핑확인");
		logger.debug("======vue에서 전송한  파일========");
		if(file.length>0) {
			//오류나는 이유 로거에서 파일출력하는 부분에서 걸렸음
			logger.debug("파일명"+file[0].getOriginalFilename());
			logger.debug("파일크기 : "+file[0].getSize());
		}
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
	@RequestMapping(value="/portfolio/pboardinfo{pboardNo}.do",method = RequestMethod.GET)
	public Pboard pboardinfo(@PathVariable int pboardNo) 
	throws JsonMappingException,JsonGenerationException,IOException{
	
		logger.debug("pbaordNo"+Integer.toString(pboardNo));
		Pboard bp=service.selectPboardOne(pboardNo);
		//return pb;
		return bp;
	}
	@RequestMapping(value="/portfolio/pboarddel{no}.do",method = RequestMethod.POST)
	public String pboarddel(@PathVariable int no,HttpServletRequest request) throws JsonMappingException,JsonGenerationException,IOException{
		String msg="";
		logger.debug("이메소드 수행");
		Attachment at=service.selectattac(no);
		if(at!=null){
			//첨부파일이 있는 게시물일 경우 이 로직 실행
			String fname=at.getRenamedFilename();
			String saveDir=request.getServletContext().getRealPath("/resources/upload/portfolio");
			int result=service.deletePboard(no);
			if(result >0) {
				msg="삭제성공";
				File file=new File(saveDir+"/"+fname);
				if(file.exists()) {
					if(file.delete()) logger.debug("삭제성공");
					else logger.debug("삭제실패");
				}
			}else {
				msg="삭제실패";
			}	
		}else {
			//첨부파일이 없는 게시글 삭제
			int result=service.deletePboard(no);
			msg= (result>0) ? "삭제성공":"삭제실패";
		}
			
	
		
		logger.debug(msg);
		return msg;	
	}
	@RequestMapping(value="/portfolio/pbaordupdate{no}.do",method = RequestMethod.GET)
	public Attachment pboardupdate(@PathVariable int no) 
			throws JsonMappingException,JsonGenerationException,IOException{
			
				logger.debug("pbaordNo"+Integer.toString(no));
				Attachment at=service.selectattac(no);
				logger.debug(at.toString());
				
				return at;
			}
	@RequestMapping(value="/portfolio/portfolioupdataend.do",method = RequestMethod.POST, consumes = { "multipart/form-data" })
	//@ModelAttribute 생략가능  써주는것이 좋음 
	public String pboardUpdataEnd(Pboard pboard,@RequestBody(required = false) MultipartFile[]  filen,HttpServletRequest request) {
			logger.debug("그냥 매핑테스트");
			
			if(filen.length>0) {
				int no=pboard.getPboardNo();
				String saveDir=request.getServletContext().getRealPath("/resources/upload/portfolio");
				File dir=new File(saveDir);
				if(!dir.exists()) {
					//지정된 경로의 폴더가 없으면 생성해라
					dir.mkdirs();
				}
				List<Attachment> files=new ArrayList();
				for(MultipartFile f:filen) {
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
					Attachment file2=new Attachment(0,no,originalFileName,renameFileName,null,null);
					files.add(file2);
					}
				}
				int result=0;
				try {
					result=service.updatepboard(pboard,files);
				}catch(RuntimeException e) {
					e.printStackTrace();
				}
				String msg="";
				if(result>0) msg="등록성공";
				else msg="등록실패";
			
			}
			else {
				int result=service.updatepboard(pboard);
			}
				
			//넘겨줄 파일이 있을때 서버에 올리고  attachment db를 수정
			//넘겨줄 파일이 없으면 게시글만 수정하면 대는거 아님?
			
	return "매핑테스트";
	}
	@RequestMapping(value="portfolio/attachment{no}",method=RequestMethod.GET)
	public Attachment returnattachment(@PathVariable int no) {
		logger.debug(Integer.toString(no));
		Attachment att=service.selectattac(no);
		if(att==null) return null; //첨부파일이 없으면 null을 반환하고
		else return att; //첨부파일이 있으면 받아온 객체를 반환해라
		
	}
	@RequestMapping(value="portfolio/filedownload",method=RequestMethod.GET)
	//첨부파일 이름 보내기
	public void filedownload(HttpServletRequest request,HttpServletResponse response,@RequestHeader(name="user-agent")String header,@RequestParam(value="oriName") String oriName,@RequestParam(value="reName")  String reName) {
		logger.debug(oriName);
		logger.debug(reName);
		String path=request.getServletContext().getRealPath("/resources/upload/portfolio");
		File saveFile=new File(path+"/"+reName);
		BufferedInputStream bis=null;
		ServletOutputStream sos=null;
		
		try {
			bis=new BufferedInputStream(new FileInputStream(saveFile));
			sos=response.getOutputStream();
			boolean isMSIE=header.indexOf("Trident")!=-1||header.indexOf("MSIE")!=-1;
			String encodeRename="";
			if(isMSIE) {
				encodeRename=URLEncoder.encode(oriName,"UTF-8").replaceAll("\\+","%20");
				
			}else {
				encodeRename=new String(oriName.getBytes("UTF-8"),"ISO-8859-1");
			}
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=\""+encodeRename+"\"");
			response.setHeader("Content-Transfer-Encoding", "binary;");
			response.setContentLength((int)saveFile.length());
			int read=-1;
			while((read=bis.read())!=-1) {
				sos.write(read);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				sos.close();
				bis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value="portfolio/comment.do",method =RequestMethod.POST)
	public String comment( Comment cm) {
		String msg="";
	
		logger.debug(cm.toString());
		logger.debug("매핑테스트");
		return msg;
	}
}
