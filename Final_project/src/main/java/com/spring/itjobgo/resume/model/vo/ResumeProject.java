package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeProject {

	private int resumeProjectno;
	private int memberNo;
	private String projectPart;
	private Date projectStartDate;
	private Date projectFinishDate;
	private String projectName;
	private String projectWork;
	private String projectDetail;
	
	public ResumeProject() {
		// TODO Auto-generated constructor stub
	}

	public ResumeProject(int resumeProjectno, int memberNo, String projectPart, Date projectStartDate,
			Date projectFinishDate, String projectName, String projectWork, String projectDetail) {
		super();
		this.resumeProjectno = resumeProjectno;
		this.memberNo = memberNo;
		this.projectPart = projectPart;
		this.projectStartDate = projectStartDate;
		this.projectFinishDate = projectFinishDate;
		this.projectName = projectName;
		this.projectWork = projectWork;
		this.projectDetail = projectDetail;
	}

	public int getResumeProjectno() {
		return resumeProjectno;
	}

	public void setResumeProjectno(int resumeProjectno) {
		this.resumeProjectno = resumeProjectno;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getProjectPart() {
		return projectPart;
	}

	public void setProjectPart(String projectPart) {
		this.projectPart = projectPart;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectFinishDate() {
		return projectFinishDate;
	}

	public void setProjectFinishDate(Date projectFinishDate) {
		this.projectFinishDate = projectFinishDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectWork() {
		return projectWork;
	}

	public void setProjectWork(String projectWork) {
		this.projectWork = projectWork;
	}

	public String getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}

	@Override
	public String toString() {
		return "ResumeProject [resumeProjectno=" + resumeProjectno + ", memberNo=" + memberNo + ", projectPart="
				+ projectPart + ", projectStartDate=" + projectStartDate + ", projectFinishDate=" + projectFinishDate
				+ ", projectName=" + projectName + ", projectWork=" + projectWork + ", projectDetail=" + projectDetail
				+ "]";
	}
	
	
}
