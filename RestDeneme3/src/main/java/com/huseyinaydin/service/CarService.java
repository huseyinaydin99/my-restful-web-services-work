package com.huseyinaydin.service;

import java.util.ArrayList;
import java.util.List;

import com.huseyinaydin.model.Car;

public class CarService {
	private List<Car> carRepo = new ArrayList<>();

	public List<Car> hepsiniVer() {
		return carRepo;
	}

	public Car ver(int no) {
		try {
			return carRepo.get(no);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public Car ekle(Car car) {
		carRepo.add(car);
		return car;
	}

	public Car sil(Car car) {
		carRepo.remove(car);
		return car;
	}

	public void sil(int no) {
		carRepo.remove(no);
	}

	public Car guncelle(int no, Car car) {
		carRepo.set(no, car);
		return car;
	}

	public List<Car> getCarRepo() {
		return carRepo;
	}

	public void setCarRepo(List<Car> carRepo) {
		this.carRepo = carRepo;
	}

}
