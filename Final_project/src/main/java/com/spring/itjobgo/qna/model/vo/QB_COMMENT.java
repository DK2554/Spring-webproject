package com.spring.itjobgo.qna.model.vo;

import java.sql.Date;

public class QB_COMMENT {
	
	private int qbCommentNo; //자동시퀀스 연결
	private int qbBoardNo; //외래키로 가져오는값
	private String qbCommentContent;
	private int memberSq;
	private Date qbcommentDate; 
	private String memberName;
	
public QB_COMMENT() {
	// TODO Auto-generated constructor stub
}

public QB_COMMENT(int qbCommentNo, int qbBoardNo, String qbCommentContent, int memberSq, Date qbcommentDate,
		String memberName) {
	super();
	this.qbCommentNo = qbCommentNo;
	this.qbBoardNo = qbBoardNo;
	this.qbCommentContent = qbCommentContent;
	this.memberSq = memberSq;
	this.qbcommentDate = qbcommentDate;
	this.memberName = memberName;
}

public int getQbCommentNo() {
	return qbCommentNo;
}

public void setQbCommentNo(int qbCommentNo) {
	this.qbCommentNo = qbCommentNo;
}

public int getQbBoardNo() {
	return qbBoardNo;
}

public void setQbBoardNo(int qbBoardNo) {
	this.qbBoardNo = qbBoardNo;
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

public Date getQbcommentDate() {
	return qbcommentDate;
}

public void setQbcommentDate(Date qbcommentDate) {
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
	return "QB_COMMENT [qbCommentNo=" + qbCommentNo + ", qbBoardNo=" + qbBoardNo + ", qbCommentContent="
			+ qbCommentContent + ", memberSq=" + memberSq + ", qbcommentDate=" + qbcommentDate + ", memberName="
			+ memberName + "]";
}


	
	
	

}
