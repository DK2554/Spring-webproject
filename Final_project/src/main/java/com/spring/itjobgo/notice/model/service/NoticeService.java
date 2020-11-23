package com.spring.itjobgo.notice.model.service;

import java.util.List;

import com.spring.itjobgo.notice.model.vo.Notice;

public interface NoticeService {
	
	List<Notice> selectNoticeList();

}
