package com.groupproject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		
			return "Hello World"; 

			
	}
	

}