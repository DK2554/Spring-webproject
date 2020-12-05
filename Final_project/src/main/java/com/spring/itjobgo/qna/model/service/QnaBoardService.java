package com.spring.itjobgo.qna.model.service;

import java.util.List;

import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
import com.spring.itjobgo.qna.model.vo.QB_COMMENT;
import com.spring.itjobgo.qna.model.vo.QnaBoard;

public interface QnaBoardService {

	List<QnaBoard> selectQnaBoard();
	
	int insertQnaBoard(QnaBoard qnaboard, List<QB_ATTACHMENT> files);
	
	QnaBoard selectQnaBoardOne(int qboardNo, boolean hasRead);
	
	int deleteBoard(int qboardNo);
	
	QB_ATTACHMENT selectAttach(int qboardNo);
	
	int updateBoard(QnaBoard qboard, List<QB_ATTACHMENT>files);
	
	int updateBoard(QnaBoard qboard);
	
	int insertComment(QB_COMMENT cm);

	int insertCommentText(int qboardNo);
	
	List<QB_COMMENT> selectQnacomment(int qboardNo);
	
	int deletecomment(int qbCommentNo);
	
	
}
