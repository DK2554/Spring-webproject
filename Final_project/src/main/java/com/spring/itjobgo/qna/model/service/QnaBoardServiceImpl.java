package com.spring.itjobgo.qna.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.community.model.dao.CommunityBoardDao;
import com.spring.itjobgo.qna.model.vo.QnaBoard;

@Service
public class QnaBoardServiceImpl implements QnaBoardService {

@Autowired
private CommunityBoardDao dao;

@Autowired
private SqlSessionTemplate session;

@Override
public List<QnaBoard> selectBoardList(){
	return dao.selectBoardList(session);
}


	
	
}
