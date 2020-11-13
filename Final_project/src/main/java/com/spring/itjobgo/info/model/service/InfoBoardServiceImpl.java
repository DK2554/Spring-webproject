package com.spring.itjobgo.info.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.itjobgo.info.model.dao.InfoBoardDao;

@Service
public class InfoBoardServiceImpl implements InfoBoardService {
	@Autowired
	private InfoBoardDao dao;
}



