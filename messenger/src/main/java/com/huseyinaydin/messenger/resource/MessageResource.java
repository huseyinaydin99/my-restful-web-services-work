package com.huseyinaydin.messenger.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.huseyinaydin.messenger.exception.DataNotFoundException;
import com.huseyinaydin.messenger.model.Message;
import com.huseyinaydin.messenger.resource.beans.MessageFilterBean;
import com.huseyinaydin.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService = new MessageService();

	@GET
	@Produces(value = {MediaType.APPLICATION_JSON})
	public List<Message> getJsonMessage(@BeanParam MessageFilterBean messageFilterBean) {
		System.out.println("json metodu called çağrıldı");
		for (int i = 0; i <= messageService.getMessages().size(); i++) {
			try {
				System.out.println(messageService.getMessages(i).getMessage());
			} catch (NullPointerException e) {}
		}
		System.out.println("------------------");
		
		
		if(messageFilterBean.getYear() > 0){
			return messageService.getAllMessageForYear(messageFilterBean.getYear());
		}
		if(messageFilterBean.getStart() > 0 && messageFilterBean.getSize() > 0){
			return messageService.getAllMessagesPagginated(messageFilterBean.getStart(), messageFilterBean.getSize());
		}
		return messageService.getAllMessage();
	}
	
	@GET
	@Produces(value = {MediaType.TEXT_XML})
	public List<Message> getXMLMessage(@BeanParam MessageFilterBean messageFilterBean) {
		System.out.println("xml metodu called çağrıldı");
		for (int i = 0; i <= messageService.getMessages().size(); i++) {
			try {
				System.out.println(messageService.getMessages(i).getMessage());
			} catch (NullPointerException e) {}
		}
		System.out.println("------------------");
		
		
		if(messageFilterBean.getYear() > 0){
			return messageService.getAllMessageForYear(messageFilterBean.getYear());
		}
		if(messageFilterBean.getStart() > 0 && messageFilterBean.getSize() > 0){
			return messageService.getAllMessagesPagginated(messageFilterBean.getStart(), messageFilterBean.getSize());
		}
		return messageService.getAllMessage();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "test";
	}

	/*
	 * @GET
	 * 
	 * @Path("/{messageId}")
	 * 
	 * @Produces(MediaType.APPLICATION_XML) public Message
	 * getMessage(@PathParam("messageId") long messageId){ return
	 * messageService.getMessages(messageId); }
	 */

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId,@Context UriInfo uriInfo) {
		
		
		Message message = messageService.getMessages(messageId);
		
		
		message.addLink(getUriForSelf(uriInfo,message), "self");
		message.addLink(getUriForProfile(uriInfo,message), "profile");
		message.addLink(getUriForComments(uriInfo,message), "message");
		return message;
	}

	private String getUriForComments(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(MessageResource.class,"getCommantResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", message.getId())
				.build();
		return uri.toString();
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder().path(ProfileResource.class)
				.path(message.getAuthor())
				.build();
		return uri.toString();
	}

	private String getUriForSelf(UriInfo uriInfo,Message message) {
		String uri = uriInfo.getAbsolutePathBuilder()
				.path(MessageResource.class)
				.path(Long.toString(message.getId()))
				.build().toString();
		return uri;
	}

	/*
	 * @POST //@Path("/{messageId}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public String testPost(){ return
	 * "test post.!"; }
	 */

	@POST
	// @Path("/{messageId}")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public Response addMessage(Message message,@Context UriInfo uriInfo) throws URISyntaxException {
		System.out.println("mesaj eklendi.! niga");
		Message newMessage =  messageService.addMessage(message);
		return Response.created(new URI("messenger/webapi/messages/" + newMessage.getId()))
				.entity(newMessage)
				.build();
	}

	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		System.out.println("update");
		message.setId(id);
		System.out.println(message.getMessage());
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") long id) {
		System.out.println("delete");
		System.out.println(id);
		return messageService.removeMessage(id);
	}
	

	@Path("/{messageId}/comments")
	@Consumes(MediaType.TEXT_PLAIN)
	public CommentResource getCommantResource(){
		return new CommentResource();
	}
	
	@GET
	@Path("/regex/{adi:[a-zA-Z0-9_/]+}")//regex pattern
	@Produces(MediaType.TEXT_PLAIN)
	public Response regexDeneme(@PathParam("adi") String adi){
		String isim =  "Selam "+adi;
		return Response.ok(isim, MediaType.TEXT_PLAIN).build();
	}
	
	//http://localhost:8080/messenger/webapi/messages/matrix;adi=Hüseyin;yasi=23
	/*@GET
	@Path("/matrixx/{adi}/{yasi}")
	@Produces(MediaType.TEXT_PLAIN + ";charset-utf-8")
	public Response matrixParamDeneme(@MatrixParam("adi") String adi,@MatrixParam("yasi") String yasi){
		String veri = "Adı : " + adi + " Yaşı "+ yasi;
		return Response.ok(veri,MediaType.TEXT_PLAIN).build();
	}*/
	
	/*@GET
	@Path("/matrix/{detay}")
	@Produces(MediaType.TEXT_PLAIN + ";charset-utf-8")
	public Response matrixParamDeneme(@PathParam("detay") PathSegment detay){
		String personel = "Personel: ";
		MultivaluedMap<String, String> matrix = detay.getMatrixParameters();
		for (String item : matrix.keySet()) {
			personel += item + " " + matrix.get(item) + " - ";
		}
		return Response.ok(personel,MediaType.TEXT_PLAIN).build();
	}*/
	
}
