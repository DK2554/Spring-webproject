package com.spring.itjobgo.resume.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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
	
	//이력서 리스트 보기
	@Override
	public List<ResumeList> selectResumeList(SqlSessionTemplate session, int memberSq) {
		System.out.println("********dao 이력서 리스트 가져오기 전**********");
		return session.selectList("resume.selectResumeList",memberSq);
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
	//이력서리스트 등록
	@Override
	public int insertResumeList(SqlSessionTemplate session, ResumeList resumelist) {
		System.out.println("********dao 이력서리스트 등록 전**********");
		return session.insert("resume.insertResumeList",resumelist);
	}
	
	//이력서(해외경험) 등록
	@Override
	public int insertResumeAbroad(SqlSessionTemplate session, ResumeAbroad abroad) {
		System.out.println("********dao 해외경험 하기 전**********");
		return session.insert("resume.insertResumeAbroad",abroad);
	}

	//이력서 불러오기
	@Override
	public ResumeAll selectResume(SqlSessionTemplate session, int resumeNo) {
		System.out.println("********dao 이력서 불러오기 전**********");
		return session.selectOne("resume.selectResume",resumeNo);
	}

	//증명사진 불러오기
	@Override
	public String selectAttachment(SqlSessionTemplate session, String resumeNo) {
		System.out.println("********dao 증명사진 불러오기 전**********");
		return session.selectOne("resume.selectAttachment",resumeNo);
	}

	
	//이력서(개인정보) 수정
		@Override
		public int updateResume(SqlSessionTemplate session, Resume resume) {
			System.out.println("********dao 이력서 수정 하기 전**********");
			return session.insert("resume.updateResume",resume);
		}
		
		//이력서(사진파일) 수정
		@Override
		public int updateResumeAttachment(SqlSessionTemplate session, ResumeAttachment file) {
			System.out.println("********dao 사진 파일첨부 수정 하기 전**********");
			return session.insert("resume.updateResumeAttachment",file);
		}
		//이력서(학력) 수정
		@Override
		public int updateResumeSchool(SqlSessionTemplate session, ResumeSchool school) {
			System.out.println("********dao 학력 수정 하기 전**********");
			return session.insert("resume.updateResumeSchool",school);
		}
		//이력서(경력) 수정
		@Override
		public int updateResumeWork(SqlSessionTemplate session, ResumeWork work) {
			System.out.println("********dao 경력 수정하기 전**********");
			return session.insert("resume.updateResumeWork",work);
		}
		//이력서(자격증) 수정
		@Override
		public int updateResumeLicense(SqlSessionTemplate session, ResumeLicense license) {
			System.out.println("********dao 자격증 수정하기 전**********");
			return session.insert("resume.updateResumeLicense",license);
		}
		//이력서(외국어) 수정
		@Override
		public int updateResumeLanguage(SqlSessionTemplate session, ResumeLanguage language) {
			System.out.println("********dao 외국어 수정하기 전**********");
			return session.insert("resume.updateResumeLanguage",language);
		}
		//이력서(활동내역) 수정
		@Override
		public int updateResumeActivity(SqlSessionTemplate session, ResumeActivity activity) {
			System.out.println("********dao 활동 수정하기 전**********");
			return session.insert("resume.updateResumeActivity",activity);
		}
		//이력서(프로젝트) 수정
		@Override
		public int updateResumeProject(SqlSessionTemplate session, ResumeProject project) {
			System.out.println("********dao 프로젝트 수정하기 전**********");
			return session.insert("resume.updateResumeProject",project);
		}
		//이력서리스트 수정
		@Override
		public int updateResumeList(SqlSessionTemplate session, ResumeList resumelist) {
			System.out.println("********dao 이력서리스트 수정 전**********");
			return session.insert("resume.updateResumeList",resumelist);
		}
		
		//이력서(해외경험) 수정
		@Override
		public int updateResumeAbroad(SqlSessionTemplate session, ResumeAbroad abroad) {
			System.out.println("********dao 해외경험 수정하기 전**********");
			return session.insert("resume.updateResumeAbroad",abroad);
		}


		//이력서(개인정보) 삭제
		@Override
		public int deleteResume(SqlSessionTemplate session, int resumeNo) {
			System.out.println("********dao 이력서 수정 하기 전**********");
			return session.delete("resume.deleteResume",resumeNo);
		}
		
		//이력서(사진파일) 삭제
		@Override
		public int deleteResumeAttachment(SqlSessionTemplate session, int resumeNo) {
			System.out.println("********dao 사진 파일첨부 수정 하기 전**********");
			return session.delete("resume.deleteResumeAttachment",resumeNo);
		}
		//이력서(학력) 수정
		@Override
		public int deleteResumeSchool(SqlSessionTemplate session, int resumeNo) {
			System.out.println("********dao 학력 수정 하기 전**********");
			return session.delete("resume.deleteResumeSchool",resumeNo);
		}
		//이력서(경력) 삭제
		@Override
		public int deleteResumeWork(SqlSessionTemplate session, int resumeNo) {
			System.out.println("********dao 경력 수정하기 전**********");
			return session.delete("resume.deleteResumeWork",resumeNo);
		}
		//이력서(자격증) 삭제
		@Override
		public int deleteResumeLicense(SqlSessionTemplate session, int resumeNo) {
			System.out.println("********dao 자격증 수정하기 전**********");
			return session.delete("resume.deleteResumeLicense",resumeNo);
		}
		//이력서(외국어) 삭제
		@Override
		public int deleteResumeLanguage(SqlSessionTemplate session, int resumeNo) {
			System.out.println("********dao 외국어 수정하기 전**********");
			return session.delete("resume.deleteResumeLanguage",resumeNo);
		}
		//이력서(활동내역) 삭제
		@Override
		public int deleteResumeActivity(SqlSessionTemplate session, int resumeNo) {
			System.out.println("********dao 활동 수정하기 전**********");
			return session.delete("resume.deleteResumeActivity",resumeNo);
		}
		//이력서(프로젝트) 삭제
		@Override
		public int deleteResumeProject(SqlSessionTemplate session, int resumeNo) {
			System.out.println("********dao 프로젝트 수정하기 전**********");
			return session.delete("resume.deleteResumeProject",resumeNo);
		}
		//이력서리스트 삭제
		@Override
		public int deleteResumeList(SqlSessionTemplate session, int resumeNo) {
			System.out.println("********dao 이력서리스트 수정 전**********");
			return session.delete("resume.deleteResumeList",resumeNo);
		}
		
		//이력서(해외경험) 삭제
		@Override
		public int deleteResumeAbroad(SqlSessionTemplate session, int resumeNo) {
			System.out.println("********dao 해외경험 수정하기 전**********");
			return session.delete("resume.deleteResumeAbroad",resumeNo);
		}
	

}
