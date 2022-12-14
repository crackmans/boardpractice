package com.vam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.BoardVO;
import com.vam.model.Criteria;
import com.vam.model.PageMakerDTO;
import com.vam.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService bservice;
	
	//게시판 목록 페이지 접속
//	@GetMapping("/list")
//	// => RequestMapping(value="list", method=RequestMethod.GET)
//	public void boardListGET(Model model) {
//		log.info("게시판 목록 페이지 진입");
//		model.addAttribute("list", bservice.getList());
//	}
	
	@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri) {
		log.info("boardListGET");
		model.addAttribute("list", bservice.getListPaging(cri));
		int total = bservice.getTotal(cri);
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		model.addAttribute("pageMaker", pageMake);
	}
	
	//게시판 등록 페이지 접속
	@GetMapping("/enroll")
	// RequestMapping(value="enroll", method=RequestMethod.GET)
	public void boardEnrollGET() {
		log.info("게시판 등록 페이지 진입");
	}
	
	//게시판 등록
	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {		
		log.info("BoardVO : " + board);
		bservice.enroll(board);
		rttr.addFlashAttribute("result", "enroll success");
		return "redirect:/board/list";
	}
	//게시글 조회
	@GetMapping("/get")
	public void boardGetPageGET(int bno, Model model, Criteria cri) {
		model.addAttribute("pageInfo", bservice.getPage(bno));
		model.addAttribute("cri", cri);
	}
	//게시글 수정페이지 이동
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model, Criteria cri) {
		model.addAttribute("pageInfo", bservice.getPage(bno));
		model.addAttribute("cri", cri);
	}
	
	//게시글 수정		
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
		log.info("Modify : " + board);
		bservice.modify(board);
		rttr.addFlashAttribute("result", "modify success");
		return "redirect:/board/list";
	}
	
	@PostMapping("/delete")
	public String boardDeletePOST(int bno, RedirectAttributes rttr) {
		log.info("Delete Bno : " + bno);
		bservice.delelte(bno);
		rttr.addFlashAttribute("result", "delete success");
		return "redirect:/board/list";
	}
	
}
