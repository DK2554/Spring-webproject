package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeAttachment {

	private int resumeAttachmentno;
	private int memberNo;
	private String originalFilename;
	private String renamedFilename;
	private Date uploadDate;
	private String status;
	
	public ResumeAttachment() {
		// TODO Auto-generated constructor stub
	}

	public ResumeAttachment(int resumeAttachmentno, int memberNo, String originalFilename, String renamedFilename,
			Date uploadDate, String status) {
		super();
		this.resumeAttachmentno = resumeAttachmentno;
		this.memberNo = memberNo;
		this.originalFilename = originalFilename;
		this.renamedFilename = renamedFilename;
		this.uploadDate = uploadDate;
		this.status = status;
	}

	public int getResumeAttachmentno() {
		return resumeAttachmentno;
	}

	public void setResumeAttachmentno(int resumeAttachmentno) {
		this.resumeAttachmentno = resumeAttachmentno;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getRenamedFilename() {
		return renamedFilename;
	}

	public void setRenamedFilename(String renamedFilename) {
		this.renamedFilename = renamedFilename;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Resume_Attachment [resumeAttachmentno=" + resumeAttachmentno + ", memberNo=" + memberNo
				+ ", originalFilename=" + originalFilename + ", renamedFilename=" + renamedFilename + ", status="
				+ status + "]";
	}
	
	
}
