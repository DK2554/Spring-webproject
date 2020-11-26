package com.spring.itjobgo.community.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.portfolio.model.vo.Attachment;

public interface CommunityBoardDao {
	
	List<CommunityBoard> selectBoardList(SqlSessionTemplate session);
	
	//글작성
	int insertCommunityBoard(SqlSessionTemplate session, CommunityBoard CB);
	
	//첨부파일 insert
	int insertAttachment(SqlSessionTemplate session, CB_ATTACHMENT cb_attach);
	
	//글 상세보기
	CommunityBoard selectCommunityBoardOne(SqlSessionTemplate session, int boardSq);

	//글 삭제하기
	int deleteBoard(SqlSessionTemplate session, int boardSq);
	
	//첨부파일 조회
	CB_ATTACHMENT selectAttach(SqlSessionTemplate session, int boardSq);

	//첨부파일 update
	int updateAttachment(SqlSessionTemplate session,CB_ATTACHMENT cb_attach);
	
	//게시글(객체) update
	int updateBoard(SqlSessionTemplate session, CommunityBoard cb);
	
	//첨부파일 insert
	int insertAttachment2(SqlSessionTemplate session, CB_ATTACHMENT cb_attach);

	//조회수증가
	int updateReadCount(SqlSessionTemplate session, int boardSq);
}
