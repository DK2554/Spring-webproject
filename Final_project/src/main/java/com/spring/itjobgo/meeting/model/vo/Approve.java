package com.spring.itjobgo.meeting.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //매개변수 있는 생성자
@NoArgsConstructor //매개변수없는 생성
public class Approve {
	private int acnumber;
	private int memberSq;
	private String position;
	private Date completeDate;
	private int collabSq;
	private String status;
}
