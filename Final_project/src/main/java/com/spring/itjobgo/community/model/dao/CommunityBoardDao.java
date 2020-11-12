package com.spring.itjobgo.community.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.community.model.vo.CommunityBoard;

public interface CommunityBoardDao {
	
	List<CommunityBoard> selectBoardList(SqlSessionTemplate session);

}
