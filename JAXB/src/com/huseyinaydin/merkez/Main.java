package com.huseyinaydin.merkez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.huseyinaydin.model.Kullanici;

public class Main {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/JAXB/kullanici/detay/1");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/xml");
			if(connection.getResponseCode()!=200){
				throw new RuntimeException("Gelen http code : " + connection.getResponseCode());
			}
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String sonuc = bufferedReader.readLine();
			System.out.println(sonuc);
			
			bufferedReader.close();
			JAXBContext context = JAXBContext.newInstance(Kullanici.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Kullanici kullanici = (Kullanici) unmarshaller.unmarshal(new StringReader(sonuc));
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
