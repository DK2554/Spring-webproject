package com.spring.itjobgo.ItNews.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;

public interface ItNewsService {
	
	//글작성
	int insertItNews(Map param, List<ItnewsAttachment> files);
	
	//게시판 리스트 불러오기
	List<ItNews> selectList();
	
	//이미지 불러오기
	ItnewsAttachment selectImage(int no);
	
	//상세화면 selectOne
	ItNews selectOne(int newsSq);
	
	//첨부파일 불러오기
	ItnewsAttachment selectAttach(int newsSq);
	
	//게시판 delete
	int deleteBoard(int newsSq);

}
