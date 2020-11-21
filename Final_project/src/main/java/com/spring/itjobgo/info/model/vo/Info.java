package com.spring.itjobgo.info.model.vo;

public class Info {
	
	private int infoSq;
	private String infoCategory;
	private String infoTitle; 
	private String infoDate; 
	private String infoTime; 
	private String infoAddress;
	private int memberNum;
	private String infoContent;
	
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

	@Override
	public String toString() {
		return "Info [infoSq=" + infoSq + ", infoCategory=" + infoCategory + ", infoTitle=" + infoTitle + ", infoDate="
				+ infoDate + ", infoTime=" + infoTime + ", infoAddress=" + infoAddress + ", memberNum=" + memberNum
				+ ", infoContent=" + infoContent + "]";
	}

	public Info(int infoSq, String infoCategory, String infoTitle, String infoDate, String infoTime, String infoAddress,
			int memberNum, String infoContent) {
		super();
		this.infoSq = infoSq;
		this.infoCategory = infoCategory;
		this.infoTitle = infoTitle;
		this.infoDate = infoDate;
		this.infoTime = infoTime;
		this.infoAddress = infoAddress;
		this.memberNum = memberNum;
		this.infoContent = infoContent;
	}
	
	
	
	
}
