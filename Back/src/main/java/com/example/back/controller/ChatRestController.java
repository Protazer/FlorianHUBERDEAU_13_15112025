package com.example.back.controller;

import com.example.back.model.Message;
import com.example.back.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/chat")
public class ChatRestController {

    final MessageService messageService;

    public ChatRestController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/messages/{sessionId}")
    public List<Message> getMessages(@PathVariable Long sessionId){
        return this.messageService.getAllMessagesBySessionId(sessionId);
    }
}
