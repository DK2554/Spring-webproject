package com.spring.itjobgo.resume.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.resume.model.vo.Rboard;
import com.spring.itjobgo.resume.model.vo.RboardAttachment;

public interface ResumeDao {
	
	//이력서 게시판 리스트
	List<Rboard> selectListRboard(SqlSessionTemplate session);
	
	//이력서 게시판 글 등록
	int insertRboard(SqlSessionTemplate session, Rboard rboard);
	
	//이력서 게시판 파일첨부 등록
	int insertAttachment(SqlSessionTemplate session, RboardAttachment file);
}
