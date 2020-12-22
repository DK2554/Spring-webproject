package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ConsultAttachmentAll {

	private int consultNo;
	private int memberSq;
	private String consultName;
	private String consultField;
	private String consultWork;
	private String consultAttachment;
	private String consultApproval;
	private Date consultDate;
	private int consultAttachemntno;
	private String originalFilename;
	private String renamedFilename;
	private Date uploadDate;
	private String status;
	
	public ConsultAttachmentAll() {
		// TODO Auto-generated constructor stub
	}

	public ConsultAttachmentAll(int consultNo, int memberSq, String consultName, String consultField,
			String consultWork, String consultAttachment, String consultApproval, Date consultDate,
			int consultAttachemntno, String originalFilename, String renamedFilename, Date uploadDate, String status) {
		super();
		this.consultNo = consultNo;
		this.memberSq = memberSq;
		this.consultName = consultName;
		this.consultField = consultField;
		this.consultWork = consultWork;
		this.consultAttachment = consultAttachment;
		this.consultApproval = consultApproval;
		this.consultDate = consultDate;
		this.consultAttachemntno = consultAttachemntno;
		this.originalFilename = originalFilename;
		this.renamedFilename = renamedFilename;
		this.uploadDate = uploadDate;
		this.status = status;
	}

	public int getConsultNo() {
		return consultNo;
	}

	public void setConsultNo(int consultNo) {
		this.consultNo = consultNo;
	}

	public int getMemberSq() {
		return memberSq;
	}

	public void setMemberSq(int memberSq) {
		this.memberSq = memberSq;
	}

	public String getConsultName() {
		return consultName;
	}

	public void setConsultName(String consultName) {
		this.consultName = consultName;
	}

	public String getConsultField() {
		return consultField;
	}

	public void setConsultField(String consultField) {
		this.consultField = consultField;
	}

	public String getConsultWork() {
		return consultWork;
	}

	public void setConsultWork(String consultWork) {
		this.consultWork = consultWork;
	}

	public String getConsultAttachment() {
		return consultAttachment;
	}

	public void setConsultAttachment(String consultAttachment) {
		this.consultAttachment = consultAttachment;
	}

	public String getConsultApproval() {
		return consultApproval;
	}

	public void setConsultApproval(String consultApproval) {
		this.consultApproval = consultApproval;
	}

	public Date getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}

	public int getConsultAttachemntno() {
		return consultAttachemntno;
	}

	public void setConsultAttachemntno(int consultAttachemntno) {
		this.consultAttachemntno = consultAttachemntno;
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
		return "ConsultAttachmentAll [consultNo=" + consultNo + ", memberSq=" + memberSq + ", consultName="
				+ consultName + ", consultField=" + consultField + ", consultWork=" + consultWork
				+ ", consultAttachment=" + consultAttachment + ", consultApproval=" + consultApproval + ", consultDate="
				+ consultDate + ", consultAttachemntno=" + consultAttachemntno + ", originalFilename="
				+ originalFilename + ", renamedFilename=" + renamedFilename + ", uploadDate=" + uploadDate + ", status="
				+ status + "]";
	}
	
	
}
