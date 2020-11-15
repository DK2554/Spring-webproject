package com.spring.itjobgo.community.model.vo;

import java.sql.Date;

import lombok.Data;


public class CB_ATTACHMENT {
	
	private int attachmentno;
	private int pboardNo;
	private String originalfilename;
	private String renamedfilename;
	private Date uploaddate;
	private String status;

	public CB_ATTACHMENT(int i, int j, String originalFileName2, String renameFileName, Object object, Object object2) {
		// TODO Auto-generated constructor stub
	}

	public int getAttachmentno() {
		return attachmentno;
	}

	public void setAttachmentno(int attachmentno) {
		this.attachmentno = attachmentno;
	}

	public int getPboardNo() {
		return pboardNo;
	}

	public void setPboardNo(int pboardNo) {
		this.pboardNo = pboardNo;
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

	@Override
	public String toString() {
		return "CB_ATTACHMENT [attachmentno=" + attachmentno + ", pboardNo=" + pboardNo + ", originalfilename="
				+ originalfilename + ", renamedfilename=" + renamedfilename + ", uploaddate=" + uploaddate + ", status="
				+ status + "]";
	}
	
	
}
