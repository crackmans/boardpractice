package com.vam.service;

import java.util.List;

import com.vam.model.BoardVO;
import com.vam.model.Criteria;

public interface BoardService {
	public void enroll(BoardVO board);
	
	public List<BoardVO> getList();
	
	public BoardVO getPage(int bno);
	
	public int modify(BoardVO board);
	
	public int delelte(int bno);
	
	public List<BoardVO> getListPaging(Criteria cri);
	
	public int getTotal(Criteria cri);
}
