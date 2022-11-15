package com.huseyinaydin.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car {
	private String carName;
	private String carModel;
	public Car(String carName, String carModel) {
		super();
		this.carName = carName;
		this.carModel = carModel;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
}
