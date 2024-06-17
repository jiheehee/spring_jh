package com.bs.spring.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bs.spring.board.model.dto.Board;
import com.bs.spring.board.service.BoardService;
import com.bs.spring.common.PageFactory;

import lombok.RequiredArgsConstructor;

@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
@Configuration
public class BoardController implements WebMvcConfigurer {
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.addViewController("/board/inputboard.do");
	}
	private final BoardService service;
	private final PageFactory page;

	@GetMapping("/boardlist.do")
	public void boardList(
			@RequestParam(defaultValue="1") int cPage,
			@RequestParam(defaultValue="5") int numPerpage,
			Model model,
			@ModelAttribute("board")Board board) {
		List<Board> result=service.selectList(
				Map.of("cPage",cPage,"numPerpage",numPerpage));
		int totalData=service.selectBoardCount();
		String pageBar=PageFactory.getPage(cPage,numPerpage,totalData,"boardlist.do");
		model.addAttribute("pageBar", pageBar);
		model.addAttribute("totalContents",totalData);
		model.addAttribute("pageBar", page.getPage(cPage, numPerpage, totalData, "boardlist"));
		model.addAttribute("boards",result);
	}
	
	@PostMapping("/insertboard.do")
	public String boardInsert(@ModelAttribute("board") @Validated Board board,
					BindingResult isResult, Model m) {
		if(isResult.hasErrors()) {
			m.addAttribute("boards",service.selectBoardAll(Map.of("cPae",1,"numPerpage",5)));
			m.addAttribute("pageBar",
					page.getPage(1, 5, service.selectBoardCount(), "boardlist"));
			return "board/inputboard.do";
		}
		int result=service.insertBoard(board);
		if(result>0) {
			return "redirect:board/boardlist";
		}else {
			m.addAttribute("msg","게시물 등록 실패ㅜ^ㅜ");
			m.addAttribute("loc","board/boardlist");
			return "common/msg";
		}
	}
	@GetMapping("/inputboard.do")
	public void inputboard() {}
	por


}



