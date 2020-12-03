package com.spring.itjobgo.meeting.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.meeting.model.vo.Mboard;
import com.spring.itjobgo.meeting.model.vo.Tmpapply;


@Repository
public class MeetingDaoImpl implements MeetingDao {

	@Override
	public int insertMboard(SqlSessionTemplate session, Map param) {
		// TODO Auto-generated method stub
		return session.insert("meeting.insertmboard",param);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, Mattachment file) {
		// TODO Auto-generated method stub
		return session.insert("meeting.insertmattach",file);
	}

	@Override
	public Mattachment selectMattach(SqlSessionTemplate session, int no) {
		// TODO Auto-generated method stub
		return session.selectOne("meeting.selectmattach",no);
	}

	@Override
	public Mboard selectMinfo(SqlSessionTemplate session, int no) {
		// TODO Auto-generated method stub
		return session.selectOne("meeting.selectminfo",no);
	}

	@Override
	public int insertapply(SqlSessionTemplate session, Tmpapply tmp) {
		// TODO Auto-generated method stub
		return session.insert("meeting.inserttapply",tmp);
	}

	@Override
	public List<Mboard> selectMlist(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("meeting.selectmList");
	}

}
