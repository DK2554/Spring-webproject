package com.spring.itjobgo.portfolio.model.vo;

import java.sql.Date;

public class Comment {
	private int pcommentNo;
	private int pboardNo;
	private String pcommentContent;
	private int memberSq;
	private Date pcommentDate;
	private String memberName;
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Comment(int pcommentNo, int pboardNo, String pcommentContent, int memberSq, Date pcommentDate,
			String memberName) {
		super();
		this.pcommentNo = pcommentNo;
		this.pboardNo = pboardNo;
		this.pcommentContent = pcommentContent;
		this.memberSq = memberSq;
		this.pcommentDate = pcommentDate;
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "Comment [pcommentNo=" + pcommentNo + ", pboardNo=" + pboardNo + ", pcommentContent=" + pcommentContent
				+ ", memberSq=" + memberSq + ", pcommentDate=" + pcommentDate + ", memberName=" + memberName + "]";
	}
	public int getPcommentNo() {
		return pcommentNo;
	}
	public void setPcommentNo(int pcommentNo) {
		this.pcommentNo = pcommentNo;
	}
	public int getPboardNo() {
		return pboardNo;
	}
	public void setPboardNo(int pboardNo) {
		this.pboardNo = pboardNo;
	}
	public String getPcommentContent() {
		return pcommentContent;
	}
	public void setPcommentContent(String pcommentContent) {
		this.pcommentContent = pcommentContent;
	}
	public int getMemberSq() {
		return memberSq;
	}
	public void setMemberSq(int memberSq) {
		this.memberSq = memberSq;
	}
	public Date getPcommentDate() {
		return pcommentDate;
	}
	public void setPcommentDate(Date pcommentDate) {
		this.pcommentDate = pcommentDate;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	

}
