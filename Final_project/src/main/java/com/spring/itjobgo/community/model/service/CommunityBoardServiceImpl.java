package com.spring.itjobgo.community.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.community.model.dao.CommunityBoardDao;
import com.spring.itjobgo.community.model.vo.CommunityBoard;

@Service
public class CommunityBoardServiceImpl implements CommunityBoardService {

@Autowired
private CommunityBoardDao dao;

@Autowired
private SqlSessionTemplate session;

@Override
public List<CommunityBoard> selectBoardList() {
	// TODO Auto-generated method stub
	return dao.selectBoardList(session);
}




}
