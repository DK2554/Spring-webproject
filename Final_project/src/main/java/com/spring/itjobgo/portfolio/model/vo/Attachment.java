package com.spring.itjobgo.portfolio.model.vo;

import java.sql.Date;

public class Attachment {
	private int attachementNo;
	private int pboardNo;
	private String originalFilename;
	private String renamedFilename;
	private Date uploadDate;
	private String status; 
	
	public Attachment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Attachment [attachementNo=" + attachementNo + ", pboardNo=" + pboardNo + ", originalFilename="
				+ originalFilename + ", renamedFilename=" + renamedFilename + ", uploadDate=" + uploadDate + ", status="
				+ status + "]";
	}

	public int getAttachementNo() {
		return attachementNo;
	}

	public void setAttachementNo(int attachementNo) {
		this.attachementNo = attachementNo;
	}

	public int getPboardNo() {
		return pboardNo;
	}

	public void setPboardNo(int pboardNo) {
		this.pboardNo = pboardNo;
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

	public Attachment(int attachementNo, int pboardNo, String originalFilename, String renamedFilename, Date uploadDate,
			String status) {
		super();
		this.attachementNo = attachementNo;
		this.pboardNo = pboardNo;
		this.originalFilename = originalFilename;
		this.renamedFilename = renamedFilename;
		this.uploadDate = uploadDate;
		this.status = status;
	}

	
	
}
