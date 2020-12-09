package com.spring.itjobgo.ItNews.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;

public interface ItNewsDao {
	
	//게시글 작성
	int insertItNews(SqlSessionTemplate session, Map param);
	
	//첨부파일 등록
	int insertAttachment(SqlSessionTemplate session, ItnewsAttachment file);
	
	//게시판 리스트 불러오기
	List<ItNews> selectList(SqlSessionTemplate session);
	
	//이미지 불러오기
	ItnewsAttachment selectImage(SqlSessionTemplate session, int no);

	//상세화면 selectOne
	ItNews selectOne(SqlSessionTemplate session, int newsSq);
	
	//첨부파일 불러오기
	ItnewsAttachment selectAttach(SqlSessionTemplate session, int newsSq);
	
	//게시글 삭제하기
	int deleteBoard(SqlSessionTemplate session, int newsSq);
	
	

}//클래스
