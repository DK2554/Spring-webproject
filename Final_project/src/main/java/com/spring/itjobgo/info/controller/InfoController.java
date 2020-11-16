package com.spring.itjobgo.info.controller;

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
import com.spring.itjobgo.info.model.service.InfoService;
import com.spring.itjobgo.info.model.vo.Info;

@RestController
@RequestMapping("/info")
public class InfoController {
	@Autowired
	private Logger logger;
	
	@Autowired
	private InfoService service;
	
	//화면전환용 메서드
	@ResponseBody
	@RequestMapping(value="/infoList" , method=RequestMethod.GET)
	public List<Info> Info()  {
		
			List<Info> list = service.selectInfoList();
			
			for(Info i : list){
			    System.out.println(i);
			}
				System.out.println(list);
					
			return list;
	}
}

