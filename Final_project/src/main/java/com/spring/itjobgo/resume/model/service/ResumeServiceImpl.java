package com.spring.itjobgo.resume.model.service;

import java.util.List;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.resume.model.dao.ResumeDao;
import com.spring.itjobgo.resume.model.vo.Rboard;
import com.spring.itjobgo.resume.model.vo.RboardAttachment;
import com.spring.itjobgo.resume.model.vo.Resume;
import com.spring.itjobgo.resume.model.vo.ResumeAbroad;
import com.spring.itjobgo.resume.model.vo.ResumeActivity;
import com.spring.itjobgo.resume.model.vo.ResumeAttachment;
import com.spring.itjobgo.resume.model.vo.ResumeLanguage;
import com.spring.itjobgo.resume.model.vo.ResumeLicense;
import com.spring.itjobgo.resume.model.vo.ResumeProject;
import com.spring.itjobgo.resume.model.vo.ResumeSchool;
import com.spring.itjobgo.resume.model.vo.ResumeWork;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDao dao;
	
	@Autowired
	private SqlSessionTemplate session;
	
	//이력서 게시판 리스트
	@Override
	public List<Rboard> selectListRboard() {
		System.out.println("*******service 들어옴******");
		
		return dao.selectListRboard(session);
	}
	//이력서 게시판 등록
	@Override
	public int insertRboard(Rboard rboard, List<RboardAttachment> files) {
		System.out.println("*******게시물 등록 service 들어옴******");
		int result=dao.insertRboard(session, rboard);
		System.out.println("*******result : "+result);
		if(result==0) throw new RuntimeException("이력서 게시판 글 등록 오류");
		if(result>0) {
			if(!files.isEmpty()) {
				for(RboardAttachment file:files) {
					System.out.println("*******file : "+file);
					result=dao.insertAttachment(session,file);
					System.out.println("******"+result+"*******");
					if(result==0) throw new RuntimeException("이력서 게시판 파일 입력 오류"); 
				}
			}
		}
		return result;
	}
	@Override
	public int insertResume(Resume resume, ResumeSchool school, ResumeWork work, ResumeLicense license, 
			ResumeLanguage language, ResumeActivity activity, ResumeProject project, 
			ResumeAbroad abroad, List<ResumeAttachment> files) {
		int result=dao.insertResume(session, resume);
			System.out.println("service: 개인정보  : "+result);
			if(result==0) {throw new RuntimeException("이력서 등록 오류");
				}else {result=0;}
		result=dao.insertResumeSchool(session, school);
			System.out.println("service: 학력  : "+result);
			if(result==0) {throw new RuntimeException("이력서 등록(학력) 오류");
				}else {result=0;}
		result=dao.insertResumeWork(session, work);
			System.out.println("service: 경력 : "+result);
			if(result==0) {throw new RuntimeException("이력서 등록(경력) 오류");
				}else {result=0;}
		result=dao.insertResumeLicense(session, license);
			System.out.println("service: 자격증  : "+result);
			if(result==0) {throw new RuntimeException("이력서 등록(자격증) 오류");
				}else {result=0;}
		result=dao.insertResumeLanguage(session, language);
			System.out.println("service: 외국어 : "+result);
			if(result==0) {throw new RuntimeException("이력서 등록(외국어) 오류");
				}else {result=0;}
		result=dao.insertResumeActivity(session, activity);
			System.out.println("service: 활동  : "+result);
			if(result==0) {throw new RuntimeException("이력서 등록(활동및수상내역) 오류");
				}else {result=0;}
		result=dao.insertResumeProject(session, project);
			System.out.println("service: 프로젝트  : "+result);
			if(result==0) {throw new RuntimeException("이력서 등록(프로젝트) 오류");
				}else {result=0;}
		result=dao.insertResumeAbroad(session, abroad);
			System.out.println("service: 해외경험  : "+result);
			if(result==0) throw new RuntimeException("이력서 등록(해외경험) 오류");
			if(result>0) {
				if(!files.isEmpty()) {
					for(ResumeAttachment file:files) {
						System.out.println("*******file : "+file);
						result=dao.insertResumeAttachment(session,file);
						System.out.println("******"+result+"*******");
						if(result==0) throw new RuntimeException("이력서  등록(사진파일) 오류"); 
					}
				}
		}
		return result;
		
	}

	
	
}
