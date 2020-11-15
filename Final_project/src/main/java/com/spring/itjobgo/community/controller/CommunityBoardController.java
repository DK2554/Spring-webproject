package com.spring.itjobgo.community.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public List<CommunityBoard> communityBoard()  {
		
			List<CommunityBoard> list = service.selectBoardList();
			
			for(CommunityBoard i : list){
			    System.out.println(i);
			}
			
			System.out.println(list);
				
			
			return list;

//		System.out.println(list);
			
//			ObjectMapper mapper = new ObjectMapper();
			
//			return mapper.writeValueAsString(list);
	}
	
	
//	@ResponseBody
//	@RequestMapping(value="/communityBoardList" , method=RequestMethod.GET)
//	public CommunityBoard communityBoardList(@RequestBody Map param) {
//		
//		CommunityBoard cb = service.selectBoardList2(param);
//		System.out.println(cb);
//		return cb;
//	}
}
