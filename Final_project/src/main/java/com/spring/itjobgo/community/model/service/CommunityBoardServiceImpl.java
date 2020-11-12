package com.spring.itjobgo.community.model.service;

import java.util.List;
import java.util.Map;

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



//@Override
//public CommunityBoard selectBoardList() {
//	// TODO Auto-generated method stub
//	 return dao.selectBoardList(session); 
//}





//  @Override public List<CommunityBoard> selectBoardList(List<CommunityBoard> list) { // TODO
//  //Auto-generated method stub r
//	  return dao.selectBoardList(session,list); 
//  }
 
//@Override
//public CommunityBoard selectBoardList2(Map param) {
//	// TODO Auto-generated method stub
//	return dao.selectBoardList2(session,param);
//}









}
