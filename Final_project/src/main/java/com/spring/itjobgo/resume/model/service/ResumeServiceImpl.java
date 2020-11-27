package com.spring.itjobgo.resume.model.service;

import java.util.List;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.resume.model.dao.ResumeDao;
import com.spring.itjobgo.resume.model.vo.Rboard;
import com.spring.itjobgo.resume.model.vo.RboardAttachment;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDao dao;
	
	@Autowired
	private SqlSessionTemplate session;
	
	//이력서 게시판 리스트
	@Override
	public List<Rboard> selectListRboard() {
		System.out.println("*******service 들어옴******");
		
		return dao.selectListRboard(session);
	}
	//이력서 게시판 등록
	@Override
	public int insertRboard(Rboard rboard, List<RboardAttachment> files) {
		System.out.println("*******게시물 등록 service 들어옴******");
		int result=dao.insertRboard(session, rboard);
		System.out.println("*******result : "+result);
		if(result==0) throw new RuntimeException("이력서 게시판 글 등록 오류");
		if(result>0) {
			if(!files.isEmpty()) {
				for(RboardAttachment file:files) {
					System.out.println("*******file : "+file);
					result=dao.insertAttachment(session,file);
					System.out.println("******"+result+"*******");
					if(result==0) throw new RuntimeException("이력서 게시판 파일 입력 오류"); 
				}
			}
		}
		return result;
	}

	
}
