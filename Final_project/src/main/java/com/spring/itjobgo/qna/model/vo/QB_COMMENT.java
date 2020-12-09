package com.spring.itjobgo.qna.model.vo;

import java.sql.Date;

public class QB_COMMENT {
	
	private int qboardCommentNo; //자동시퀀스 연결
	private int qboardNo; //외래키로 가져오는값
	private String qbCommentContent;
	private int memberSq;
	private String qbcommentDate; 
	private String memberName;
	
	 
	public QB_COMMENT() {
		// TODO Auto-generated constructor stub
	}


	public QB_COMMENT(int qboardCommentNo, int qboardNo, String qbCommentContent, int memberSq, String qbcommentDate,
			String memberName) {
		super();
		this.qboardCommentNo = qboardCommentNo;
		this.qboardNo = qboardNo;
		this.qbCommentContent = qbCommentContent;
		this.memberSq = memberSq;
		this.qbcommentDate = qbcommentDate;
		this.memberName = memberName;
	}


	public int getQboardCommentNo() {
		return qboardCommentNo;
	}


	public void setQboardCommentNo(int qboardCommentNo) {
		this.qboardCommentNo = qboardCommentNo;
	}


	public int getQboardNo() {
		return qboardNo;
	}


	public void setQboardNo(int qboardNo) {
		this.qboardNo = qboardNo;
	}


	public String getQbCommentContent() {
		return qbCommentContent;
	}


	public void setQbCommentContent(String qbCommentContent) {
		this.qbCommentContent = qbCommentContent;
	}


	public int getMemberSq() {
		return memberSq;
	}


	public void setMemberSq(int memberSq) {
		this.memberSq = memberSq;
	}


	public String getQbcommentDate() {
		return qbcommentDate;
	}


	public void setQbcommentDate(String qbcommentDate) {
		this.qbcommentDate = qbcommentDate;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	@Override
	public String toString() {
		return "QB_COMMENT [qboardCommentNo=" + qboardCommentNo + ", qboardNo=" + qboardNo + ", qbCommentContent="
				+ qbCommentContent + ", memberSq=" + memberSq + ", qbcommentDate=" + qbcommentDate + ", memberName="
				+ memberName + "]";
	}


	
	
	
	
	
}
