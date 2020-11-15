package com.spring.itjobgo.portfolio.model.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.portfolio.model.vo.Attachment;
import com.spring.itjobgo.portfolio.model.vo.Pboard;
@Repository
public class PortfolioDaoImpl implements PortfolioDao {

	@Override
	public int insertPboard(SqlSessionTemplate session, Pboard pboard) {
		
		return session.insert("pboard.insertpboard",pboard);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, Attachment file) {
		// TODO Auto-generated method stub
		return session.insert("pboard.insertAttachment",file);
	}

	@Override
	public Pboard selectOnepboard(SqlSessionTemplate session, int pboardNo) {
	
		return session.selectOne("pboard.selectOnepboard",pboardNo);
	}

	@Override
	public List<Pboard> selectLitpboard(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("pboard.selectpboard");
	}
	
}
