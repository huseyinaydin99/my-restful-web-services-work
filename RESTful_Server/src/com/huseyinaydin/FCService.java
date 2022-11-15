package com.huseyinaydin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/ftocservice")
public class FCService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response converttoC() throws JSONException{
		double fahrenheit = 98.24;
		double celsius = (fahrenheit - 32) * 5 / 9;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("f value", fahrenheit);
		jsonObject.put("c value", celsius);
		
		String sonuc = "" + jsonObject;
		return Response.ok(sonuc).status(200).build();
	}
	
	@GET
	@Path("/detay/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response converttoC_Detay(@PathParam("id") double fah) throws JSONException{
		double fahrenheit = fah;
		double celsius = (fahrenheit - 32) * 5 / 9;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("f value", fahrenheit);
		jsonObject.put("c value", celsius);
		
		String sonuc = "" + jsonObject;
		return Response.ok(sonuc).status(200).build();
	}
}
