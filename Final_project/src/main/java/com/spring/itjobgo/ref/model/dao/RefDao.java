package com.spring.itjobgo.ref.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.ItNews.model.vo.ItNews;
import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;
import com.spring.itjobgo.ref.model.vo.REF_SITE;
import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

public interface RefDao {
	
	//글작성
	int insertSite(SqlSessionTemplate session, Map param);
	
	//글작성(첨부파일)
	int insertAttachment(SqlSessionTemplate session, REF_SITE_ATTACHMENT file);
	
	//리스트 불러오기(조회)
	List<REF_SITE> selectList(SqlSessionTemplate session);
	
	//이미지 불러오기
	REF_SITE_ATTACHMENT selectImage(SqlSessionTemplate session, int no);
	
	//첨부파일 불러오기
	REF_SITE_ATTACHMENT selectAttach(SqlSessionTemplate session, int refNo);
	
	//상세화면 selectOne
	REF_SITE selectOne(SqlSessionTemplate session, int refNo);
	
	//게시글 삭제하기
	int deleteSite(SqlSessionTemplate session, int refNo);
	
	//update 게시판
	int updateSite(SqlSessionTemplate session, REF_SITE refsite);
	
	//update 첨부파일
	int updateAttachment(SqlSessionTemplate session, REF_SITE_ATTACHMENT file);
	
	//첨부파일이 없을때 게시판 수정시 첨부파일 등록(insert)
	int insertAttachment2(SqlSessionTemplate session, REF_SITE_ATTACHMENT file);	
	
	//관리자 승인
	int updateStatus(SqlSessionTemplate session, int refNo);
	
	
	
	
}
