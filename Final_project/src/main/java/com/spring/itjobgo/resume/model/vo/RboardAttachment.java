package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class RboardAttachment {

	private int rboardAttachmentno;
	private int rboardNo;
	private String originalFilename;
	private String renamedFilename;
	private Date uploadDate;
	private String status;
	
	public RboardAttachment() {
		// TODO Auto-generated constructor stub
	}

	public RboardAttachment(int rboardAttachmentno, int rboardNo, String originalFilename, String renamedFilename,
			Date uploadDate, String status) {
		super();
		this.rboardAttachmentno = rboardAttachmentno;
		this.rboardNo = rboardNo;
		this.originalFilename = originalFilename;
		this.renamedFilename = renamedFilename;
		this.uploadDate = uploadDate;
		this.status = status;
	}

	public int getRboardAttachmentno() {
		return rboardAttachmentno;
	}

	public void setRboardAttachmentno(int rboardAttachmentno) {
		this.rboardAttachmentno = rboardAttachmentno;
	}

	public int getRboardNo() {
		return rboardNo;
	}

	public void setRboardNo(int rboardNo) {
		this.rboardNo = rboardNo;
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
		return "RboardAttachment [rboardAttachmentno=" + rboardAttachmentno + ", rboardNo=" + rboardNo
				+ ", originalFilename=" + originalFilename + ", renamedFilename=" + renamedFilename + ", uploadDate="
				+ uploadDate + ", status=" + status + "]";
	}

	
}