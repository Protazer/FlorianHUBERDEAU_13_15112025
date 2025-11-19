package com.example.back.controller;

import com.example.back.dto.MessageDto;
import com.example.back.model.Session;
import com.example.back.service.implementation.SessionService;
import com.example.back.service.implementation.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    final SessionService sessionService;
    final MessageService messageService;
    final SimpMessagingTemplate simpMessagingTemplate;

    public MessageController(final SessionService sessionService, final MessageService messageService, final SimpMessagingTemplate simpleMessagingTemplate ) {
        this.sessionService = sessionService;
        this.messageService = messageService;
        this.simpMessagingTemplate = simpleMessagingTemplate;
    }


    @MessageMapping("/send")
    public void sendMessage(MessageDto msg) {
       Session session = sessionService.getSession(msg.sessionId()).orElse(sessionService.createSession());
        messageService.createMessage(msg,session);

        simpMessagingTemplate.convertAndSend(
                "/topic/messages/" + session.getId(),
                msg
        );
    }

    @GetMapping("/api/messages/{sessionId}")
    public List<MessageDto> getMessages(@PathVariable Long sessionId) {
        return messageService.getAllMessagesBySessionId(sessionId);
    }
}
