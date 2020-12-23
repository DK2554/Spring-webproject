package com.spring.itjobgo.meeting.model.vo;

import java.util.Date;

public class Tmpapply {
	private int tmpNo;
	private int memberSq;// 신청한 사람
	private String postion;
	private int collabSq;
	private int writerNo;
	private Date tmpDate;

	private Mboard mboard;

	public Tmpapply() {
		// TODO Auto-generated constructor stub
	}

	public Tmpapply(int tmpNo, int memberSq, String postion, int collabSq, int writerNo, Date tmpDate, Mboard mboard) {
		super();
		this.tmpNo = tmpNo;
		this.memberSq = memberSq;
		this.postion = postion;
		this.collabSq = collabSq;
		this.writerNo = writerNo;
		this.tmpDate = tmpDate;
		this.mboard = mboard;
	}

	public int getTmpNo() {
		return tmpNo;
	}

	public void setTmpNo(int tmpNo) {
		this.tmpNo = tmpNo;
	}

	public int getMemberSq() {
		return memberSq;
	}

	public void setMemberSq(int memberSq) {
		this.memberSq = memberSq;
	}

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public int getCollabSq() {
		return collabSq;
	}

	public void setCollabSq(int collabSq) {
		this.collabSq = collabSq;
	}

	public int getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}

	@Override
	public String toString() {
		return "Tmpapply [tmpNo=" + tmpNo + ", memberSq=" + memberSq + ", postion=" + postion + ", collabSq=" + collabSq
				+ ", writerNo=" + writerNo + ", tmpDate=" + tmpDate + ", mboard=" + mboard + "]";
	}

	public Date getTmpDate() {
		return tmpDate;
	}

	public void setTmpDate(Date tmpDate) {
		this.tmpDate = tmpDate;
	}

	public Mboard getMboard() {
		return mboard;
	}

	public void setMboard(Mboard mboard) {
		this.mboard = mboard;
	}

}
