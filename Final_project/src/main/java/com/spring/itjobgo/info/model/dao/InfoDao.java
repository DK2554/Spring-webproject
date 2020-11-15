package com.spring.itjobgo.info.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.info.model.vo.Info;

public interface InfoDao {
	
	List<Info> selectInfoList(SqlSessionTemplate session);

}
