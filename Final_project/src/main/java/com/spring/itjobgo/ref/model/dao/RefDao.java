package com.spring.itjobgo.ref.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

public interface RefDao {
	
	//글작성
	int insertSite(SqlSessionTemplate session, Map param);
	
	//글작성(첨부파일)
	int insertAttachment(SqlSessionTemplate session, REF_SITE_ATTACHMENT file);
	

}
