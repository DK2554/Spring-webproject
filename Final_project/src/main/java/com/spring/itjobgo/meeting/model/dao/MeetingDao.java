package com.spring.itjobgo.meeting.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.meeting.model.vo.Mboard;
import com.spring.itjobgo.meeting.model.vo.Tmpapply;


public interface MeetingDao {

	int insertMboard(SqlSessionTemplate session, Map param);

	int insertAttachment(SqlSessionTemplate session, Mattachment file);

	List<Mboard> selectMlist(SqlSessionTemplate session);

	Mboard selectMinfo(SqlSessionTemplate session, int no);

	int insertapply(SqlSessionTemplate session, Tmpapply tmp);

	Mattachment selectMattach(SqlSessionTemplate session, int no);

}
