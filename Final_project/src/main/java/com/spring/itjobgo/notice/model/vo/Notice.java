package com.spring.itjobgo.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int noticeSq;
	private String noticeDivision;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeDate;
	private int noticeReadCount;
	private int memberNum;
	private int noticeId;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public int getNoticeSq() {
		return noticeSq;
	}

	public void setNoticeSq(int noticeSq) {
		this.noticeSq = noticeSq;
	}

	public String getNoticeDivision() {
		return noticeDivision;
	}

	public void setNoticeDivision(String noticeDivision) {
		this.noticeDivision = noticeDivision;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getNoticeReadCount() {
		return noticeReadCount;
	}

	public void setNoticeReadCount(int noticeReadCount) {
		this.noticeReadCount = noticeReadCount;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	@Override
	public String toString() {
		return "Notice [noticeSq=" + noticeSq + ", noticeDivision=" + noticeDivision + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + ", noticeReadCount="
				+ noticeReadCount + ", memberNum=" + memberNum + ", noticeId=" + noticeId + "]";
	}

	public Notice(int noticeSq, String noticeDivision, String noticeTitle, String noticeContent, Date noticeDate,
			int noticeReadCount, int memberNum, int noticeId) {
		super();
		this.noticeSq = noticeSq;
		this.noticeDivision = noticeDivision;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeReadCount = noticeReadCount;
		this.memberNum = memberNum;
		this.noticeId = noticeId;
	}
	
	
	

}
