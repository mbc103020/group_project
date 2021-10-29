package com.groupproject.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.groupproject.models.Offer;
import com.groupproject.models.User;
import com.groupproject.repositories.OfferRepository;

@Service
public class OfferService {
	@Autowired
	private OfferRepository offerRepo;
	
	public List<Offer> allOffers() {
		return offerRepo.findAll();
	}
	public Offer findById(Long id) {
		return this.offerRepo.findById(id).orElse(null);
	}
	public Offer create(Offer idea) {
		return this.offerRepo.save(idea);
	}
	
	public Offer update(Offer idea) {
		return this.offerRepo.save(idea);
	}
	
	public void delete(Long id) {
		this.offerRepo.deleteById(id);
	}
	public void manageApplicants(Offer offer, User user, boolean isApplying) {
		if(isApplying) {
			offer.getApplicants().add(user);
		} else {
			offer.getApplicants().remove(user);
		}
		this.offerRepo.save(offer);
	}
}
