package com.spring.itjobgo.info.model.vo;

import java.sql.Date;

import lombok.Data;


public class INFO_ATTACHMENT {
	
	private int attachmentno;
	private int infoNo;
	private String originalfilename;
	private String renamedfilename;
	private Date uploaddate;
	private String status;

	public INFO_ATTACHMENT() {
		// TODO Auto-generated constructor stub
	}

	public int getAttachmentno() {
		return attachmentno;
	}

	public void setAttachmentno(int attachmentno) {
		this.attachmentno = attachmentno;
	}

	public int getInfoNo() {
		return infoNo;
	}

	public void setgetInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}

	public String getOriginalfilename() {
		return originalfilename;
	}

	public void setOriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}

	public String getRenamedfilename() {
		return renamedfilename;
	}

	public void setRenamedfilename(String renamedfilename) {
		this.renamedfilename = renamedfilename;
	}

	public Date getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public INFO_ATTACHMENT(int attachmentno, int infoNo, String originalfilename, String renamedfilename,
			Date uploaddate, String status) {
		super();
		this.attachmentno = attachmentno;
		this.infoNo = infoNo;
		this.originalfilename = originalfilename;
		this.renamedfilename = renamedfilename;
		this.uploaddate = uploaddate;
		this.status = status;
	}
	
	
}
