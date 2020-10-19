package kr.co.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

	@RequestMapping("/signin")
	public String signin() {
		return "thymeleaf/signin";
	}

}
