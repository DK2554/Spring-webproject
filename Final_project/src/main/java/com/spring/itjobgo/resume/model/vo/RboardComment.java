package com.spring.itjobgo.resume.model.vo;

public class RboardComment {

	private int rboardCommentno;
	private int rboardNo;
	private int memberSq;
	private String memberName;
	private String rboardCommentContent;
	private String rboardCommentDate;
	
	public RboardComment() {
		// TODO Auto-generated constructor stub
	}

	public RboardComment(int rboardCommentno, int rboardNo, int memberSq, String memberName,
			String rboardCommentContent, String rboardCommentDate) {
		super();
		this.rboardCommentno = rboardCommentno;
		this.rboardNo = rboardNo;
		this.memberSq = memberSq;
		this.memberName = memberName;
		this.rboardCommentContent = rboardCommentContent;
		this.rboardCommentDate = rboardCommentDate;
	}

	public int getRboardCommentno() {
		return rboardCommentno;
	}

	public void setRboardCommentno(int rboardCommentno) {
		this.rboardCommentno = rboardCommentno;
	}

	public int getRboardNo() {
		return rboardNo;
	}

	public void setRboardNo(int rboardNo) {
		this.rboardNo = rboardNo;
	}

	public int getMemberSq() {
		return memberSq;
	}

	public void setMemberSq(int memberSq) {
		this.memberSq = memberSq;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getRboardCommentContent() {
		return rboardCommentContent;
	}

	public void setRboardCommentContent(String rboardCommentContent) {
		this.rboardCommentContent = rboardCommentContent;
	}

	public String getRboardCommentDate() {
		return rboardCommentDate;
	}

	public void setRboardCommentDate(String rboardCommentDate) {
		this.rboardCommentDate = rboardCommentDate;
	}

	@Override
	public String toString() {
		return "RboardComment [rboardCommentno=" + rboardCommentno + ", rboardNo=" + rboardNo + ", memberSq=" + memberSq
				+ ", memberName=" + memberName + ", rboardCommentContent=" + rboardCommentContent
				+ ", rboardCommentDate=" + rboardCommentDate + "]";
	}

	
}
