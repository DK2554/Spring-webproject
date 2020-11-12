package com.spring.itjobgo.portfolio.model.vo;

import java.sql.Date;

public class Attachment {
	private int attachementNo;
	private int pboardNo;
	private String orginalFilename;
	private String renameFilename;
	private Date uploadDate;
	private String status; 
	
	public Attachment() {
		// TODO Auto-generated constructor stub
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

	public String getOrginalFilename() {
		return orginalFilename;
	}

	public void setOrginalFilename(String orginalFilename) {
		this.orginalFilename = orginalFilename;
	}

	public String getRenameFilename() {
		return renameFilename;
	}

	public void setRenameFilename(String renameFilename) {
		this.renameFilename = renameFilename;
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
		return "Attachment [attachementNo=" + attachementNo + ", pboardNo=" + pboardNo + ", orginalFilename="
				+ orginalFilename + ", renameFilename=" + renameFilename + ", uploadDate=" + uploadDate + ", status="
				+ status + "]";
	}

	public Attachment(int attachementNo, int pboardNo, String orginalFilename, String renameFilename, Date uploadDate,
			String status) {
		super();
		this.attachementNo = attachementNo;
		this.pboardNo = pboardNo;
		this.orginalFilename = orginalFilename;
		this.renameFilename = renameFilename;
		this.uploadDate = uploadDate;
		this.status = status;
	}


	
}
