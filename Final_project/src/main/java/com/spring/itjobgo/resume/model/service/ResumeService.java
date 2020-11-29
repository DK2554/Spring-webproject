package com.spring.itjobgo.resume.model.service;

import java.util.List;

import com.spring.itjobgo.resume.model.vo.Rboard;
import com.spring.itjobgo.resume.model.vo.RboardAttachment;

public interface ResumeService {
	// 이력서 게시판 보기
	List<Rboard> selectListRboard();
	
	//이력서 게시판 등록하기
	int insertRboard(Rboard rboard, List<RboardAttachment> files);
}
