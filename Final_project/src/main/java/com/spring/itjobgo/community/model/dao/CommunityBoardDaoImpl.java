package com.spring.itjobgo.community.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CB_COMMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;

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
	
	//첩부파일 조회
	@Override
	public CB_ATTACHMENT selectAttach(SqlSessionTemplate session, int boardSq) {
		// TODO Auto-generated method stub
		return session.selectOne("communityBoard.selectAttach",boardSq);
	}
	
	//첨부파일 update
	@Override
	public int updateAttachment(SqlSessionTemplate session, CB_ATTACHMENT cb_attach) {
		// TODO Auto-generated method stub
		return session.update("communityBoard.updateAttachment",cb_attach);
	}
	
	//게시글(객체)update
	@Override
	public int updateBoard(SqlSessionTemplate session, CommunityBoard cb) {
		// TODO Auto-generated method stub
		return session.update("communityBoard.updateBoard",cb);
	}
	//첨부파일 다운로드
	@Override
	public int insertAttachment2(SqlSessionTemplate session, CB_ATTACHMENT cb_attach) {
		// TODO Auto-generated method stub
		return session.insert("communityBoard.insertAttachment2",cb_attach);
	}
	//조회수 증가로직
	@Override
	public int updateReadCount(SqlSessionTemplate session, int boardSq) {
		// TODO Auto-generated method stub
		return session.update("communityBoard.updateReadCount",boardSq);
	}
	//댓글 insert
	@Override
	public int insertComment(SqlSessionTemplate session, CB_COMMENT cbc) {
		// TODO Auto-generated method stub
		return session.insert("communityBoard.insertComment",cbc);
	}
	//댓글 조회
	@Override
	public List<CB_COMMENT> selectComment(SqlSessionTemplate session, int cboardNo) {
		// TODO Auto-generated method stub
		return session.selectList("communityBoard.selectComment",cboardNo);
	}
	//댓글 삭제
	@Override
	public int deleteComment(SqlSessionTemplate session, int cboardNo) {
		// TODO Auto-generated method stub
		return session.delete("communityBoard.deleteComment",cboardNo);
	}
	//댓글 수정
	@Override
	public int updateComment(SqlSessionTemplate session, Map param) {
		// TODO Auto-generated method stub
		return session.update("communityBoard.updateComment",param);
	}

	//댓글 카운트
	@Override
	public int updateCommentCount(SqlSessionTemplate session, CB_COMMENT cbc) {
		// TODO Auto-generated method stub
		return session.update("communityBoard.updateCommentCount", cbc);
	}
	//댓글정보가져오기
	@Override
	public CB_COMMENT selectOneComment(SqlSessionTemplate session, int cbCommentNo) {
		// TODO Auto-generated method stub
		return session.selectOne("communityBoard.selectOneComment",cbCommentNo );
	}
	//댓글 카운트 -1
	@Override
	public int deleteCount(SqlSessionTemplate session, int cboardNo) {
		// TODO Auto-generated method stub
		return session.update("communityBoard.deleteCount",cboardNo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		
	

	

}//클래스
