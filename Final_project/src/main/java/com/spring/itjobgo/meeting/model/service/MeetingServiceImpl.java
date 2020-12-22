package com.spring.itjobgo.meeting.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.itjobgo.meeting.model.dao.MeetingDao;
import com.spring.itjobgo.meeting.model.vo.Approve;
import com.spring.itjobgo.meeting.model.vo.Mattachment;
import com.spring.itjobgo.meeting.model.vo.Mboard;
import com.spring.itjobgo.meeting.model.vo.Mcount;
import com.spring.itjobgo.meeting.model.vo.Tmpapply;
import com.spring.itjobgo.member.model.vo.Member;
import com.spring.itjobgo.portfolio.model.vo.Attachment;

@Service
public class MeetingServiceImpl implements MeetingService {
	@Autowired
	private MeetingDao dao;
	@Autowired
	private SqlSessionTemplate session;
	@Transactional
	@Override
	public int insertMboard(Map param, List<Mattachment> files) {
		// TODO Auto-generated method stub
		int result = dao.insertMboard(session, param);
		int check = dao.insertcount(session, param);
		if (result == 0)
			throw new RuntimeException("입력오류");
		if (result > 0) {
			// 모임 생성되면 모임 인원확인하는 테이블에도 생성
			System.out.println(check);
			if (!files.isEmpty()) {
				// files에 데이터가 있으면
				for (Mattachment file : files) {
					result = dao.insertAttachment(session, file);
					if (result == 0)
						throw new RuntimeException("입력오류");
				}
			}

		}
		return result;
	}

	@Override
	public Integer selectapplycheck(Tmpapply tmp) {
		// TODO Auto-generated method stub
		return dao.selectapplycheck(session, tmp);
	}
	@Transactional
	@Override
	public int updatedcount(Map param) {
		// TODO Auto-generated method stub
		return dao.updatedcount(session, param);
	}

	@Override
	public List enterList(int no) {
		// TODO Auto-generated method stub
		return dao.enterList(session, no);
	}

	@Override
	public Mcount joinmcount(int no) {
		// TODO Auto-generated method stub
		return dao.joincount(session, no);
	}

	@Override
	public Mattachment selectMat(int no) {
		// TODO Auto-generated method stub
		// 번호로 첨부파일 db연동
		return dao.selectMattach(session, no);
	}

	@Override
	public List<Mboard> selectendlist() {
		// TODO Auto-generated method stub
		return dao.selectendList(session);
	}
	@Transactional
	@Override
	public int updatedstatus(Tmpapply tmp) {
		// TODO Auto-generated method stub
		return dao.updatestatus(session,tmp);
	}

	@Override
	public Mcount selectcount(Tmpapply tmp) {
		// TODO Auto-generated method stub
		return dao.selectcount(session, tmp);
	}

	@Override
	public Mboard selectMb(int no) {
		// TODO Auto-generated method stub
		return dao.selectMinfo(session, no);
	}

	@Transactional
	@Override
	public int insertapply(Tmpapply tmp) {
		// TODO Auto-generated method stub
		// 없으면 0 있으면 을 반환 0이면 임시에 넣는다.
		return dao.insertapply(session, tmp);

	}

	@Override
	public int selectapply(Tmpapply tmp) {
		// TODO Auto-generated method stub
		return dao.selectapply(session, tmp);
	}

	@Override
	public String selectMboardname(int collabSq) {
		// TODO Auto-generated method stub

		return dao.selectMboardname(session, collabSq);
	}

	@Override
	public int deleteapply(Tmpapply tmp) {
		// TODO Auto-generated method stub
		return dao.deleteapply(session, tmp);
	}

	@Override
	public String selectmembername(int memberSq) {
		// TODO Auto-generated method stub

		return dao.selectMembername(session, memberSq);
	}

	@Override
	public Tmpapply selectOneapply(int no) {
		// TODO Auto-generated method stub
		return dao.selectOneapply(session, no);
	}
	@Transactional
	@Override
	public int insertApprove(Approve ap) {
		// TODO Auto-generated method stub
		return dao.insertApprove(session, ap);
	}

	@Override
	public int selecttno(Tmpapply tmp) {
		// TODO Auto-generated method stub
		return dao.selecttno(session, tmp);
	}

	@Override
	public List<Approve> selectApprove(int no) {
		// TODO Auto-generated method stub
		return dao.selectApprove(session, no);
	}

	@Override
	public int deleteapply(int no) {
		// TODO Auto-generated method stub
		return dao.deleteapply(session, no);
	}

	@Override
	public List<Tmpapply> selectapply(int no) {
		// TODO Auto-generated method stub
		return dao.selectapply(session, no);
	}

	@Override
	public List<Mboard> selectMlist() {
		// TODO Auto-generated method stub
		return dao.selectMlist(session);
	}

	@Override
	public Member selectOneMember(String email) {
		// TODO Auto-generated method stub
		Member m = dao.selectMemberOne(session, email);

		// return
		return m;

	}

	@Override
	public List<Mboard> selectMklist(int memberSq) {
		// TODO Auto-generated method stub
		List<Mboard> list = dao.selectMklist(session, memberSq);
		System.out.println(list.toString());
		return list;
	}
	@Transactional
	@Override
	public int updatedmeeting(Map param, List<Mattachment> files) {
		// TODO Auto-generated method stub
		int result = dao.updatemeeting(session, param);
		int check = dao.updatecount(session, param);
		if (result == 0)
			throw new RuntimeException("데이터입력오류");
		if (result > 0) {
			if (!files.isEmpty()) {
				// files에 데이터가 있으면
				for (Mattachment file : files) {
					result = dao.updateattachment(session, file);
					System.out.println(result);
					if (result == 0)
						throw new RuntimeException("이미지입력오류");
				}
			}

		}
		return result;
	}
	@Transactional
	@Override
	public int updatedmeeting(Map param) {
		// TODO Auto-generated method stub
		int result = dao.updatemeeting(session, param);
		int check = dao.updatecount(session, param);
		return result;
	}

	@Override
	public int deletemeeting(int no) {
		// TODO Auto-generated method stub
		return dao.deletemeeting(session, no);
	}

	@Override
	public List selectWaitList(int no) {
		return dao.selectWaitList(session, no);
	}

}
