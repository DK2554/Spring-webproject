package com.spring.itjobgo.notice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.notice.model.service.NoticeService;
import com.spring.itjobgo.notice.model.vo.Notice;

@RestController
public class NoticeController {

	@Autowired
	private Logger logger;
	
	@Autowired
	private NoticeService service;
	
	//공지사항 리스트 조회
	@ResponseBody
	@RequestMapping(value="notice/noticeList", method=RequestMethod.GET)
	public List<Notice> noticeList(){
		
		List<Notice>list = service.selectNoticeList();
		
		for(Notice i : list){
		    System.out.println(i);
		}
		
		return list;
		
	}
	
	
}//클래스
