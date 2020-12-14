package com.spring.itjobgo.ref.model.service;

import java.util.List;
import java.util.Map;

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
	
	//글작성
	@Override
	public int insertSite(Map param, List<REF_SITE_ATTACHMENT> files) {
		//글작성이 정삭적으로 이루어지면=(result>0)
		//첨부파일 등록
		int result=dao.insertSite(session,param);
		if(result==0) throw new RuntimeException("ref site 글작성 오류");
		if(result>0) {
			if(!files.isEmpty()) {
				for(REF_SITE_ATTACHMENT file:files) {
					result=dao.insertAttachment(session,file);
					if(result==0) throw new RuntimeException("ref site 첨부파일 작성 오류");
				}
			}
		}return result;
	}

	//리스트 불러오기(조회)
	@Override
	public List<REF_SITE> selectList() {
		return dao.selectList(session);
	}

	@Override
	public REF_SITE_ATTACHMENT selectImage(int no) {
		return dao.selectImage(session,no);
	}
	
	
	
	
	
	
}
