package com.example.back.mapper;

import com.example.back.dto.MessageDto;
import com.example.back.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageMapper {

    public MessageDto toMessageDto(Message message) {
        return new MessageDto(message.getSession().getId(), message.getSender(), message.getContent());
    }
}
