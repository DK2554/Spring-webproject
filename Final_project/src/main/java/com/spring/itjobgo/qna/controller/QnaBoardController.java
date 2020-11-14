package com.spring.itjobgo.qna.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.itjobgo.qna.model.service.QnaBoardService;

@RestController
public class QnaBoardController {
	@Autowired
	private Logger logger;
	
	@Autowired
	private QnaBoardService service;
	//화면전환시키기
	@RequestMapping("/qna/qnaboardlist")
	

	
	
	
	
	
}
