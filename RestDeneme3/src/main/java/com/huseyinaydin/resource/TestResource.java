package com.huseyinaydin.resource;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

@Path("/test")
//@Singleton
public class TestResource {
	private int count = 0;
	
	//http://localhost:8080/RestDeneme3/webapi/test/testmethod/deger?deger2=selam
	@GET
	@Path("/testmethod/{deger1}")
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(@PathParam("deger1")String deger1,@QueryParam("deger2")String deger2) {
		count++;
		return "Bu metot su kadar cagrildi : " + count + "<br> pathparam  : " + deger1 + " queryparam : " + deger2;
	}
	
	@GET
	@Path("/testdate")
	@Produces(MediaType.TEXT_PLAIN)
	public Date testDate() {
		return Calendar.getInstance().getTime();
	}
	
	@GET
	@Path("/testshortdate")
	@Produces(value = {MediaType.TEXT_PLAIN,"text/shortdate"})
	public Date testShortDate() {
		return Calendar.getInstance().getTime();
	}
}
