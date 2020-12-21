package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class Consult {

	private int consultNo;
	private int memberSq;
	private String consultName;
	private String consultField;
	private String consultWork;
	private String consultAttachment;
	private String consultApproval;
	private Date consultDate;
	
	
	public Consult() {
		// TODO Auto-generated constructor stub
	}


	public Consult(int consultNo, int memberSq, String consultName, String consultField, String consultWork,
			String consultAttachment, String consultApproval, Date consultDate) {
		super();
		this.consultNo = consultNo;
		this.memberSq = memberSq;
		this.consultName = consultName;
		this.consultField = consultField;
		this.consultWork = consultWork;
		this.consultAttachment = consultAttachment;
		this.consultApproval = consultApproval;
		this.consultDate = consultDate;
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


	@Override
	public String toString() {
		return "ResumeConsult [consultNo=" + consultNo + ", memberSq=" + memberSq + ", consultName=" + consultName
				+ ", consultField=" + consultField + ", consultWork=" + consultWork + ", consultAttachment="
				+ consultAttachment + ", consultApproval=" + consultApproval + ", consultDate=" + consultDate + "]";
	}
	
	
}
