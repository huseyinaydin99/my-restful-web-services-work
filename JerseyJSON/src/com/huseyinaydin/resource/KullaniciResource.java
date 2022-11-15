package com.huseyinaydin.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.huseyinaydin.model.Kullanici;

@Path("/kullanici")
public class KullaniciResource {

	@GET
	@Path("/bilgi/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBilgi(@PathParam("id") int id){
		Kullanici kullanici = new Kullanici();
		kullanici.setKullaniciId(id);
		kullanici.setKullaniciAdi("Hüseyin");
		kullanici.setKullaniciSoyadi("Aydın");
		return Response.ok(kullanici).status(200).build();
	}
	
	@GET
	@Path("/silgi/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getSilgi(@PathParam("id") int id){
		Kullanici kullanici = new Kullanici();
		kullanici.setKullaniciId(id + 1);
		kullanici.setKullaniciAdi("Silgi Hüseyin");
		kullanici.setKullaniciSoyadi("Aydın");
		return Response.ok(kullanici).status(200).build();
	}
}
