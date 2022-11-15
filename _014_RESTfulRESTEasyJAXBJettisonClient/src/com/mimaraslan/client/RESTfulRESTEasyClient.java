package com.mimaraslan.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.mimaraslan.ogrenci.Ogrenci;

public class RESTfulRESTEasyClient {

	public static void main(String[] args) {
		String ogrenci1 = "{ \"ogrenci\":{ \"id\": 1,     \"adi\": \"Anıl\",     \"soyadi\":\"Erdoğan\",      \"yasi\":31}}";
		String ogrenci2 = "{ \"ogrenci\":{ \"id\": 2,     \"adi\": \"Burhan\",     \"soyadi\":\"Güven\",      \"yasi\":33}}";
		Ogrenci ogrenci3 = new Ogrenci(3,"Faik", "Turan", 30);
		
		try {
			
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8080/_014_RESTfulRESTEasyJAXBJettisonClient/rest/ogrenci/gonder");
			
			Response response = target.request().post(Entity.entity(ogrenci1, "application/json;charset=utF-8"));
			

			if (response.getStatus() != 200) {
				throw new RuntimeException("HATA : HTTP STATUS CODE :" + response.getStatus());
			}
			
			System.out.println(response.readEntity(String.class));
			
			System.out.println("-------------------------------------");
			
			
			
			response = target.request().post(Entity.entity(ogrenci2, "application/json;charset=utF-8"));
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("HATA : HTTP STATUS CODE :" + response.getStatus());
			}
			
			System.out.println(response.readEntity(String.class));
			
			System.out.println("-------------------------------------");			
			
			
			
			response = target.request().post(Entity.entity(ogrenci3, "application/json;charset=utF-8"));
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("HATA : HTTP STATUS CODE :" + response.getStatus());
			}
			
			System.out.println(response.readEntity(String.class));
			
			System.out.println("-------------------------------------");			
					
			
			response.close();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
