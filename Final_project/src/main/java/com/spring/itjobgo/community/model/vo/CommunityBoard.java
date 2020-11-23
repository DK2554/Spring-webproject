package com.spring.itjobgo.community.model.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


public class CommunityBoard {
	
	
	private int boardSq;// 번호(PK)
	private String boardDivision;//분류
	private String boardTitle; //제목
	private String boardContent;//내용
	private Date boardDate;//날짜
	private int memberNum; //회원시퀀스로 분류
	private String boardWriter;
	private int boardCount;//조회수
	
	
	public CommunityBoard() {
		// TODO Auto-generated constructor stub
	}


	public int getBoardSq() {
		return boardSq;
	}


	public void setBoardSq(int boardSq) {
		this.boardSq = boardSq;
	}


	public String getBoardDivision() {
		return boardDivision;
	}


	public void setBoardDivision(String boardDivision) {
		this.boardDivision = boardDivision;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public Date getBoardDate() {
		return boardDate;
	}


	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}


	public int getMemberNum() {
		return memberNum;
	}


	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}


	public String getBoardWriter() {
		return boardWriter;
	}


	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}


	public int getBoardCount() {
		return boardCount;
	}


	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}


	public CommunityBoard(int boardSq, String boardDivision, String boardTitle, String boardContent, Date boardDate,
			int memberNum, String boardWriter, int boardCount) {
		super();
		this.boardSq = boardSq;
		this.boardDivision = boardDivision;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.memberNum = memberNum;
		this.boardWriter = boardWriter;
		this.boardCount = boardCount;
	}
	
	
}
