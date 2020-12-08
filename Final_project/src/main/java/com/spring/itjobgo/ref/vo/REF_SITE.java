package com.spring.itjobgo.ref.vo;

import java.sql.Date;

public class REF_SITE {

	private int refNo; //작성글 번호
	private String refCategory; //카테고리
	private String refTitle; //제목
	private String refContent; //내용
	private String refSiteAddr; //사이트 주소
	private Date refDate; //등록일
	private int RefReadCount; //조회수
	private int MemberNum; //회원번호로 조회
	
	public REF_SITE() {
		// TODO Auto-generated constructor stub
	}

	public REF_SITE(int refNo, String refCategory, String refTitle, String refContent, String refSiteAddr, Date refDate,
			int refReadCount, int memberNum) {
		super();
		this.refNo = refNo;
		this.refCategory = refCategory;
		this.refTitle = refTitle;
		this.refContent = refContent;
		this.refSiteAddr = refSiteAddr;
		this.refDate = refDate;
		RefReadCount = refReadCount;
		MemberNum = memberNum;
	}

	public int getRefNo() {
		return refNo;
	}

	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}

	public String getRefCategory() {
		return refCategory;
	}

	public void setRefCategory(String refCategory) {
		this.refCategory = refCategory;
	}

	public String getRefTitle() {
		return refTitle;
	}

	public void setRefTitle(String refTitle) {
		this.refTitle = refTitle;
	}

	public String getRefContent() {
		return refContent;
	}

	public void setRefContent(String refContent) {
		this.refContent = refContent;
	}

	public String getRefSiteAddr() {
		return refSiteAddr;
	}

	public void setRefSiteAddr(String refSiteAddr) {
		this.refSiteAddr = refSiteAddr;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	public int getRefReadCount() {
		return RefReadCount;
	}

	public void setRefReadCount(int refReadCount) {
		RefReadCount = refReadCount;
	}

	public int getMemberNum() {
		return MemberNum;
	}

	public void setMemberNum(int memberNum) {
		MemberNum = memberNum;
	}

	@Override
	public String toString() {
		return "REF_SITE [refNo=" + refNo + ", refCategory=" + refCategory + ", refTitle=" + refTitle + ", refContent="
				+ refContent + ", refSiteAddr=" + refSiteAddr + ", refDate=" + refDate + ", RefReadCount="
				+ RefReadCount + ", MemberNum=" + MemberNum + "]";
	}
	
	
	
	
	
	
}
