package com.revature.models;

public class Car {

	private String make;
	private String color;
	private double price;
	private  int carID;
	
	public Car(int carID,  String make, String color, double price) {
		
		this.make = make;
		this.color = color;
		this.price = price;
		this.carID = carID;
	}	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}


	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", color=" + color + ", price=" + price + ", carID=" + carID + "]\n";
	}


}
