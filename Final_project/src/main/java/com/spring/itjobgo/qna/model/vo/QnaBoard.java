package com.spring.itjobgo.qna.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class QnaBoard {
	
	private int qna_seq;
	private String qna_category;
	private String qna_title;
	private String qna_content;
	private String qna_answer_yn;
	private Date qna_date;
	private int member_num;
	
}
