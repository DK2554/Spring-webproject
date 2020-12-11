package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeSchool {

	private int resumeSchoolno;
	private int memberNo ;
	private String school1;
	private String schoolName1;
	private Date schoolStartDate1;
	private Date schoolFinishDate1;
	private String major1;
	private String education1;
	private String school2;
	private String schoolName2;
	private Date schoolStartDate2;
	private Date schoolFinishDate2;
	private String major2;
	private String education2;
	
	public ResumeSchool() {
		// TODO Auto-generated constructor stub
	}

	public ResumeSchool(int resumeSchoolno, int memberNo, String school1, String schoolName1, Date schoolStartDate1,
			Date schoolFinishDate1, String major1, String education1, String school2, String schoolName2,
			Date schoolStartDate2, Date schoolFinishDate2, String major2, String education2) {
		super();
		this.resumeSchoolno = resumeSchoolno;
		this.memberNo = memberNo;
		this.school1 = school1;
		this.schoolName1 = schoolName1;
		this.schoolStartDate1 = schoolStartDate1;
		this.schoolFinishDate1 = schoolFinishDate1;
		this.major1 = major1;
		this.education1 = education1;
		this.school2 = school2;
		this.schoolName2 = schoolName2;
		this.schoolStartDate2 = schoolStartDate2;
		this.schoolFinishDate2 = schoolFinishDate2;
		this.major2 = major2;
		this.education2 = education2;
	}

	public int getResumeSchoolno() {
		return resumeSchoolno;
	}

	public void setResumeSchoolno(int resumeSchoolno) {
		this.resumeSchoolno = resumeSchoolno;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getSchool1() {
		return school1;
	}

	public void setSchool1(String school1) {
		this.school1 = school1;
	}

	public String getSchoolName1() {
		return schoolName1;
	}

	public void setSchoolName1(String schoolName1) {
		this.schoolName1 = schoolName1;
	}

	public Date getSchoolStartDate1() {
		return schoolStartDate1;
	}

	public void setSchoolStartDate1(Date schoolStartDate1) {
		this.schoolStartDate1 = schoolStartDate1;
	}

	public Date getSchoolFinishDate1() {
		return schoolFinishDate1;
	}

	public void setSchoolFinishDate1(Date schoolFinishDate1) {
		this.schoolFinishDate1 = schoolFinishDate1;
	}

	public String getMajor1() {
		return major1;
	}

	public void setMajor1(String major1) {
		this.major1 = major1;
	}

	public String getEducation1() {
		return education1;
	}

	public void setEducation1(String education1) {
		this.education1 = education1;
	}

	public String getSchool2() {
		return school2;
	}

	public void setSchool2(String school2) {
		this.school2 = school2;
	}

	public String getSchoolName2() {
		return schoolName2;
	}

	public void setSchoolName2(String schoolName2) {
		this.schoolName2 = schoolName2;
	}

	public Date getSchoolStartDate2() {
		return schoolStartDate2;
	}

	public void setSchoolStartDate2(Date schoolStartDate2) {
		this.schoolStartDate2 = schoolStartDate2;
	}

	public Date getSchoolFinishDate2() {
		return schoolFinishDate2;
	}

	public void setSchoolFinishDate2(Date schoolFinishDate2) {
		this.schoolFinishDate2 = schoolFinishDate2;
	}

	public String getMajor2() {
		return major2;
	}

	public void setMajor2(String major2) {
		this.major2 = major2;
	}

	public String getEducation2() {
		return education2;
	}

	public void setEducation2(String education2) {
		this.education2 = education2;
	}

	@Override
	public String toString() {
		return "ResumeSchool [resumeSchoolno=" + resumeSchoolno + ", memberNo=" + memberNo + ", school1=" + school1
				+ ", schoolName1=" + schoolName1 + ", schoolStartDate1=" + schoolStartDate1 + ", schoolFinishDate1="
				+ schoolFinishDate1 + ", major1=" + major1 + ", education1=" + education1 + ", school2=" + school2
				+ ", schoolName2=" + schoolName2 + ", schoolStartDate2=" + schoolStartDate2 + ", schoolFinishDate2="
				+ schoolFinishDate2 + ", major2=" + major2 + ", education2=" + education2 + "]";
	}
	
	
	
}
