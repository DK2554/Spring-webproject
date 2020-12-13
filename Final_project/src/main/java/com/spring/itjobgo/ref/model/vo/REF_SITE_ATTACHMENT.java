package com.spring.itjobgo.ref.model.vo;

import java.sql.Date;

public class REF_SITE_ATTACHMENT {

	private int attachmentNo;
	private int refNo;
	private String originalfilename;
	private String renamedfilename;
	private Date uploaddate;
	private String status;
	
	 public REF_SITE_ATTACHMENT() {
		// TODO Auto-generated constructor stub
	}

	public REF_SITE_ATTACHMENT(int attachmentNo, int refNo, String originalfilename, String renamedfilename,
			Date uploaddate, String status) {
		super();
		this.attachmentNo = attachmentNo;
		this.refNo = refNo;
		this.originalfilename = originalfilename;
		this.renamedfilename = renamedfilename;
		this.uploaddate = uploaddate;
		this.status = status;
	}

	public int getAttachmentNo() {
		return attachmentNo;
	}

	public void setAttachmentNo(int attachmentNo) {
		this.attachmentNo = attachmentNo;
	}

	public int getRefNo() {
		return refNo;
	}

	public void setRefNo(int refNo) {
		this.refNo = refNo;
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
		return "REF_SITE_ATTACHMENT [attachmentNo=" + attachmentNo + ", refNo=" + refNo + ", originalfilename="
				+ originalfilename + ", renamedfilename=" + renamedfilename + ", uploaddate=" + uploaddate + ", status="
				+ status + "]";
	}
	 
	
	
	
}
