package com.huseyinaydin;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class Client {
	public static void main(String[] args) throws UnvalidatedException {
		getFahrenheitToCelcius();
		getCelciusToFahrenheit();
	}
	
	public static void getFahrenheitToCelcius() throws UnvalidatedException{
		com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RESTful_Server/rest/ctofservice");
		ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
		if(clientResponse.getStatus() != 200){
			//throw new RuntimeException("Geçerli yanýt gelmedi. Gelen yanýt ahan da bu : " + clientResponse.getStatus());
			throw new UnvalidatedException("Geçerli yanýt gelmedi. Gelen yanýt ahan da bu : " + clientResponse.getStatus());
		}
		String sonuc = clientResponse.getEntity(String.class);
		System.out.println(sonuc);
	}
	
	public static void getCelciusToFahrenheit(){
		com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RESTful_Server/rest/ftocservice");
		Builder webBuilder = webResource.accept("application/json");
		ClientResponse clientResponse = webBuilder.get(ClientResponse.class);
		if(clientResponse.getStatus() != 200){
			throw new RuntimeException("Geçerli yanýt gelmedi. Gelen yanýt ahan da bu : " + clientResponse.getStatus());
		}
		String sonuc = clientResponse.getEntity(String.class);
		System.out.println(sonuc);
	}
}
