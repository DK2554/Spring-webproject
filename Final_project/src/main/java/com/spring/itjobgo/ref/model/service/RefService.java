package com.spring.itjobgo.ref.model.service;

import java.util.List;

import com.spring.itjobgo.ref.model.vo.REF_SITE;
import com.spring.itjobgo.ref.model.vo.REF_SITE_ATTACHMENT;

public interface RefService {
	
	int insertSite(REF_SITE REFSITE, List<REF_SITE_ATTACHMENT> files);

}
