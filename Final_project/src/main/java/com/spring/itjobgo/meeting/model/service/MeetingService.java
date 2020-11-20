package com.spring.itjobgo.meeting.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.meeting.model.vo.Mboard;


public interface MeetingService {

	int insertMboard(Map param, List<Mattachment> files);

	List<Mboard> selectMlist();

	Mboard selectMb(int no);

}
