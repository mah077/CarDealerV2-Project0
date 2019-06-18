package com.revature.dao;

import java.util.List;

import com.revature.models.Car;


public interface CarInterface {
	
	public void addCar(Car c);
	
	public void removeCar(int i);
	
	public List<Car> getAllCars();
	
	public void viewOneCar(int i);
	
	
}
