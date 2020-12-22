package com.spring.itjobgo.qna.model.vo;

import java.sql.Date;


public class QnaBoard {
	
	private int qboardNo; //번호(PK) 
	private String qnaCategory; //분류
	private String qnaTitle; //제목
	private String qnaWriter; //작성자
	private String qnaContent; //내용
	private String qnaAnswerYn; //답변여부
	private Date qnaDate; //날짜
	private int memberNum; //회원시퀀스로 분류
	private int boardCount; //조회수
	private int commentCount; //댓글수
	
	public QnaBoard() {
		// TODO Auto-generated constructor stub
	}

	public QnaBoard(int qboardNo, String qnaCategory, String qnaTitle, String qnaWriter, String qnaContent,
			String qnaAnswerYn, Date qnaDate, int memberNum, int boardCount, int commentCount) {
		super();
		this.qboardNo = qboardNo;
		this.qnaCategory = qnaCategory;
		this.qnaTitle = qnaTitle;
		this.qnaWriter = qnaWriter;
		this.qnaContent = qnaContent;
		this.qnaAnswerYn = qnaAnswerYn;
		this.qnaDate = qnaDate;
		this.memberNum = memberNum;
		this.boardCount = boardCount;
		this.commentCount = commentCount;
	}

	public int getQboardNo() {
		return qboardNo;
	}

	public void setQboardNo(int qboardNo) {
		this.qboardNo = qboardNo;
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

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "QnaBoard [qboardNo=" + qboardNo + ", qnaCategory=" + qnaCategory + ", qnaTitle=" + qnaTitle
				+ ", qnaWriter=" + qnaWriter + ", qnaContent=" + qnaContent + ", qnaAnswerYn=" + qnaAnswerYn
				+ ", qnaDate=" + qnaDate + ", memberNum=" + memberNum + ", boardCount=" + boardCount + ", commentCount="
				+ commentCount + "]";
	}

	
	
}
