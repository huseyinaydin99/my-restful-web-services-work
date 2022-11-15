package com.huseyinaydin;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/uye")
public class UyeServis {

	@POST
	@Path("/giris")
	@Produces(value = MediaType.TEXT_PLAIN + ";charset=utf-8")
	public Response girisYap(@FormParam("kadi") String kadi,@FormParam("pass") String pass){
		String total = "Kullan�c� Ad� : " + kadi + " �ifre : ";
		return Response.status(200).entity(total).build();
	}
	/*@GET
	@Path("/gir")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String test(){
		return "Ok";
	}*/
}
