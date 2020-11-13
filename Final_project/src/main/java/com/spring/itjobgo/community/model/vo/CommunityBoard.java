package com.spring.itjobgo.community.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class CommunityBoard {
	
	private int boardSq;// 번호
	private String boardDivision;//분류
	private String boardContent;//제목,내용
	private Date boardDate;//날짜
	private String boardOriginalFilepath;
	private String boardRenameFilepath;
	private int memberNum;

}
