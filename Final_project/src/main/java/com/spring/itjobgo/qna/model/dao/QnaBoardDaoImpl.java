package com.spring.itjobgo.qna.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.qna.model.service.QnaBoardService;
import com.spring.itjobgo.qna.model.vo.QnaBoard;

@Repository
public class QnaBoardDaoImpl implements QnaBoardDao {

	@Override
	public List<QnaBoard> selectQnaBoard(SqlSessionTemplate session){
		
		return session.selectList("qnaBoard.selectBoardList");
	}

	
	
	
}
