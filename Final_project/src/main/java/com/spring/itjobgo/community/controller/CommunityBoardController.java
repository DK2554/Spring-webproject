package com.spring.itjobgo.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.itjobgo.community.model.service.CommunityBoardService;
import com.spring.itjobgo.community.model.vo.CommunityBoard;

@Controller
public class CommunityBoardController {

	@Autowired
	private CommunityBoardService service;
	
	//자유게시판 화면전환용 메서드
	@RequestMapping("/community/communityBoradList.do")
	public ModelAndView communityBoard(ModelAndView mv) {
		
		
		List<CommunityBoard>list = service.selectBoardList();
		
		System.out.println(list);
		
		mv.addObject("list",list);
		
		mv.setViewName("communityBorad/communityBoardList");
		
		return mv;
		
	}
}
