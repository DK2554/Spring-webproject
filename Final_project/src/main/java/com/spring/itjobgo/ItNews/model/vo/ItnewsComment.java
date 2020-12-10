package com.spring.itjobgo.ItNews.model.vo;

public class ItnewsComment {
	
	private int itCommentNo;
	private int itnewsNo;
	private String itCommentContent;
	private int memberSq;
	private String itCommentDate;
	private String memberName;
	
	public ItnewsComment() {
		// TODO Auto-generated constructor stub
	}

	public int getItCommentNo() {
		return itCommentNo;
	}

	public void setItCommentNo(int itCommentNo) {
		this.itCommentNo = itCommentNo;
	}

	public int getItnewsNo() {
		return itnewsNo;
	}

	public void setItnewsNo(int itnewsNo) {
		this.itnewsNo = itnewsNo;
	}

	public String getItCommentContent() {
		return itCommentContent;
	}

	public void setItCommentContent(String itCommentContent) {
		this.itCommentContent = itCommentContent;
	}

	public int getMemberSq() {
		return memberSq;
	}

	public void setMemberSq(int memberSq) {
		this.memberSq = memberSq;
	}

	public String getItCommentDate() {
		return itCommentDate;
	}

	public void setItCommentDate(String itCommentDate) {
		this.itCommentDate = itCommentDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "ItnewsComment [itCommentNo=" + itCommentNo + ", itnewsNo=" + itnewsNo + ", itCommentContent="
				+ itCommentContent + ", memberSq=" + memberSq + ", itCommentDate=" + itCommentDate + ", memberName="
				+ memberName + "]";
	}

	public ItnewsComment(int itCommentNo, int itnewsNo, String itCommentContent, int memberSq, String itCommentDate,
			String memberName) {
		super();
		this.itCommentNo = itCommentNo;
		this.itnewsNo = itnewsNo;
		this.itCommentContent = itCommentContent;
		this.memberSq = memberSq;
		this.itCommentDate = itCommentDate;
		this.memberName = memberName;
	}
	
	

}
