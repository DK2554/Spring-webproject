package com.spring.itjobgo.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberPhoto {
	
	private int memberSq;
	private int memPhotoSq;
	private String originalFileName;
	private String renamedFileName;
	private Date uploadDate;

}
