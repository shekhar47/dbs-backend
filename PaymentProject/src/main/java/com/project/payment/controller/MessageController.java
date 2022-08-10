package com.project.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.exception.MessageCodeNotFoundException;
import com.project.payment.model.Message;
import com.project.payment.service.MessageService;

@RestController
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	public Message findMessage(String msg) throws MessageCodeNotFoundException {
		return messageService.findMessage(msg);
	}
	

}
