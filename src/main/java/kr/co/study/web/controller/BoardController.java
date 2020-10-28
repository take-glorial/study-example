package kr.co.study.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.study.application.BoardService;
import kr.co.study.domain.Board;
import kr.co.study.web.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

	private final BoardService boardService;

	@GetMapping("list")
	public String list( Model model ) {

		List<BoardDTO> boardDTOList = boardService.selectBoardList()
				.stream()
				.map(board -> BoardDTO.builder().id(board.getId()).title(board.getTitle()).contents(board.getContents())
						.regId(board.getRegId()).regDate(board.getRegDate()).build())
				.collect(Collectors.toList());

		model.addAttribute("boardList", boardDTOList);

		return "thymeleaf/page/board/list";
	}

	@GetMapping("write")
	public String write( @ModelAttribute(name="board") BoardDTO board ) {
		return "thymeleaf/page/board/write";
	}

	@PostMapping("write")
	public String writeProc( @Valid @ModelAttribute(name="board") BoardDTO board, BindingResult bindingResult, Authentication auth ) {

		if(bindingResult.hasErrors()) {
			return "thymeleaf/page/board/write";
		}

		boardService.insertBoard(new Board(board.getId(), board.getTitle(), board.getContents(), board.getRegId(), board.getRegDate()));

		return "redirect:list";
	}
}
