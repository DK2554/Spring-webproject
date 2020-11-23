package com.spring.itjobgo.notice.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.notice.model.dao.NoticeDao;
import com.spring.itjobgo.notice.model.vo.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao dao;
		
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<Notice> selectNoticeList() {
		// TODO Auto-generated method stub
		return dao.selectNoticeList(session);
	}
	
	
	
	

}
