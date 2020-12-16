package com.spring.itjobgo.ref.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.ref.model.vo.REF_SITE;
import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

@Repository
public class RefDaoImpl implements RefDao {

	//글작성
	@Override
	public int insertSite(SqlSessionTemplate session, Map param) {
		return session.insert("refSite.insertSite",param);
	}

	//글작성(첨부파일)
	@Override
	public int insertAttachment(SqlSessionTemplate session, REF_SITE_ATTACHMENT refattachment) {
		return session.insert("refSite.insertAttachment", refattachment);
	}

	//리스트 불러오기(조회)
	@Override
	public List<REF_SITE> selectList(SqlSessionTemplate session) {
		return session.selectList("refSite.selectList");
	}

	//이미지 불러오기
	@Override
	public REF_SITE_ATTACHMENT selectImage(SqlSessionTemplate session, int no) {
		return session.selectOne("refSite.selectImage",no);
	}

	//첨부파일 불러오기
	@Override
	public REF_SITE_ATTACHMENT selectAttach(SqlSessionTemplate session, int refNo) {
		return session.selectOne("refSite.selectAttach",refNo);
	}
	
	//상세화면 selectOne
	@Override
	public REF_SITE selectOne(SqlSessionTemplate session, int refNo) {
		return session.selectOne("refSite.selectOne",refNo);
	}
	
	//글 삭제
	@Override
	public int deleteSite(SqlSessionTemplate session, int refNo) {
		return session.delete("refSite.deleteSite",refNo);
	}

	//게시판 update
	@Override
	public int updateSite(SqlSessionTemplate session, REF_SITE refsite) {
		return session.update("refSite.updateSite",refsite);
	}

	//첨부파일 update(게시판 update)
	@Override
	public int updateAttachment(SqlSessionTemplate session, REF_SITE_ATTACHMENT file) {
		return session.update("refSite.updateAttachment",file);
	}

	//게시판 update시 첨부파일이 없다면 >> 새롭게 insert
	@Override
	public int insertAttachment2(SqlSessionTemplate session, REF_SITE_ATTACHMENT file) {
		return session.insert("refSite.insertAttachment2" , file);
	}


	
	
	
	
}
