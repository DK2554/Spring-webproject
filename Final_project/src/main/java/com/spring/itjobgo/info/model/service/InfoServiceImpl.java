package com.spring.itjobgo.info.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
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
	// TODO Auto-generated method stub
	return dao.selectInfoList(session);
}

	//자유게시판 글쓰기
	@Override
	public int insertInfo(Info cb, List<INFO_ATTACHMENT> files) {
		
		int result=dao.insertInfo(session,cb);
		
		if(result==0) throw new RuntimeException("입력오류");
		if(result>0) {
			if(!files.isEmpty()) {
				//files에 데이터가 있으면
				for(INFO_ATTACHMENT file:files) {
					
					//결과값이 있으면 반복문을 통해서 첨부파일을 insert하는 dao 로직을 생성
					result=dao.insertAttachment(session,file);
					
					if(result==0)throw new RuntimeException("입력오류");
				}
			}
			
		}
		return result;
	}

	//상세보기
	@Override
	public Info selectInfoOne(int infoSq) {
		// TODO Auto-generated method stub
		return dao.selectInfoOne(session,infoSq);
	}

	//삭제하기
	@Override
	public int deleteBoard(int infoSq) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(session, infoSq);
	}

	//첨부파일 조회
	@Override
	public INFO_ATTACHMENT selectAttach(int infoSq) {
		// TODO Auto-generated method stub
		return dao.selectAttach(session, infoSq);
	}


	}
