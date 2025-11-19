package com.example.back.mapper;

import com.example.back.dto.MessageDto;
import com.example.back.dto.SessionDto;
import com.example.back.model.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionMapper {

    final MessageMapper messageMapper;

    public SessionMapper(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public SessionDto toSessionDto(Session session){
        List<MessageDto> sessionMessages = new ArrayList<>();
        session.getMessages().forEach(message -> sessionMessages.add(messageMapper.toMessageDto(message)));
        return new SessionDto(session.getId(),session.getUserId(), session.getCreatedAt(), session.getClosedAt(),sessionMessages);
    }
}
