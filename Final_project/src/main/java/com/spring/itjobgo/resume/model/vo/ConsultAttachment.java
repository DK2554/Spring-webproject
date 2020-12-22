package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ConsultAttachment {

	private int consultAttachemntno;
	private int consultNo;
	private String originalFilename;
	private String renamedFilename;
	private Date uploadDate;
	private String status;
	
	public ConsultAttachment() {
		// TODO Auto-generated constructor stub
	}

	public ConsultAttachment(int consultAttachemntno, int consultNo, String originalFilename, String renamedFilename,
			Date uploadDate, String status) {
		super();
		this.consultAttachemntno = consultAttachemntno;
		this.consultNo = consultNo;
		this.originalFilename = originalFilename;
		this.renamedFilename = renamedFilename;
		this.uploadDate = uploadDate;
		this.status = status;
	}

	public int getConsultAttachemntno() {
		return consultAttachemntno;
	}

	public void setConsultAttachemntno(int consultAttachemntno) {
		this.consultAttachemntno = consultAttachemntno;
	}

	public int getConsultNo() {
		return consultNo;
	}

	public void setConsultNo(int consultNo) {
		this.consultNo = consultNo;
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
		return "ConsultAttachment [consultAttachemntno=" + consultAttachemntno + ", consultNo=" + consultNo
				+ ", originalFilename=" + originalFilename + ", renamedFilename=" + renamedFilename + ", uploadDate="
				+ uploadDate + ", status=" + status + "]";
	}
	
	
}
