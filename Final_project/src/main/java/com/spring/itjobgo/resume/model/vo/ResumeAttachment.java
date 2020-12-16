package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeAttachment {

	private int resumeAttachmentno;
	private int resumeNo;
	private String originalFilename;
	private String renamedFilename;
	private Date uploadDate;
	private String status;
	public ResumeAttachment(int resumeAttachmentno, int resumeNo, String originalFilename, String renamedFilename,
			Date uploadDate, String status) {
		super();
		this.resumeAttachmentno = resumeAttachmentno;
		this.resumeNo = resumeNo;
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
	public int getResumeNo() {
		return resumeNo;
	}
	public void setResumeNo(int resumeNo) {
		this.resumeNo = resumeNo;
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
		return "ResumeAttachment [resumeAttachmentno=" + resumeAttachmentno + ", resumeNo=" + resumeNo
				+ ", originalFilename=" + originalFilename + ", renamedFilename=" + renamedFilename + ", uploadDate="
				+ uploadDate + ", status=" + status + "]";
	}
	
	
	
	
}
