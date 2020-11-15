package com.spring.itjobgo.info.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.info.model.vo.Info;

@Repository
public class InfoDaoImpl implements InfoDao {

	@Override
	public List<Info> selectInfoList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("Info.selectInfoList"); 
	
	
	
	}
  
}
