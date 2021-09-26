package com.groupproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupproject.models.User;
import com.groupproject.services.UserService;
import com.groupproject.validator.UserValidator;


@Controller
public class HomeController {
	private final UserService userService;
	private final UserValidator userValidator;

	public HomeController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user, Model model, HttpSession session) {
		if(session.getAttribute("errorMessage") != null) {
			model.addAttribute("errorMessage", session.getAttribute("errorMessage"));
			return "/User/index.jsp";
		}else
	return "/User/index.jsp";
	}
}
