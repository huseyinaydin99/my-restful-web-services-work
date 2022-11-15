package com.huseyinaydin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ApacheClient {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		run();
		// getCelciusToFahrenheit();
	}

	public static void getFahrenheitToCelcius() throws ClientProtocolException, IOException {
		/*
		 * com.sun.jersey.api.client.Client client =
		 * com.sun.jersey.api.client.Client.create(); WebResource webResource =
		 * client.resource("http://localhost:8080/RESTful_Server/rest/ctofservice");
		 * ClientResponse clientResponse =
		 * webResource.accept("application/json").get(ClientResponse.class);
		 */

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet("http://localhost:8080/RESTful_Server/rest/ctofservice");
		httpGet.addHeader("accept", "application/json");

		HttpResponse httpResponse = httpClient.execute(httpGet);

		if (httpResponse.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException(
					"Geçerli yanýt gelmedi. Gelen yanýt ahan da bu : " + httpResponse.getStatusLine().getStatusCode());
		}

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(httpResponse.getEntity().getContent()));
		String bellek = "";
		String sonuc = "";
		while ((bellek = bufferedReader.readLine()) != null) {
			sonuc += bellek;
		}

		// String sonuc = httpResponse.getEntity(String.class);
		System.out.println(sonuc);
	}

	public static void getCelciusToFahrenheit() {
		com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RESTful_Server/rest/ftocservice");
		ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
		if (clientResponse.getStatus() != 200) {
			throw new RuntimeException("Geçerli yanýt gelmedi. Gelen yanýt ahan da bu : " + clientResponse.getStatus());
		}
		String sonuc = clientResponse.getEntity(String.class);
		System.out.println(sonuc);
	}

	public static void crack() throws ClientProtocolException, IOException {
		/*
		 * com.sun.jersey.api.client.Client client =
		 * com.sun.jersey.api.client.Client.create(); WebResource webResource =
		 * client.resource("http://localhost:8080/RESTful_Server/rest/ctofservice");
		 * ClientResponse clientResponse =
		 * webResource.accept("application/json").get(ClientResponse.class);
		 */
		HttpResponse httpResponse = null;
		for (int i = 0; i < 2000; i++) {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet httpGet = new HttpGet("http://localhost:8081/news/shutdown/" + String.valueOf(i));
			httpGet.addHeader("accept", "application/json");

			try {
				httpResponse = httpClient.execute(httpGet);
			} catch (ConnectException e) {
				System.err.println("Þifre kýrýldý reyiz!");
				return;
			}

			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Geçerli yanýt gelmedi. Gelen yanýt ahan da bu : "
						+ httpResponse.getStatusLine().getStatusCode());
			}

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpResponse.getEntity().getContent()));
			String bellek = "";
			String sonuc = "";
			while ((bellek = bufferedReader.readLine()) != null) {
				sonuc += bellek;
			}
			System.err
					.println("denendi : ///  http://localhost:8081/news/shutdown/" + String.valueOf(i) + " - " + sonuc);
		}

		// String sonuc = httpResponse.getEntity(String.class);

	}
	
	
	public static void run() throws ClientProtocolException, IOException {
		/*
		 * com.sun.jersey.api.client.Client client =
		 * com.sun.jersey.api.client.Client.create(); WebResource webResource =
		 * client.resource("http://localhost:8080/RESTful_Server/rest/ctofservice");
		 * ClientResponse clientResponse =
		 * webResource.accept("application/json").get(ClientResponse.class);
		 */
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				HttpResponse httpResponse = null;
				HttpClient httpClient = HttpClientBuilder.create().build();
				HttpGet httpGet = new HttpGet("http://localhost:8081/news/random/22");
				//httpGet.addHeader("accept", "application/xml");

				try {
					httpResponse = httpClient.execute(httpGet);
				} catch (ConnectException e) {
					//System.err.println("Þifre kýrýldý reyiz!");
					return;
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (httpResponse.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Geçerli yanýt gelmedi. Gelen yanýt ahan da bu : "
							+ httpResponse.getStatusLine().getStatusCode());
				}

				BufferedReader bufferedReader = null;
				try {
					bufferedReader = new BufferedReader(
							new InputStreamReader(httpResponse.getEntity().getContent()));
				} catch (UnsupportedOperationException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String bellek = "";
				String sonuc = "";
				try {
					while ((bellek = bufferedReader.readLine()) != null) {
						sonuc += bellek;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(sonuc);
				sonuc = "";
				Runtime.getRuntime().gc();
			}
		};
		timer.schedule(timerTask,0, 900);
	}
}
