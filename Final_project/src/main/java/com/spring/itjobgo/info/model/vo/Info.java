package com.spring.itjobgo.info.model.vo;

public class Info {
	
	private int infoSq; //게시글 번호
	private String infoCategory; //분류
	private String infoTitle;  //기업명
	private String infoDate;  //일정
	private String infoTime;  //시간
	private String infoAddress; //주소
	private int memberNum;   //작성자(관리자)
	private String infoContent;  //첨부 내용
	private int infoCount; //조회수
	
	public Info() {
		// TODO Auto-generated constructor stub
	}

	
	public int getInfoSq() {
		return infoSq;
	}

	public void setInfoSq(int infoSq) {
		this.infoSq = infoSq;
	}

	public String getInfoCategory() {
		return infoCategory;
	}

	public void setInfoCategory(String infoCategory) {
		this.infoCategory = infoCategory;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	public String getInfoTime() {
		return infoTime;
	}

	public void setInfoTime(String infoTime) {
		this.infoTime = infoTime;
	}

	public String getInfoAddress() {
		return infoAddress;
	}

	public void setInfoAddress(String infoAddress) {
		this.infoAddress = infoAddress;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public int getInfoCount() {
		return infoCount;
	}

	public void setInfoCount(int infoCount) {
		this.infoCount = infoCount;
	}


	public Info(int infoSq, String infoCategory, String infoTitle, String infoDate, String infoTime, String infoAddress,
			int memberNum, String infoContent, int infoCount) {
		super();
		this.infoSq = infoSq;
		this.infoCategory = infoCategory;
		this.infoTitle = infoTitle;
		this.infoDate = infoDate;
		this.infoTime = infoTime;
		this.infoAddress = infoAddress;
		this.memberNum = memberNum;
		this.infoContent = infoContent;
		this.infoCount = infoCount;
	}

}