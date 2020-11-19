package com.spring.itjobgo.qna.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
import com.spring.itjobgo.qna.model.vo.QnaBoard;

@Repository
public class QnaBoardDaoImpl implements QnaBoardDao {

	@Override
	public List<QnaBoard> selectQnaBoard(SqlSessionTemplate session){
		
		return session.selectList("qnaBoard.selectBoardList");
	}

	@Override
	public int insertQnaBoard(SqlSessionTemplate session, QnaBoard qb) {
		return session.insert("qnaboard.insertQna",qb);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, QB_ATTACHMENT qb_attachment) {
		return session.insert("qnaboard.insertAttachment",qb_attachment);
	}

	
	
}
