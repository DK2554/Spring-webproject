package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeAll {

	//Resume
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
	//학력
	private int resumeSchoolno;
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
	//경력
	private int resumeWorkno;
	private Date workStartDate;
	private Date workFinishDate;
	private String workName;
	private String workLevel;
	private String workState;
	private String workDetail;
	//자격증
	private int resumeLicenseno;
	private String licenseName;
	private String licenseAgency;
	private Date licenseDate;
	//외국어능력
	private int resumeLanguageno;
	private String languageName;
	private String languageLevel;
	private String languageTest;
	private String languageScore;
	private Date languageDate;
	//주요활동 및 수상
	private int resumeActivityno;
	private String activity;
	private Date activityStartDate;
	private Date activityFinishDate;
	private String activityAgency;
	private String activityWork;
	private String activityDetail;
	//참여프로젝트
	private int resumeProjectno;
	private String projectPart;
	private Date projectStartDate;
	private Date projectFinishDate;
	private String projectName;
	private String projectWork;
	private String projectDetail;
	//해외경험
	private int resumeAbroadno;
	private String abroad;
	private Date abroadStartDate;
	private Date abroadFinishDate;
	private String abroadCountury;
	private String abroadAgency;
	private String abroadDetail;
	
	public ResumeAll() {
		// TODO Auto-generated constructor stub
	}

	public ResumeAll(int resumeNo, int memberNo, String rname, String engName, Date birth, String gender, int postcode,
			String address, String addressDetail, String telephone, String rphone, String remail, int resumeSchoolno,
			String school1, String schoolName1, Date schoolStartDate1, Date schoolFinishDate1, String major1,
			String education1, String school2, String schoolName2, Date schoolStartDate2, Date schoolFinishDate2,
			String major2, String education2, int resumeWorkno, Date workStartDate, Date workFinishDate,
			String workName, String workLevel, String workState, String workDetail, int resumeLicenseno,
			String licenseName, String licenseAgency, Date licenseDate, int resumeLanguageno, String languageName,
			String languageLevel, String languageTest, String languageScore, Date languageDate, int resumeActivityno,
			String activity, Date activityStartDate, Date activityFinishDate, String activityAgency,
			String activityWork, String activityDetail, int resumeProjectno, String projectPart, Date projectStartDate,
			Date projectFinishDate, String projectName, String projectWork, String projectDetail, int resumeAbroadno,
			String abroad, Date abroadStartDate, Date abroadFinishDate, String abroadCountury, String abroadAgency,
			String abroadDetail) {
		super();
		this.resumeNo = resumeNo;
		this.memberNo = memberNo;
		this.rname = rname;
		this.engName = engName;
		this.birth = birth;
		this.gender = gender;
		this.postcode = postcode;
		this.address = address;
		this.addressDetail = addressDetail;
		this.telephone = telephone;
		this.rphone = rphone;
		this.remail = remail;
		this.resumeSchoolno = resumeSchoolno;
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
		this.resumeWorkno = resumeWorkno;
		this.workStartDate = workStartDate;
		this.workFinishDate = workFinishDate;
		this.workName = workName;
		this.workLevel = workLevel;
		this.workState = workState;
		this.workDetail = workDetail;
		this.resumeLicenseno = resumeLicenseno;
		this.licenseName = licenseName;
		this.licenseAgency = licenseAgency;
		this.licenseDate = licenseDate;
		this.resumeLanguageno = resumeLanguageno;
		this.languageName = languageName;
		this.languageLevel = languageLevel;
		this.languageTest = languageTest;
		this.languageScore = languageScore;
		this.languageDate = languageDate;
		this.resumeActivityno = resumeActivityno;
		this.activity = activity;
		this.activityStartDate = activityStartDate;
		this.activityFinishDate = activityFinishDate;
		this.activityAgency = activityAgency;
		this.activityWork = activityWork;
		this.activityDetail = activityDetail;
		this.resumeProjectno = resumeProjectno;
		this.projectPart = projectPart;
		this.projectStartDate = projectStartDate;
		this.projectFinishDate = projectFinishDate;
		this.projectName = projectName;
		this.projectWork = projectWork;
		this.projectDetail = projectDetail;
		this.resumeAbroadno = resumeAbroadno;
		this.abroad = abroad;
		this.abroadStartDate = abroadStartDate;
		this.abroadFinishDate = abroadFinishDate;
		this.abroadCountury = abroadCountury;
		this.abroadAgency = abroadAgency;
		this.abroadDetail = abroadDetail;
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

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
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

	public int getResumeSchoolno() {
		return resumeSchoolno;
	}

	public void setResumeSchoolno(int resumeSchoolno) {
		this.resumeSchoolno = resumeSchoolno;
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

	public int getResumeWorkno() {
		return resumeWorkno;
	}

	public void setResumeWorkno(int resumeWorkno) {
		this.resumeWorkno = resumeWorkno;
	}

	public Date getWorkStartDate() {
		return workStartDate;
	}

	public void setWorkStartDate(Date workStartDate) {
		this.workStartDate = workStartDate;
	}

	public Date getWorkFinishDate() {
		return workFinishDate;
	}

	public void setWorkFinishDate(Date workFinishDate) {
		this.workFinishDate = workFinishDate;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getWorkLevel() {
		return workLevel;
	}

	public void setWorkLevel(String workLevel) {
		this.workLevel = workLevel;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getWorkDetail() {
		return workDetail;
	}

	public void setWorkDetail(String workDetail) {
		this.workDetail = workDetail;
	}

	public int getResumeLicenseno() {
		return resumeLicenseno;
	}

	public void setResumeLicenseno(int resumeLicenseno) {
		this.resumeLicenseno = resumeLicenseno;
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

	public int getResumeLanguageno() {
		return resumeLanguageno;
	}

	public void setResumeLanguageno(int resumeLanguageno) {
		this.resumeLanguageno = resumeLanguageno;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLanguageLevel() {
		return languageLevel;
	}

	public void setLanguageLevel(String languageLevel) {
		this.languageLevel = languageLevel;
	}

	public String getLanguageTest() {
		return languageTest;
	}

	public void setLanguageTest(String languageTest) {
		this.languageTest = languageTest;
	}

	public String getLanguageScore() {
		return languageScore;
	}

	public void setLanguageScore(String languageScore) {
		this.languageScore = languageScore;
	}

	public Date getLanguageDate() {
		return languageDate;
	}

	public void setLanguageDate(Date languageDate) {
		this.languageDate = languageDate;
	}

	public int getResumeActivityno() {
		return resumeActivityno;
	}

	public void setResumeActivityno(int resumeActivityno) {
		this.resumeActivityno = resumeActivityno;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Date getActivityStartDate() {
		return activityStartDate;
	}

	public void setActivityStartDate(Date activityStartDate) {
		this.activityStartDate = activityStartDate;
	}

	public Date getActivityFinishDate() {
		return activityFinishDate;
	}

	public void setActivityFinishDate(Date activityFinishDate) {
		this.activityFinishDate = activityFinishDate;
	}

	public String getActivityAgency() {
		return activityAgency;
	}

	public void setActivityAgency(String activityAgency) {
		this.activityAgency = activityAgency;
	}

	public String getActivityWork() {
		return activityWork;
	}

	public void setActivityWork(String activityWork) {
		this.activityWork = activityWork;
	}

	public String getActivityDetail() {
		return activityDetail;
	}

	public void setActivityDetail(String activityDetail) {
		this.activityDetail = activityDetail;
	}

	public int getResumeProjectno() {
		return resumeProjectno;
	}

	public void setResumeProjectno(int resumeProjectno) {
		this.resumeProjectno = resumeProjectno;
	}

	public String getProjectPart() {
		return projectPart;
	}

	public void setProjectPart(String projectPart) {
		this.projectPart = projectPart;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectFinishDate() {
		return projectFinishDate;
	}

	public void setProjectFinishDate(Date projectFinishDate) {
		this.projectFinishDate = projectFinishDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectWork() {
		return projectWork;
	}

	public void setProjectWork(String projectWork) {
		this.projectWork = projectWork;
	}

	public String getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}

	public int getResumeAbroadno() {
		return resumeAbroadno;
	}

	public void setResumeAbroadno(int resumeAbroadno) {
		this.resumeAbroadno = resumeAbroadno;
	}

	public String getAbroad() {
		return abroad;
	}

	public void setAbroad(String abroad) {
		this.abroad = abroad;
	}

	public Date getAbroadStartDate() {
		return abroadStartDate;
	}

	public void setAbroadStartDate(Date abroadStartDate) {
		this.abroadStartDate = abroadStartDate;
	}

	public Date getAbroadFinishDate() {
		return abroadFinishDate;
	}

	public void setAbroadFinishDate(Date abroadFinishDate) {
		this.abroadFinishDate = abroadFinishDate;
	}

	public String getAbroadCountury() {
		return abroadCountury;
	}

	public void setAbroadCountury(String abroadCountury) {
		this.abroadCountury = abroadCountury;
	}

	public String getAbroadAgency() {
		return abroadAgency;
	}

	public void setAbroadAgency(String abroadAgency) {
		this.abroadAgency = abroadAgency;
	}

	public String getAbroadDetail() {
		return abroadDetail;
	}

	public void setAbroadDetail(String abroadDetail) {
		this.abroadDetail = abroadDetail;
	}

	@Override
	public String toString() {
		return "ResumeAll [resumeNo=" + resumeNo + ", memberNo=" + memberNo + ", rname=" + rname + ", engName="
				+ engName + ", birth=" + birth + ", gender=" + gender + ", postcode=" + postcode + ", address="
				+ address + ", addressDetail=" + addressDetail + ", telephone=" + telephone + ", rphone=" + rphone
				+ ", remail=" + remail + ", resumeSchoolno=" + resumeSchoolno + ", school1=" + school1
				+ ", schoolName1=" + schoolName1 + ", schoolStartDate1=" + schoolStartDate1 + ", schoolFinishDate1="
				+ schoolFinishDate1 + ", major1=" + major1 + ", education1=" + education1 + ", school2=" + school2
				+ ", schoolName2=" + schoolName2 + ", schoolStartDate2=" + schoolStartDate2 + ", schoolFinishDate2="
				+ schoolFinishDate2 + ", major2=" + major2 + ", education2=" + education2 + ", resumeWorkno="
				+ resumeWorkno + ", workStartDate=" + workStartDate + ", workFinishDate=" + workFinishDate
				+ ", workName=" + workName + ", workLevel=" + workLevel + ", workState=" + workState + ", workDetail="
				+ workDetail + ", resumeLicenseno=" + resumeLicenseno + ", licenseName=" + licenseName
				+ ", licenseAgency=" + licenseAgency + ", licenseDate=" + licenseDate + ", resumeLanguageno="
				+ resumeLanguageno + ", languageName=" + languageName + ", languageLevel=" + languageLevel
				+ ", languageTest=" + languageTest + ", languageScore=" + languageScore + ", languageDate="
				+ languageDate + ", resumeActivityno=" + resumeActivityno + ", activity=" + activity
				+ ", activityStartDate=" + activityStartDate + ", activityFinishDate=" + activityFinishDate
				+ ", activityAgency=" + activityAgency + ", activityWork=" + activityWork + ", activityDetail="
				+ activityDetail + ", resumeProjectno=" + resumeProjectno + ", projectPart=" + projectPart
				+ ", projectStartDate=" + projectStartDate + ", projectFinishDate=" + projectFinishDate
				+ ", projectName=" + projectName + ", projectWork=" + projectWork + ", projectDetail=" + projectDetail
				+ ", resumeAbroadno=" + resumeAbroadno + ", abroad=" + abroad + ", abroadStartDate=" + abroadStartDate
				+ ", abroadFinishDate=" + abroadFinishDate + ", abroadCountury=" + abroadCountury + ", abroadAgency="
				+ abroadAgency + ", abroadDetail=" + abroadDetail + "]";
	}
	
	
	
}