package com.spring.itjobgo.portfolio.model.service;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.portfolio.model.dao.PortfolioDao;
import com.spring.itjobgo.portfolio.model.vo.Attachment;
import com.spring.itjobgo.portfolio.model.vo.Pboard;



@Service
public class PortfolioServiceImpl implements PortfolioService {
	@Autowired
	private  PortfolioDao dao;
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertPboard(Pboard pboard, List<Attachment> files) {
		int result=dao.insertPboard(session,pboard);
		
		if(result==0) throw new RuntimeException("입력오류");
		if(result>0) {
			if(!files.isEmpty()) {
				//files에 데이터가 있으면
				for(Attachment file:files) {
					result=dao.insertAttachment(session,file);
					if(result==0)throw new RuntimeException("입력오류");
				}
			}
			
		}
		return result;
	}

}
