package kr.co.study.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.study.application.UserService;
import kr.co.study.web.dto.JoinDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller("/user")
public class UserController {

	private final UserService userService;

	@GetMapping("/signup")
	public String signup( @ModelAttribute JoinDTO joinDTO ) {
		return "thymeleaf/signup";
	}

	@PostMapping("/signupProc")
	public String signupProc( @Valid @ModelAttribute JoinDTO joinDTO, BindingResult bindingResult ) {

		if(bindingResult.hasErrors()) {
			return "thymeleaf/signup";
		}

		return "redirect:/";
	}

}
