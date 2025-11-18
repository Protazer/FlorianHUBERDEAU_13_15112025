package com.example.back.controller;

import com.example.back.dto.MessageDto;
import com.example.back.model.ChatSession;
import com.example.back.model.Message;
import com.example.back.service.ChatSessionService;
import com.example.back.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ChatController {

    final ChatSessionService chatSessionService;
    final MessageService messageService;

    public ChatController(final ChatSessionService chatSessionService, final MessageService messageService) {
        this.chatSessionService = chatSessionService;
        this.messageService = messageService;
    }



    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(MessageDto messageDto){
        Optional<ChatSession> session = chatSessionService.getChatSession(messageDto.sessionId());
        if(session.isPresent()){
            return messageService.createMessage(messageDto, session.get());
        } else{
            ChatSession newSession = chatSessionService.CreateChatSession();
           return messageService.createMessage(messageDto, newSession);
        }
    }
}
