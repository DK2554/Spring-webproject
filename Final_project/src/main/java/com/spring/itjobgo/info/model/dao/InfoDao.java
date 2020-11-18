package com.spring.itjobgo.info.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.info.model.vo.Info;

public interface InfoDao {
	
	List<Info> selectInfoList(SqlSessionTemplate session);

	//글작성
	int insertInfo(SqlSessionTemplate session, Info CB);
	
	//첨부파일 insert
	int insertAttachment(SqlSessionTemplate session, CB_ATTACHMENT cb_attach);

	
}
