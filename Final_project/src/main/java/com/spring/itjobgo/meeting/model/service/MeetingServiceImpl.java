package com.spring.itjobgo.meeting.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.meeting.model.dao.MeetingDao;
import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.meeting.model.vo.Mboard;
import com.spring.itjobgo.portfolio.model.vo.Attachment;

@Service
public class MeetingServiceImpl implements MeetingService {
	@Autowired
	private MeetingDao dao;
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int insertMboard(Map param, List<Mattachment> files) {
		// TODO Auto-generated method stub
		int result=dao.insertMboard(session,param);
		if(result==0) throw new RuntimeException("입력오류");
		if(result>0) {
			if(!files.isEmpty()) {
				//files에 데이터가 있으면
				for(Mattachment file:files) {
					result=dao.insertAttachment(session,file);
					if(result==0)throw new RuntimeException("입력오류");
				}
			}
			
		}
		return result;
	}

	@Override
	public Mboard selectMb(int no) {
		// TODO Auto-generated method stub
		return dao.selectMinfo(session,no);
	}

	@Override
	public List<Mboard> selectMlist() {
		// TODO Auto-generated method stub
		return dao.selectMlist(session);
	}

}
