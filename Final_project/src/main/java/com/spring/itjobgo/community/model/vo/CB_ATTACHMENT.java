package com.spring.itjobgo.community.model.vo;

import java.sql.Date;

import lombok.Data;


public class CB_ATTACHMENT {
	
	private int attachmentno;
	private int cbBoardNo;
	private String originalfilename;
	private String renamedfilename;
	private Date uploaddate;
	private String status;

	public CB_ATTACHMENT() {
		// TODO Auto-generated constructor stub
	}

	public int getAttachmentno() {
		return attachmentno;
	}

	public void setAttachmentno(int attachmentno) {
		this.attachmentno = attachmentno;
	}

	public int getCbBoardNo() {
		return cbBoardNo;
	}

	public void setCbBoardNo(int cbBoardNo) {
		this.cbBoardNo = cbBoardNo;
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

	public CB_ATTACHMENT(int attachmentno, int cbBoardNo, String originalfilename, String renamedfilename,
			Date uploaddate, String status) {
		super();
		this.attachmentno = attachmentno;
		this.cbBoardNo = cbBoardNo;
		this.originalfilename = originalfilename;
		this.renamedfilename = renamedfilename;
		this.uploaddate = uploaddate;
		this.status = status;
	}
	
	
}
