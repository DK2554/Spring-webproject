package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeList {

	private int resumeListno;
	private int memberNo;
	private int resumeNo;
	private String resumelistTitle;
	private String resumelistWriter;
	private Date resumelistDate;
	private String resumelistStatus;
	private String resumelistAttachment;
	private int resumelistCount;
	
	public ResumeList() {
		// TODO Auto-generated constructor stub
	}

	public ResumeList(int resumeListno, int memberNo, int resumeNo, String resumelistTitle, String resumelistWriter,
			Date resumelistDate, String resumelistStatus, String resumelistAttachment, int resumelistCount) {
		super();
		this.resumeListno = resumeListno;
		this.memberNo = memberNo;
		this.resumeNo = resumeNo;
		this.resumelistTitle = resumelistTitle;
		this.resumelistWriter = resumelistWriter;
		this.resumelistDate = resumelistDate;
		this.resumelistStatus = resumelistStatus;
		this.resumelistAttachment = resumelistAttachment;
		this.resumelistCount = resumelistCount;
	}

	public int getResumeListno() {
		return resumeListno;
	}

	public void setResumeListno(int resumeListno) {
		this.resumeListno = resumeListno;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getResumeNo() {
		return resumeNo;
	}

	public void setResumeNo(int resumeNo) {
		this.resumeNo = resumeNo;
	}

	public String getResumelistTitle() {
		return resumelistTitle;
	}

	public void setResumelistTitle(String resumelistTitle) {
		this.resumelistTitle = resumelistTitle;
	}

	public String getResumelistWriter() {
		return resumelistWriter;
	}

	public void setResumelistWriter(String resumelistWriter) {
		this.resumelistWriter = resumelistWriter;
	}

	public Date getResumelistDate() {
		return resumelistDate;
	}

	public void setResumelistDate(Date resumelistDate) {
		this.resumelistDate = resumelistDate;
	}

	public String getResumelistStatus() {
		return resumelistStatus;
	}

	public void setResumelistStatus(String resumelistStatus) {
		this.resumelistStatus = resumelistStatus;
	}

	public String getResumelistAttachment() {
		return resumelistAttachment;
	}

	public void setResumelistAttachment(String resumelistAttachment) {
		this.resumelistAttachment = resumelistAttachment;
	}

	public int getResumelistCount() {
		return resumelistCount;
	}

	public void setResumelistCount(int resumelistCount) {
		this.resumelistCount = resumelistCount;
	}

	@Override
	public String toString() {
		return "ResumeList [resumeListno=" + resumeListno + ", memberNo=" + memberNo + ", resumeNo=" + resumeNo
				+ ", resumelistTitle=" + resumelistTitle + ", resumelistWriter=" + resumelistWriter
				+ ", resumelistDate=" + resumelistDate + ", resumelistStatus=" + resumelistStatus
				+ ", resumelistAttachment=" + resumelistAttachment + ", resumelistCount=" + resumelistCount + "]";
	}

	
	
}
