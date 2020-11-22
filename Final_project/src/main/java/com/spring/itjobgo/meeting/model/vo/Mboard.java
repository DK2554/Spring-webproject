package com.spring.itjobgo.meeting.model.vo;

import java.sql.Date;
import java.util.Arrays;

public class Mboard {
	private int collabSq;
	private String collabTitle;
	private String collabContent;
	private String collabSimcontent;
	private String collabWriter;
	private String collabEmail;
	private String collabPhone;
	private Date collabUploaddate;
	private Date collabDeadline;
	private String[] collabLang;
	private int collabBack;
	private int collabFront;
	private int collabDesgin;
	private String address;
	private Date rdate;
	public Mboard() {
		// TODO Auto-generated constructor stub
	}
	public int getCollabSq() {
		return collabSq;
	}
	public void setCollabSq(int collabSq) {
		this.collabSq = collabSq;
	}
	public String getCollabTitle() {
		return collabTitle;
	}
	public void setCollabTitle(String collabTitle) {
		this.collabTitle = collabTitle;
	}
	public String getCollabContent() {
		return collabContent;
	}
	public void setCollabContent(String collabContent) {
		this.collabContent = collabContent;
	}
	public String getCollabSimcontent() {
		return collabSimcontent;
	}
	public void setCollabSimcontent(String collabSimcontent) {
		this.collabSimcontent = collabSimcontent;
	}
	public String getCollabWriter() {
		return collabWriter;
	}
	public void setCollabWriter(String collabWriter) {
		this.collabWriter = collabWriter;
	}
	public String getCollabEmail() {
		return collabEmail;
	}
	public void setCollabEmail(String collabEmail) {
		this.collabEmail = collabEmail;
	}
	public String getCollabPhone() {
		return collabPhone;
	}
	public void setCollabPhone(String collabPhone) {
		this.collabPhone = collabPhone;
	}
	public Date getCollabUploaddate() {
		return collabUploaddate;
	}
	public void setCollabUploaddate(Date collabUploaddate) {
		this.collabUploaddate = collabUploaddate;
	}
	public Date getCollabDeadline() {
		return collabDeadline;
	}
	public void setCollabDeadline(Date collabDeadline) {
		this.collabDeadline = collabDeadline;
	}
	public String[] getCollabLang() {
		return collabLang;
	}
	public void setCollabLang(String[] collabLang) {
		this.collabLang = collabLang;
	}
	public int getCollabBack() {
		return collabBack;
	}
	public void setCollabBack(int collabBack) {
		this.collabBack = collabBack;
	}
	public int getCollabFront() {
		return collabFront;
	}
	public void setCollabFront(int collabFront) {
		this.collabFront = collabFront;
	}
	public int getCollabDesgin() {
		return collabDesgin;
	}
	public void setCollabDesgin(int collabDesgin) {
		this.collabDesgin = collabDesgin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public Mboard(int collabSq, String collabTitle, String collabContent, String collabSimcontent, String collabWriter,
			String collabEmail, String collabPhone, Date collabUploaddate, Date collabDeadline, String[] collabLang,
			int collabBack, int collabFront, int collabDesgin, String address, Date rdate) {
		super();
		this.collabSq = collabSq;
		this.collabTitle = collabTitle;
		this.collabContent = collabContent;
		this.collabSimcontent = collabSimcontent;
		this.collabWriter = collabWriter;
		this.collabEmail = collabEmail;
		this.collabPhone = collabPhone;
		this.collabUploaddate = collabUploaddate;
		this.collabDeadline = collabDeadline;
		this.collabLang = collabLang;
		this.collabBack = collabBack;
		this.collabFront = collabFront;
		this.collabDesgin = collabDesgin;
		this.address = address;
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "Mboard [collabSq=" + collabSq + ", collabTitle=" + collabTitle + ", collabContent=" + collabContent
				+ ", collabSimcontent=" + collabSimcontent + ", collabWriter=" + collabWriter + ", collabEmail="
				+ collabEmail + ", collabPhone=" + collabPhone + ", collabUploaddate=" + collabUploaddate
				+ ", collabDeadline=" + collabDeadline + ", collabLang=" + Arrays.toString(collabLang) + ", collabBack="
				+ collabBack + ", collabFront=" + collabFront + ", collabDesgin=" + collabDesgin + ", address="
				+ address + ", rdate=" + rdate + "]";
	}
	
	
	
}
