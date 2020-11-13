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
import com.spring.itjobgo.info.model.service.InfoBoardService;
import com.spring.itjobgo.info.model.vo.InfoBoard;

@RestController
@RequestMapping("/info")
public class InfoBoardController {
	@Autowired
	private Logger logger;
	
	@Autowired
	private InfoBoardService service;
	
	@ResponseBody
	@RequestMapping(value="/infoBoardList" , method=RequestMethod.GET)
	public String communityBoard() throws JsonProcessingException {
		
		List<InfoBoard> list = service.selectBoardList();
	
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(list);
	}
}


