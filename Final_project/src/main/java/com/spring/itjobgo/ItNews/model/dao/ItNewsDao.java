package com.spring.itjobgo.ItNews.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;
import com.spring.itjobgo.ItNews.model.vo.ItnewsComment;

public interface ItNewsDao {
	
	//게시글 작성
	int insertItNews(SqlSessionTemplate session, ItNews itnews);
	
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
	
	//update 게시판
	int updateBoard(SqlSessionTemplate session, ItNews itnews);
	
	//update 첨부파일
	int updateAttachment(SqlSessionTemplate session, ItnewsAttachment file);
	
	//첨부파일이 없을때 게시판 수정시 첨부파일 등록(insert)
	int insertAttachment2(SqlSessionTemplate session, ItnewsAttachment file);
	
	//댓글 작성
	int insertComment(SqlSessionTemplate session, ItnewsComment it_comment);
	
	//댓글 조회
	List<ItnewsComment> selecCommenttList(SqlSessionTemplate session, int itnewsNo);

	//댓글 삭제
	int deleteComment(SqlSessionTemplate session, int itCommentNo);
	
	//댓글 수정
	int updateComment(SqlSessionTemplate session, Map param);
	
	
}//클래스
