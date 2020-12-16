package com.spring.itjobgo.ItNews.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.spring.itjobgo.ItNews.model.service.ItNewsService;
import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;
import com.spring.itjobgo.ItNews.model.vo.ItnewsComment;
import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;

@RestController
public class ItNewsController {

	@Autowired
	private Logger logger;
	
	@Autowired
	private ItNewsService service;
 
	//ItNews 글작성
	@RequestMapping(value="/itnews/insertNews",method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String meetingFromEnd(@RequestParam Map param,@RequestBody MultipartFile[] upfile,HttpServletRequest request) {
		String msg="";
		System.out.println(param);	
		if(upfile.length>0) {
			
			String saveDir=request.getServletContext().getRealPath("/resources/upload/itNews");
			File dir=new File(saveDir);
			if(!dir.exists()) {
				
				dir.mkdirs();
			}
			List<ItnewsAttachment> files=new ArrayList();
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
				ItnewsAttachment file2=new ItnewsAttachment(0,0,originalFileName,renameFileName,null,null);
				files.add(file2);
				}
			}
			int result=0;
			try {
				result=service.insertItNews(param,files);
			}catch(RuntimeException e) {
				e.printStackTrace();
			}
			
			if(result>0) msg="등록성공";
			else msg="등록실패";
		}
		return msg;
	}
	
	//게시판 리스트 불러오기
	@RequestMapping(value="itnews/selectList" ,method = RequestMethod.GET)
	public List<ItNews> selectList()throws JsonMappingException,JsonGenerationException,IOException{
		List<ItNews> list=service.selectList();
			logger.debug("list 불러오기 성공");
			logger.debug(list.toString());
		return list;
	}
	
	//게시판 list 에 이미지 불러오기
	@RequestMapping(value="itnews/imagesrequest{no}",method=RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[]  selectImage(@PathVariable int no,HttpServletRequest request,HttpServletResponse res)throws Exception{
		logger.debug("이미지요청");
		//받아온 번호로 해당 첨부파일 db가서 받아오는 로직수행
		ItnewsAttachment mt=service.selectImage(no);
		
		logger.debug(mt.toString());
		//파일경로
		String realFile = request.getServletContext().getRealPath("/resources/upload/itNews");
		//파일이름
		String fileNm = mt.getRenamedfilename();
		//파일 확장자
		String ext = fileNm.substring(fileNm.lastIndexOf(".") + 1);
		String image=realFile+"\\"+fileNm;
		
		logger.debug("realFile:"+realFile+"fileNm:"+fileNm+"ext:"+ext);
		logger.debug(realFile+"\\"+fileNm);
		
		InputStream in =new FileInputStream(image);
		byte[] imageByteArray=IOUtils.toByteArray(in);
		in.close();
		
		return imageByteArray;
	}
	
	//상세화면 selectOne
	@RequestMapping(value="itnews/itnewsView{newsSq}",method=RequestMethod.GET)
	public ItNews meetinginfo(@PathVariable int newsSq)throws JsonMappingException,JsonGenerationException,IOException{
		
		ItNews itnews=service.selectOne(newsSq);
		logger.debug(itnews.toString());
		return itnews;
	}
	
	//게시판 글 삭제
	@RequestMapping(value="itnews/itnewsDelete{newsSq}", method=RequestMethod.POST)
	public String deleteBoard(@PathVariable int newsSq, HttpServletRequest request)
			throws JsonMappingException, JsonGenerationException, IOException{
		
		//첨부파일이 있다면 삭제 후 게시글 삭제하도록
		String msg="";
		logger.debug("게시글 삭제 맵핑 성공 > 첨부파일 있는지 확인 후> 게시글 삭제 > 첨부파일 삭제");
		
		ItnewsAttachment itAttach = service.selectAttach(newsSq);
		//첨부파일이 있을때 게시글 삭제
		if(itAttach!=null) {
			String ReNameFile =itAttach.getRenamedfilename();
			String saveDir =request.getServletContext().getRealPath("/resources/upload/itNews");
		
			//게시글 먼저 삭제
			int result = service.deleteBoard(newsSq);
			
			if(result>0) {
				msg="itNews 게시판 글 삭제 성공";
				//첨부파일 삭제 실행
				File file = new File(saveDir+"/"+ReNameFile);
				if(file.exists()) {
					if(file.delete()) logger.debug("첨부파일 삭제 성공");
					else logger.debug("첨부파일 삭제 실패");
				}
			}
			else {
				msg = "itNews 게시판 글 삭제 실패";
			}
			//첨부파일이 없는 게시글 삭제할때
		}else {
			int result=service.deleteBoard(newsSq);
			msg=(result>0)?"itNews 게시판 글 삭제성공":"itNews게시판 글 삭제 실패";
		}
		logger.debug(msg);
		return msg;
		
	}
	
	//Update페이지로 첨부파일테이블 불러오기
	@RequestMapping(value="itnews/itnewsUpdate{newsSq}",
									method=RequestMethod.GET)
	public ItnewsAttachment selectAttach(@PathVariable int newsSq) {
		
		ItnewsAttachment itAttach = service.selectAttach(newsSq);
		
		return itAttach;

	}
	//게시판 수정
	@RequestMapping(value="notice/updateEnd",
									method=RequestMethod.POST,
									consumes = {"multipart/form-data"})
	public String updateEnd(ItNews itnews,
											@RequestBody(required = false) MultipartFile[] file,
											HttpServletRequest request) {
		
		System.out.println("업데이트 메서드 맵핑 성공");
		
		if(file.length>0) {
			int newsSq= itnews.getNewsSq();
			
			String saveDir = request.getServletContext().getRealPath("/resources/upload/itNews");
			
			File dir = new File(saveDir);
			if(!dir.exists()) {
				dir.mkdir();
			}
			List<ItnewsAttachment>files = new ArrayList();
			
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
			             
			            ItnewsAttachment file2 =new ItnewsAttachment(0,newsSq,originalFileName,renameFileName,null,null);
			             files.add(file2);
			             
			          }
			       }
			       int result=0;
			       try {
			          //게시판 글 업데이트
			          result =service.updateBoard(itnews,files);
			       }catch(RuntimeException e) {
			          e.printStackTrace();
			       }
			       String msg="";
			       if(result>0) msg="게시글 수정 성공";
			       else msg="게시글 수정 실패";
			       
			       }//파일이 없을때 게시판 업데이트
			       else {
			          int result = service.updateBoard(itnews);
			       }
			       return "업데이트 테스트";
		
	}//메서드
	
	//댓글작성
	@RequestMapping(value="itnews/insertComment", method=RequestMethod.POST)
	public String insertComment(ItnewsComment it_comment) {
		
		String msg = "댓글 insert 메서드 실행 ";
		
		int result = service.insertComment(it_comment);
		
		return msg;
	}
	
	//댓글조회
	@RequestMapping(value="itnews/selectCommentList{itnewsNo}",method=RequestMethod.GET)
	public List<ItnewsComment> selecCommenttList(@PathVariable int itnewsNo){
		
		List<ItnewsComment>list=service.selecCommenttList(itnewsNo);
		
		return list;
		
	}
	
	//댓글 삭제
	@RequestMapping(value="itnews/deleteComment{itCommentNo}",method=RequestMethod.POST)
	public void deleteComment(@PathVariable int itCommentNo) {
		
		int result = service.deleteComment(itCommentNo);
		
	}
	

	
	//댓글 업데이트 수정
	@RequestMapping(value="itnews/updateComment",method=RequestMethod.POST)
	public void updateComment(@RequestBody Map param) {
		
		int result=service.updateComment(param);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//클래스
