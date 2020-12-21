package com.spring.itjobgo.ref.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.ref.model.dao.RefDao;
import com.spring.itjobgo.ref.model.vo.REF_SITE;
import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

@Service
public class RefServiceImpl implements RefService {
	
	@Autowired
	private RefDao dao;
	@Autowired
	private SqlSessionTemplate session;
	
	//글작성
	@Override
	public int insertSite(Map param, List<REF_SITE_ATTACHMENT> files) {
		//글작성이 정삭적으로 이루어지면=(result>0)
		//첨부파일 등록
		int result=dao.insertSite(session,param);
		if(result==0) throw new RuntimeException("ref site 글작성 오류");
		if(result>0) {
			if(!files.isEmpty()) {
				for(REF_SITE_ATTACHMENT file:files) {
					result=dao.insertAttachment(session,file);
					
					//글등록 수 조회
					result=dao.statuscount(session);
					
					if(result==0) throw new RuntimeException("ref site 첨부파일 작성 오류");
				}
			}
		}return result;
	}

	//리스트 불러오기(조회)
	@Override
	public List<REF_SITE> selectList() {
		return dao.selectList(session);
	}

	@Override
	public REF_SITE_ATTACHMENT selectImage(int no) {
		return dao.selectImage(session,no);
	}

	@Override
	public REF_SITE_ATTACHMENT selectAttach(int refNo) {
		return dao.selectAttach(session, refNo);
	}

	//게시글 삭제하기
	@Override
	public int deleteSite(int refNo) {
		return dao.deleteSite(session, refNo);
	}

	//상세화면 selectOne
	@Override
	public REF_SITE selectOne(int refNo) {
		return dao.selectOne(session,refNo);
	}

	//update 파일이 있을 떄
	@Override
	public int updateSite(REF_SITE refsite, List<REF_SITE_ATTACHMENT> files) {
		
				//게시판 insert와 마찬가지로
				//먼저 itnews테이블만 먼저 update하고
				//file이 존재하면 파일을 update
				//file이 없으면 insert 버전 2로 (기존 첨부파일 insert와 다른) 실행한다.
				
				int  result = dao.updateSite(session, refsite);
				
				if(result==0) throw new RuntimeException();
				
				if(result>0) {
					if(!files.isEmpty()) {
						for(REF_SITE_ATTACHMENT file:files) {
							result=dao.updateAttachment(session,file);
							
							if(result==0)
								dao.insertAttachment2(session, file);
						}
					}
				}
				
				return result;
			}

	//update 파일이 없을 때
	@Override
	public int updateSite(REF_SITE refsite) {
		return dao.updateSite(session,refsite);
	}
	
	//관리자 승인
	@Override
	public int updateStatus(int refNo) {
		return dao.updateStatus(session, refNo);
	}

	//글작성 카운트 조회
	@Override
	public int selectCount() {
		return dao.selectCount(session);
	}	
	
	
	
	
	
	
}
