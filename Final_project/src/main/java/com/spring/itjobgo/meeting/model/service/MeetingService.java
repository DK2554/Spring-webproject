package com.spring.itjobgo.meeting.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.meeting.model.vo.Mboard;
import com.spring.itjobgo.meeting.model.vo.Tmpapply;
import com.spring.itjobgo.member.model.vo.Member;


public interface MeetingService {

	int insertMboard(Map param, List<Mattachment> files);

	List<Mboard> selectMlist();

	Mboard selectMb(int no);

	int insertapply(int memberSq, String postion, int collabSq, int writerNo);

	Mattachment selectMat(int no);

	List<Tmpapply> selectapply(int i);

	Member selectOneMember(String email);

	List<Mboard> selectMlist(int memberSq);

	

}
