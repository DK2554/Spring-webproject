package com.spring.itjobgo.resume.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.resume.model.dao.ResumeDao;
import com.spring.itjobgo.resume.model.vo.Consult;
import com.spring.itjobgo.resume.model.vo.ConsultAttachment;
import com.spring.itjobgo.resume.model.vo.Rboard;
import com.spring.itjobgo.resume.model.vo.RboardAttachment;
import com.spring.itjobgo.resume.model.vo.Resume;
import com.spring.itjobgo.resume.model.vo.ResumeAbroad;
import com.spring.itjobgo.resume.model.vo.ResumeActivity;
import com.spring.itjobgo.resume.model.vo.ResumeAll;
import com.spring.itjobgo.resume.model.vo.ResumeAttachment;
import com.spring.itjobgo.resume.model.vo.ResumeLanguage;
import com.spring.itjobgo.resume.model.vo.ResumeLicense;
import com.spring.itjobgo.resume.model.vo.ResumeList;
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
	
	//이력서 리스트 보기
	@Override
	public List<ResumeList> selectResumeList(int memberSq) {
		System.out.println("*******service selectResumeList 들어옴******");
		return dao.selectResumeList(session, memberSq);
	}
	
	//이력서 등록
	@Override
	public int insertResume(Resume resume, ResumeSchool school, ResumeWork work, ResumeLicense license, 
			ResumeLanguage language, ResumeActivity activity, ResumeProject project, 
			ResumeAbroad abroad, List<ResumeAttachment> files, ResumeList resumelist) {
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
			
		result=dao.insertResumeList(session, resumelist);
			System.out.println("service: 이력서리스트  : "+result);
			if(result==0) {throw new RuntimeException("이력서리스트 등록 오류");
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

	//이력서 보기
	@Override
	public ResumeAll selectResume(int resumeNo) {
		System.out.println("*******service 들어옴******");
		return dao.selectResume(session, resumeNo);
	}
	
	//증명사진 보기
	@Override
	public String selectAttachment(String resumeNo) {
		System.out.println("*******service selectAttachment 들어옴******");
		return dao.selectAttachment(session, resumeNo);
	}
	
	//이력서 수정
	@Override
	public int updateResume(Resume resume, ResumeSchool school, ResumeWork work, ResumeLicense license,
			ResumeLanguage language, ResumeActivity activity, ResumeProject project, ResumeAbroad abroad,
			List<ResumeAttachment> files, ResumeList resumelist) {
		
			int result=dao.updateResume(session, resume);
			System.out.println("service: 개인정보  : "+result);
			if(result==0) {throw new RuntimeException("이력서 수정 오류");
				}else {result=0;}
			
		result=dao.updateResumeSchool(session, school);
			System.out.println("service: 학력  : "+result);
			if(result==0) {throw new RuntimeException("이력서  수정(학력) 오류");
				}else {result=0;}
		result=dao.updateResumeWork(session, work);
			System.out.println("service: 경력 : "+result);
			if(result==0) {throw new RuntimeException("이력서  수정(경력) 오류");
				}else {result=0;}
		result=dao.updateResumeLicense(session, license);
			System.out.println("service: 자격증  : "+result);
			if(result==0) {throw new RuntimeException("이력서 수정(자격증) 오류");
				}else {result=0;}
		result=dao.updateResumeLanguage(session, language);
			System.out.println("service: 외국어 : "+result);
			if(result==0) {throw new RuntimeException("이력서  수정(외국어) 오류");
				}else {result=0;}
		result=dao.updateResumeActivity(session, activity);
			System.out.println("service: 활동  : "+result);
			if(result==0) {throw new RuntimeException("이력서 수정(활동및수상내역) 오류");
				}else {result=0;}
		result=dao.updateResumeProject(session, project);
			System.out.println("service: 프로젝트  : "+result);
			if(result==0) {throw new RuntimeException("이력서  수정(프로젝트) 오류");
				}else {result=0;}
			
		result=dao.updateResumeList(session, resumelist);
			System.out.println("service: 이력서리스트  : "+result);
			if(result==0) {throw new RuntimeException("이력서리스트  수정 오류");
				}else {result=0;}
			
		result=dao.updateResumeAbroad(session, abroad);
			System.out.println("service: 해외경험  : "+result);
			if(result==0) throw new RuntimeException("이력서  수정(해외경험) 오류");
			if(result>0) {
				if(!files.isEmpty()) {
					for(ResumeAttachment file:files) {
						System.out.println("*******file : "+file);
						result=dao.updateResumeAttachment(session,file);
						System.out.println("******"+result+"*******");
						if(result==0) throw new RuntimeException("이력서   수정(사진파일) 오류"); 
					}
				}
		}
	
		return result;
	}
	
	//이력서 삭제하기 (파일포함)
	@Override
	public int deleteResume(int resumeNo) {
		
			
		int result=dao.deleteResumeSchool(session, resumeNo);
			System.out.println("service: 학력  : "+result);
			if(result==0) {throw new RuntimeException("이력서  삭제(학력) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeWork(session, resumeNo);
			System.out.println("service: 경력 : "+result);
			if(result==0) {throw new RuntimeException("이력서  삭제(경력) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeLicense(session, resumeNo);
			System.out.println("service: 자격증  : "+result);
			if(result==0) {throw new RuntimeException("이력서 삭제(자격증) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeLanguage(session, resumeNo);
			System.out.println("service: 외국어 : "+result);
			if(result==0) {throw new RuntimeException("이력서  삭제(외국어) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeActivity(session, resumeNo);
			System.out.println("service: 활동  : "+result);
			if(result==0) {throw new RuntimeException("이력서 삭제(활동및수상내역) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeProject(session, resumeNo);
			System.out.println("service: 프로젝트  : "+result);
			if(result==0) {throw new RuntimeException("이력서  삭제(프로젝트) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeList(session, resumeNo);
			System.out.println("service: 이력서리스트  : "+result);
			if(result==0) {throw new RuntimeException("이력서리스트 삭제 오류");
				}else {result=0;}
			
		result=dao.deleteResumeAbroad(session, resumeNo);
			System.out.println("service: 해외경험  : "+result);
			if(result==0) {throw new RuntimeException("이력서  삭제(해외경험) 오류");
			}else {result=0;}
			
		result=dao.deleteResumeAttachment(session,resumeNo);
			System.out.println("******"+result+"*******");
			if(result==0) {throw new RuntimeException("이력서  삭제(사진파일) 오류"); 
			}else {result=0;}
			
		result=dao.deleteResume(session, resumeNo);
			System.out.println("service: 개인정보  : "+result);
			if(result==0) {throw new RuntimeException("이력서(개인정보) 삭제 오류");
			}
			
			return result;
	   }
	
	//이력서 삭제하기 (파일제외)
	@Override
	public int deleteResume1(int resumeNo) {
		
		int result=dao.deleteResumeSchool(session, resumeNo);
			System.out.println("service: 학력  : "+result);
			if(result==0) {throw new RuntimeException("이력서  삭제(학력) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeWork(session, resumeNo);
			System.out.println("service: 경력 : "+result);
			if(result==0) {throw new RuntimeException("이력서  삭제(경력) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeLicense(session, resumeNo);
			System.out.println("service: 자격증  : "+result);
			if(result==0) {throw new RuntimeException("이력서 삭제(자격증) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeLanguage(session, resumeNo);
			System.out.println("service: 외국어 : "+result);
			if(result==0) {throw new RuntimeException("이력서  삭제(외국어) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeActivity(session, resumeNo);
			System.out.println("service: 활동  : "+result);
			if(result==0) {throw new RuntimeException("이력서 삭제(활동및수상내역) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeProject(session, resumeNo);
			System.out.println("service: 프로젝트  : "+result);
			if(result==0) {throw new RuntimeException("이력서  삭제(프로젝트) 오류");
				}else {result=0;}
			
		result=dao.deleteResumeList(session, resumeNo);
			System.out.println("service: 이력서리스트  : "+result);
			if(result==0) {throw new RuntimeException("이력서리스트 삭제 오류");
				}else {result=0;}
			
		result=dao.deleteResumeAbroad(session, resumeNo);
			System.out.println("service: 해외경험  : "+result);
			if(result==0) {throw new RuntimeException("이력서  삭제(해외경험) 오류");
			}else {result=0;}
			
			result=dao.deleteResume(session, resumeNo);
			System.out.println("service: 개인정보  : "+result);
			if(result==0) {throw new RuntimeException("이력서(개인정보) 삭제 오류");
			}
			
			return result;
	      }
	@Override
	public int insertConsult(Consult consult, List<ConsultAttachment> files) {

		int result=dao.insertConsult(session, consult);
		System.out.println("service consult result  : "+result);
		
		if(result==0) throw new RuntimeException("전문가 등록 오류");
		if(result>0) {
			if(!files.isEmpty()) {
				for(ConsultAttachment file:files) {
					System.out.println("*******file : "+file);
					result=dao.insertConsultAttachment(session,file);
					System.out.println("******"+result+"*******");
					if(result==0) throw new RuntimeException("전문가 증빙서류(파일첨부) 오류"); 
				}
			}
		}
		return result;
	}
	

	
	
}
