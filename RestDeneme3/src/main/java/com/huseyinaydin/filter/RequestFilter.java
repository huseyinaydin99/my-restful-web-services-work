package com.huseyinaydin.filter;

import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

@Provider
public class RequestFilter implements ContainerRequestFilter {
	
	@Override
	public ContainerRequest filter(ContainerRequest request) {
		System.out.println("çalýþtý");
		return request;
	}
}
