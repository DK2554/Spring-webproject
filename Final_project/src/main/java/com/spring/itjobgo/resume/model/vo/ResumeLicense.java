package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeLicense {

	private int resumeLicenseno;
	private int resumeNo;
	private String licenseName;
	private String licenseAgency;
	private Date licenseDate;
	
	public ResumeLicense() {
		// TODO Auto-generated constructor stub
	}

	public ResumeLicense(int resumeLicenseno, int resumeNo, String licenseName, String licenseAgency,
			Date licenseDate) {
		super();
		this.resumeLicenseno = resumeLicenseno;
		this.resumeNo = resumeNo;
		this.licenseName = licenseName;
		this.licenseAgency = licenseAgency;
		this.licenseDate = licenseDate;
	}

	public int getResumeLicenseno() {
		return resumeLicenseno;
	}

	public void setResumeLicenseno(int resumeLicenseno) {
		this.resumeLicenseno = resumeLicenseno;
	}

	public int getResumeNo() {
		return resumeNo;
	}

	public void setResumeNo(int resumeNo) {
		this.resumeNo = resumeNo;
	}

	public String getLicenseName() {
		return licenseName;
	}

	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}

	public String getLicenseAgency() {
		return licenseAgency;
	}

	public void setLicenseAgency(String licenseAgency) {
		this.licenseAgency = licenseAgency;
	}

	public Date getLicenseDate() {
		return licenseDate;
	}

	public void setLicenseDate(Date licenseDate) {
		this.licenseDate = licenseDate;
	}

	@Override
	public String toString() {
		return "ResumeLicense [resumeLicenseno=" + resumeLicenseno + ", resumeNo=" + resumeNo + ", licenseName="
				+ licenseName + ", licenseAgency=" + licenseAgency + ", licenseDate=" + licenseDate + "]";
	}
	
	
}
