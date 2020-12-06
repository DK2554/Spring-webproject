package com.spring.itjobgo.notice.model.vo;

public class NoticeComment {

	private int ntCommentNo;
	private int ntBoardNo;
	private String ntCommentContent;
	private int memberSq;
	private String ntCommentDate;
	private String memberName;
	
	public NoticeComment() {
		// TODO Auto-generated constructor stub
	}

	public int getNtCommentNo() {
		return ntCommentNo;
	}

	public void setNtCommentNo(int ntCommentNo) {
		this.ntCommentNo = ntCommentNo;
	}

	public int getNtBoardNo() {
		return ntBoardNo;
	}

	public void setNtBoardNo(int ntBoardNo) {
		this.ntBoardNo = ntBoardNo;
	}

	public String getNtCommentContent() {
		return ntCommentContent;
	}

	public void setNtCommentContent(String ntCommentContent) {
		this.ntCommentContent = ntCommentContent;
	}

	public int getMemberSq() {
		return memberSq;
	}

	public void setMemberSq(int memberSq) {
		this.memberSq = memberSq;
	}

	public String getNtCommentDate() {
		return ntCommentDate;
	}

	public void setNtCommentDate(String ntCommentDate) {
		this.ntCommentDate = ntCommentDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public NoticeComment(int ntCommentNo, int ntBoardNo, String ntCommentContent, int memberSq, String ntCommentDate,
			String memberName) {
		super();
		this.ntCommentNo = ntCommentNo;
		this.ntBoardNo = ntBoardNo;
		this.ntCommentContent = ntCommentContent;
		this.memberSq = memberSq;
		this.ntCommentDate = ntCommentDate;
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "NoticeComment [ntCommentNo=" + ntCommentNo + ", ntBoardNo=" + ntBoardNo + ", ntCommentContent="
				+ ntCommentContent + ", memberSq=" + memberSq + ", ntCommentDate=" + ntCommentDate + ", memberName="
				+ memberName + "]";
	}
	
	
	
}
