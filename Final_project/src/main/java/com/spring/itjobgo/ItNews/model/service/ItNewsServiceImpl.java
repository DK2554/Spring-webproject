package com.spring.itjobgo.ItNews.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.ItNews.model.dao.ItNewsDao;
import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;
import com.spring.itjobgo.ItNews.model.vo.ItnewsComment;

@Service
public class ItNewsServiceImpl implements ItNewsService {

	@Autowired
	private ItNewsDao dao;
	
	@Autowired
	private SqlSessionTemplate session;
	
	//itnews 글작성
	@Override
	public int insertItNews(Map param, List<ItnewsAttachment> files) {
		
		//글작성이 정삭적으로 이루어지면=(result>0)
		//첨부파일 등록
		int result = dao.insertItNews(session, param);
		if(result==0) throw new RuntimeException("itnews글작성 오류");
		if(result>0) {
			if(!files.isEmpty()) {
				for(ItnewsAttachment file : files) {
					result=dao.insertAttachment(session,file);
					if(result==0) throw new RuntimeException("itnews첨부파일 등록 오류");					
				}
			}
		}return result;
	}
	
	// 게시판 리스트 불러오기
	@Override
	public List<ItNews> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList(session);
	}
	
	//이미지 불러오기
	@Override
	public ItnewsAttachment selectImage(int no) {
		// TODO Auto-generated method stub
		return dao.selectImage(session,no);
	}
	//상세화면 selectOne
	@Override
	public ItNews selectOne(int newsSq) {
		// TODO Auto-generated method stub
		return dao.selectOne(session,newsSq);
	}
	//첨부파일 불러오기
	@Override
	public ItnewsAttachment selectAttach(int newsSq) {
		// TODO Auto-generated method stub
		return dao.selectAttach(session, newsSq);
	}

	//게시판 삭제하기
	public int deleteBoard(int newsSq) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(session, newsSq);
	}
	//update 파일이 있을 떄
	@Override
	public int updateBoard(ItNews itnews, List<ItnewsAttachment> files) {
		
		//게시판 insert와 마찬가지로
		//먼저 itnews테이블만 먼저 update하고
		//file이 존재하면 파일을 update
		//file이 없으면 insert 버전 2로 (기존 첨부파일 insert와 다른) 실행한다.
		
		int  result = dao.updateBoard(session, itnews);
		
		if(result==0) throw new RuntimeException();
		
		if(result>0) {
			if(!files.isEmpty()) {
				for(ItnewsAttachment file:files) {
					result=dao.updateAttachment(session,file);
					
					if(result==0)
						dao.insertAttachment2(session, file);
				}
			}
		}
		
		return result;
	}
	//update 파일이 없을 때
	@Override
	public int updateBoard(ItNews itnews) {
		// TODO Auto-generated method stub
		return dao.updateBoard(session,itnews);
	}
	//댓글 작성
	@Override
	public int insertComment(ItnewsComment it_comment) {
		// TODO Auto-generated method stub
		return dao.insertComment(session,it_comment);
	}
	//댓글 조회(리스트)
	@Override
	public List<ItnewsComment> selecCommenttList(int itnewsNo) {
		// TODO Auto-generated method stub
		return dao.selecCommenttList(session,itnewsNo);
	}
	//댓글 삭제
	@Override
	public int deleteComment(int itCommentNo) {
		// TODO Auto-generated method stub
		return dao.deleteComment(session, itCommentNo);
	}
	//댓글 수정
	@Override
	public int updateComment(Map param) {
		// TODO Auto-generated method stub
		return dao.updateComment(session,param);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//클래스
