package com.spring.itjobgo.community.model.vo;

import java.sql.Date;

public class CB_COMMENT {
	
	private int cbCommentNo;
	private int cboardNo;
	private String cbCommentContent;
	private int memberSq;
	private Date cbCommentDate;
	private String memberName;
	
	
	  public CB_COMMENT() {
		// TODO Auto-generated constructor stub
	}

	public int getCbCommentNo() {
		return cbCommentNo;
	}


	public void setCbCommentNo(int cbCommentNo) {
		this.cbCommentNo = cbCommentNo;
	}


	public int getCboardNo() {
		return cboardNo;
	}


	public void setCboardNo(int cboardNo) {
		this.cboardNo = cboardNo;
	}


	public String getCbCommentContent() {
		return cbCommentContent;
	}


	public void setCbCommentContent(String cbCommentContent) {
		this.cbCommentContent = cbCommentContent;
	}


	public int getMemberSq() {
		return memberSq;
	}


	public void setMemberSq(int memberSq) {
		this.memberSq = memberSq;
	}


	public Date getCbCommentDate() {
		return cbCommentDate;
	}


	public void setCbCommentDate(Date cbCommentDate) {
		this.cbCommentDate = cbCommentDate;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	@Override
	public String toString() {
		return "CB_COMMENT [cbCommentNo=" + cbCommentNo + ", cboardNo=" + cboardNo + ", cbCommentContent="
				+ cbCommentContent + ", memberSq=" + memberSq + ", cbCommentDate=" + cbCommentDate + ", memberName="
				+ memberName + "]";
	}


	public CB_COMMENT(int cbCommentNo, int cboardNo, String cbCommentContent, int memberSq, Date cbCommentDate,
			String memberName) {
		super();
		this.cbCommentNo = cbCommentNo;
		this.cboardNo = cboardNo;
		this.cbCommentContent = cbCommentContent;
		this.memberSq = memberSq;
		this.cbCommentDate = cbCommentDate;
		this.memberName = memberName;
	}



	  
}
