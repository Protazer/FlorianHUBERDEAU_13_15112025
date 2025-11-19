package com.example.back.service.implementation;

import com.example.back.dto.MessageDto;
import com.example.back.mapper.MessageMapper;
import com.example.back.model.Session;
import com.example.back.model.Message;
import com.example.back.repository.MessageRepository;
import com.example.back.service.interfaces.IMessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService implements IMessageService {

    final MessageRepository messageRepository;
    final MessageMapper messageMapper;

    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    public void createMessage(MessageDto messageDto, Session session){
        Message newMessage =  new Message();
        newMessage.setSender(messageDto.sender());
        newMessage.setContent(messageDto.content());
        newMessage.setSentAt(LocalDateTime.now());
        newMessage.setSession(session);
        this.messageRepository.save(newMessage);
    }

    public List<MessageDto> getAllMessagesBySessionId(Long sessionId){
        List<MessageDto> messages = new ArrayList<>();
        this.messageRepository.findBySessionId(sessionId).forEach( message -> {
            messages.add(messageMapper.toMessageDto(message));
        });
        return messages;
    }
}
