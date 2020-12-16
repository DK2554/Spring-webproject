package com.spring.itjobgo.community.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CB_COMMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;

public interface CommunityBoardService {
	
	List<CommunityBoard> selectBoardList();
	
	int insertCommunityBoard(CommunityBoard cb, List<CB_ATTACHMENT> files);

	CommunityBoard selectCommunityBoardOne(int boardSq ,boolean hasRead);
	
	int deleteBoard(int boardSq);
	
	CB_ATTACHMENT selectAttach(int boardSq);
	
	int updateBoard(CommunityBoard cb,List<CB_ATTACHMENT>files);
	
	int updateBoard(CommunityBoard cb);
	
	int insertComment(CB_COMMENT cbc);
	
	List<CB_COMMENT>selectComment(int cboardNo);
	
	int deleteComment(int cbCommentNo);
	
	int updateComment(Map param);
	
	//댓글갯수 카운트 +1
	int updateCommentCount(CB_COMMENT cbc);
	
	//댓글 정보가져오기
	CB_COMMENT selectOneComment(int cbCommentNo);
	
	//댓글 갯수 카운트 -1
	int deleteCount(int cboardNo);
}
