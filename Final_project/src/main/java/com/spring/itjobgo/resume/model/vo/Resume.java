package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class Resume {

	private int resumeNo;
	private int memberNo;
	private String rname;
	private String engName;
	private Date birth;
	private String gender;
	private int postcode;
	private String address;
	private String addressDetail;
	private String telephone;
	private String rphone;
	private String remail;

	public Resume() {
		// TODO Auto-generated constructor stub
	}

	public Resume(int resumeNo, int memberNo, String rname, String engName, Date birth, String gender, int postcode,
			String address, String telephone, String rphone, String remail) {
		super();
		this.resumeNo = resumeNo;
		this.memberNo = memberNo;
		this.rname = rname;
		this.engName = engName;
		this.birth = birth;
		this.gender = gender;
		this.postcode = postcode;
		this.address = address;
		this.telephone = telephone;
		this.rphone = rphone;
		this.remail = remail;
	}

	public int getResumeNo() {
		return resumeNo;
	}

	public void setResumeNo(int resumeNo) {
		this.resumeNo = resumeNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRphone() {
		return rphone;
	}

	public void setRphone(String rphone) {
		this.rphone = rphone;
	}

	public String getRemail() {
		return remail;
	}

	public void setRemail(String remail) {
		this.remail = remail;
	}

	@Override
	public String toString() {
		return "Resume [resumeNo=" + resumeNo + ", memberNo=" + memberNo + ", rname=" + rname + ", engName=" + engName
				+ ", birth=" + birth + ", gender=" + gender + ", postcode=" + postcode + ", address=" + address
				+ ", telephone=" + telephone + ", rphone=" + rphone + ", remail=" + remail + "]";
	}
	
	
}
