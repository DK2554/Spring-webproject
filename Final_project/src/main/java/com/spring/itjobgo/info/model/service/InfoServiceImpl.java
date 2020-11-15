package com.spring.itjobgo.info.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.info.model.dao.InfoDao;
import com.spring.itjobgo.info.model.vo.Info;

@Service
public class InfoServiceImpl implements InfoService {

@Autowired
private InfoDao dao;

@Autowired
private SqlSessionTemplate session;

@Override
public List<Info> selectInfoList() {
	// TODO Auto-generated method stub
	return dao.selectInfoList(session);


	}
}
