package com.spring.itjobgo.qna.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.qna.model.dao.QnaBoardDao;
import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
import com.spring.itjobgo.qna.model.vo.QB_COMMENT;
import com.spring.itjobgo.qna.model.vo.QnaBoard;
import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

	@Service
	public class QnaBoardServiceImpl implements QnaBoardService {
	
	@Autowired
	private QnaBoardDao dao;
	@Autowired
	private SqlSessionTemplate session;
	@Override
	public List<QnaBoard> selectQnaBoard(){
		
		return dao.selectQnaBoard(session);
		
		
	}

	//qna게시판 글쓰기
	@Override
	public int insertQnaBoard(QnaBoard qb, List<QB_ATTACHMENT> files) {
		int result=dao.insertQnaBoard(session,qb);

		if(result==0) throw new RuntimeException("입력오류");
		if(result>0) {
			if(!files.isEmpty()) {
				for(QB_ATTACHMENT file:files) {
					
					result=dao.insertAttachment(session,file);
					
					if(result==0) throw new RuntimeException("입력오류");
					
				}
			}
		}
		return result;
	}

	//qna게시판 상세보기
	@Override
	public QnaBoard selectQnaBoardOne(int qboardNo, boolean hasRead) {
		
		QnaBoard qb = dao.selectQnaBoardOne(session, qboardNo);
		
		//hasRead가 false이면
		if(qb!=null && !hasRead) {
			int result = dao.updateReadCount(session,qboardNo);
			System.out.println("조회수 증가 로직 성공");
		}
		return qb;
	}

	//qna게시판 삭제하기
	@Override
	public int deleteBoard(int qboardNo) {
		return dao.deleteBoard(session,qboardNo);
	}

	//첨부파일 조회
	@Override
	public QB_ATTACHMENT selectAttach(int qboardNo) {
		return dao.selectAttach(session,qboardNo);
	}

	//첨부파일이 있을때 update
	@Override
	public int updateBoard(QnaBoard qboard, List<QB_ATTACHMENT> files) {
		//첨부파일이 있으면 첨부파일 등록 dao도 같이 실행해줘야 한다.
		int result = dao.updateBoard(session,qboard);
		//등록이 성공되지 않는다면
		if(result==0) throw new RuntimeException("게시글 등록 오류");
		//등록이 성공하고 첨부파일이 존재한다면 첨부파일 등록을 해줘야 한다.
		if(result>0) {
			if(!files.isEmpty()) {
				for(QB_ATTACHMENT file:files) {
					result=dao.updateAttachment(session,file);
					
					//첨부파일이 없는 게시글일 경우 시퀀스 때문에 수정이 안된다.
					//그럴경우 시퀀스가 없는 insertAttachment2매퍼로 이동하도록 유도한다.
					
					if(result==0)						
						 
						dao.insertAttachment2(session,file);
							System.out.println("==첨부파일이 없는 글 첨부파일 등록 성공===");
							
				}//for문
			}//세번째 if문
		}//두번째 if문
		
		return result;
	}

	//첨부파일이 없을때 게시판 내용만 update
	@Override
	public int updateBoard(QnaBoard qboard) {
		return dao.updateBoard(session,qboard);
	}

	//댓글 insert 로직
	@Override
	public int insertComment(QB_COMMENT cm) {
		return dao.insertComment(session,cm);
	}
	
	//댓글이 달리면 답변여부 변경해주는 로직
	@Override
	public int insertCommentText(int qboardNo) {
		return dao.insertCommentText(session, qboardNo);
	}

	//댓글 조회 로직
	@Override
	public List<QB_COMMENT> selectComment(int qboardNo) {
		return dao.selectQnacomment(session,qboardNo);
	}

	//댓글 삭제 로직
	@Override
	public int deletecomment(int qboardCommentNo) {
		return dao.deletecomment(session,qboardCommentNo);
	}

	@Override
	public int updateComment(Map param) {
		return dao.updateComment(session,param);
	}

	//댓글 갯수 카운트 +1
	@Override
	public int updateCommentCount(QB_COMMENT qbc) {
		return dao.updateCommentCount(session,qbc);
	}
	//댓글 정보가져오기
	@Override
	public QB_COMMENT selectOneComment(int qbCommentNo) {
		return dao.selectOneComment(session, qbCommentNo);
	}
	//댓글 갯수 -1
	@Override
	public int deleteCount(int qboardNo) {
		return dao.deleteCount(session, qboardNo);
	}
	
	//이미지 불러오기
	@Override
	public QB_ATTACHMENT selectImage(int qboardNo) {
		return dao.selectImage(session,qboardNo);
	}
	
	
	
	
	

	
	
}
