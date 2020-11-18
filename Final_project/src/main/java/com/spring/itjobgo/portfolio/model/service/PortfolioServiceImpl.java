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
	@Override
	public Pboard selectPboardOne(int pboardNo) {
	
		return dao.selectOnepboard(session,pboardNo);
	}
	@Override
	public Attachment selectattac(int no) {
		// TODO Auto-generated method stub
		return dao.selectOneAttach(session,no);
	}
	@Override
	public List<Pboard> selectListPboard() {
		// TODO Auto-generated method stub
		return dao.selectLitpboard(session);
	}
	@Override
	public int updatepboard(Pboard pboard, List<Attachment> files) {
		// TODO Auto-generated method stub
		int result =dao.updatedpboard(session,pboard);
		if(result==0) throw new RuntimeException("입력오류");
		if(result>0) {
			if(!files.isEmpty()) {
				//files에 데이터가 있으면
				for(Attachment file:files) {
					result=dao.updateattachment(session, file);
					if(result==0)throw new RuntimeException("입력오류");
				}
			}
			
		}
		return result;

	}
	//게시판삭제
	@Override
	public int deletePboard(int no) {
		// TODO Auto-generated method stub
		return dao.deletepboard(session,no);
	}

}
