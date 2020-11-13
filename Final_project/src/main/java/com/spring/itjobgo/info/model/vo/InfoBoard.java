package com.spring.itjobgo.info.model.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class InfoBoard {
	
	private int infoSq;
	private String infoCategory;
	private String infoTitle;
	private Date infoDate;
	private int infoTime;
	private String infoAddress;
	private String infoOriginalFilepath;
	private String infoRenameFilepath;
	private int memberNum;
	
}
  

