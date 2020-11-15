package com.spring.itjobgo.info.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.itjobgo.community.model.service.CommunityBoardService;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.info.model.service.InfoBoardService;
import com.spring.itjobgo.info.model.vo.InfoBoard;

@RestController
@RequestMapping("/community")
public class InfoBoardController {
	@Autowired
	private Logger logger;
	
	@Autowired
	private InfoBoardService service;
	
    //화면전환용 메서드
	@ResponseBody
	@RequestMapping(value="/infoBoardList" , method=RequestMethod.GET)
	public List<InfoBoard> InfoBoard()  {
		
		List<InfoBoard> list = service.selectBoardList();
		
		for(InfoBoard i : list){
		    System.out.println(i);
		}

		System.out.println(list);
			
		
		return list;

		
		
		
			}
	}