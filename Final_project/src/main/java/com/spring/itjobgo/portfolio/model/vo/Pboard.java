package com.spring.itjobgo.portfolio.model.vo;

import java.sql.Date;

public class Pboard {
	private int pboardNo;
	private int pboardId;
	private String pboardTitle;
	private String pboardWriter;
	private String pboardContent;
	private Date pboardDate;
	private String pboardStatus;
	private int pboardCount;
	public int getPboardId() {
		return pboardId;
	}

	public void setPboardId(int pboardId) {
		this.pboardId = pboardId;
	}

	
	
	public Pboard() {
		// TODO Auto-generated constructor stub
	}

	public int getPboardNo() {
		return pboardNo;
	}

	public void setPboardNo(int pboardNo) {
		this.pboardNo = pboardNo;
	}

	public String getPboardTitle() {
		return pboardTitle;
	}

	public void setPboardTitle(String pboardTitle) {
		this.pboardTitle = pboardTitle;
	}

	public String getPboardWriter() {
		return pboardWriter;
	}

	public void setPboardWriter(String pboardWriter) {
		this.pboardWriter = pboardWriter;
	}

	public String getPboardContent() {
		return pboardContent;
	}

	public void setPboardContent(String pboardContent) {
		this.pboardContent = pboardContent;
	}

	public Date getPboardDate() {
		return pboardDate;
	}

	public void setPboardDate(Date pboardDate) {
		this.pboardDate = pboardDate;
	}

	public String getPboardStatus() {
		return pboardStatus;
	}

	public void setPboardStatus(String pboardStatus) {
		this.pboardStatus = pboardStatus;
	}

	public int getPboardCount() {
		return pboardCount;
	}

	public void setPboardCount(int pboardCount) {
		this.pboardCount = pboardCount;
	}

	@Override
	public String toString() {
		return "Pboard [pboardNo=" + pboardNo + ", pboardId=" + pboardId+", pboardTitle=" + pboardTitle + ", pboardWriter=" + pboardWriter
				+ ", pboardContent=" + pboardContent + ", pboardDate=" + pboardDate + ", pboardStatus=" + pboardStatus
				+ ", pboardCount=" + pboardCount + "]";
	}

	public Pboard(int pboardNo, int pboardId ,String pboardTitle, String pboardWriter, String pboardContent, Date pboardDate,
			String pboardStatus, int pboardCount) {
		super();
		this.pboardNo = pboardNo;
		this.pboardId = pboardId;
		this.pboardTitle = pboardTitle;
		this.pboardWriter = pboardWriter;
		this.pboardContent = pboardContent;
		this.pboardDate = pboardDate;
		this.pboardStatus = pboardStatus;
		this.pboardCount = pboardCount;
	}

	

}
