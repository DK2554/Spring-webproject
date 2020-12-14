package com.spring.itjobgo.ref.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.ref.model.vo.REF_SITE;
import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

@Repository
public class RefDaoImpl implements RefDao {

	//글작성
	@Override
	public int insertSite(SqlSessionTemplate session, Map param) {
		return session.insert("refSite.insertSite",param);
	}

	//글작성(첨부파일)
	@Override
	public int insertAttachment(SqlSessionTemplate session, REF_SITE_ATTACHMENT refattachment) {
		return session.insert("refSite.insertAttachment", refattachment);
	}

	//리스트 불러오기(조회)
	@Override
	public List<REF_SITE> selectList(SqlSessionTemplate session) {
		return session.selectList("refSite.selectList");
	}

	@Override
	public REF_SITE_ATTACHMENT selectImage(SqlSessionTemplate session, int no) {
		return session.selectOne("refSite.selectImage",no);
	}

	
	
	
	
}
