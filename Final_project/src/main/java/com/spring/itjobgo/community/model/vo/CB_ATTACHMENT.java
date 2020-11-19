package com.spring.itjobgo.community.model.vo;

import java.sql.Date;

import lombok.Data;


public class CB_ATTACHMENT {
	
	private int attachmentno;
	private int boardSq;
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

	public int getBoardSq() {
		return boardSq;
	}

	public void setBoardSq(int boardSq) {
		this.boardSq = boardSq;
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
		return "CB_ATTACHMENT [attachmentno=" + attachmentno + ", boardSq=" + boardSq + ", originalfilename="
				+ originalfilename + ", renamedfilename=" + renamedfilename + ", uploaddate=" + uploaddate + ", status="
				+ status + "]";
	}

	public CB_ATTACHMENT(int attachmentno, int boardSq, String originalfilename, String renamedfilename,
			Date uploaddate, String status) {
		super();
		this.attachmentno = attachmentno;
		this.boardSq = boardSq;
		this.originalfilename = originalfilename;
		this.renamedfilename = renamedfilename;
		this.uploaddate = uploaddate;
		this.status = status;
	}

    
	
	
	
	
}
