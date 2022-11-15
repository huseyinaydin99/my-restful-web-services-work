package com.mimaraslan;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/files")
public class IndirDownloadServis {

	private static final String TXT_ADRES = "/Users/mimaraslan/Desktop/baslangic/ornek.txt";
	                                   //  "C:\\Users\\mimaraslan\\Desktop\\baslangic\\ornek.txt";
			
	@GET
	@Path("/txt")
	@Produces ("text/plain")
	//@Produces ("image/png")
	//@Produces ("application/pdf")
	//@Produces ("application/vnd.ms-excel")
	public Response txtIndir() {
		
		File file = new File(TXT_ADRES);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"inendosya.txt\"");
		return response.build();
	}	
	 
	
	
	private static final String PNG_ADRES = "/Users/mimaraslan/Desktop/baslangic/ornek.png";
	
	@GET
	@Path("/png")
	@Produces ("image/png")
	public Response pngIndir() {
		
		File file = new File(PNG_ADRES);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"inendosya.png\"");
		return response.build();
	}	
	 
	
	
}
