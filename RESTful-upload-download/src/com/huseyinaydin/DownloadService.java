package com.huseyinaydin;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/files")
public class DownloadService {

	@GET
	@Path("/download_txt")
	@Produces(MediaType.TEXT_PLAIN)
	public Response indirTXT(){
		File file = new File("C:\\Users\\husey\\Desktop\\yuklenen\\dosya.txt");
		ResponseBuilder builder = Response.ok((Object)file);
		builder.header("Content-Disposition", "attachement; filename='inenedosya.txt'");
		return builder.build();
	}
	
	@GET
	@Path("/download_png")
	@Produces("image/plain")
	public Response indirPNG(){
		File file = new File("C:\\Users\\husey\\Desktop\\yuklenen\\dosya.png");
		ResponseBuilder builder = Response.ok((Object)file);
		builder.header("Content-Disposition", "attachement; filename='inenedosya.png'");
		return builder.build();
	}
}
