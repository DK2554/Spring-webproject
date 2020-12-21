package com.spring.itjobgo.ItNews.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;
import com.spring.itjobgo.ItNews.model.vo.ItnewsComment;

@Repository
public class ItNewsDaoImpl implements ItNewsDao {

	//게시판 작성
	@Override
	public int insertItNews(SqlSessionTemplate session, ItNews itnews) {
		// TODO Auto-generated method stub
		return session.insert("itNews.insertItNews",itnews);
	}
	//첨부파일 등록
	@Override
	public int insertAttachment(SqlSessionTemplate session, ItnewsAttachment file) {
		// TODO Auto-generated method stub
		return session.insert("itNews.insertAttachment", file);
	}
	//게시판 리스트 불러오기
	@Override
	public List<ItNews> selectList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("itNews.selectList");
	}
	//이미지 불러오기
	@Override
	public ItnewsAttachment selectImage(SqlSessionTemplate session, int no) {
		// TODO Auto-generated method stub
		return session.selectOne("itNews.selectImage",no);
	}
	//상세화면 selectOne
	@Override
	public ItNews selectOne(SqlSessionTemplate session, int newsSq) {
		// TODO Auto-generated method stub
		return session.selectOne("itNews.selectOne",newsSq);
	}
	//첨부파일 불러오기
	@Override
	public ItnewsAttachment selectAttach(SqlSessionTemplate session, int newsSq) {
		// TODO Auto-generated method stub
		return session.selectOne("itNews.selectAttach",newsSq);
	}
	//게시판 삭제하기
	@Override
	public int deleteBoard(SqlSessionTemplate session, int newsSq) {
		// TODO Auto-generated method stub
		return session.delete("itNews.deleteBoard",newsSq);
	}
	//게시판 update
	@Override
	public int updateBoard(SqlSessionTemplate session, ItNews itnews) {
		// TODO Auto-generated method stub
		return session.update("itNews.updateBoard",itnews);
	}
	//첨부파일 update(게시판 update)
	@Override
	public int updateAttachment(SqlSessionTemplate session, ItnewsAttachment file) {
		// TODO Auto-generated method stub
		return session.update("itNews.updateAttachment",file);
	}
	//게시판 update시 첨부파일이 없다면 >> 새롭게 insert
	@Override
	public int insertAttachment2(SqlSessionTemplate session, ItnewsAttachment file) {
		// TODO Auto-generated method stub
		return session.insert("itNews.insertAttachment2" , file);
	}
	//댓글 insert 작성
	@Override
	public int insertComment(SqlSessionTemplate session, ItnewsComment it_comment) {
		// TODO Auto-generated method stub
		return session.insert("itNews.insertComment", it_comment);
	}
	//댓글 selectList 조회
	@Override
	public List<ItnewsComment> selecCommenttList(SqlSessionTemplate session, int itnewsNo) {
		// TODO Auto-generated method stub
		return session.selectList("itNews.selecCommenttList", itnewsNo);
	}
	//댓글 삭제
	@Override
	public int deleteComment(SqlSessionTemplate session, int itCommentNo) {
		// TODO Auto-generated method stub
		return session.delete("itNews.deleteComment", itCommentNo);
	}
	//댓글수정
	@Override
	public int updateComment(SqlSessionTemplate session, Map param) {
		// TODO Auto-generated method stub
		return session.update("itNews.updateComment",param);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}//클래스
