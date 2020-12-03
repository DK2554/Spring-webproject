package com.spring.itjobgo.qna.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.spring.itjobgo.qna.model.service.QnaBoardService;
import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
import com.spring.itjobgo.qna.model.vo.QB_COMMENT;
import com.spring.itjobgo.qna.model.vo.QnaBoard;

@RestController
public class QnaBoardController {
	
	@Autowired
	private Logger logger;
	
	@Autowired
	private QnaBoardService service;
	
	@ResponseBody
	@RequestMapping(value="qna/qnaboardlist" , method=RequestMethod.GET)
	public List<QnaBoard> qnaBoard() {
		
		System.out.println("==qna리스트==");
		List<QnaBoard> list =service.selectQnaBoard();

		for(QnaBoard i : list) {
			System.out.println(i);
		}
		
		System.out.println(list);

		return list;
	}
	
	//qna게시판 글쓰기
	@RequestMapping(value="/qna/qnaBoardWrite",
										method = RequestMethod.POST, consumes= {"multipart/form-data"})
		public String qbBoard(QnaBoard Qboard, @RequestParam(value="memberSq") int memberno,
													@RequestBody MultipartFile[] file, HttpServletRequest request) 
										{
		
		System.out.println("멤버번호 : " + memberno);
		Qboard.setMemberNum(memberno);
		
		logger.debug("매핑확인");
		logger.debug("======vue에서 전송한  파일========");
		//파일이 있다면
		if(file.length>0) {
			logger.debug("파일명"+file[0].getOriginalFilename());
			logger.debug("파일크기"+file[0].getSize());
		}
		logger.debug(Qboard.toString());
		
		
		//업로드 경로 설정
		//파일 리네임 처리후 파일 저장하기
		String saveDir=request.getServletContext().getRealPath("/resources/upload/qnaBorad");
		
		File dir=new File(saveDir);
		
		if(!dir.exists()) {
		//지정된경로의 폴더가 없으면
		dir.mkdirs(); //mk > make directory
		}
		
		List<QB_ATTACHMENT> files=new ArrayList<QB_ATTACHMENT>();
		
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
		QB_ATTACHMENT file2=new QB_ATTACHMENT(0,0,originalFileName,renameFileName,null,null);
		files.add(file2);
		}
	}
	int result=0;
		
		
		try {
		//게시판 글 작성
		result=service.insertQnaBoard(Qboard,files);
		
		}catch(RuntimeException e) {
		e.printStackTrace();
		}
		
		String msg="";
		if(result>0) msg="등록성공";
		
		else msg="등록실패";
		
		return msg;
	

	}
	
	//qna게시판 상세화면 전환페이지
	@RequestMapping(value="/qna/qnaBoardView{QnaSeq}",
										method=RequestMethod.GET)
	public QnaBoard selectQnaBoardOne(@PathVariable int QnaSeq,
																			HttpServletRequest request,
																			HttpServletResponse response)
			throws JsonMappingException,JsonGenerationException,IOException{
		
		System.out.print("=======상세화면========");
		
		logger.debug("qnaSeq"+Integer.toString(QnaSeq));
		
		//조회수 증가로직 쿠키이용
		Cookie[] cookies = request.getCookies();
		String boardHistory="";
		boolean hasRead=false;
		
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				
				if("boardHistory".equals(name)) {
					boardHistory=value; //현재 저장된 값 대입 덮어쓰기 하면서 누적
					
					if(value.contains("|"+QnaSeq+"|")) {
						hasRead=true;
						break;
					}
				}
			}//for
		}//if
		
		if(!hasRead) {
			Cookie c = new Cookie("boardHistory",boardHistory+"|"+QnaSeq+"|");
			c.setMaxAge(-1);
			response.addCookie(c);
					
		}
		
		QnaBoard qboard =service.selectQnaBoardOne(QnaSeq,hasRead);
		
		return qboard;
	}
	
	
	//qna게시판 삭제하기
	@RequestMapping(value="/qna/qnaBoardDelete{qnaSeq}",
									method=RequestMethod.POST)
	public String deleteBoard(@PathVariable int qnaSeq, HttpServletRequest request) 
			throws JsonMappingException,JsonGenerationException,IOException
			{
		
			//첨부파일 삭제가 되면 그 결과값이 result>0이면 게시글 삭제로 이어지도록
			String msg="";
			logger.debug("첨부파일 삭제 후 게시글 삭제 로직 수행 logger");
			
			//먼저 게시글 번호를 가지고 해당 첨부파일을 가져오는 메서드
			QB_ATTACHMENT qba = service.selectAttach(qnaSeq);
			System.out.println("qba");
			
			//첨부파일이 있을경우
			if(qba!=null) {

			//첨부파일을 가져온 후 첨부파일을 서버에서(/resources/upload/communityBoard)삭제
			String ReNameFile = qba.getRenamedfilename();
			String saveDir = request.getServletContext().getRealPath("/resources/upload/qnaBoard");
			
			//먼저 게시글 삭제 후 첨부파일 삭제
			int result =service.deleteBoard(qnaSeq);
			
			if(result>0) {
				msg="qna게시판 글 삭제 성공";
				//게시글 삭제를 성공했을때 첨부파일이 있다면 첨부파일도 삭제
				File file = new File(saveDir+"/"+ReNameFile);
				if(file.exists()) {
					if(file.delete()) logger.debug("첨부파일 삭제 성공");
					else logger.debug("첨부파일 삭제 실패");
				}
			}
			
			else {
				msg="qna게시판 글 삭제 실패";
			}
			//첨부파일이 없는 게시글 삭제
			}else {
				int result = service.deleteBoard(qnaSeq);
				msg =(result>0)? "qna게시판 글 삭제 성공" : "qna게시판 글 삭제 실패";
			}
			logger.debug(msg);
			return msg;
	}
	
	
	//첨부파일 먼저 불러오기(update form으로)
	@RequestMapping(value="/qna/qnaBoardUpdate{qnaSeq}",
										method = RequestMethod.GET)
	public QB_ATTACHMENT selectAttach(@PathVariable int qnaSeq) {
		System.out.println("===첨부파일 불러오기 맵핑 시작===");
		
		QB_ATTACHMENT qba=service.selectAttach(qnaSeq);
		
		System.out.println("qba");
		
		return qba;
	}
	
	
	//qna 게시판 수정하기
	@RequestMapping(value="/qna/qnaBoardUpdateEnd",
										method=RequestMethod.POST,
										consumes= {"multipart/form-data"})
	public String qnaBoardUpdate(QnaBoard qb,
														@RequestBody(required=false)
															MultipartFile[] file,
															HttpServletRequest request) {
		
		System.out.println("==업데이트 메서드 실행=========");
		
		if(file.length>0) {
			//파일이 존재한다면 게시판 번호를 변수에 넣어둔다.
			int qnaSeq = qb.getQnaSeq();
			
			String saveDir=request.getServletContext().getRealPath("/resources/upload/qnaBoard");
			
			File dir = new File(saveDir);
			if(!dir.exists()) {
				//지정된 경로가 없으면 폴더를 생성해주는 메서드 mkdirs()
				dir.mkdirs();
			}
			
			List<QB_ATTACHMENT> files = new ArrayList();
			
			//원래 파일이 존재한다면 get해서 가져와서 변수에 저장해두기
			for(MultipartFile f:file) {
				if(!f.isEmpty()) {
					String originalFileName=f.getOriginalFilename();
					String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
					int rndNum=(int)(Math.random()*1000);
					String renameFileName=sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
					
					try {
						//파일 저장하기
						//스프링이 제공하는 멀티파트가 메소드를 제공한다.
						//transfer to(파일) 메소드를 이용한다.
						f.transferTo(new File(saveDir+"/"+renameFileName));
					}catch(IOException e) {
						e.printStackTrace();
					}
					
					QB_ATTACHMENT file2 = new QB_ATTACHMENT(0,qnaSeq,originalFileName,renameFileName,null,null);
					files.add(file2);
					
				}
			}
			int result=0;
			try {
				//게시판 글 업데이트
				result = service.updateBoard(qb,files);
			}catch(RuntimeException e) {
				e.printStackTrace();
			}
			String msg="";
			if(result>0) msg="게시글 수정 성공";
			else msg="게시글 수정 실패";
			
			}//193번째줄 if > 파일이 있다면 / 게시판 정보만 업데이트
			else {
			int result = service.updateBoard(qb);
			}
			return "업데이트 테스트";
	
	}
		
	//첨부파일 표시
	@RequestMapping(value="qna/qnaBoardAttachment{qnaSeq}",
										method=RequestMethod.GET)
	public QB_ATTACHMENT downLoad(@PathVariable int qnaSeq) {
		
		System.out.println("====첨부파일 다운로드 매핑 시작=====");
		logger.debug(Integer.toString(qnaSeq));
		QB_ATTACHMENT qba=service.selectAttach(qnaSeq);
		if(qba==null) return null;
		else return qba;
	}
	
	
	//첨부파일 다운로드(이름 보내기)
	@RequestMapping(value="qna/qnafiledownload",method=RequestMethod.GET)
	public void qnafiledownload(HttpServletRequest request, HttpServletResponse response,
														@RequestHeader(name="user-agent")String header,
														@RequestParam(value="oriName")String oriName,
														@RequestParam(value="reName")String reName)
														{
		logger.debug(oriName);
		logger.debug(reName);
		String path=request.getServletContext().getRealPath("/resources/upload/qnaBoard");
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
			
	// 댓글작성하기
	@RequestMapping(value="qna/qnacomment",method = RequestMethod.POST)
	public void comment(QB_COMMENT cm) {
	System.out.println("댓글~~~~~~~~~~~~~~~~~~~~~~~매핑시작");
		int result = service.insertComment(cm);
		if(result>0) {
			//답글이 달리면 N->Y로 변경.
			int comment = service.insertCommentText(cm.getQbBoardNo());
		}
		
	}
	//댓글 조회
	@RequestMapping(value="qna/qnalist",method =RequestMethod.GET)
	public List<QB_COMMENT> commentList(@PathVariable int qbBoardNo){
		//해당 게시글 번호를 가져와서 게시글에 맞는 댓글을 불러오는 것
		logger.debug("댓글 조회 매핑테스트");
		List<QB_COMMENT> list=service.selectQnacomment(qbBoardNo);
		for(QB_COMMENT cm:list) {
			logger.debug(cm.toString());
		}
		return list;
	}
	
	//댓글삭제
	@RequestMapping(value="qna/commentdel",method=RequestMethod.POST)
	public void commentdel(@PathVariable int qbCommentNo) {
			int result=service.deletecomment(qbCommentNo);
	}
	
	
	
	
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	

