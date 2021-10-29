package com.groupproject.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupproject.models.Offer;
import com.groupproject.models.User;
import com.groupproject.services.OfferService;
import com.groupproject.services.UserService;

@Controller
public class OfferController {
	@Autowired
	private UserService uService;
	@Autowired
	private OfferService iService;
	
	public Long userSessionId(HttpSession session) {
		if(session.getAttribute("userId") == null)
			return null;
		return (Long)session.getAttribute("userId");
	}
	
	//show all offers
	@GetMapping("/offers")
	public String Index(@ModelAttribute("offer") Offer offer, Model model, HttpSession session) {
		Long userId = this.userSessionId(session);
		if(userId == null)
			return "redirect:/";
		
		User user = uService.findUserById(userId);
		List<Offer> offers = iService.allOffers(); 
		model.addAttribute("offers", offers);
		model.addAttribute("user", user);
		return "/Offers/index.jsp";
		//return "/Offers/newOffer.jsp";
	}
	
	//post offer
	
	@GetMapping("offers/new")
	public String getOfferForm(@ModelAttribute("offer") Offer offer, Model model) {

		return "Offers/newOffer.jsp"; 
		
	}
	@PostMapping("offers/new")
	public String Create(@Valid @ModelAttribute("offer") Offer offer, BindingResult result, Model model, HttpSession session, @RequestParam Map<String,String> body) {
		if(result.hasErrors()) {
			Long userId = this.userSessionId(session);
			User user = this.uService.findUserById(userId);
			model.addAttribute("user", user);
			return "Offers/newOffer.jsp";
		}
		Long userId = this.userSessionId(session);
		User user = this.uService.findUserById(userId);
		offer.setEmployer(user);
		this.iService.create(offer);
		return "redirect:/offers";
	}
	
	//show offer
	@GetMapping("/{id}")
	public String Show(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = this.userSessionId(session);
		Offer offer = this.iService.findById(id);
		User user = this.uService.findUserById(userId);
		model.addAttribute("user", user);
		if(userId == null)
			return "redirect:/";
		if(offer == null)
			return "redirect:/offers";
		model.addAttribute("offer", offer);
		model.addAttribute("userId", userId);
		return "offers/show";
	}
	
	@GetMapping("/offers/edit/{id}")
	public String Edit(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = this.userSessionId(session);
		Offer offer = this.iService.findById(id);
		User user = this.uService.findUserById(userId);
		model.addAttribute("user", user);
		if(userId == null)
			return "redirect:/";
//		if(offer == null || !offer.getPlanner().getId().equals(userId))
//			return "redirect:/offers";
		
		model.addAttribute("offer", offer);
		model.addAttribute("userId", userId);
		return "Offers/edit.jsp";
	}
	@PostMapping("/offers/edit/{id}")
	public String Update(@Valid @ModelAttribute("offer") Offer offer, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		if(result.hasErrors()) {
			Long userId = this.userSessionId(session);
			model.addAttribute("offer", offer);
			model.addAttribute("userId", userId);
			return "offers/edit/{id}";
		}
		Long userId = this.userSessionId(session);
		User user = this.uService.findUserById(userId);
		offer.setEmployer(user);
		this.iService.update(offer);
		return "redirect:/offers";
	}
	 @GetMapping("/offers/delete/{id}")
	 public String destroyOffer(@PathVariable("id") Long id) {
		 Offer offer = this.iService.findById(id);
			
			if ( offer != null ) {
				this.iService.delete(id);
			}
			
			return "redirect:/offers";
	 }
	@GetMapping("/a/{choice}/{id}")
	public String ManageApplicants(@PathVariable("id") Long id, @PathVariable("choice") String choice, HttpSession session) {
		Long userId = this.userSessionId(session);
		Offer offer = this.iService.findById(id);
		boolean isApplying = (choice.equals("like"));
		if(userId == null) {
			return "redirect:/";
		}
		if(isApplying) {
			offer.setApplicantCount(1);
		}
		else {
			offer.setApplicantCount(-1);
		}
			
		User user = this.uService.findUserById(userId);
		this.iService.manageApplicants(offer, user, isApplying);
		
		return "redirect:/offers";
	}

}