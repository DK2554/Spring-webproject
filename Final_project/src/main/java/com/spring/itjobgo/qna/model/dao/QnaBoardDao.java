package com.spring.itjobgo.qna.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
import com.spring.itjobgo.qna.model.vo.QB_COMMENT;
import com.spring.itjobgo.qna.model.vo.QnaBoard;

public interface QnaBoardDao {

	List<QnaBoard> selectQnaBoard(SqlSessionTemplate session);
	
	//qna게시판 글쓰기
	int insertQnaBoard(SqlSessionTemplate session, QnaBoard qb);
	
	//첨부파일 insert
	int insertAttachment(SqlSessionTemplate session, QB_ATTACHMENT qb_attachment);
	
	//글 상세보기
	QnaBoard selectQnaBoardOne(SqlSessionTemplate session, int qnaSeq);
	
	//글삭제
	int deleteBoard(SqlSessionTemplate session, int qnaSeq);
	
	//첨부파일 조회
	QB_ATTACHMENT selectAttach(SqlSessionTemplate session, int qnaSeq);
	
	//첨부파일 update
	int updateAttachment(SqlSessionTemplate session,QB_ATTACHMENT qb_attach);
	
	//게시글(객체) update
	int updateBoard(SqlSessionTemplate session, QnaBoard qb);
	
	//첨부파일 insert
	int insertAttachment2(SqlSessionTemplate session, QB_ATTACHMENT qb_attach);
	
	//조회수 증가
	int updateReadCount(SqlSessionTemplate session, int qnaSeq);
	
	//댓글 등록
	int insertComment(SqlSessionTemplate session, QB_COMMENT cm);
	
	//댓글 등록시 답변여부 변경
	int insertCommentText(SqlSessionTemplate session, int qbBoardNo);
	
	
	
}


