package com.spring.itjobgo.portfolio.model.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.portfolio.model.vo.Attachment;
import com.spring.itjobgo.portfolio.model.vo.Comment;
import com.spring.itjobgo.portfolio.model.vo.Pboard;
@Repository
public class PortfolioDaoImpl implements PortfolioDao {

	@Override
	public int deletepboard(SqlSessionTemplate session, int no) {
		// TODO Auto-generated method stub
		return session.delete("pboard.deletepboard",no);
	}

	@Override
	public int insertComment(SqlSessionTemplate session, Comment cm) {
		// TODO Auto-generated method stub
		return session.insert("pboard.insertcomment",cm);
	}

	@Override
	public int updateReadCount(SqlSessionTemplate session, int pboardNo) {
		// TODO Auto-generated method stub
		return session.update("pboard.updatacount",pboardNo);
	}

	@Override
	public int updatecomment(SqlSessionTemplate session, Map param) {
		// TODO Auto-generated method stub
		return session.update("pboard.updatecomment", param);
	}

	@Override
	public int updatacommentText(SqlSessionTemplate session, int pboardNo) {
		// TODO Auto-generated method stub
		// 답변 여부 변경 
		return session.update("pboard.updatecommentstatus",pboardNo);
	}

	@Override
	public Attachment selectOneAttach(SqlSessionTemplate session, int no) {
		// TODO Auto-generated method stub
		return session.selectOne("pboard.selectattachment",no);
	}

	

	@Override
	public int deletecomment(SqlSessionTemplate session,int no) {
		// TODO Auto-generated method stub
		return session.delete("pboard.deletecomment",no);
	}

	@Override
	public List<Comment> selectComment(SqlSessionTemplate session, int no) {
		// TODO Auto-generated method stub
		return session.selectList("pboard.selectcommentlist",no);
	}

	@Override
	public int updateattachment(SqlSessionTemplate session, Attachment file) {
		// TODO Auto-generated method stub
		return session.update("pboard.updateattachment",file);
	}

	@Override
	public int updatedpboard(SqlSessionTemplate session, Pboard pboard) {
		// TODO Auto-generated method stub
		return session.update("pboard.updatepboard",pboard);
	}

	@Override
	public int selectmemberno(SqlSessionTemplate session, String email) {
		// TODO Auto-generated method stub
		return session.selectOne("pboard.selectmemberno",email);
	}

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
