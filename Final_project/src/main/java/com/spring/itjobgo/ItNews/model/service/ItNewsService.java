package com.spring.itjobgo.ItNews.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;
import com.spring.itjobgo.ItNews.model.vo.ItnewsComment;

public interface ItNewsService {
	
	//글작성
	int insertItNews(ItNews itnews, List<ItnewsAttachment> files);
	
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
	
	//update(파일 있을때)
	int updateBoard(ItNews itnews, List<ItnewsAttachment>files);
	
	//update(파일 없을때)
	int updateBoard(ItNews itnews);
	
	//댓글 insert
	int insertComment(ItnewsComment it_comment);
	
	//댓글 조회 selectList
	List<ItnewsComment>selecCommenttList(int itnewsNo);
	
	//댓글 삭제
	int deleteComment(int itCommentNo);
	
	//댓글 수정
	int updateComment(Map param);

}
