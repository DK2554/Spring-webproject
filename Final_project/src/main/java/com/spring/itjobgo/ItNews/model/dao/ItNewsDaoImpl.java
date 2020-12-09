package com.spring.itjobgo.ItNews.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;

@Repository
public class ItNewsDaoImpl implements ItNewsDao {

	//게시판 작성
	@Override
	public int insertItNews(SqlSessionTemplate session, Map param) {
		// TODO Auto-generated method stub
		return session.insert("itNews.insertItNews",param);
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
	@Override
	public int deleteBoard(SqlSessionTemplate session, int newsSq) {
		// TODO Auto-generated method stub
		return session.delete("itNews.deleteBoard",newsSq);
	}
	
	
	
	
	
	
	
	

}//클래스
