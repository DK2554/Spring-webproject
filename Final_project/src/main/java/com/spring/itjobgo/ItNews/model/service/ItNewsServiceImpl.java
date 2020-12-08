package com.spring.itjobgo.ItNews.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.ItNews.model.dao.ItNewsDao;
import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;

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
	
	
	
	
	
	
	
}//클래스
