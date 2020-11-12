package com.spring.itjobgo.community.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.itjobgo.community.model.service.CommunityBoardService;
import com.spring.itjobgo.community.model.vo.CommunityBoard;

@RestController
@RequestMapping("/community")
public class CommunityBoardController {
	@Autowired
	private Logger logger;
	
	@Autowired
	private CommunityBoardService service;
	
	//자유게시판 화면전환용 메서드
	@ResponseBody
	@RequestMapping(value="/communityBoardList" , method=RequestMethod.GET)
	public List<CommunityBoard> communityBoard() {
		
		List<CommunityBoard>list = service.selectBoardList();
		
//		System.out.println("123: " + list);
		
		logger.debug(list.toString());
		
		return list;
		
	}
}
