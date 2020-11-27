package com.spring.itjobgo.resume.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.resume.model.vo.Rboard;
import com.spring.itjobgo.resume.model.vo.RboardAttachment;

@Repository
public class ResumeDaoImpl implements ResumeDao {
	
	//이력서 게시판 리스트
	@Override
	public List<Rboard> selectListRboard(SqlSessionTemplate session) {

		return session.selectList("rboard.selectRboard");
	}
	
	//이력서 게시판 글 등록
	@Override
	public int insertRboard(SqlSessionTemplate session, Rboard rboard) {
		System.out.println("*******게시물 등록 dao 들어옴******");
		return session.insert("rboard.insertRboard",rboard);
	}

	//이력서 게시판 첨부파일 등록
	@Override
	public int insertAttachment(SqlSessionTemplate session, RboardAttachment file) {
		System.out.println("********dao 파일첨부 하기 전**********");
		return session.insert("rboard.insertAttachment",file);
	}




}
