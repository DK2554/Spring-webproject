package com.spring.itjobgo.qna.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.qna.model.dao.QnaBoardDao;
import com.spring.itjobgo.qna.model.vo.QB_ATTACHMENT;
import com.spring.itjobgo.qna.model.vo.QnaBoard;

	@Service
	public class QnaBoardServiceImpl implements QnaBoardService {
	
	@Autowired
	private QnaBoardDao dao;
	@Autowired
	private SqlSessionTemplate session;
	@Override
	public List<QnaBoard> selectQnaBoard(){
		
		return dao.selectQnaBoard(session);
		
		
	}

	//qna게시판 글쓰기
	@Override
	public int insertQnaBoard(QnaBoard qb, List<QB_ATTACHMENT> files) {
		int result=dao.insertQnaBoard(session,qb);

		if(result==0) throw new RuntimeException("입력오류");
		if(result>0) {
			if(!files.isEmpty()) {
				for(QB_ATTACHMENT file:files) {
					
					result=dao.insertAttachment(session,file);
					
					if(result==0) throw new RuntimeException("입력오류");
					
				}
			}
		}
		return result;
	}

	//qna게시판 상세보기
	@Override
	public QnaBoard selectQnaBoardOne(int qnaSeq) {
		return dao.selectQnaBoardOne(session,qnaSeq);
	}

	@Override
	public int deleteBoard(int qnaSeq) {
		return dao.deleteBoard(session,qnaSeq);
	}

	@Override
	public QB_ATTACHMENT selectAttach(int qnaSeq) {
		return dao.selectAttach(session,qnaSeq);
	}

	@Override
	public int updateBoard(QnaBoard qb, List<QB_ATTACHMENT> files) {
		//첨부파일이 있으면 첨부파일 등록 dao도 같이 실행해줘야 한다.
		int result = dao.updateBoard(session,qb);
		//등록이 성공되지 않는다면
		if(result>0) {
			if(!files.isEmpty()) {
				for(QB_ATTACHMENT file:files) {
					result=dao.updateAttachment(session,file);
					//첨부파일이 없는 게시글일 경우 시퀀스 때문에 수정이 안된다.
					//그럴경우 시퀀스가 없는 insertAttachment2매퍼로 이동하도록 유도한다.
					if(result==0)						
						 
						dao.insertAttachment2(session,file);
							System.out.println("==첨부파일이 없는 글 첨부파일 등록 성공===");
				}//for문
			}//세번째 if문
		}//두번째 if문
		
		return result;
	}

	@Override
	public int updateBoard(QnaBoard qb) {
		return dao.updateBoard(session,qb);
	}
	
	
	
	

	
	
}
