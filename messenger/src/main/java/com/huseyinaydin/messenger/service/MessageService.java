package com.huseyinaydin.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.huseyinaydin.messenger.database.DatabaseClass;
import com.huseyinaydin.messenger.model.Message;



public class MessageService {
	private Map<Long, Message> messages = new HashMap<>();
	
	
	
	@SuppressWarnings("deprecation")
	public MessageService() {
		super();
		this.messages.put(1L, new Message(1, "Merhaba", new Date(2017, 5, 0), "Hüseyin Aydın"));
		this.messages.put(2L, new Message(2, "Hello", new Date(2016, 5, 0), "Alexder Anderson"));
		this.messages.put(3L, new Message(3, "Konniciva", new Date(2015, 5, 0), "Kinomia Takao"));
		this.messages.put(4L, new Message(4, "Selamun Aleyküm", new Date(2014, 5, 0), "Muhammed (S.A.V)"));
	}

	public List<Message> getAllMessage(){
		return new ArrayList<>(messages.values());
	}
	
	public Message getMessages(long id) {
		return messages.get(id);
	}
	
	public List<Message> getAllMessageForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for(Message message : messages.values()){
			calendar.setTime(message.getCreated());
			if(calendar.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPagginated(int start,int size){
		ArrayList<Message> list = new ArrayList<>(messages.values());
		return list.subList(start, start + size);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() +1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() == 0)
			return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		System.out.println("silinmek için geldi : " + id);
		for (int i = 0; i <= getMessages().size(); i++) {
			try {
				System.out.println(getMessages(i).getMessage());
			} catch (NullPointerException e) {}
		}
		return this.messages.remove(id);
	}

	public Map<Long, Message> getMessages() {
		return messages;
	}

	
	
	
	
}
