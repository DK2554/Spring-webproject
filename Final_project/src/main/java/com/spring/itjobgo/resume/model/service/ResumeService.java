package com.spring.itjobgo.resume.model.service;

import java.util.List;

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

public interface ResumeService {
	//이력서 컨설팅 게시판 보기
	List<Rboard> selectListRboard();
	
	//이력서 리스트 보기
	List<ResumeList> selectResumeList(int memberSq);
	
	//이력서 게시판 등록하기
	int insertRboard(Rboard rboard, List<RboardAttachment> files);
	
	//이력서(개인정보+첨부파일) 등록
	int insertResume(Resume resume, ResumeSchool school, ResumeWork work, ResumeLicense license, 
			ResumeLanguage language, ResumeActivity activity, ResumeProject project, 
			ResumeAbroad abroad, List<ResumeAttachment> files, ResumeList resumelist);
	
	//이력서 불러오기
	ResumeAll selectResume(int resumeNo);
	
	//증명사진 불러오기
	String selectAttachment(String resumeNo);
}
