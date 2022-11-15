package com.huseyinaydin.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.huseyinaydin.model.Car;
import com.huseyinaydin.service.CarService;

@Path("/car")
public class CarResource {
	private static CarService carService = new CarService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Car> getAllCar(){
		return carService.getCars();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_XML)
	public String addCar(Car car){
		System.err.println("Çalýþtý ekleme " + car.getCarModel() + " " + car.getCarName());
		return String.valueOf(carService.add(car));
	}
	
	@PUT
	@Path("/{index}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Car updateCar(@PathParam("index") int index,Car car){
		System.err.println("Çalýþtý güncelleme " + car.getCarModel() + " " + car.getCarName());
		return carService.update(index, car);
	}
	
	@DELETE
	@Path("/{index}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Car deleteCar(@PathParam("index") int index){
		System.err.println("Çalýþtý silme ");
		return carService.delete(index);
	}
}
