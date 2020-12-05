package com.spring.itjobgo.notice.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.notice.model.vo.Notice;
import com.spring.itjobgo.notice.model.vo.NoticeAttachment;
import com.spring.itjobgo.notice.model.vo.NoticeComment;

public interface NoticeDao {
	
	//공지사항 조회
	List<Notice> selectNoticeList(SqlSessionTemplate session);
	
	//공지사항 작성
	int insertNotice(SqlSessionTemplate session,Notice notice);
	
	//첨부파일 입력
	int insertNoticeAttachment(SqlSessionTemplate session,NoticeAttachment notice_attach);
	
	//글 상세보기
	Notice selectNoticeOne(SqlSessionTemplate session, int noticeSq);

	//조회수증가
	int updateReadCount(SqlSessionTemplate session, int noticeSq);
	
	//첨부파일 조회
	NoticeAttachment selectAttach(SqlSessionTemplate session, int noticeSq);
	
	//게시판 삭제
	int deleteBoard(SqlSessionTemplate session, int noticeSq);
	
	//첨부파일 update
	int updateAttachment(SqlSessionTemplate session,NoticeAttachment notice_attach);
		
	//게시글(객체) update
	int updateBoard(SqlSessionTemplate session, Notice notice);
	
	//첨부파일 insert
	//첨부파일이없는 게시글일 경우 시퀀스때문에 수정이 안된다
	//그럴경우 시퀀스가 없는 insertAttachment2매퍼로 이동하도록 유도한다.
	int insertAttachment2(SqlSessionTemplate session, NoticeAttachment notice_attach);

	//댓글달기
	int insertComment(SqlSessionTemplate session, NoticeComment nbc);
	
	//댓글조회
	List<NoticeComment>selectComment(SqlSessionTemplate session, int ntBoardNo);
	
	//댓글 삭제
	int deleteComment(SqlSessionTemplate session, int ntCommentNo);
	
	//댓글 update
	int updateComment(SqlSessionTemplate session, Map param);
	
	
	
}//클래스
