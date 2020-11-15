package com.spring.itjobgo.community.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.portfolio.model.vo.Attachment;

@Repository
public class CommunityBoardDaoImpl implements CommunityBoardDao {

	@Override
	public List<CommunityBoard> selectBoardList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("communityBoard.selectBoardList"); 
	}

	@Override
	public int insertCommunityBoard(SqlSessionTemplate session, CommunityBoard CB) {
		// TODO Auto-generated method stub
		return session.insert("communityBoard.insertBoard",CB);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, CB_ATTACHMENT ca) {
		// TODO Auto-generated method stub
		return session.insert("communityBoard.insertAttachment",ca);
	}

	

	

}
