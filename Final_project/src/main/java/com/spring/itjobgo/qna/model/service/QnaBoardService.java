package com.spring.itjobgo.qna.model.service;

import java.util.List;
import java.util.Map;

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
	
	//댓글
	int insertComment(QB_COMMENT cm);

	int insertCommentText(int qboardNo);
	
	List<QB_COMMENT> selectComment(int qboardNo);
	
	int deletecomment(int qboardCommentNo);
	
	int updateComment(Map param);
	
	//댓글갯수 카운트 +1
	int updateCommentCount(QB_COMMENT qbc);
	
	//댓글 정보 가져오기
	QB_COMMENT selectOneComment(int qbCommentNo);
	
	//댓글갯수 카운트 -1
	int deleteCount(int qboardNo);
	
	
	
}
