package com.huseyinaydin.messenger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param")String param, @HeaderParam("headerParam")String param2,@CookieParam("cookieparam") String param3){
		return "matrix param: " + param + " Header param : " + param2 + " Cookie param : " + param3;
	}
	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders httpHeaders){
		return "Path : " + uriInfo.getAbsolutePath().toString() + " Cookies : " + httpHeaders.getCookies().toString();
	}
}
