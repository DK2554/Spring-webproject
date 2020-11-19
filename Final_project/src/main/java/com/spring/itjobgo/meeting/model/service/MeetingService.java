package com.spring.itjobgo.meeting.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.meeting.model.vo.Mattachment;


public interface MeetingService {

	int insertMboard(Map param, List<Mattachment> files);

}
