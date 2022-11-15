package com.huseyinaydin.filter;

import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.xml.internal.messaging.saaj.util.Base64;

@Provider
public class SecurityFilter2 implements ContainerResponseFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
	
	@Override
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
		System.out.println("çalýþtý xxx");
		if (request.getRequestUri().getPath().contains("secure")) {//istek yolunda secure isimli bir þey içeriyorsa
			System.out.println("if te");
			List<String> autHeader = request.getRequestHeaders().get(AUTHORIZATION_HEADER_KEY);//username pass kýsmýndan key'i al postmandan
			if (autHeader != null && autHeader.size() > 0) {//alýnan keyler 0 dan büyükse yani deðer varsa
				String autToken = autHeader.get(0);//0. yý al
				System.out.println(autToken);
				autToken = autToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");//basic kýsmýnýdaki base64 has'ý al
				System.out.println(autToken);
				String decodeString = Base64.base64Decode(autToken);//alýnan base64 hash'ý decode et
				System.out.println(decodeString);
				StringTokenizer stringTokenizer = new StringTokenizer(decodeString, ":");//tokenizer ayýraç user:pass þeklinde
				String username = stringTokenizer.nextToken();//kullanýcý adýný al
				String password = stringTokenizer.nextToken();//pass al
				if ("user".equals(username) && "pass".equals(password)) { //user pass eþitse
					System.out.println("giriþ baþarýlý!"); //baþarýlý
					Response responsex = Response.status(Response.Status.ACCEPTED).entity("giriþ baþarýlý!").build();
					//response.setEntity(responsex, Response.class);
					//response.setStatus(200);
					response.getHttpHeaders().add("Giris", "Basarili");
					//response.setEntity("Baþarýlý");
					return response;
				} else {
					System.out.println("giriþ baþarýsýz!");//baþarýsýz
					Response responsex = Response.status(Response.Status.UNAUTHORIZED).entity("giriþ baþarýsýz!").build();
					//response.setEntity(responsex, Response.class);
					response.setStatus(500);
					response.getHttpHeaders().add("Giriþ Baþarýsýz","OK");
					return response;
				}
				//Response response = Response.status(Response.Status.UNAUTHORIZED).entity("giriþ baþarýsýz!").build();
			}
		}
		return response;
	}

}
