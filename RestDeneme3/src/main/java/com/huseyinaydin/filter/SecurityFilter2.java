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
		System.out.println("�al��t� xxx");
		if (request.getRequestUri().getPath().contains("secure")) {//istek yolunda secure isimli bir �ey i�eriyorsa
			System.out.println("if te");
			List<String> autHeader = request.getRequestHeaders().get(AUTHORIZATION_HEADER_KEY);//username pass k�sm�ndan key'i al postmandan
			if (autHeader != null && autHeader.size() > 0) {//al�nan keyler 0 dan b�y�kse yani de�er varsa
				String autToken = autHeader.get(0);//0. y� al
				System.out.println(autToken);
				autToken = autToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");//basic k�sm�n�daki base64 has'� al
				System.out.println(autToken);
				String decodeString = Base64.base64Decode(autToken);//al�nan base64 hash'� decode et
				System.out.println(decodeString);
				StringTokenizer stringTokenizer = new StringTokenizer(decodeString, ":");//tokenizer ay�ra� user:pass �eklinde
				String username = stringTokenizer.nextToken();//kullan�c� ad�n� al
				String password = stringTokenizer.nextToken();//pass al
				if ("user".equals(username) && "pass".equals(password)) { //user pass e�itse
					System.out.println("giri� ba�ar�l�!"); //ba�ar�l�
					Response responsex = Response.status(Response.Status.ACCEPTED).entity("giri� ba�ar�l�!").build();
					//response.setEntity(responsex, Response.class);
					//response.setStatus(200);
					response.getHttpHeaders().add("Giris", "Basarili");
					//response.setEntity("Ba�ar�l�");
					return response;
				} else {
					System.out.println("giri� ba�ar�s�z!");//ba�ar�s�z
					Response responsex = Response.status(Response.Status.UNAUTHORIZED).entity("giri� ba�ar�s�z!").build();
					//response.setEntity(responsex, Response.class);
					response.setStatus(500);
					response.getHttpHeaders().add("Giri� Ba�ar�s�z","OK");
					return response;
				}
				//Response response = Response.status(Response.Status.UNAUTHORIZED).entity("giri� ba�ar�s�z!").build();
			}
		}
		return response;
	}

}
