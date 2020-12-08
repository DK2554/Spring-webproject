package com.spring.itjobgo.member.model.vo;

import lombok.Data;

@Data
public class MemberScrap { 
   
   
   private int scrapSq;
   private int memberSq;
   private String jobNo;
   private String jobTitle;
   private String company;
   private String deadline;
   private String applyMethod;

}