package com.groupproject.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupproject.models.User;
import com.groupproject.services.UserService;
import com.groupproject.validator.UserValidator;


@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	
	public UserController(UserService userService,UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	

    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
    	userValidator.validate(user, result);
    if(result.hasErrors()) {
    	return "index.jsp";
    }else {
    	User u = userService.registerUser(user);
    	session.setAttribute("userId", u.getId());
    	return "redirect:/ideas";
    }
    }


     //post login info to check for correct credentials if pass then will redirect if fail will recieve error message 
//    @RequestMapping(value="/login", method=RequestMethod.POST)
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session,Model model) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if(userService.authenticateUser(email, password)) {
    		User theuser = userService.findByEmail(email);
    		session.setAttribute("userId", theuser.getId());
    		return "redirect:/ideas";
    	}else {
    		session.setAttribute("errorMessage", "Wrong Email or Password");
    		return "redirect:/";
    	}
    }
    
    @RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
