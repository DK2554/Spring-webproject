package com.spring.itjobgo.community.model.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CommunityBoard {
	
	
	private int boardSq;// 번호
	private String boardDivision;//분류
	private String boardTitle; //제목
	private String boardContent;//내용
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date boardDate;//날짜
	private int memberNum; //회원시퀀스로 분류

}
