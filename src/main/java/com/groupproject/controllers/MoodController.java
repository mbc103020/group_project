package com.groupproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupproject.services.UserService;
import com.groupproject.validator.UserValidator;

@Controller
public class MoodController {
	private final UserService userService;
	private final UserValidator userValidator;

	public MoodController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/dashboard")  //jazmine working on view
	public String dashboard() {
		return "/User/dashboard.jsp";
	}
}
