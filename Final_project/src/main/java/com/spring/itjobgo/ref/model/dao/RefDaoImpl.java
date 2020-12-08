package com.spring.itjobgo.ref.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.ref.model.vo.REF_SITE;
import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

@Repository
public class RefDaoImpl implements RefDao {

	@Override
	public int insertSite(SqlSessionTemplate session, REF_SITE REFSITE) {
		return session.insert("refSite.insertSite",REFSITE);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, REF_SITE_ATTACHMENT ref_attachment) {
		return session.insert("refSite.insertAttachment",ref_attachment);
	}

	
	
	
}
