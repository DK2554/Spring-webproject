package com.spring.itjobgo.info.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import com.spring.itjobgo.info.model.vo.InfoBoard;
public interface InfoBoardDao {
	
	
	List<InfoBoard> selectInfoBoardList(SqlSessionTemplate session);
	

}
