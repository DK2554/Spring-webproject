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
import com.spring.itjobgo.meeting.model.vo.Approve;
import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.meeting.model.vo.Mboard;
import com.spring.itjobgo.meeting.model.vo.Mcount;
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
	public int applymeeting(@RequestParam(value="postion") String postion,@RequestParam int memberSq,@RequestParam int collabSq,@RequestParam int writerNo  ) {
		Tmpapply tmp=new Tmpapply();
		tmp.setMemberSq(memberSq);
		tmp.setPostion(postion);
		tmp.setCollabSq(collabSq);
		tmp.setWriterNo(writerNo);
	
		int code=0;
		//이미 가입한 모임인지 확인
		Integer appcount=service.selectapplycheck(tmp);
		if(appcount!=null) {
			code=3;
			return code;
		}else {
			Mcount mc=service.selectcount(tmp);
			logger.debug(mc.toString());
			//신청한 포지션이 마감 여부
			if(postion.equals("back")) {
				code=mc.getCollabBack()==mc.getBackCount() ? 2:0;
			}else if(postion.equals("front")) {
				code=mc.getCollabFront()==mc.getFrontCount()?2:0;
			}else if(postion.equals("desgin")) {
				code=mc.getCollabDesgin()==mc.getDesginCount()?2:0;
			}
			if(code==0) {
				int check=service.selectapply(tmp);
				if(check==0) {
					code=service.insertapply(tmp);
				}
			}
			return code;
		}
		
		
	}
	//모임신청 취소
	@RequestMapping(value="meeting/delapplymeeting.do",method=RequestMethod.POST)
	public int delapplymeeting(@RequestParam int memberSq,@RequestParam int collabSq) {
		Tmpapply tmp=new Tmpapply();
		tmp.setMemberSq(memberSq);
		tmp.setCollabSq(collabSq);
		int check=service.selectapply(tmp);
		logger.debug(Integer.toString(check));
		int result=0;
		if(check==1) {
			int tno=service.selecttno(tmp);
			logger.debug(Integer.toString(tno));
			result=service.deleteapply(tno);
			logger.debug(Integer.toString(result));
			return result;
		}else return 0;
		      
	}
	//모임 목록에 이미지 보여주는 로직
	@RequestMapping(value="meeting/imagesrequest{no}",method=RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[]  imagereq(@PathVariable int no,HttpServletRequest request,HttpServletResponse res)throws Exception{
		logger.debug("이미지요청");
		//받아온 번호로 해당 첨부파일 db가서 받아오는 로직수행
		Mattachment mt=service.selectMat(no);
		logger.debug(mt.toString());
		String realFile = request.getServletContext().getRealPath("/resources/upload/meeting");
		String fileNm = mt.getRenamedFilename();
		//파일이름
		if(fileNm!=null) {
			//파일 확장자
			String ext = fileNm.substring(fileNm.lastIndexOf(".") + 1);
			String image=realFile+"\\"+fileNm;
			logger.debug("realFile:"+realFile+"fileNm:"+fileNm+"ext:"+ext);
			logger.debug(realFile+"\\"+fileNm);
			InputStream in =new FileInputStream(image);
			byte[] imageByteArray=IOUtils.toByteArray(in);
			in.close();
			return imageByteArray;
		}else {
			return null;
		}
		
		
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
	@RequestMapping(value="meeting/approve{no}.do",method=RequestMethod.GET)
	public void approvemeeting(@PathVariable int no) {
		Tmpapply tmp=service.selectOneapply(no);
		//번호로 해당 임시테이블에 있는 정보를 실제 신청완료한 테이블에 넣어준다.
		//승인이면 상태를 Y로 넣어준다(기본값은 N)
		Map param=new HashedMap();
		param.put("position",tmp.getPostion());
		param.put("collabsq",tmp.getCollabSq());
		logger.debug("param:"+param.get("position"));
		Approve ap=new Approve(0,tmp.getMemberSq(),tmp.getPostion(),null,tmp.getCollabSq(),"Y");
		int result=service.insertApprove(ap);
		if(result>0) {
			int pluscount=service.updatedcount(param);
			System.out.println(pluscount);
			int check=service.deleteapply(no);
		}//throws로 예외처리해야함
		
	}
	@RequestMapping(value="meeting/unapprove{no}.do",method=RequestMethod.GET)
	public void unapprovemeeting(@PathVariable int no) {
		Tmpapply tmp=service.selectOneapply(no);
		//번호로 해당 임시테이블에 있는 정보를 실제 신청완료한 테이블에 넣어준다.
		//미승인이면 상태를 N 넣어준다(기본값은 N)
		Approve ap=new Approve(0,tmp.getMemberSq(),tmp.getPostion(),null,tmp.getCollabSq(),"N");
		int result=service.insertApprove(ap);
		if(result>0) {
			int check=service.deleteapply(no);
		}//throws로 예외처리해야함
		
	}
	@RequestMapping(value="meeting/approvelist{no}.do",method=RequestMethod.GET)
	public List approvelist(@PathVariable int no) {
		logger.debug(Integer.toString(no));
		//회원 번호로 신청한 모임목록을 가져오는 로직
		List<Approve> ap=service.selectApprove(no);
		logger.debug(ap.toString());
		List list2=new ArrayList();
		Map param=null;
		String mname=null;
		for(Approve app:ap) {
			param=new HashedMap();
			mname=service.selectMboardname(app.getCollabSq());
			param.put("no",app.getAcnumber());
			param.put("collname",mname);
			param.put("collsq",app.getCollabSq());
			param.put("position",app.getPosition());
			param.put("status",app.getStatus());
			list2.add(param);
		}
		return list2;
	}
	@RequestMapping(value="meeting/mklist{memberSq}.do",method=RequestMethod.GET)
	public List retunmkmeeting(@PathVariable int memberSq) {
		logger.debug(Integer.toString(memberSq));
		List<Mboard> list =service.selectMklist(memberSq);
		List relist=new ArrayList();
		Map param =null;
		String bname=null;
		for(Mboard md:list) {
			param=new HashedMap();
			bname=service.selectMboardname(md.getCollabSq());
			param.put("collabSq",md.getCollabSq());
			param.put("title",bname);
			param.put("mdate",md.getMkdate());
			relist.add(param);
		}
		logger.debug(list.toString());
		return relist;
	}
	@RequestMapping(value="meeting/meetingdel{no}.do",method=RequestMethod.GET)
	public void delmeeting(@PathVariable int no ,HttpServletRequest request,HttpServletResponse response) {
		Mattachment mat=service.selectMat(no);
		if(mat!=null) {
			String fname=mat.getRenamedFilename();
			String saveDir=request.getServletContext().getRealPath("/resource/upload/meeting");
			int result=service.deletemeeting(no);
			if(result>0) {
				File file=new File(saveDir+"/"+fname);
				if(file.exists()) {
					if(file.delete()) logger.debug("이미지파일 삭제성공");
					else logger.debug("삭제실패");
				}
				
			}
		}else {
			int result=service.deletemeeting(no);
		}
	}
	@RequestMapping(value="meeting/meetingupdate{no}.do",method=RequestMethod.GET)
	public List updatemeeting(@PathVariable int no) {
		logger.debug(Integer.toString(no));
		Mboard md=service.selectMb(no);
		Mattachment mat=service.selectMat(no);
		logger.debug(mat.toString());
		List list=new ArrayList();
		list.add(md);
		list.add(mat);
	  
		
		return list;
	}
	@RequestMapping(value="/meeting/updatemeeting.do",method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public void meetingUpdateEnd(@RequestParam Map param,@RequestBody MultipartFile[] upfile,HttpServletRequest request) {
		
		int mtno=Integer.valueOf((String) param.get("mtno"));
		int result=0;
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
				logger.debug(Integer.toString(mtno));
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
			Mattachment file2=new Mattachment(mtno,0,originalFileName,renameFileName,null,null);
				files.add(file2);
				
				}
			}
			
			try {
				result=service.updatedmeeting(param,files);
			}catch(RuntimeException e) {
				e.printStackTrace();
			}
			
			}else {
				result=service.updatedmeeting(param);
			}
		
			

	}
}
	
	


	

	
