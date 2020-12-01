package com.spring.itjobgo.info.model.vo;

import java.sql.Date;


public class INFO_ATTACHMENT {
	
	private int attachmentno;
	private int infoSq;
	private String originalfilename;
	private String renamedfilename;
	private Date uploaddate;
	private String status;

	public INFO_ATTACHMENT() {
	}

	public int getAttachmentno() {
		return attachmentno;
	}

	public void setAttachmentno(int attachmentno) {
		this.attachmentno = attachmentno;
	}

	public int getInfoSq() {
		return infoSq;
	}

	public void setInfoSq(int infoSq) {
		this.infoSq = infoSq;
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
		return "INFO_ATTACHMENT [attachmentno=" + attachmentno + ", infoSq=" + infoSq + ", originalfilename="
				+ originalfilename + ", renamedfilename=" + renamedfilename + ", uploaddate=" + uploaddate + ", status="
				+ status + "]";
	}

	public INFO_ATTACHMENT(int attachmentno, int infoSq, String originalfilename, String renamedfilename,
			Date uploaddate, String status) {
		super();
		this.attachmentno = attachmentno;
		this.infoSq = infoSq;
		this.originalfilename = originalfilename;
		this.renamedfilename = renamedfilename;
		this.uploaddate = uploaddate;
		this.status = status;
	}
	
}