package com.revature.dao;

import java.util.List;

import com.revature.models.Offer;

public interface OfferInterface {

	public void AddOffer(Offer o);
	
	public void removeOffer(int i);
		
	public List<Offer> getAllOffers();
	
	public void viewOwnerOffer(int i);
	
	public void viewAllPaiments();
	
	
}
