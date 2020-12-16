package com.spring.itjobgo.resume.model.vo;

import java.sql.Date;

public class ResumeActivity {

	private int resumeActivityno;
	private int resumeNo;
	private String activity;
	private Date activityStartDate;
	private Date activityFinishDate;
	private String activityAgency;
	private String activityWork;
	private String activityDetail;
	
	public ResumeActivity() {
		// TODO Auto-generated constructor stub
	}

	public ResumeActivity(int resumeActivityno, int resumeNo, String activity, Date activityStartDate,
			Date activityFinishDate, String activityAgency, String activityWork, String activityDetail) {
		super();
		this.resumeActivityno = resumeActivityno;
		this.resumeNo = resumeNo;
		this.activity = activity;
		this.activityStartDate = activityStartDate;
		this.activityFinishDate = activityFinishDate;
		this.activityAgency = activityAgency;
		this.activityWork = activityWork;
		this.activityDetail = activityDetail;
	}

	public int getResumeActivityno() {
		return resumeActivityno;
	}

	public void setResumeActivityno(int resumeActivityno) {
		this.resumeActivityno = resumeActivityno;
	}

	public int getResumeNo() {
		return resumeNo;
	}

	public void setResumeNo(int resumeNo) {
		this.resumeNo = resumeNo;
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

	@Override
	public String toString() {
		return "ResumeActivity [resumeActivityno=" + resumeActivityno + ", resumeNo=" + resumeNo + ", activity="
				+ activity + ", activityStartDate=" + activityStartDate + ", activityFinishDate=" + activityFinishDate
				+ ", activityAgency=" + activityAgency + ", activityWork=" + activityWork + ", activityDetail="
				+ activityDetail + "]";
	}
	
	
	
}
