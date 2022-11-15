package com.huseyinaydin.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.xml.internal.messaging.saaj.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		System.out.println("�al��t�");
		if (request.getRequestUri().getPath().contains("secure")) {//istek yolunda secure isimli bir �ey i�eriyorsa
			System.out.println("if te");
			List<String> autHeader = request.getRequestHeaders().get(AUTHORIZATION_HEADER_KEY);//username pass k�sm�ndan key'i al postmandan
			if (autHeader != null && autHeader.size() > 0) {//al�nan keyler 0 dan b�y�kse yani de�er varsa
				String autToken = autHeader.get(0);//0. y� al
				System.out.println(autToken);
				autToken = autToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");//basic k�sm�n�daki base64 hash'� al
				System.out.println(autToken);
				String decodeString = Base64.base64Decode(autToken);//al�nan base64 hash'� decode et | username:pass
				System.out.println(decodeString);
				StringTokenizer stringTokenizer = new StringTokenizer(decodeString, ":");//tokenizer ay�ra� user:pass �eklinde
				String username = stringTokenizer.nextToken();//kullan�c� ad�n� al
				String password = stringTokenizer.nextToken();//pass al
				if ("user".equals(username) && "pass".equals(password)) { //user pass e�itse
					System.out.println("giri� ba�ar�l�!"); //ba�ar�l�
					request.getRequestHeaders().add("Giri� ba�ar�l�", "devam!");
					return request;
				} else {
					Response response = Response.status(Response.Status.UNAUTHORIZED).entity("giri� ba�ar�s�z!").build();
					System.out.println("giri� ba�ar�s�z!");//ba�ar�s�z
					request.getRequestHeaders().add("Giri� ba�ar�l�", "devam!");
					return request;
				}
				
			}
		}
		request.getRequestHeaders().add("Giri� ba�ar�s�z", "Stop!");
		return request;
	}
}
