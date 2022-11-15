package com.huseyinaydin.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.huseyinaydin.filter.ResponseFilter;

@ApplicationPath("/webapi")
public class MyApp extends Application {

	/*@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<>();
		singletons.add(new PoweredByResponseFilter());
		return singletons;
	}*/
	
}
