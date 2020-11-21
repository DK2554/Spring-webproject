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

//첨부파일 조회
@Override
public CB_ATTACHMENT selectAttach(int boardSq) {
	// TODO Auto-generated method stub
	return dao.selectAttach(session, boardSq);
}

//첨부파일이 있을때 update
@Override
public int updateBoard(CommunityBoard cb, List<CB_ATTACHMENT> files) {
	//첨부파일이 있으면 첨부파일 등록 dao도 같이 실행해줘야 한다
	int result = dao.updateBoard(session,cb);
	//등록이 성공되지 않는다면
	if(result==0) throw new RuntimeException("게시글 등록 오류");
	//등록이 성공하고 첨부파일이 존재한다면 첨부파일 등록해줘야한다.
		if(result>0) {
			if(!files.isEmpty()) {
				for(CB_ATTACHMENT file : files) {
					result=dao.updateAttachment(session, file);
					
					//첨부파일이없는 게시글일 경우 시퀀스때문에 수정이 안된다
					//그럴경우 시퀀스가 없는 insertAttachment2매퍼로 이동하도록 유도한다.
					if(result==0) 
						
						dao.insertAttachment2(session, file);
					
						System.out.println("==첨부파일 없는 글 첨부파일 등록성공==");
				}//for문
			}//세번째 if문
		}//두번째 if문
		
		return result;
	}

//첨부파일이 없을때 게시판 내용만 update
@Override
public int updateBoard(CommunityBoard cb) {
	// TODO Auto-generated method stub
	return dao.updateBoard(session,cb);
}






}
