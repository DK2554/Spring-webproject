package com.spring.itjobgo.meeting.model.vo;

public class Mcount {
	private int collabSq;
	private int collabBack;
	private int collabFront;
	private int collabDesgin;
	private int backCount;
	private int frontCount;
	private int desginCount;
	public Mcount(int collabSq, int collabBack, int collabFront, int collabDesgin, int backCount, int frontCount,
			int desginCount, String status) {
		super();
		this.collabSq = collabSq;
		this.collabBack = collabBack;
		this.collabFront = collabFront;
		this.collabDesgin = collabDesgin;
		this.backCount = backCount;
		this.frontCount = frontCount;
		this.desginCount = desginCount;
		this.status = status;
	}
	private String status;
	public Mcount() {
		// TODO Auto-generated constructor stub
	}
	public int getCollabSq() {
		return collabSq;
	}
	public void setCollabSq(int collabSq) {
		this.collabSq = collabSq;
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
	public int getBackCount() {
		return backCount;
	}
	public void setBackCount(int backCount) {
		this.backCount = backCount;
	}
	public int getFrontCount() {
		return frontCount;
	}
	public void setFrontCount(int frontCount) {
		this.frontCount = frontCount;
	}
	public int getDesginCount() {
		return desginCount;
	}
	public void setDesginCount(int desginCount) {
		this.desginCount = desginCount;
	}
	@Override
	public String toString() {
		return "Mcount [collabSq=" + collabSq + ", collabBack=" + collabBack + ", collabFront=" + collabFront
				+ ", collabDesgin=" + collabDesgin + ", backCount=" + backCount + ", frontCount=" + frontCount
				+ ", desginCount=" + desginCount + ", status=" + status + "]";
	}
	
	
	

}
