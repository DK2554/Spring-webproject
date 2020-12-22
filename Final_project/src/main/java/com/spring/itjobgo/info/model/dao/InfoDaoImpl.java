package com.spring.itjobgo.info.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.ItNews.model.vo.ItnewsAttachment;
import com.spring.itjobgo.info.model.vo.INFO_ATTACHMENT;
import com.spring.itjobgo.info.model.vo.Info;

@Repository
public class InfoDaoImpl implements InfoDao {

	//게시판 리스트 불러오기
	@Override
	public List<Info> selectInfoList(SqlSessionTemplate session) {
		return session.selectList("info.selectInfoList"); 
	}	
	//글쓰기
	@Override
	public int insertInfo(SqlSessionTemplate session, Info IFO) {
		return session.insert("info.insertInfo",IFO);
	}
	//글쓰기 할때 첨부파일
	@Override
	public int insertAttachment(SqlSessionTemplate session, INFO_ATTACHMENT info_attach) {
		return session.insert("info.insertAttachment",info_attach);
	}
	
	//이미지 불러오기
	@Override
	public INFO_ATTACHMENT selectImage(SqlSessionTemplate session, int sq) {
		return session.selectOne("info.selectImage",sq);
	}
	
	//상세보기
	@Override
	public Info selectInfoOne(SqlSessionTemplate session, int infoSq) {
		return session.selectOne("info.selectInfoOne", infoSq);
	}

	//삭제하기
	@Override
	public int deleteInfo(SqlSessionTemplate session, int  infoSq) {
		return session.delete("info.deleteInfo", infoSq);
	}
	
	//첨부파일 조회
	@Override
	public INFO_ATTACHMENT selectAttach(SqlSessionTemplate session, int infoSq) {
		return session.selectOne("info.selectAttach",infoSq);
	}
	
	//첨부파일 update
	@Override
	public int updateAttachment(SqlSessionTemplate session, INFO_ATTACHMENT info_attach) {
		return session.update("info.updateAttachment",info_attach);
	}
	
	//게시글(객체)update
	@Override
	public int updateInfo(SqlSessionTemplate session, Info ifo) {
		return session.update("info.updateinfo",ifo);
	}

	//첨부파일 다운로드
	@Override
	public int insertAttachment2(SqlSessionTemplate session, INFO_ATTACHMENT info_attach) {
		return session.insert("info.insertAttachment2",info_attach);
	}
	
	//조회수 증가로직
	@Override
	public int updateReadCount(SqlSessionTemplate session, int infoSq) {
		return session.update("info.updateReadCount",infoSq);
	}
	
}
