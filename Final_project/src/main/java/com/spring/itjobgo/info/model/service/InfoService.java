package com.spring.itjobgo.info.model.service;

import java.util.List;

import com.spring.itjobgo.info.model.vo.INFO_ATTACHMENT;
import com.spring.itjobgo.info.model.vo.Info;

public interface InfoService {
	
	List<Info> selectInfoList();

	int insertInfo(Info ifo, List<INFO_ATTACHMENT> files);

	Info selectInfoOne(int infoSq,boolean hasRead);
	
	int deleteInfo(int infoSq);
	
	INFO_ATTACHMENT selectAttach(int infoSq);

	int updateInfo(Info ifo,List<INFO_ATTACHMENT>files);
	
	int updateInfo(Info ifo);

}


