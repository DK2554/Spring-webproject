package com.spring.itjobgo.qna.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.spring.itjobgo.qna.model.service.QnaBoardService;
import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
import com.spring.itjobgo.qna.model.vo.QnaBoard;

@RestController
public class QnaBoardController {
	
	@Autowired
	private Logger logger;
	
	
	@Autowired
	private QnaBoardService service;
	
	@ResponseBody
	@RequestMapping(value="/qna/qnaboardlist" , method=RequestMethod.GET)
	public List<QnaBoard> qnaBoard() {
		
		List<QnaBoard> list =service.selectQnaBoard();

		for(QnaBoard i : list) {
			System.out.println(i);
		}
		
		System.out.println(list);

		return list;
	}
	
	//qna게시판 글작성하기
	@RequestMapping(value="/qna/qnaBoardWrite",method = RequestMethod.POST,
										consumes= {"multipart/form-data"})
	public String qnaWrite(QnaBoard qnaboard,
										@RequestBody MultipartFile[] file, HttpServletRequest request)
																																								{
//			qnaboard.setQnaSeq(1);
	
	logger.debug("매핑 확인");
	logger.debug("======vue에서 전송한  파일========");
	logger.debug("파일명"+file[0].getOriginalFilename());
	logger.debug("파일크기 : "+file[0].getSize());
	logger.debug(qnaboard.toString());
			
	
	
	//업로드 경로설정
	//파일 리네임 처리 후 파일 저장하기
	String saveDir=request.getServletContext().getRealPath("/resource/upload/qnaBoard");
	
	File dir=new File(saveDir);
	
	if(!dir.exists()) {
		//지정된경로의 폴더가 없으면
		dir.mkdirs(); //mk > make directory
	}
	
	List<QB_ATTACHMENT> files=new ArrayList();
	
	for(MultipartFile f:file) {
		
		if(!f.isEmpty()) {
			
			String originalFileName=f.getOriginalFilename();
			String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
			
			int rndNum=(int)(Math.random()*1000);
			
			String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
			
			try {
				//파일저장하기
				//스프링이 제공하는 멀티파트가 메소드를 제공한다. transferTo(파일)이라는 메소드를 제공한다.
				f.transferTo(new File(saveDir+"/"+renameFileName));
			}catch(IOException e) {
				e.printStackTrace();
			}
			QB_ATTACHMENT file2=new QB_ATTACHMENT(0,0,originalFileName,renameFileName,null,null);
			files.add(file2);

		}
	}
	int result=0;
	
	try {
		result=service.insertQnaBoard(qnaboard,files);
	
	}catch(RuntimeException e) {
		e.printStackTrace();
	}
	
	String msg="";
	if(result>0) msg="등록성공";
	
	else msg="등록실패";
	
	return msg;
	

	}
	
	
	
	
	
	
	
	
}

	
	
	
	

