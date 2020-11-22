package com.spring.itjobgo.notice.model.vo;

import java.sql.Date;

public class NoticeAttachment {
	
	private int attachmentno;
	private int noticeSq;
	private String originalfilename;
	private String renamedfilename;
	private Date uploaddate;
	private String status;

	public NoticeAttachment() {
		// TODO Auto-generated constructor stub
	}

	public int getAttachmentno() {
		return attachmentno;
	}

	public void setAttachmentno(int attachmentno) {
		this.attachmentno = attachmentno;
	}

	public int getNoticeSq() {
		return noticeSq;
	}

	public void setNoticeSq(int noticeSq) {
		this.noticeSq = noticeSq;
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
		return "NoticeAttachment [attachmentno=" + attachmentno + ", noticeSq=" + noticeSq + ", originalfilename="
				+ originalfilename + ", renamedfilename=" + renamedfilename + ", uploaddate=" + uploaddate + ", status="
				+ status + "]";
	}

	public NoticeAttachment(int attachmentno, int noticeSq, String originalfilename, String renamedfilename,
			Date uploaddate, String status) {
		super();
		this.attachmentno = attachmentno;
		this.noticeSq = noticeSq;
		this.originalfilename = originalfilename;
		this.renamedfilename = renamedfilename;
		this.uploaddate = uploaddate;
		this.status = status;
	}
	
	
	
}
