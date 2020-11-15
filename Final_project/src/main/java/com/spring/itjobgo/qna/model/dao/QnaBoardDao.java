package com.spring.itjobgo.qna.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.qna.model.vo.QnaBoard;

public interface QnaBoardDao {

	List<QnaBoard> selectQnaBoard(SqlSessionTemplate session);
	
}


