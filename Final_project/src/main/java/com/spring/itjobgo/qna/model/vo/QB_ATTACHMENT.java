package com.spring.itjobgo.qna.model.vo;

import java.sql.Date;

//import lombok.Data;


public class QB_ATTACHMENT {
	
	private int attachmentno;
	private int qnaSeq;
	private String originalfilename;
	private String renamedfilename;
	private Date uploaddate;
	private String status;

public QB_ATTACHMENT() {
	// TODO Auto-generated constructor stub
}

public int getAttachmentno() {
	return attachmentno;
}

public void setAttachmentno(int attachmentno) {
	this.attachmentno = attachmentno;
}

public int getQnaSeq() {
	return qnaSeq;
}

public void setQnaSeq(int qnaSeq) {
	this.qnaSeq = qnaSeq;
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
	return "QB_ATTACHMENT [attachmentno=" + attachmentno + ", qnaSeq=" + qnaSeq + ", originalfilename="
			+ originalfilename + ", renamedfilename=" + renamedfilename + ", uploaddate=" + uploaddate + ", status="
			+ status + "]";
}

public QB_ATTACHMENT(int attachmentno, int qnaSeq, String originalfilename, String renamedfilename, Date uploaddate,
		String status) {
	super();
	this.attachmentno = attachmentno;
	this.qnaSeq = qnaSeq;
	this.originalfilename = originalfilename;
	this.renamedfilename = renamedfilename;
	this.uploaddate = uploaddate;
	this.status = status;
}



	
	
}
