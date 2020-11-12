package com.spring.itjobgo.community.model.service;

import java.util.List;

import com.spring.itjobgo.community.model.vo.CommunityBoard;

public interface CommunityBoardService {
	
	List<CommunityBoard> selectBoardList();

}
