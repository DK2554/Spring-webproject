package com.spring.itjobgo.community.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.community.model.vo.CommunityBoard;

@Repository
public class CommunityBoardDaoImpl implements CommunityBoardDao {

	@Override
	public List<CommunityBoard> selectBoardList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("communityBoard.selectBoardList"); 
	}

	

//	@Override
//	public CommunityBoard selectBoardList(SqlSessionTemplate session) {
//		// TODO Auto-generated method stub
//		return session.selectList("communityBoard.selectBoardList"); 
//	}

//	@Override
//	public CommunityBoard selectBoardList(SqlSessionTemplate session, List<CommunityBoard> list) {
//		// TODO Auto-generated method stub
//		return session.selectList("communityBoard.selectBoardList"); 
//	}
//	  
	  
	 

//	@Override
//	public CommunityBoard selectBoardList2(SqlSessionTemplate session, Map param) {
//		// TODO Auto-generated method stub
//		return (CommunityBoard) session.selectList("communityBoard.selectBoardList2");
//	}

}
