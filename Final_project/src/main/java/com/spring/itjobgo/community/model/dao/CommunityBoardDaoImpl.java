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

	//자유게시판 리스트 불러오기
	@Override
	public List<CommunityBoard> selectBoardList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("communityBoard.selectBoardList"); 
	}
	
	//자유게시판 글쓰기
	@Override
	public int insertCommunityBoard(SqlSessionTemplate session, CommunityBoard CB) {
		// TODO Auto-generated method stub
		return session.insert("communityBoard.insertBoard",CB);
	}
	
	//자유게시판 글쓰기 부분의 <첨부파일>
	@Override
	public int insertAttachment(SqlSessionTemplate session, CB_ATTACHMENT cb_attach) {
		// TODO Auto-generated method stub
		return session.insert("communityBoard.insertAttachment",cb_attach);
	}
	
	//자유게시판 상세보기
	@Override
	public CommunityBoard selectCommunityBoardOne(SqlSessionTemplate session, int boardSq) {
		// TODO Auto-generated method stub
		return session.selectOne("communityBoard.selectCommunityBoardOne",boardSq);
	}

	//자유게시판 삭제하기
	@Override
	public int deleteBoard(SqlSessionTemplate session, int boardSq) {
		// TODO Auto-generated method stub
		return session.delete("communityBoard.deleteBoard",boardSq);
	}
	
	
	
	

		
	

	

}
