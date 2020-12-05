package com.spring.itjobgo.notice.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.notice.model.vo.Notice;
import com.spring.itjobgo.notice.model.vo.NoticeAttachment;
import com.spring.itjobgo.notice.model.vo.NoticeComment;

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
		return session.insert("notice.insertNotice",notice);
	}
	//첨부파일 입력
	@Override
	public int insertNoticeAttachment(SqlSessionTemplate session, NoticeAttachment notice_attach) {
		// TODO Auto-generated method stub
		return session.insert("notice.insertNoticeAttachment",notice_attach);
	}
	//공지사항 상세보기
	@Override
	public Notice selectNoticeOne(SqlSessionTemplate session, int noticeSq) {
		// TODO Auto-generated method stub
		return session.selectOne("notice.selectNoticeOne",noticeSq);
	}
	//공지사항 조회수 증가
	@Override
	public int updateReadCount(SqlSessionTemplate session, int noticeSq) {
		// TODO Auto-generated method stub
		return session.update("notice.updateReadCount",noticeSq);
	}
	//첨부파일 선택
	@Override
	public NoticeAttachment selectAttach(SqlSessionTemplate session, int noticeSq) {
		// TODO Auto-generated method stub
		return session.selectOne("notice.selectAttach", noticeSq);
	}
	//게시물 삭제
	@Override
	public int deleteBoard(SqlSessionTemplate session, int noticeSq) {
		// TODO Auto-generated method stub
		return session.delete("notice.deleteBoard",noticeSq);
	}
	//첨부파일 update
	@Override
	public int updateAttachment(SqlSessionTemplate session, NoticeAttachment notice_attach) {
		// TODO Auto-generated method stub
		return session.update("notice.updateAttachment",notice_attach);
	}
	//게시판 업데이트
	@Override
	public int updateBoard(SqlSessionTemplate session, Notice notice) {
		// TODO Auto-generated method stub
		return session.update("notice.updateBoard",notice);
	}
	//첨부파일 insert
	//첨부파일이없는 게시글일 경우 시퀀스때문에 수정이 안된다
	//그럴경우 시퀀스가 없는 insertAttachment2매퍼로 이동하도록 유도한다.
	@Override
	public int insertAttachment2(SqlSessionTemplate session, NoticeAttachment notice_attach) {
		// TODO Auto-generated method stub
		return session.update("notice.insertAttachment2",notice_attach);
	}
	//댓글 insert
	@Override
	public int insertComment(SqlSessionTemplate session, NoticeComment nbc) {
		// TODO Auto-generated method stub
		return session.insert("notice.insertComment",nbc);
	}
	//댓글 list select
	@Override
	public List<NoticeComment> selectComment(SqlSessionTemplate session, int ntBoardNo) {
		// TODO Auto-generated method stub
		return session.selectList("notice.selectComment",ntBoardNo);
	}
	//댓글 delete
	@Override
	public int deleteComment(SqlSessionTemplate session, int ntCommentNo) {
		// TODO Auto-generated method stub
		return session.delete("notice.deleteComment",ntCommentNo);
	}
	//댓글수정
	@Override
	public int updateComment(SqlSessionTemplate session, Map param) {
		// TODO Auto-generated method stub
		return session.update("notice.updateComment",param);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
}
