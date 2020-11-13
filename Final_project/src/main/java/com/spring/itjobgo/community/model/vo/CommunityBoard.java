package com.spring.itjobgo.community.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class CommunityBoard {
	
	private int boardSq;
	private String boardDivision;
	private String boardContent;
	private Date boardDate;
	private String boardOriginalFilepath;
	private String boardRenameFilepath;
	private int memberNum;

}
