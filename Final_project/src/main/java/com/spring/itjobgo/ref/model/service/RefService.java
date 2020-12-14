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

}
