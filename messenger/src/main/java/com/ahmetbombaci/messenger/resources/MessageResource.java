package com.ahmetbombaci.messenger.resources;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.ahmetbombaci.messenger.model.Message;
import com.ahmetbombaci.messenger.resources.beans.MessageFilterBean;
import com.ahmetbombaci.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessage(@BeanParam MessageFilterBean filterBean) {
	//public List<Message> getMessage(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size) {
		/*
		if(year > 0)
			return messageService.getAllMessagesForYear(year);
		
		if(start>0 && size>0)
			return messageService.getAllMessagesPaginated(start, size);
		*/

		if(filterBean.getYear() > 0)
			return messageService.getAllMessagesForYear(filterBean.getYear());
		
		if(filterBean.getStart()>0 && filterBean.getSize()>0)
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		return messageService.getAllMessages();
	}
	

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
	}
	
	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	


	
	
}
