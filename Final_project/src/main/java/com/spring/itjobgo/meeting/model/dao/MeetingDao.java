package com.spring.itjobgo.meeting.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.meeting.model.vo.Mboard;
import com.spring.itjobgo.meeting.model.vo.Tmpapply;
import com.spring.itjobgo.member.model.vo.Member;


public interface MeetingDao {

	int insertMboard(SqlSessionTemplate session, Map param);

	int insertAttachment(SqlSessionTemplate session, Mattachment file);

	List<Mboard> selectMlist(SqlSessionTemplate session);

	Mboard selectMinfo(SqlSessionTemplate session, int no);

	int insertapply(SqlSessionTemplate session, Tmpapply tmp);

	Mattachment selectMattach(SqlSessionTemplate session, int no);

	List<Tmpapply> selectapply(SqlSessionTemplate session, String email);

	Member selectMemberOne(SqlSessionTemplate session, String email);

	List<Mboard> selectMlist(SqlSessionTemplate session, int memberSq);

}
