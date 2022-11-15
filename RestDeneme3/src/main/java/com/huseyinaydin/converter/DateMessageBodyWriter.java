package com.huseyinaydin.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Random;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

//@Provider
//@Produces(MediaType.TEXT_PLAIN)
public class DateMessageBodyWriter implements MessageBodyWriter<Date> {

	@Override
	public long getSize(Date t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public void writeTo(Date t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		Random random = new Random();
		int[] dizi = new int[13];
		boolean durum = false;
		int uretilenSayi = 0;
		for(int i = 0; i < dizi.length; i++) {
			durum = false;
			while(!durum) {
				uretilenSayi = random.nextInt(15);
				for(int j = 0; j < dizi.length; j++) {
					if(dizi[j] == uretilenSayi)
						break;
					if(j == dizi.length -1)
						durum = true;
				}
			}
			dizi[i] = uretilenSayi;
		}
		String s = t.toString();
		for(int i = 0; i < dizi.length; i++)
			s += " - " + dizi[i];
		entityStream.write(s.getBytes());
		//entityStream.write("selam".getBytes());
	}
}
