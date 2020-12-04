package com.spring.itjobgo.portfolio.model.service;

import java.util.List;
import java.util.Map;

import com.spring.itjobgo.portfolio.model.vo.Attachment;
import com.spring.itjobgo.portfolio.model.vo.Comment;
import com.spring.itjobgo.portfolio.model.vo.Pboard;

public interface PortfolioService {

	int insertPboard(Pboard pboard, List<Attachment> files);

	List<Pboard> selectListPboard();

	Pboard selectPboardOne(int pboardNo, boolean hasRead);

	int deletePboard(int no);

	Attachment selectattac(int no);

	int updatepboard(Pboard pboard, List<Attachment> files);

	int updatepboard(Pboard pboard);

	int selectmemberno(String email);

	int insertComment(Comment cm);

	List<Comment> selectComment(int no);

	int deletecomment(int no);

	int updatacommentText(int pboardNo);

	int updatecomment(Map param);

	

}
