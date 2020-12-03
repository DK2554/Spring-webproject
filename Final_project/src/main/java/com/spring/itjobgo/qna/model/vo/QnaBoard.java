package com.spring.itjobgo.qna.model.vo;

import java.sql.Date;


public class QnaBoard {
	
	private int qnaSeq; //번호(PK)  qnaboardNo
	private String qnaCategory; //분류
	private String qnaTitle; //제목
	private String qnaWriter; //작성자
	private String qnaContent; //내용
	private String qnaAnswerYn; //답변여부
	private Date qnaDate; //날짜
	private int memberNum; //회원시퀀스로 분류
	private int boardCount; //조회수
	
	public QnaBoard() {
		// TODO Auto-generated constructor stub
	}

	public QnaBoard(int qnaSeq, String qnaCategory, String qnaTitle, String qnaWriter, String qnaContent,
			String qnaAnswerYn, Date qnaDate, int memberNum, int boardCount) {
		super();
		this.qnaSeq = qnaSeq;
		this.qnaCategory = qnaCategory;
		this.qnaTitle = qnaTitle;
		this.qnaWriter = qnaWriter;
		this.qnaContent = qnaContent;
		this.qnaAnswerYn = qnaAnswerYn;
		this.qnaDate = qnaDate;
		this.memberNum = memberNum;
		this.boardCount = boardCount;
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

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	@Override
	public String toString() {
		return "QnaBoard [qnaSeq=" + qnaSeq + ", qnaCategory=" + qnaCategory + ", qnaTitle=" + qnaTitle + ", qnaWriter="
				+ qnaWriter + ", qnaContent=" + qnaContent + ", qnaAnswerYn=" + qnaAnswerYn + ", qnaDate=" + qnaDate
				+ ", memberNum=" + memberNum + ", boardCount=" + boardCount + "]";
	}
	
	
}
