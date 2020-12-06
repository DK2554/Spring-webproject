package com.spring.itjobgo.notice.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.notice.model.vo.Notice;
import com.spring.itjobgo.notice.model.vo.NoticeAttachment;
import com.spring.itjobgo.notice.model.vo.NoticeComment;

public interface NoticeService {
	
	List<Notice> selectNoticeList();
	
	int insertNotice(Notice notice,List<NoticeAttachment> files );
	
	Notice selectNoticeOne(int noticeSq ,boolean hasRead);
	
	NoticeAttachment selectAttach(int noticeSq);
	
	int deleteBoard(int noticeSq);
	
	int updateBoard(Notice notice,List<NoticeAttachment>files);
	
	int updateBoard(Notice notice);
	
	int insertComment(NoticeComment nbc);
	
	List<NoticeComment> selectComment(int ntBoardNo);
	
	int deleteComment(int ntCommentNo);

	int updateComment(Map param);
}
