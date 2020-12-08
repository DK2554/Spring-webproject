package com.spring.itjobgo.ref.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.ref.model.dao.RefDao;
import com.spring.itjobgo.ref.model.vo.REF_SITE;
import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

@Service
public class RefServiceImpl implements RefService {
	
	@Autowired
	private RefDao dao;
	@Autowired
	private SqlSessionTemplate session;
	

	@Override
	public int insertSite(REF_SITE REFSITE, List<REF_SITE_ATTACHMENT> files) {
		int result=dao.insertSite(session,REFSITE);
		
		if(result==0) throw new RuntimeException("입력오류");
		if(result>0) {
			if(!files.isEmpty()) {
				for(REF_SITE_ATTACHMENT file:files) {
					
					result=dao.insertAttachment(session,file);
					
					if(result==0) throw new RuntimeException("입력오류");
				}
			}
		}
		return result;
		
	}

	
	
}
