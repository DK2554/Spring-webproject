package com.spring.itjobgo.portfolio.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.portfolio.model.vo.Attachment;
import com.spring.itjobgo.portfolio.model.vo.Pboard;

public interface PortfolioDao {

	int insertPboard(SqlSessionTemplate session, Pboard pboard);

	int insertAttachment(SqlSessionTemplate session, Attachment file);

	List<Pboard> selectLitpboard(SqlSessionTemplate session);

	Pboard selectOnepboard(SqlSessionTemplate session, int pboardNo);

	int deletepboard(SqlSessionTemplate session, int no);

	Attachment selectOneAttach(SqlSessionTemplate session, int no);

}
