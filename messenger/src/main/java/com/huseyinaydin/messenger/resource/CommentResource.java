package com.huseyinaydin.messenger.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.persistence.annotations.ReturnUpdate;

import com.huseyinaydin.messenger.model.Comment;
import com.huseyinaydin.messenger.model.Message;
import com.huseyinaydin.messenger.resource.beans.MessageFilterBean;
import com.huseyinaydin.messenger.service.CommentService;
import com.huseyinaydin.messenger.service.MessageService;

@Path("/comment")
public class CommentResource {
	CommentService commentService = new CommentService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Comment> getComments(@BeanParam MessageFilterBean messageFilterBean) {
		for (int i = 0; i <= commentService.getComments().size(); i++) {
			try {
				System.out.println(commentService.getComments(i,0).getMessage());
			} catch (NullPointerException e) {}
		}
		System.out.println("------------------");
		
		
		if(messageFilterBean.getYear() > 0){
			return commentService.getAllCommentForYear(messageFilterBean.getYear());
		}
		if(messageFilterBean.getStart() > 0 && messageFilterBean.getSize() > 0){
			return commentService.getAllCommentPagginated(messageFilterBean.getStart(), messageFilterBean.getSize());
		}
		return commentService.getAllComments();
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
	public Comment getComment(@PathParam("messageId") long messageId) {
		for (int i = 0; i <= commentService.getAllComments().size(); i++) {
			try {
				System.out.println(commentService.getComments(i,0).getMessage());
			} catch (NullPointerException e) {}
		}
		System.out.println("------------------");
		return commentService.getComments(messageId,0);
	}

	/*
	 * @POST //@Path("/{messageId}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public String testPost(){ return
	 * "test post.!"; }
	 */

	@POST
	// @Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment addComment(Comment comment) {
		System.out.println("burda");
		return commentService.addComment(comment);
	}

	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment updateMessage(@PathParam("messageId") long id, Comment comment) {
		System.out.println("update");
		comment.setId(id);
		System.out.println(comment.getMessage());
		return commentService.updateComment(comment);
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment deleteMessage(@PathParam("messageId") long id) {
		System.out.println("delete");
		System.out.println(id);
		return commentService.removeComment(id);
	}
	
	/*@GET
	@Path("/{commentId}")
	public String test2(@PathParam("messageId")long messageId,@PathParam("commentId")long commentId){
		return "message id = "+messageId + " comment id = " + commentId;
	}*/
	//çalışıyor ancak hatalı gözüküyor (:
}
