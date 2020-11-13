package com.spring.itjobgo.qna.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class QnaBoard {
	
	private int qnaSeq;
	private String qnaCategory;
	private String qnaTitle;
	private String qnaContent;
	private String qnaAnswerYn;
	private Date qnaDate;
	private int memberNum;
	
}
