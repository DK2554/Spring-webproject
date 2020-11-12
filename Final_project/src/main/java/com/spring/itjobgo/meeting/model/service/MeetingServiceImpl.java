package com.spring.itjobgo.meeting.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.itjobgo.meeting.model.dao.MeetingDao;

@Service
public class MeetingServiceImpl implements MeetingService {
	@Autowired
	private MeetingDao dao;

}
