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
	
	Kullanici kullanici = new Kullanici();
	@GET
	@Path("/detay/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response detayVer(@PathParam("id") int id){
		kullanici.setKullaniciId(id);
		kullanici.setKullaniciAdi("Hüseyin");
		kullanici.setKullaniciSoyadi("Aydýn");
		Response response = Response.ok(kullanici).status(200).build();
		return response;
	}
}
