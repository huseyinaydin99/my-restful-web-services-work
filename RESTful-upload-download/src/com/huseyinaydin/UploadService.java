package com.huseyinaydin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/file")
public class UploadService {

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadNow(@FormDataParam("file") InputStream inputStream,@FormDataParam("file") FormDataContentDisposition dosyaninDetaylari) throws IOException{
		String dosyaYolu = "C:\\Users\\husey\\Desktop\\yuklenen\\"+dosyaninDetaylari.getFileName();
		kaydet(inputStream,dosyaYolu);
		return Response.ok("Yüklendi " + dosyaYolu).status(200).build();
	}

	private void kaydet(InputStream inputStream, String dosyaYolu) throws IOException {
		OutputStream outputStream = new FileOutputStream(new File(dosyaYolu));
		int okuRead = 0;
		byte[] buffer = new byte[1024];
		while((okuRead = inputStream.read(buffer))!=-1){
			outputStream.write(buffer, 0, okuRead);
			
		}
		outputStream.flush();
		outputStream.close();
		inputStream.close();
	}
	
}
