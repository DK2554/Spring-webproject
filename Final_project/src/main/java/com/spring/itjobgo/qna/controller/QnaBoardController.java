package com.spring.itjobgo.qna.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.itjobgo.qna.model.service.QnaBoardService;
import com.spring.itjobgo.qna.model.vo.QnaBoard;

@RestController
public class QnaBoardController {
	
	@Autowired
	private Logger logger;
	
	@Autowired
	private QnaBoardService service;
	
	@RequestMapping(value="/qna/qnaboardlist" , method=RequestMethod.GET)
	public List<QnaBoard> qnaBoard() {
		
		List<QnaBoard> list =service.selectBoardList();

		for(QnaBoard i : list) {
			System.out.println(i);
		}
		
		System.out.println(list);

		return list;
	}
	
	
	

	
	
	
	
	
}
