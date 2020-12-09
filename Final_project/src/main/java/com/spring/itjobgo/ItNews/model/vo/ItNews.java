package com.spring.itjobgo.ItNews.model.vo;

import java.sql.Date;

public class ItNews {
	
	private int newsSq;
	private String newsDivision;
	private String newsTitle;
	private String newsContent;
	private String newsRefSite;
	private Date newsDate;
	private int newsReadCount;
	private int memberNum;
	
	public ItNews() {
		// TODO Auto-generated constructor stub
	}

	public int getNewsSq() {
		return newsSq;
	}

	public void setNewsSq(int newsSq) {
		this.newsSq = newsSq;
	}

	public String getNewsDivision() {
		return newsDivision;
	}

	public void setNewsDivision(String newsDivision) {
		this.newsDivision = newsDivision;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsRefSite() {
		return newsRefSite;
	}

	public void setNewsRefSite(String newsRefSite) {
		this.newsRefSite = newsRefSite;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public int getNewsReadCount() {
		return newsReadCount;
	}

	public void setNewsReadCount(int newsReadCount) {
		this.newsReadCount = newsReadCount;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	@Override
	public String toString() {
		return "ItNews [newsSq=" + newsSq + ", newsDivision=" + newsDivision + ", newsTitle=" + newsTitle
				+ ", newsContent=" + newsContent + ", newsRefSite=" + newsRefSite + ", newsDate=" + newsDate
				+ ", newsReadCount=" + newsReadCount + ", memberNum=" + memberNum + "]";
	}

	public ItNews(int newsSq, String newsDivision, String newsTitle, String newsContent, String newsRefSite,
			Date newsDate, int newsReadCount, int memberNum) {
		super();
		this.newsSq = newsSq;
		this.newsDivision = newsDivision;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsRefSite = newsRefSite;
		this.newsDate = newsDate;
		this.newsReadCount = newsReadCount;
		this.memberNum = memberNum;
	}

	
	
	

}
