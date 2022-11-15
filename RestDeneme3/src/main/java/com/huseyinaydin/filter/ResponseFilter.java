package com.huseyinaydin.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

@Provider
public class ResponseFilter implements ContainerResponseFilter {

	@Override
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
		System.out.println("çalýþtý cevap");
		System.out.println(response.getHttpHeaders());
		response.getHttpHeaders().add("Huseyin", "Aydin");
		return response;
	}
}
