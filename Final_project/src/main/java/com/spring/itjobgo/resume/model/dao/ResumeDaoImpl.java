package com.spring.itjobgo.resume.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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

@Repository
public class ResumeDaoImpl implements ResumeDao {
	
	//이력서 게시판 리스트
	@Override
	public List<Rboard> selectListRboard(SqlSessionTemplate session) {

		return session.selectList("rboard.selectRboard");
	}
	
	//이력서 게시판 글 등록
	@Override
	public int insertRboard(SqlSessionTemplate session, Rboard rboard) {
		System.out.println("*******게시물 등록 dao 들어옴******");
		return session.insert("rboard.insertRboard",rboard);
	}

	//이력서 게시판 첨부파일 등록
	@Override
	public int insertAttachment(SqlSessionTemplate session, RboardAttachment file) {
		System.out.println("********dao 파일첨부 하기 전**********");
		return session.insert("rboard.insertAttachment",file);
	}
	
	//이력서(개인정보) 등록
	@Override
	public int insertResume(SqlSessionTemplate session, Resume resume) {
		System.out.println("********dao 이력서 등록 하기 전**********");
		return session.insert("resume.insertResume",resume);
	}
	
	//이력서(사진파일) 등록
	@Override
	public int insertResumeAttachment(SqlSessionTemplate session, ResumeAttachment file) {
		System.out.println("********dao 사진 파일첨부 하기 전**********");
		return session.insert("resume.insertResumeAttachment",file);
	}
	//이력서(학력) 등록
	@Override
	public int insertResumeSchool(SqlSessionTemplate session, ResumeSchool school) {
		System.out.println("********dao 학력 하기 전**********");
		return session.insert("resume.insertResumeSchool",school);
	}
	//이력서(경력) 등록
	@Override
	public int insertResumeWork(SqlSessionTemplate session, ResumeWork work) {
		System.out.println("********dao 경력 하기 전**********");
		return session.insert("resume.insertResumeWork",work);
	}
	//이력서(자격증) 등록
	@Override
	public int insertResumeLicense(SqlSessionTemplate session, ResumeLicense license) {
		System.out.println("********dao 자격증 하기 전**********");
		return session.insert("resume.insertResumeLicense",license);
	}
	//이력서(외국어) 등록
	@Override
	public int insertResumeLanguage(SqlSessionTemplate session, ResumeLanguage language) {
		System.out.println("********dao 외국어 하기 전**********");
		return session.insert("resume.insertResumeLanguage",language);
	}
	//이력서(활동내역) 등록
	@Override
	public int insertResumeActivity(SqlSessionTemplate session, ResumeActivity activity) {
		System.out.println("********dao 활동 하기 전**********");
		return session.insert("resume.insertResumeActivity",activity);
	}
	//이력서(프로젝트) 등록
	@Override
	public int insertResumeProject(SqlSessionTemplate session, ResumeProject project) {
		System.out.println("********dao 프로젝트 하기 전**********");
		return session.insert("resume.insertResumeProject",project);
	}
	//이력서(해외경험) 등록
	@Override
	public int insertResumeAbroad(SqlSessionTemplate session, ResumeAbroad abroad) {
		System.out.println("********dao 해외경험 하기 전**********");
		return session.insert("resume.insertResumeAbroad",abroad);
	}

	
	

}
