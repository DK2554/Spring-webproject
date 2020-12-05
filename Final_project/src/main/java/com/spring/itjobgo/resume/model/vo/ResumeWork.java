package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeWork {

	private int resumeWorkno;
	private int memberNo;
	private Date workStartDate;
	private Date workFinishDate;
	private String workName;
	private String workLevel;
	private String workState;
	private String workDetail;
	
	public ResumeWork() {
		// TODO Auto-generated constructor stub
	}

	public ResumeWork(int resumeWorkno, int memberNo, Date workStartDate, Date workFinishDate, String workName,
			String workLevel, String workState, String workDetail) {
		super();
		this.resumeWorkno = resumeWorkno;
		this.memberNo = memberNo;
		this.workStartDate = workStartDate;
		this.workFinishDate = workFinishDate;
		this.workName = workName;
		this.workLevel = workLevel;
		this.workState = workState;
		this.workDetail = workDetail;
	}

	public int getResumeWorkno() {
		return resumeWorkno;
	}

	public void setResumeWorkno(int resumeWorkno) {
		this.resumeWorkno = resumeWorkno;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Date getWorkStartDate() {
		return workStartDate;
	}

	public void setWorkStartDate(Date workStartDate) {
		this.workStartDate = workStartDate;
	}

	public Date getWorkFinishDate() {
		return workFinishDate;
	}

	public void setWorkFinishDate(Date workFinishDate) {
		this.workFinishDate = workFinishDate;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getWorkLevel() {
		return workLevel;
	}

	public void setWorkLevel(String workLevel) {
		this.workLevel = workLevel;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getWorkDetail() {
		return workDetail;
	}

	public void setWorkDetail(String workDetail) {
		this.workDetail = workDetail;
	}

	@Override
	public String toString() {
		return "ResumeWork [resumeWorkno=" + resumeWorkno + ", memberNo=" + memberNo + ", workStartDate="
				+ workStartDate + ", workFinishDate=" + workFinishDate + ", workName=" + workName + ", workLevel="
				+ workLevel + ", workState=" + workState + ", workDetail=" + workDetail + "]";
	}
	
	
}
