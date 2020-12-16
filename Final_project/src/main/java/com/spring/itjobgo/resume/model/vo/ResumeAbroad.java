package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeAbroad {

	private int resumeAbroadno;
	private int resumeNo;
	private String abroad;
	private Date abroadStartDate;
	private Date abroadFinishDate;
	private String abroadCountury;
	private String abroadAgency;
	private String abroadDetail;

	public ResumeAbroad() {
		// TODO Auto-generated constructor stub
	}

	public ResumeAbroad(int resumeAbroadno, int resumeNo, String abroad, Date abroadStartDate, Date abroadFinishDate,
			String abroadCountury, String abroadAgency, String abroadDetail) {
		super();
		this.resumeAbroadno = resumeAbroadno;
		this.resumeNo = resumeNo;
		this.abroad = abroad;
		this.abroadStartDate = abroadStartDate;
		this.abroadFinishDate = abroadFinishDate;
		this.abroadCountury = abroadCountury;
		this.abroadAgency = abroadAgency;
		this.abroadDetail = abroadDetail;
	}

	public int getResumeAbroadno() {
		return resumeAbroadno;
	}

	public void setResumeAbroadno(int resumeAbroadno) {
		this.resumeAbroadno = resumeAbroadno;
	}

	public int getResumeNo() {
		return resumeNo;
	}

	public void setResumeNo(int resumeNo) {
		this.resumeNo = resumeNo;
	}

	public String getAbroad() {
		return abroad;
	}

	public void setAbroad(String abroad) {
		this.abroad = abroad;
	}

	public Date getAbroadStartDate() {
		return abroadStartDate;
	}

	public void setAbroadStartDate(Date abroadStartDate) {
		this.abroadStartDate = abroadStartDate;
	}

	public Date getAbroadFinishDate() {
		return abroadFinishDate;
	}

	public void setAbroadFinishDate(Date abroadFinishDate) {
		this.abroadFinishDate = abroadFinishDate;
	}

	public String getAbroadCountury() {
		return abroadCountury;
	}

	public void setAbroadCountury(String abroadCountury) {
		this.abroadCountury = abroadCountury;
	}

	public String getAbroadAgency() {
		return abroadAgency;
	}

	public void setAbroadAgency(String abroadAgency) {
		this.abroadAgency = abroadAgency;
	}

	public String getAbroadDetail() {
		return abroadDetail;
	}

	public void setAbroadDetail(String abroadDetail) {
		this.abroadDetail = abroadDetail;
	}

	@Override
	public String toString() {
		return "ResumeAbroad [resumeAbroadno=" + resumeAbroadno + ", resumeNo=" + resumeNo + ", abroad=" + abroad
				+ ", abroadStartDate=" + abroadStartDate + ", abroadFinishDate=" + abroadFinishDate
				+ ", abroadCountury=" + abroadCountury + ", abroadAgency=" + abroadAgency + ", abroadDetail="
				+ abroadDetail + "]";
	}
	
	
}
