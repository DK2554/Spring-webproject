package com.spring.itjobgo.info.model.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Info {
	
	private int infoSq;// 번호
	private String infoCategory;//분류
	private String infoTitle; //제목
	private String infoDate; //날짜
/* @DateTimeFormat(pattern = "yyyy-MM-dd") */
	private String infoTime; //시간
	private String infoAddress;//주소
//private String infoOriginalFilepath; 
//private String infoRenameFilepath; 
	private int memberNum; //회원시퀀스로 분류

}
