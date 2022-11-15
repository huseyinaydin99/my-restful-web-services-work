package com.huseyinaydin.resource;

import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.huseyinaydin.model.Car;
import com.huseyinaydin.service.CarService;
import com.sun.jersey.spi.resource.Singleton;

@Path("/CarResource")
@Singleton
public class CarResource {
	private CarService carService = new CarService();

	public CarResource() {
		// super();
		if (carService.getCarRepo().isEmpty())
			carService.ekle(new Car("Broadway", "1999"));
	}

	@GET
	@Path("/hepsiniver")
	@Produces(MediaType.APPLICATION_XML)
	public List<Car> hepsiniVer() {
		return carService.hepsiniVer();
	}

	private static String isim = "";
	private static boolean isimDurum = false;

	@GET
	@Path("/ver/{no}")
	@Produces(value = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response ver(@PathParam("no") int no) {
		Car car = carService.ver(no);
		Random random = new Random();
		int[] dizi = new int[10];
		int sayi = 0;
		boolean durum = true;
		for (int i = 0; i < dizi.length; i++) {
			durum = true;
			while (durum) {
				sayi = random.nextInt(20);
				for (int j = 0; j < dizi.length; j++) {
					if (dizi[j] == sayi)
						break;
					if (j == dizi.length - 1)
						durum = false;
				}
			}
			dizi[i] = sayi;
		}
		String metin = "";
		for (int i = 0; i < 10; i++)
			metin = metin + " " + dizi[i];
		if (!isimDurum) {
			if (car != null)
				isim = car.getCarName();
			isimDurum = true;
		}
		if (car != null) {
			car.setCarName("");
			car.setCarName(isim + " " + metin);
		}
		else
			car = new Car("Böyle bir araba yok!", "Böyle bir araba yok!");
		Response response = Response.ok(car).status(200).build();
		/*ResponseBuilder responseBuilder = Response.ok(car);
		Response response2 = responseBuilder.status(200).build();*/ 
		// response.status(200);
		return response;
		// return Response.ok(car).status(200).build();
	}

	@POST
	@Path("/ekle")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Car ekle(Car car) {
		System.out.println("eklendi " + car.getCarName() + " - " + car.getCarModel());
		return carService.ekle(car);
	}

	@DELETE
	@Path("/sil")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Car sil(Car car) {
		System.out.println("Silindi " + car.getCarName() + " - " + car.getCarModel());
		return carService.sil(car);
	}

	@DELETE
	@Path("/sil/{no}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sil(@PathParam("no") int no) {
		carService.sil(no);
		return "Silinen No " + String.valueOf(no);
	}

	@PUT
	@Path("/guncelle/{no}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Car guncelle(@PathParam("no") int no, Car car) {
		return carService.guncelle(no, car);
	}
}
