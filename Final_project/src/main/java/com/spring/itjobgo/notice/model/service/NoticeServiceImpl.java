package com.spring.itjobgo.notice.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.notice.model.dao.NoticeDao;
import com.spring.itjobgo.notice.model.vo.Notice;
import com.spring.itjobgo.notice.model.vo.NoticeAttachment;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao dao;
		
	@Autowired
	private SqlSessionTemplate session;

	//공지사항 조회
	@Override
	public List<Notice> selectNoticeList() {
		// TODO Auto-generated method stub
		return dao.selectNoticeList(session);
	}
	//공지사항 작성
	@Override
	public int insertNotice(Notice notice, List<NoticeAttachment> files) {
		// TODO Auto-generated method stub
		
		//공지사항 작성
		int result =dao.insertNotice(session, notice);
		
		if(result==0) throw new RuntimeException("공지사항 작성 오류");
		
		if(result>0) {
			//작성이 성공하면 첨부파일 작성
			if(!files.isEmpty()) {
				for(NoticeAttachment file:files) {
					result=dao.insertNoticeAttachment(session,file);
					
					if(result==0) throw new RuntimeException("공지사항 첨부파일 입력오류");
				}
			}
		}
		
		return result;
	}
	
	
	
	
	

}
