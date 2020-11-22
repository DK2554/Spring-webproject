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
				//첨부파일이있을경우에 있는값을 리턴하고
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
	//로그인한 email로 멤버 기본키 가져오기
	@Override
	public int selectmemberno(String email) {
		// TODO Auto-generated method stub
		return dao.selectmemberno(session,email);
	}
	@Override
	public int updatepboard(Pboard pboard) {
		// TODO Auto-generated method stub
		return   dao.updatedpboard(session,pboard);
	}
	//게시판삭제
	@Override
	public int deletePboard(int no) {
		// TODO Auto-generated method stub
		return dao.deletepboard(session,no);
	}

}
