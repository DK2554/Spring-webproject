package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class Rboard {

	private int rboardNo;
	private int rboardId;
	private String rboardTitle;
	private String rboardContent;
	private String rboardWriter;
	private Date rboardDate;
	private String rboardStatus;
	private int rboardCount;
	
	public Rboard() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Rboard(int rboardNo, int rboardId, String rboardTitle, String rboardContent, String rboardWriter, 
			Date rboardDate, String rboardStatus, int rboardCount) {
		super();
		this.rboardNo = rboardNo;
		this.rboardId = rboardId;
		this.rboardTitle = rboardTitle;
		this.rboardContent = rboardContent;
		this.rboardWriter = rboardWriter;
		this.rboardDate = rboardDate;
		this.rboardStatus = rboardStatus;
		this.rboardCount = rboardCount;
	}

	public int getRboardNo() {
		return rboardNo;
	}

	public void setRboardNo(int rboardNo) {
		this.rboardNo = rboardNo;
	}

	public int getRboardId() {
		return rboardId;
	}

	public void setRboardId(int rboardId) {
		this.rboardId = rboardId;
	}

	public String getRboardTitle() {
		return rboardTitle;
	}

	public void setRboardTitle(String rboardTitle) {
		this.rboardTitle = rboardTitle;
	}

	public String getRboardWriter() {
		return rboardWriter;
	}

	public void setRboardWriter(String rboardWriter) {
		this.rboardWriter = rboardWriter;
	}

	public String getRboardContent() {
		return rboardContent;
	}

	public void setRboardContent(String rboardContent) {
		this.rboardContent = rboardContent;
	}

	public Date getRboardDate() {
		return rboardDate;
	}

	public void setRboardDate(Date rboardDate) {
		this.rboardDate = rboardDate;
	}

	public String getRboardStatus() {
		return rboardStatus;
	}

	public void setRboardStatus(String rboardStatus) {
		this.rboardStatus = rboardStatus;
	}

	public int getRboardCount() {
		return rboardCount;
	}

	public void setRboardCount(int rboardCount) {
		this.rboardCount = rboardCount;
	}

	@Override
	public String toString() {
		return "Rboard [rboardNo=" + rboardNo + ", rboardId=" + rboardId + ", rboardTitle=" + rboardTitle
				+ ", rboardWriter=" + rboardWriter + ", rboardContent=" + rboardContent + ", rboardDate=" + rboardDate
				+ ", rboardStatus=" + rboardStatus + ", rboardCount=" + rboardCount + "]";
	}

	
	
}
