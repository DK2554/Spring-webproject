package com.spring.itjobgo.resume.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

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

public interface ResumeDao {
	
	//이력서 게시판 리스트
	List<Rboard> selectListRboard(SqlSessionTemplate session);
	
	//이력서 게시판 글 등록
	int insertRboard(SqlSessionTemplate session, Rboard rboard);
	
	//이력서 게시판 파일첨부 등록
	int insertAttachment(SqlSessionTemplate session, RboardAttachment file);
	
	//이력서 리스트 보기
	List<ResumeList> selectResumeList(SqlSessionTemplate session, int memberSq);
	
	//이력서(개인정보) 등록
	int insertResume(SqlSessionTemplate session, Resume resume);
	
	//이력서(학력) 등록
	int insertResumeSchool(SqlSessionTemplate session, ResumeSchool school);
	
	//이력서(경력) 등록
	int insertResumeWork(SqlSessionTemplate session, ResumeWork work);
	
	//이력서(자격증) 등록
	int insertResumeLicense(SqlSessionTemplate session, ResumeLicense license);
	
	//이력서(외국어) 등록
	int insertResumeLanguage(SqlSessionTemplate session, ResumeLanguage language);
	
	//이력서(활동내역) 등록
	int insertResumeActivity(SqlSessionTemplate session, ResumeActivity activity);
	
	//이력서(프로젝트) 등록
	int insertResumeProject(SqlSessionTemplate session, ResumeProject project);
	
	//이력서(해외경험) 등록
	int insertResumeAbroad(SqlSessionTemplate session, ResumeAbroad abroad);
	
	//이력서리스트 등록
	int insertResumeList(SqlSessionTemplate session, ResumeList resumelist);
	
	//이력서(사진파일) 등록
	int insertResumeAttachment(SqlSessionTemplate session, ResumeAttachment file);
	
	//이력서 불러오기
	ResumeAll selectResume(SqlSessionTemplate session, int resumeNo);
}
