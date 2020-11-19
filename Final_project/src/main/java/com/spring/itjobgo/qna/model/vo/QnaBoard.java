package com.spring.itjobgo.qna.model.vo;

import java.sql.Date;

import lombok.Data;


public class QnaBoard {
	
	private int qnaSeq;
	private String qnaCategory;
	private String qnaTitle;
	private String qnaWriter;
	private String qnaContent;
	private String qnaAnswerYn;
	private Date qnaDate;
	private int memberNum;
	
	public QnaBoard() {
		// TODO Auto-generated constructor stub
	}

	public int getQnaSeq() {
		return qnaSeq;
	}

	public void setQnaSeq(int qnaSeq) {
		this.qnaSeq = qnaSeq;
	}

	public String getQnaCategory() {
		return qnaCategory;
	}

	public void setQnaCategory(String qnaCategory) {
		this.qnaCategory = qnaCategory;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaWriter() {
		return qnaWriter;
	}

	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public String getQnaAnswerYn() {
		return qnaAnswerYn;
	}

	public void setQnaAnswerYn(String qnaAnswerYn) {
		this.qnaAnswerYn = qnaAnswerYn;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	@Override
	public String toString() {
		return "QnaBoard [qnaSeq=" + qnaSeq + ", qnaCategory=" + qnaCategory + ", qnaTitle=" + qnaTitle + ", qnaWriter="
				+ qnaWriter + ", qnaContent=" + qnaContent + ", qnaAnswerYn=" + qnaAnswerYn + ", qnaDate=" + qnaDate
				+ ", memberNum=" + memberNum + "]";
	}

	public QnaBoard(int qnaSeq, String qnaCategory, String qnaTitle, String qnaWriter, String qnaContent,
			String qnaAnswerYn, Date qnaDate, int memberNum) {
		super();
		this.qnaSeq = qnaSeq;
		this.qnaCategory = qnaCategory;
		this.qnaTitle = qnaTitle;
		this.qnaWriter = qnaWriter;
		this.qnaContent = qnaContent;
		this.qnaAnswerYn = qnaAnswerYn;
		this.qnaDate = qnaDate;
		this.memberNum = memberNum;
	}
	
	
}
