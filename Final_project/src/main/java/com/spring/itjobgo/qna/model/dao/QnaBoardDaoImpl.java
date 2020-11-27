package com.spring.itjobgo.qna.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
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
	public QnaBoard selectQnaBoardOne(SqlSessionTemplate session, int qnaSeq) {
		return session.selectOne("qnaBoard.selectQnaBoardOne",qnaSeq);
	}

	//qna게시판 삭제하기
	@Override
	public int deleteBoard(SqlSessionTemplate session, int qnaSeq) {
		return session.delete("qnaBoard.deleteBoard",qnaSeq);
	}

	//첨부파일 조회
	@Override
	public QB_ATTACHMENT selectAttach(SqlSessionTemplate session, int qnaSeq) {
		return session.selectOne("qnaBoard.selectAttach",qnaSeq);
	}

	//첨부파일 update
	@Override
	public int updateAttachment(SqlSessionTemplate session, QB_ATTACHMENT qb_attach) {
		return session.update("qnaBoard.updateAttachment",qb_attach);
	}

	//게시글(객체)update
	@Override
	public int updateBoard(SqlSessionTemplate session, QnaBoard qb) {
		return session.update("qnaBoard.updateBoard",qb);
	}

	@Override
	public int insertAttachment2(SqlSessionTemplate session, QB_ATTACHMENT qb_attach) {
		return session.insert("qnaBoard.insertAttachment2",qb_attach);
	}

	//조회수 증가로직
	@Override
	public int updateReadCount(SqlSessionTemplate session, int qnaSeq) {
		return session.update("qnaBoard.updateReadCount",qnaSeq);
	}
	
	
	
	
	
}
