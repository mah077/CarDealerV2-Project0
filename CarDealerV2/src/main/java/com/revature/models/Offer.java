package com.revature.models;

public class Offer {

	//private int offerID;
	private static int offerID=8;
	private String status="Pending";
	private int car_id;
	private int customer_id;
	private double price;

	public Offer(/* int offerID, */ /* String status, */   int car_id, int customer_id, double price) {
		//this.offerID = offerID;
		//this.status = status;
		this.car_id = car_id;
		this.customer_id = customer_id;
		this.price = price;
		offerID++;
	
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getOfferID() {
		return offerID;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Offer() {
	}

	@Override
	public String toString() {
		return "Offer [offerID=" + offerID + ", status=" + status + ", car_id=" + car_id + ", customer_id="
				+ customer_id + "]";
	}


	
}
