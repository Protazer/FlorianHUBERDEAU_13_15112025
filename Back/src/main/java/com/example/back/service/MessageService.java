package com.example.back.service;

import com.example.back.dto.MessageDto;
import com.example.back.model.ChatSession;
import com.example.back.model.Message;
import com.example.back.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(MessageDto messageDto, ChatSession session){
        Message newMessage =  new Message();
        newMessage.setSender(messageDto.sender());
        newMessage.setContent(messageDto.content());
        newMessage.setSentAt(LocalDateTime.now());
        newMessage.setSession(session);
        return this.messageRepository.save(newMessage);
    }

    public List<Message> getAllMessagesBySessionId(Long sessionId){
        return this.messageRepository.findByChatSessionId(sessionId);
    }
}
