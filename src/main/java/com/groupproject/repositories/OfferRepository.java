package com.groupproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.groupproject.models.Offer;

public interface OfferRepository extends CrudRepository<Offer, Long>{
	//all offers
	List<Offer> findAll();

}