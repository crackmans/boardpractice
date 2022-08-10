package com.vam.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.Criteria;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
//	@Test
//	public void testEnroll() {
//		BoardVO vo = new BoardVO();
//		
//		vo.setTitle("service test");
//		vo.setContent("service test");
//		vo.setWriter("service test");
//		
//		service.enroll(vo);
//	}
//	
//	@Test
//	public void testGetList() {
//		service.getList().forEach(board -> log.info(""+board));
//	}
	
//	@Test
//	public void testGetPage() {
//		int bno = 8;
//		log.info(""+service.getPage(bno));
//	}
	
//	@Test
//	public void testModify() {
//		BoardVO board = new BoardVO();
//		board.setBno(8);
//		board.setTitle("수정제목1");
//		board.setContent("수정내용1");
//		
//		int result = service.modify(board);
//		log.info("result : " + result);
//	}
	
//	@Test
//	public void testDelete() {
//		int result = service.delelte(25);
//		log.info("result : " + result);
//	}
	
	@Test
	public void testGetListPaging() {
		Criteria cri = new Criteria();
		List list = service.getListPaging(cri);
		list.forEach(board -> log.info(""+board));
	}

}
