package com.spring.itjobgo.meeting.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.itjobgo.meeting.model.vo.Approve;
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

	

	Member selectMemberOne(SqlSessionTemplate session, String email);

	List<Mboard> selectMlist(SqlSessionTemplate session, int memberSq);

	List<Tmpapply> selectapply(SqlSessionTemplate session, int no);

	String selectMembername(SqlSessionTemplate session, int memberSq);

	String selectMboardname(SqlSessionTemplate session, int collabSq);

	Tmpapply selectOneapply(SqlSessionTemplate session, int no);

	int insertApprove(SqlSessionTemplate session, Approve ap);

	int deleteapply(SqlSessionTemplate session, int no);

	List<Approve> selectApprove(SqlSessionTemplate session, int no);

	int deletemeeting(SqlSessionTemplate session, int no);

	int updatemeeting(SqlSessionTemplate session, Map param);

	int updateattachment(SqlSessionTemplate session, Mattachment file);

}
