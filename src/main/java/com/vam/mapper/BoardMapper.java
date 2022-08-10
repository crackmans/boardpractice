package com.vam.mapper;

import java.util.List;

import com.vam.model.BoardVO;
import com.vam.model.Criteria;

public interface BoardMapper {
	
	//게시물 등록
	public void enroll(BoardVO board);
	
	
	//게시물 목록
	public List<BoardVO> getList();
	
	//게시물 목록 페이징
	public List<BoardVO> getListPaging(Criteria cri);
	
	//게시물 조회
	public BoardVO getPage(int bno);
	
	
	//게시물 수정
	public int modify(BoardVO board);
	
	
	//게시물 삭제
	public int delete(int bno);
	
	//게시물 총 갯수
	public int getTotal(Criteria cri);
}
