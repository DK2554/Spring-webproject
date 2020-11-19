package com.spring.itjobgo.meeting.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.meeting.model.vo.Mattachment;


@Repository
public class MeetingDaoImpl implements MeetingDao {

	@Override
	public int insertMboard(SqlSessionTemplate session, Map param) {
		// TODO Auto-generated method stub
		return session.insert("meeting.insertmboard",param);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, Mattachment file) {
		// TODO Auto-generated method stub
		return session.insert("meeting.insertmattach",file);
	}

}
