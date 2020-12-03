package com.spring.itjobgo.notice.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.notice.model.vo.Notice;
import com.spring.itjobgo.notice.model.vo.NoticeAttachment;

public interface NoticeDao {
	
	//공지사항 조회
	List<Notice> selectNoticeList(SqlSessionTemplate session);
	
	//공지사항 작성
	int insertNotice(SqlSessionTemplate session,Notice notice);
	
	//첨부파일 입력
	int insertNoticeAttachment(SqlSessionTemplate session,NoticeAttachment notice_attach);

}
