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

	//상세보기
	@Override
	public Info selectInfoOne(int infoSq) {
		return dao.selectInfoOne(session,infoSq);
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


	}
