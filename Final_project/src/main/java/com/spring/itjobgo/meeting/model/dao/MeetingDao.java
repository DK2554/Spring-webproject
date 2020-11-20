package com.spring.itjobgo.meeting.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.meeting.model.vo.Mattachment;


public interface MeetingDao {

	int insertMboard(SqlSessionTemplate session, Map param);

	int insertAttachment(SqlSessionTemplate session, Mattachment file);

	int selectMlist(SqlSessionTemplate session);

}
