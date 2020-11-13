package com.spring.itjobgo.community.model.vo;

import java.sql.Date;
<<<<<<< HEAD
=======

import org.springframework.format.annotation.DateTimeFormat;

>>>>>>> 838c2c33b6f1804d82127551aaf74b19da1d1f18
import lombok.Data;

@Data
public class CommunityBoard {
	
	private int boardSq;// 번호
	private String boardDivision;//분류
	private String boardTitle; //제목
	private String boardContent;//내용
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date boardDate;//날짜
	private String boardOriginalFilepath;
	private String boardRenameFilepath;
	private int memberNum; //회원시퀀스로 분류

}
