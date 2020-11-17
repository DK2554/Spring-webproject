package com.spring.itjobgo.community.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.community.model.dao.CommunityBoardDao;
import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.portfolio.model.vo.Attachment;

@Service
public class CommunityBoardServiceImpl implements CommunityBoardService {

@Autowired
private CommunityBoardDao dao;

@Autowired
private SqlSessionTemplate session;

@Override
public List<CommunityBoard> selectBoardList() {
	// TODO Auto-generated method stub
	return dao.selectBoardList(session);
}

//자유게시판 글쓰기
@Override
public int insertCommunityBoard(CommunityBoard cb, List<CB_ATTACHMENT> files) {
	
	int result=dao.insertCommunityBoard(session,cb);
	
	if(result==0) throw new RuntimeException("입력오류");
	if(result>0) {
		if(!files.isEmpty()) {
			//files에 데이터가 있으면
			for(CB_ATTACHMENT file:files) {
				
				//결과값이 있으면 반복문을 통해서 첨부파일을 insert하는 dao 로직을 생성
				result=dao.insertAttachment(session,file);
				
				if(result==0)throw new RuntimeException("입력오류");
			}
		}
		
	}
	return result;
}


//자유게시판 상세보기
@Override
public CommunityBoard selectCommunityBoardOne(int boardSq) {
	// TODO Auto-generated method stub
	return dao.selectCommunityBoardOne(session,boardSq);
}

//자유게시판 삭제하기
@Override
public int deleteBoard(int boardSq) {
	// TODO Auto-generated method stub
	return dao.deleteBoard(session, boardSq);
}















}
