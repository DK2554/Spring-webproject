package com.spring.itjobgo.qna.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
import com.spring.itjobgo.qna.model.vo.QB_COMMENT;
import com.spring.itjobgo.qna.model.vo.QnaBoard;

@Repository
public class QnaBoardDaoImpl implements QnaBoardDao {

	//qna게시판 리스트 불러오기
	@Override
	public List<QnaBoard> selectQnaBoard(SqlSessionTemplate session){
		
		return session.selectList("qnaBoard.selectBoardList");
	}

	//qna게시판 글쓰기
	@Override
	public int insertQnaBoard(SqlSessionTemplate session, QnaBoard qb) {
		return session.insert("qnaBoard.insertQna",qb);
	}

	//qna게시판 글쓰기(첨부파일)
	@Override
	public int insertAttachment(SqlSessionTemplate session, QB_ATTACHMENT qb_attachment) {
		return session.insert("qnaBoard.insertAttachment",qb_attachment);
	}

	//qna게시판 상세보기
	@Override
	public QnaBoard selectQnaBoardOne(SqlSessionTemplate session, int qboardNo) {
		return session.selectOne("qnaBoard.selectQnaBoardOne",qboardNo);
	}

	//qna게시판 삭제하기
	@Override
	public int deleteBoard(SqlSessionTemplate session, int qboardNo) {
		return session.delete("qnaBoard.deleteBoard",qboardNo);
	}

	//첨부파일 조회
	@Override
	public QB_ATTACHMENT selectAttach(SqlSessionTemplate session, int no) {
		return session.selectOne("qnaBoard.selectAttach",no);
	}

	//첨부파일 update
	@Override
	public int updateAttachment(SqlSessionTemplate session, QB_ATTACHMENT file) {
		return session.update("qnaBoard.updateAttachment",file);
	}

	//게시글(객체)update
	@Override
	public int updateBoard(SqlSessionTemplate session, QnaBoard qboard) {
		return session.update("qnaBoard.updateBoard",qboard);
	}

	@Override
	public int insertAttachment2(SqlSessionTemplate session, QB_ATTACHMENT qb_attach) {
		return session.insert("qnaBoard.insertAttachment2",qb_attach);
	}

	//조회수 증가로직
	@Override
	public int updateReadCount(SqlSessionTemplate session, int qboardNo) {
		return session.update("qnaBoard.updateReadCount",qboardNo);
	}

	//댓글 등록 로직
	@Override
	public int insertComment(SqlSessionTemplate session, QB_COMMENT cm) {
		return session.insert("qnaBoard.insertComment",cm);
	}

	//댓글 등록시 답변여부 변경로직
	@Override
	public int insertCommentText(SqlSessionTemplate session, int qboardNo) {
		return session.update("qnaBoard.insertCommentText",qboardNo);
	}

	//댓글 조회
	@Override
	public List<QB_COMMENT> selectQnacomment(SqlSessionTemplate session, int qboardNo) {
		return session.selectList("qnaBoard.selectQnacomment",qboardNo);
	}

	//댓글 삭제
	@Override
	public int deletecomment(SqlSessionTemplate session, int qbCommentNo) {
		return session.delete("qnaBoard.deletecomment",qbCommentNo);
	}
	
	
	
	
	
	
	
}
