package com.spring.itjobgo.meeting.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.meeting.model.vo.Approve;
import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.meeting.model.vo.Mboard;
import com.spring.itjobgo.meeting.model.vo.Mcount;
import com.spring.itjobgo.meeting.model.vo.Tmpapply;
import com.spring.itjobgo.member.model.vo.Member;


public interface MeetingService {

	int insertMboard(Map param, List<Mattachment> files);

	List<Mboard> selectMlist();

	Mboard selectMb(int no);

	int insertapply(Tmpapply tmp);

	Mattachment selectMat(int no);

	List<Tmpapply> selectapply(int i);

	Member selectOneMember(String email);

	List<Mboard> selectMklist(int memberSq);

	String selectmembername(int memberSq);

	String selectMboardname(int collabSq);

	Tmpapply selectOneapply(int no);

	int insertApprove(Approve ap);

	int deleteapply(int no);

	List<Approve> selectApprove(int no);

	int deletemeeting(int no);

	int updatedmeeting(Map param, List<Mattachment> files);

	int updatedmeeting(Map param);

	int selectapply(Tmpapply tmp);

	int deleteapply(Tmpapply tmp);

	int selecttno(Tmpapply tmp);

	int updatedcount(Map param);

	Mcount selectcount(Tmpapply tmp);

	Integer selectapplycheck(Tmpapply tmp);

	

}
