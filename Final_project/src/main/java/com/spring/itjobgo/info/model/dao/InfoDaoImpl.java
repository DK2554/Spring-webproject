package com.spring.itjobgo.info.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.info.model.vo.Info;

@Repository
public class InfoDaoImpl implements InfoDao {

	@Override
	public List<Info> selectInfoList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("info.selectInfoList");  
	 }
	@Override
	public int insertInfo(SqlSessionTemplate session, Info CB) {
		// TODO Auto-generated method stub
		return session.insert("info.insertInfo",CB);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, CB_ATTACHMENT cb_attach) {
		// TODO Auto-generated method stub
		return session.insert("info.insertAttachment",cb_attach);
	
	
	}
  
}
