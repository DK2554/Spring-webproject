package com.spring.itjobgo.meeting.model.vo;

import lombok.Data;

public class Tmpapply {
	private int tmpNo;
	private int memberSq;
	private String postion;
	
	public Tmpapply() {
	// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Tmpapply [tmpNo=" + tmpNo + ", memberSq=" + memberSq + ", postion=" + postion + "]";
	}

	public Tmpapply(int tmpNo, int memberSq, String postion) {
		super();
		this.tmpNo = tmpNo;
		this.memberSq = memberSq;
		this.postion = postion;
	}
	
}
