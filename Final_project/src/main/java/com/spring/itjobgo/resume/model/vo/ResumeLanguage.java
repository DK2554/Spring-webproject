package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeLanguage {

	private int resumeLanguageno;
	private int resumeNo;
	private String languageName;
	private String languageLevel;
	private String languageTest;
	private String languageScore;
	private Date languageDate;
	
	public ResumeLanguage() {
		// TODO Auto-generated constructor stub
	}
	
	public ResumeLanguage(int resumeLanguageno, int resumeNo, String languageName, String languageLevel,
			String languageTest, String languageScore, Date languageDate) {
		super();
		this.resumeLanguageno = resumeLanguageno;
		this.resumeNo = resumeNo;
		this.languageName = languageName;
		this.languageLevel = languageLevel;
		this.languageTest = languageTest;
		this.languageScore = languageScore;
		this.languageDate = languageDate;
	}

	public int getResumeLanguageno() {
		return resumeLanguageno;
	}

	public void setResumeLanguageno(int resumeLanguageno) {
		this.resumeLanguageno = resumeLanguageno;
	}

	public int getResumeNo() {
		return resumeNo;
	}

	public void setResumeNo(int resumeNo) {
		this.resumeNo = resumeNo;
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

	@Override
	public String toString() {
		return "ResumeLanguage [resumeLanguageno=" + resumeLanguageno + ", resumeNo=" + resumeNo + ", languageName="
				+ languageName + ", languageLevel=" + languageLevel + ", languageTest=" + languageTest
				+ ", languageScore=" + languageScore + ", languageDate=" + languageDate + "]";
	}
	
	
	
}
