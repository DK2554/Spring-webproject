package com.spring.itjobgo.ref.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.ref.model.vo.REF_SITE;
import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

public interface RefService {
	
	//글작성
	int insertSite(Map param, List<REF_SITE_ATTACHMENT> files);
	
	//리스트 불러오기(조회)
	List<REF_SITE> selectList();
	
	//이미지 불러오기
	REF_SITE_ATTACHMENT selectImage(int no);

	//첨부파일 불러오기
	REF_SITE_ATTACHMENT selectAttach(int refNo);
	
	//상세화면 selectOne
	REF_SITE selectOne(int refNo);
	
	//게시판 delete
	int deleteSite(int refNo);

	//update(파일 있을때)
	int updateSite(REF_SITE refsite, List<REF_SITE_ATTACHMENT>files);
	
	//update(파일 없을때)
	int updateSite(REF_SITE refsite);
	
	//관리자 승인
	int updateStatus(int refNo);
	
	//글작성 카운트 조회
	int selectCount();
	
	
	
}
