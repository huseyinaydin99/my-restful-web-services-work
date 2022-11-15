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
		System.out.println("çalýþtý");
		if (request.getRequestUri().getPath().contains("secure")) {//istek yolunda secure isimli bir þey içeriyorsa
			System.out.println("if te");
			List<String> autHeader = request.getRequestHeaders().get(AUTHORIZATION_HEADER_KEY);//username pass kýsmýndan key'i al postmandan
			if (autHeader != null && autHeader.size() > 0) {//alýnan keyler 0 dan büyükse yani deðer varsa
				String autToken = autHeader.get(0);//0. yý al
				System.out.println(autToken);
				autToken = autToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");//basic kýsmýnýdaki base64 hash'ý al
				System.out.println(autToken);
				String decodeString = Base64.base64Decode(autToken);//alýnan base64 hash'ý decode et | username:pass
				System.out.println(decodeString);
				StringTokenizer stringTokenizer = new StringTokenizer(decodeString, ":");//tokenizer ayýraç user:pass þeklinde
				String username = stringTokenizer.nextToken();//kullanýcý adýný al
				String password = stringTokenizer.nextToken();//pass al
				if ("user".equals(username) && "pass".equals(password)) { //user pass eþitse
					System.out.println("giriþ baþarýlý!"); //baþarýlý
					request.getRequestHeaders().add("Giriþ baþarýlý", "devam!");
					return request;
				} else {
					Response response = Response.status(Response.Status.UNAUTHORIZED).entity("giriþ baþarýsýz!").build();
					System.out.println("giriþ baþarýsýz!");//baþarýsýz
					request.getRequestHeaders().add("Giriþ baþarýlý", "devam!");
					return request;
				}
				
			}
		}
		request.getRequestHeaders().add("Giriþ baþarýsýz", "Stop!");
		return request;
	}
}
