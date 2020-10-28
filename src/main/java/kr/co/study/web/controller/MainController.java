package kr.co.study.web.controller;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.study.application.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

	private final MainService mainService;

	@RequestMapping({"/"})
	public String index(Model model) {
		model.addAttribute("hello", "Hello World");
		model.addAttribute("userCount", mainService.getUserCount());
		return "thymeleaf/page/index";
	}
}
