package com.huseyinaydin;

import java.util.ArrayList;
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

import com.huseyinaydin.model.Araba;
@Path("/resource")
public class Service {
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_XML)
	public List<Araba> test(){
		List<Araba> arabas = new ArrayList<>();
		arabas.add(new Araba("Reno", "51"));
		arabas.add(new Araba("Fiat", "52"));
		return arabas;
	}
	
	@POST
	@Path("/ekle")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public List<Araba> ekle(Araba araba){
		System.out.println("ekle çalýþtý");
		List<Araba> arabas = new ArrayList<>();
		arabas.add(new Araba("Reno xx", "99"));
		arabas.add(new Araba("Fiat xx", "61"));
		return arabas;
	}
	
	@PUT
	@Path("/guncelle/{idd}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public List<Araba> guncelle(@PathParam("idd") long idd,Araba araba){
		System.out.println("güncelle çalýþtý gelen id " + idd + " gelen araba " + araba.getArabaAdi());
		List<Araba> arabas = new ArrayList<>();
		arabas.add(new Araba("Reno ff", "01"));
		arabas.add(new Araba("Fiat ff", "02"));
		return arabas;
	}
	
	@DELETE
	@Path("/sil/{id}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public List<Araba> sil(@PathParam("id") long id){
		System.out.println("sil çalýþtý gelen id " + id);
		List<Araba> arabas = new ArrayList<>();
		arabas.add(new Araba("Reno yy", "101"));
		arabas.add(new Araba("Fiat yy", "102"));
		return arabas;
	}
	
	
}
