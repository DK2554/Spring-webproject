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

	
	
}
