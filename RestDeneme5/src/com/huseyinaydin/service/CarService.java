package com.huseyinaydin.service;

import java.util.ArrayList;
import java.util.List;

import com.huseyinaydin.model.Car;

public class CarService {
	private List<Car> cars;

	public CarService() {
		super();
		cars = new ArrayList<>();
		cars.add(new Car("Renault Broadway", "1999"));
	}
	
	public boolean add(Car car){
		return cars.add(car);
	}
	
	public Car update(int index,Car car){
		return cars.set(index, car);
	}
	
	public Car delete(int index){
		return cars.remove(index);
	}
	
	public Car select(int index){
		return cars.get(index);
	}

	public List<Car> getCars() {
		return cars;
	}
	
}
