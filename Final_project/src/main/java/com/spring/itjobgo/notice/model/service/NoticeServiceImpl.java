package com.spring.itjobgo.notice.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.notice.model.dao.NoticeDao;
import com.spring.itjobgo.notice.model.vo.Notice;
import com.spring.itjobgo.notice.model.vo.NoticeAttachment;
import com.spring.itjobgo.notice.model.vo.NoticeComment;

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
	//공지사항 상세보기
	@Override
	public Notice selectNoticeOne(int noticeSq, boolean hasRead) {
		
		Notice notice =dao.selectNoticeOne(session, noticeSq);
		//hasRead가 false이면
		if(notice!=null && !hasRead) {
			int result =dao.updateReadCount(session,noticeSq);
			System.out.println("조회수증가로직 성공");
		}	
				
		return notice;
		
	}
	//첨부파일 선택해오기(삭제로직)
	@Override
	public NoticeAttachment selectAttach(int noticeSq) {
		// TODO Auto-generated method stub
		return dao.selectAttach(session,noticeSq);
	}
	
	//자유게시판 삭제 
	@Override
	public int deleteBoard(int noticeSq) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(session,noticeSq);
	}
	//update (첨부파일이 있을때)
	@Override
	public int updateBoard(Notice notice, List<NoticeAttachment> files) {
		//첨부파일이 있으면 첨부파일 등록 dao도 같이 실행해줘야 한다
		int result = dao.updateBoard(session,notice);
		//등록이 성공되지 않는다면
		if(result==0) throw new RuntimeException("게시글 등록 오류");
		//등록이 성공하고 첨부파일이 존재한다면 첨부파일 등록해줘야한다.
			if(result>0) {
				if(!files.isEmpty()) {
					for(NoticeAttachment file : files) {
						result=dao.updateAttachment(session, file);
						
						//첨부파일이없는 게시글일 경우 시퀀스때문에 수정이 안된다
						//그럴경우 시퀀스가 없는 insertAttachment2매퍼로 이동하도록 유도한다.
						if(result==0) 
							
							dao.insertAttachment2(session, file);
						
							System.out.println("==첨부파일 없는 글 첨부파일 등록성공==");
					}//for문
				}//세번째 if문
			}//두번째 if문
			
			return result;
	}
	
	//update (첨부파일이 없을때)
	@Override
	public int updateBoard(Notice notice) {
		// TODO Auto-generated method stub
		return dao.updateBoard(session,notice);
	}
	//댓글달기
	@Override
	public int insertComment(NoticeComment nbc) {
		// TODO Auto-generated method stub
		return dao.insertComment(session,nbc);
	}
	//댓글 조회
	@Override
	public List<NoticeComment> selectComment(int ntBoardNo) {
		// TODO Auto-generated method stub
		return dao.selectComment(session,ntBoardNo);
	}
	//댓글 삭제
	@Override
	public int deleteComment(int ntCommentNo) {
		// TODO Auto-generated method stub
		return dao.deleteComment(session, ntCommentNo);
	}
	//댓글 수정
	@Override
	public int updateComment(Map param) {
		// TODO Auto-generated method stub
		return dao.updateComment(session, param);
	}
	
	
	
	
	
	
	
	
	
	
	

}
