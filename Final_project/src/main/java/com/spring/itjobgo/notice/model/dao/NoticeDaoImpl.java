package com.spring.itjobgo.notice.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.notice.model.vo.Notice;
import com.spring.itjobgo.notice.model.vo.NoticeAttachment;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	//공지사항 조회
	@Override
	public List<Notice> selectNoticeList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("notice.noticeList");
	}
	//공지사항 작성
	@Override
	public int insertNotice(SqlSessionTemplate session, Notice notice) {
		// TODO Auto-generated method stub
		return session.insert("notice.insertNotice");
	}
	//첨부파일 입력
	@Override
	public int insertNoticeAttachment(SqlSessionTemplate session, NoticeAttachment notice_attach) {
		// TODO Auto-generated method stub
		return session.insert("notice.insertNoticeAttachment");
	}


	
	
}
