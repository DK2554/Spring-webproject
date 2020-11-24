package com.spring.itjobgo.info.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.info.model.vo.INFO_ATTACHMENT;
import com.spring.itjobgo.info.model.vo.Info;

public interface InfoDao {
	
	List<Info> selectInfoList(SqlSessionTemplate session);

	//글작성
	int insertInfo(SqlSessionTemplate session, Info CB);
	
	//첨부파일 insert
	int insertAttachment(SqlSessionTemplate session, INFO_ATTACHMENT info_attach);

	//글 상세보기
	Info selectInfoOne(SqlSessionTemplate session, int infoSq);

	//글 삭제하기
	int deleteBoard(SqlSessionTemplate session, int infoSq);
	
	//첨부파일 조회
	INFO_ATTACHMENT selectAttach(SqlSessionTemplate session, int infoSq);

	//첨부파일 update
	int updateAttachment(SqlSessionTemplate session,INFO_ATTACHMENT info_attach);
	
	//게시글(객체) update
	int updateInfo(SqlSessionTemplate session, Info cb);
	
	//첨부파일 insert
	int insertAttachment2(SqlSessionTemplate session, INFO_ATTACHMENT info_attach);

	
}
