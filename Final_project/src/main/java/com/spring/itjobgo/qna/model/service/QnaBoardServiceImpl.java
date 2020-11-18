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


	
	
}
