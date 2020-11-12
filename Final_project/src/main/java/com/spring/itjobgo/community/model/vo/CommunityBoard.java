package com.spring.itjobgo.community.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class CommunityBoard {
	
	private int board_sq;
	private String board_division;
	private String board_content;
	private Date board_date;
	private String board_original_filepath;
	private String board_rename_filepath;
	private int member_num;

}
