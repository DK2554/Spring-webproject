package com.spring.itjobgo.ref.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

@Repository
public class RefDaoImpl implements RefDao {

	@Override
	public int insertSite(SqlSessionTemplate session, Map param) {
		return session.insert("refSite.insertSite",param);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, REF_SITE_ATTACHMENT refattachment) {
		return session.insert("refSite.insertAttachment", refattachment);
	}

	
	
	
}
