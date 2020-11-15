package com.spring.itjobgo.info.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.itjobgo.info.model.dao.InfoBoardDao;
import com.spring.itjobgo.info.model.vo.InfoBoard;

@Service
public class InfoBoardServiceImpl implements InfoBoardService {
	
@Autowired
private InfoBoardDao dao;

@Autowired
private SqlSessionTemplate session;

@Override
public List<InfoBoard> selectBoardList() {
	// TODO Auto-generated method stub
	return dao.selectInfoBoardList(session);
	
	
	
	
	}
}



