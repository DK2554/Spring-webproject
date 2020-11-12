package com.spring.itjobgo.community.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.community.model.vo.CommunityBoard;

public interface CommunityBoardDao {
	
//		CommunityBoard selectBoardList(SqlSessionTemplate session);
	
	List<CommunityBoard> selectBoardList(SqlSessionTemplate session);
	
//	CommunityBoard selectBoardList2(SqlSessionTemplate session, Map param);
}
