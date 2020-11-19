package com.spring.itjobgo.info.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.info.model.vo.INFO_ATTACHMENT;
import com.spring.itjobgo.info.model.vo.Info;

public interface InfoService {
	
	List<Info> selectInfoList();

	int insertInfo(Info cb, List<INFO_ATTACHMENT> files);

	Info selectInfoOne(int infoSq);
	
	int deleteBoard(int infoSq);
	
	INFO_ATTACHMENT selectAttach(int infoSq);
}


