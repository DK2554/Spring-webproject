package com.spring.itjobgo.info.model.service;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.info.model.dao.InfoDao;
import com.spring.itjobgo.info.model.vo.INFO_ATTACHMENT;
import com.spring.itjobgo.info.model.vo.Info;

@Service
public class InfoServiceImpl implements InfoService {

@Autowired
private InfoDao dao;

@Autowired
private SqlSessionTemplate session;

@Override
public List<Info> selectInfoList() {
	return dao.selectInfoList(session);
	
}

	//취업정보 글쓰기
	@Override
	public int insertInfo(Info cb, List<INFO_ATTACHMENT> files) {
		
		int result=dao.insertInfo(session,cb);
		
		if(result==0) throw new RuntimeException("입력오류");
		if(result>0) {
			if(!files.isEmpty()) {	
				for(INFO_ATTACHMENT file:files) {
					result=dao.insertAttachment(session,file);
					
					if(result==0)throw new RuntimeException("입력오류");
				}
			}	
		}
		
		return result;
		
	}

	//상세 글 보기
	@Override
	public Info selectInfoOne(int infoSq,boolean hasRead) {
		Info cb =dao.selectInfoOne(session, infoSq);
		//hasRead가 false이면
		if(cb!=null && !hasRead) {
			int result =dao.updateReadCount(session,infoSq);
			System.out.println("조회수 증가 성공");
		}	
				
		return cb;
	}

	//삭제하기
	@Override
	public int deleteBoard(int infoSq) {
		return dao.deleteBoard(session, infoSq);
	}

	//첨부파일 조회
	@Override
	public INFO_ATTACHMENT selectAttach(int infoSq) {
		return dao.selectAttach(session, infoSq);
	}

	//첨부파일이 있을때 update
	@Override
	public int updateInfo(Info cb, List<INFO_ATTACHMENT> files) {
		//첨부파일이 있으면 첨부파일 등록 dao도 같이 실행해줘야 한다
		int result = dao.updateInfo(session,cb);
		//등록이 성공되지 않는다면
		if(result==0) throw new RuntimeException("게시글 등록 오류");
		//등록이 성공하고 첨부파일이 존재한다면 첨부파일 등록해줘야한다.
			if(result>0) {
				if(!files.isEmpty()) {
					for(INFO_ATTACHMENT file : files) {
						result=dao.updateAttachment(session, file);
						
						//첨부파일이없는 게시글일 경우 시퀀스때문에 수정이 안된다
						//그럴경우 시퀀스가 없는 insertAttachment2매퍼로 이동하도록 유도한다.
						if(result==0) 
							
							dao.insertAttachment2(session, file);
						
							System.out.println("==첨부파일 없는 글 첨부파일 등록==");
					}//for문
				}//세번째 if문
			}//두번째 if문
			
			return result;
		}

	//첨부파일이 없을때 게시판 내용만 update
	@Override
	public int updateInfo(Info cb) {
		// TODO Auto-generated method stub
		return dao.updateInfo(session,cb);
		}


	}
