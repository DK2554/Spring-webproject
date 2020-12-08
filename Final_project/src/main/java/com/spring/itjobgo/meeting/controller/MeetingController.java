package com.spring.itjobgo.meeting.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
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
import com.spring.itjobgo.meeting.model.service.MeetingService;
import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.meeting.model.vo.Mboard;
import com.spring.itjobgo.meeting.model.vo.Tmpapply;
import com.spring.itjobgo.member.model.vo.Member;


@RestController
public class MeetingController {
	@Autowired
	private MeetingService service;
	
	@Autowired
	private Logger logger;
	//vue에서 보낸 첨부파일을 받기위한 설정
	@RequestMapping(value="/meeting/enrollmeeting.do",method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String meetingFromEnd(@RequestParam Map param,@RequestBody MultipartFile[] upfile,HttpServletRequest request) {
		String msg="";
		System.out.println(param);	
		if(upfile.length>0) {
			
			String saveDir=request.getServletContext().getRealPath("/resources/upload/meeting");
			File dir=new File(saveDir);
			if(!dir.exists()) {
				//지정된 경로의 폴더가 없으면 생성해라
				dir.mkdirs();
			}
			List<Mattachment> files=new ArrayList();
			for(MultipartFile f:upfile) {
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
			Mattachment file2=new Mattachment(0,0,originalFileName,renameFileName,null,null);
				files.add(file2);
				}
			}
			int result=0;
			try {
				result=service.insertMboard(param,files);
			}catch(RuntimeException e) {
				e.printStackTrace();
			}
			
			if(result>0) msg="등록성공";
			else msg="등록실패";
		}
		return msg;
	}
	@RequestMapping(value="meeting/meetingList.do" ,method = RequestMethod.GET)
	public List<Mboard> meetingList()throws JsonMappingException,JsonGenerationException,IOException{
		List<Mboard> list=service.selectMlist();
		logger.debug("여기오면 매핑성공");
		logger.debug(list.toString());
		return list;
	}
	//모임을 클릭했을때 해당 모임정보를 리턴
	@RequestMapping(value="meeting/meetinginfo{no}.do",method=RequestMethod.GET)
	public Mboard meetinginfo(@PathVariable int no)throws JsonMappingException,JsonGenerationException,IOException{
		Mboard md=service.selectMb(no);
		logger.debug(md.toString());
		return md;
	}
	//모임신청하는 로직
	@RequestMapping(value="meeting/applymeeting.do",method=RequestMethod.POST)
	public void applymeeting(@RequestParam(value="postion") String postion,@RequestParam int memberSq,@RequestParam int collabSq,@RequestParam int writerNo  ) {
		logger.debug(Integer.toString(memberSq));
		logger.debug(Integer.toString(collabSq));
		logger.debug(Integer.toString(writerNo));
		logger.debug(postion);
		int result=service.insertapply(memberSq,postion,collabSq,writerNo);
		
	}
	//모임 목록에 이미지 보여주는 로직
	@RequestMapping(value="meeting/imagesrequest{no}",method=RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[]  imagereq(@PathVariable int no,HttpServletRequest request,HttpServletResponse res)throws Exception{
		logger.debug("이미지요청");
		//받아온 번호로 해당 첨부파일 db가서 받아오는 로직수행
		Mattachment mt=service.selectMat(no);
		logger.debug(mt.toString());
		//파일경로
		String realFile = request.getServletContext().getRealPath("/resources/upload/meeting");
		//파일이름
		String fileNm = mt.getRenamedFilename();
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
	@RequestMapping(value="meeting/meetingapply{email}.do",method=RequestMethod.GET)
	public List  returntmpapply(@PathVariable String email) throws JsonMappingException,JsonGenerationException,IOException{
		logger.debug(email);
		//로그인한 이메일로 사용자 정보 확인
		Member m = service.selectOneMember(email);
		logger.debug(m.toString());
		List<Tmpapply>list=service.selectapply(m.getMemberSq());
		List list2=new ArrayList();
		Map param=null;
		String mname=null;
		String bname=null;
		logger.debug(list.toString());
		
		for(Tmpapply m2 : list) {
				param=new HashMap();
				mname=service.selectmembername(m2.getMemberSq());	
				bname=service.selectMboardname(m2.getCollabSq());
				param.put("no",m2.getTmpNo());
				param.put("username",mname);
				param.put("position",m2.getPostion());
				param.put("collname",bname);
				param.put("writerNo",m2.getWriterNo());
				list2.add(param);
				
			logger.debug(m2.toString());
			logger.debug(param+"param");
			logger.debug(list2.toString());
		}
		return list2;
	}


	
}
	
