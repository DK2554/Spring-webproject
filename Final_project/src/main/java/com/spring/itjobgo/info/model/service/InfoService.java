package com.spring.itjobgo.info.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.community.model.vo.CB_ATTACHMENT;
import com.spring.itjobgo.community.model.vo.CommunityBoard;
import com.spring.itjobgo.info.model.vo.Info;

public interface InfoService {
	
	List<Info> selectInfoList();

	int insertInfo(Info cb, List<CB_ATTACHMENT> files);



}
