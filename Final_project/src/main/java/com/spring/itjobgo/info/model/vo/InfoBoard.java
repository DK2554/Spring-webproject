package com.spring.itjobgo.info.model.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class InfoBoard {
	
	private int InfoSq;
	private String InfoCategory;
	private String InfoTitle;
	private Date InfoDate;
	private int InfoTime;
	private String InfoAddress;
	private String InfoOriginalFilepath;
	private String InfoRenameFilepath;
	private int MemberNum;
	
}
  

