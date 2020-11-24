package com.spring.itjobgo.info.model.dao;

import java.util.List;
/*import java.util.Map;*/

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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
	public int insertInfo(SqlSessionTemplate session, Info CB) {
		return session.insert("info.insertInfo",CB);
	}
	//글쓰기 할때 첨부파일
	@Override
	public int insertAttachment(SqlSessionTemplate session, INFO_ATTACHMENT info_attach) {
		return session.insert("info.insertAttachment",info_attach);
	}
	
	//상세보기
	@Override
	public Info selectInfoOne(SqlSessionTemplate session, int infoSq) {
		return session.selectOne("info.selectInfoOne", infoSq);
	}

	//삭제하기
	@Override
	public int deleteBoard(SqlSessionTemplate session, int  infoSq) {
		return session.delete("info.deleteBoard", infoSq);
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
	public int updateInfo(SqlSessionTemplate session, Info cb) {
		return session.update("info.updateinfo",cb);
	}

	@Override
	public int insertAttachment2(SqlSessionTemplate session, INFO_ATTACHMENT info_attach) {
		return session.insert("info.insertAttachment2",info_attach);
	}
		
}
