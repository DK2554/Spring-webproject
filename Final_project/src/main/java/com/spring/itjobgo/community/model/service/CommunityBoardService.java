package com.spring.itjobgo.community.model.service;

import java.util.List;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;

public interface CommunityBoardService {
	
	List<CommunityBoard> selectBoardList();
	
	int insertCommunityBoard(CommunityBoard cb, List<CB_ATTACHMENT> files);

	CommunityBoard selectCommunityBoardOne(int boardSq);
	
	int deleteBoard(int boardSq);
}
