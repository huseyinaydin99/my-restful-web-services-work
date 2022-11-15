package com.huseyinaydin.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.huseyinaydin.messenger.model.Comment;
import com.huseyinaydin.messenger.model.ErrorMessage;
import com.huseyinaydin.messenger.model.Message;

public class CommentService {
private Map<Long, Comment> comments = new HashMap<>();
private Map<Long, Message> messages = new HashMap<>();
	
	
	
	@SuppressWarnings("deprecation")
	public CommentService() {
		super();
		this.comments.put(1L, new Comment(1, "Merhaba", new Date(2017, 5, 0), "Hüseyin Aydın"));
		this.comments.put(2L, new Comment(2, "Hello", new Date(2016, 5, 0), "Alexder Anderson"));
		this.comments.put(3L, new Comment(3, "Konniciva", new Date(2015, 5, 0), "Kinomia Takao"));
		this.comments.put(4L, new Comment(4, "Selamun Aleyküm", new Date(2014, 5, 0), "Muhammed (S.A.V)"));
	}

	public List<Comment> getAllComments(){
		return new ArrayList<>(comments.values());
	}
	
	public Comment getComments(long messageId, long id) {
		ErrorMessage errorMessage = new ErrorMessage("Aradığınız bulunamadı", 404, "Böyle bir kayıt yok");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		
		Message message = messages.get(messageId);
		if(message == null){
			throw new WebApplicationException(response);
		}
		Comment comment = comments.get(id);
		if(comment==null){
			throw new WebApplicationException(response);
		}
		return comments.get(id);
	}
	
	public List<Comment> getAllCommentForYear(int year){
		List<Comment> messagesForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for(Comment message : comments.values()){
			calendar.setTime(message.getCreated());
			if(calendar.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Comment> getAllCommentPagginated(int start,int size){
		ArrayList<Comment> list = new ArrayList<>(comments.values());
		return list.subList(start, start + size);
	}
	
	public Comment addComment(Comment comment){
		comment.setId(comments.size() +1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(Comment comment){
		if(comment.getId() == 0)
			return null;
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long id){
		System.out.println("silinmek için geldi : " + id);
		for (int i = 0; i <= getComments().size(); i++) {
			try {
				System.out.println(getComments(i,id).getMessage());
			} catch (NullPointerException e) {}
		}
		return this.comments.remove(id);
	}

	public Map<Long, Comment> getComments() {
		return comments;
	}
}
