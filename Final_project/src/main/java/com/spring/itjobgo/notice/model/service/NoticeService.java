package com.spring.itjobgo.notice.model.service;

import java.util.List;

import com.spring.itjobgo.notice.model.vo.Notice;
import com.spring.itjobgo.notice.model.vo.NoticeAttachment;

public interface NoticeService {
	
	List<Notice> selectNoticeList();
	
	int insertNotice(Notice notice,List<NoticeAttachment> files );

}
